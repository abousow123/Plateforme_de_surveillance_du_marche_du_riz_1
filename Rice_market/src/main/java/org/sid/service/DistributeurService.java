package org.sid.service;

import java.util.List;
import org.sid.entity.Distributeurs;
import org.sid.repository.DistributeurRepository;
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
public class DistributeurService {
	
	@Autowired
	private DistributeurRepository distRepository;
	@Autowired
	private UtilisateurRepository userRepository ;

	
	
	@RequestMapping(value = "/listdistributeurs",method=RequestMethod.GET)
	public List<Distributeurs> listdistributeur(){
		return distRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listdistributeurs/{id}",method=RequestMethod.GET)
	public Distributeurs getByRef(@PathVariable("id")Long ref){
		return distRepository.getOne(ref) ;
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
	
	
	
	@RequestMapping(value = "/savedistributeur",method=RequestMethod.POST)
	public Distributeurs saveProduit(@RequestBody Distributeurs c){
	
		userRepository.saveAndFlush(c.getUtilisateur()) ;
		return distRepository.save(c);
	}
	@RequestMapping(value = "/editdistributeur",method=RequestMethod.PUT)
	public Distributeurs updateProduit(@RequestBody Distributeurs d){
		userRepository.saveAndFlush(d.getUtilisateur()) ;
		return distRepository.saveAndFlush(d);
	}
	@RequestMapping(value = "/deletedistributeur/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		distRepository.deleteById(id);
		return true ;
	}
	

}


