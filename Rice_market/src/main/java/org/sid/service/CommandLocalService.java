package org.sid.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.List;

import org.sid.entity.CommandeLocal;
import org.sid.repository.CommadLocalRepository;
import org.sid.repository.DistributeurRepository;
import org.sid.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class CommandLocalService {
	
	@Autowired
	private CommadLocalRepository comLocalRepository;
	@Autowired
	private DistributeurRepository dist ;
	@Autowired
	private UtilisateurRepository u ;

	
	
	@RequestMapping(value = "/listcomlocals",method=RequestMethod.GET)
	public List<CommandeLocal> listCommandes(){
		return comLocalRepository.findAll();
		
	}
	@RequestMapping(value = "/listcomlocalfacts",method=RequestMethod.GET)
	public List<CommandeLocal> listCommandefacts(@RequestParam(name="idUsine")Long idUsine){
		return comLocalRepository.commandsatisfaite(idUsine) ;
	}
	@RequestMapping(value = "/listcomlocalnfacts",method=RequestMethod.GET)
	public List<CommandeLocal> listCommandenonfacts(@RequestParam(name="idUsine")Long idUsine){
		return comLocalRepository.commandnonsatisfaite(idUsine);
		
	}
	
	@RequestMapping(value = "/listcomlocals/{id}",method=RequestMethod.GET)
	public CommandeLocal getByRef(@PathVariable("id")Long ref){
		return comLocalRepository.getOne(ref) ;
	}
//	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "/cherchercommandimport",method=RequestMethod.GET)
//	public Page<Compte> chercher(
//			@RequestParam(name="mc", defaultValue="") String mc,
//			@RequestParam(name="page", defaultValue="0") int page,
//			@RequestParam(name="size", defaultValue="5") int size){
//		return comImportRepository.chercher("%"+mc+"%", new PageRequest(page, size));
//		
//	}
	
	
	
	@RequestMapping(value = "/savecommandlocal",method=RequestMethod.POST)
	public CommandeLocal saveProduit(@RequestBody CommandeLocal c){
		
		u.saveAndFlush(c.getDistributeurs().getUtilisateur()) ;
		dist.saveAndFlush(c.getDistributeurs()) ;
		return comLocalRepository.save(c);
	}
	
	@RequestMapping(value = "/savecommandlocald",method=RequestMethod.POST)
	public CommandeLocal savedProduit(@RequestBody CommandeLocal c){
		
		return comLocalRepository.save(c);
	}
	
	@RequestMapping(value = "/editcommandlocal",method=RequestMethod.PUT)
	public CommandeLocal updateProduit(@RequestBody CommandeLocal com){
		return comLocalRepository.saveAndFlush(com);
	}
	@RequestMapping(value = "/deletecommandlocal/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		comLocalRepository.deleteById(id);
		return true ;
	} 
	

}


