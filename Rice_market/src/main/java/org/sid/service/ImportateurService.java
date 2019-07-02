package org.sid.service;

import java.util.List;

import org.sid.entity.Importateurs;
import org.sid.repository.ImportateurRepository;
import org.sid.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class ImportateurService {
	
	@Autowired
	private ImportateurRepository importRepository;
	@Autowired
	private UtilisateurRepository userRepository ;

	
	
	@RequestMapping(value = "/listimportateurs",method=RequestMethod.GET)
	public List<Importateurs> listdistributeur(){
		return importRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listimportateurs/{id}",method=RequestMethod.GET)
	public Importateurs getByRef(@PathVariable("id")Long ref){
		return importRepository.getOne(ref) ;
	}
//	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "/chercherAgentGouv",method=RequestMethod.GET)
//	public Page<AgentGouv> chercher(
//			@RequestParam(name="mc", defaultValue="") String mc,
//			@RequestParam(name="page", defaultValue="0") int page,
//			@RequestParam(name="size", defaultValue="5") int size){
//		return agRepository.chercher("%"+mc+"%", new PageRequest(page, size));
//		
//	}
	
	
	
	@RequestMapping(value = "/saveimportateur",method=RequestMethod.POST)
	public Importateurs saveProduit(@RequestBody Importateurs c){
		
		return importRepository.save(c);
	}
	@RequestMapping(value = "/editimportateur",method=RequestMethod.PUT)
	public Importateurs updateProduit(@RequestBody Importateurs d){
		userRepository.saveAndFlush(d.getUtilisateur()) ;
		return importRepository.saveAndFlush(d);
	}
	@RequestMapping(value = "/deleteimportateur/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		importRepository.deleteById(id);
		return true ;
	}
	

}


