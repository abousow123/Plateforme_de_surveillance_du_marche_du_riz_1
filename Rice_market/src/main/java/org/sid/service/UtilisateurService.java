package org.sid.service;

import java.util.List;

import org.sid.entity.Utilisateur;
import org.sid.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository userRepository;
	
	@RequestMapping(value = "/listusers",method=RequestMethod.GET)
	public List<Utilisateur> listProduits(){
		return userRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listuser/{id}",method=RequestMethod.GET)
	public Utilisateur getProduitByRef(@PathVariable("id")Long ref){
		return userRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercheruser",method=RequestMethod.GET)
	public Page<Utilisateur> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return userRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@RequestMapping(value = "/saveuser",method=RequestMethod.POST)
	public Utilisateur saveProduit(@RequestBody Utilisateur user){
		return userRepository.save(user);
	}
	@RequestMapping(value = "/edituser",method=RequestMethod.PUT)
	public Utilisateur updateProduit(@RequestBody Utilisateur user){
		return userRepository.saveAndFlush(user);
	}
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		userRepository.deleteById(id);
		return true ;
	}

}
