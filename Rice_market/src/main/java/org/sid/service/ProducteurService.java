package org.sid.service;

import java.util.List;

import org.sid.entity.Producteurs;
import org.sid.repository.ProducteurRepository;
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
public class ProducteurService {
	
	@Autowired
	private ProducteurRepository prodRepository;
	@Autowired
	private UtilisateurRepository userRepository ;

	
	
	@RequestMapping(value = "/listproducteurs",method=RequestMethod.GET)
	public List<Producteurs> listproducteurs(){
		return prodRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listproducteurs/{id}",method=RequestMethod.GET)
	public Producteurs getByRef(@PathVariable("id")Long ref){
		return prodRepository.getOne(ref) ;
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
	
	
	
	@RequestMapping(value = "/saveproducteur",method=RequestMethod.POST)
	public Producteurs saveProduit(@RequestBody Producteurs c){
		userRepository.saveAndFlush(c.getUtilisateur()) ;
		return prodRepository.saveAndFlush(c);
	}
	@RequestMapping(value = "/editproducteur",method=RequestMethod.PUT)
	public Producteurs updateProduit(@RequestBody Producteurs d){
		return prodRepository.saveAndFlush(d);
	}
	@RequestMapping(value = "/deleteproducteur/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		prodRepository.deleteById(id);
		return true ;
	}
	

}


