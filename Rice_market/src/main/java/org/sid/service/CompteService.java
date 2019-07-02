package org.sid.service;

import java.util.List;

import org.sid.entity.Compte;
import org.sid.repository.CompteRepository;
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

public class CompteService {
	
	@Autowired
	private CompteRepository compteRepository;

	
	
	@RequestMapping(value = "/listcomptes",method=RequestMethod.GET)
	public List<Compte> listProduits(){
		return compteRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listcompte/{id}",method=RequestMethod.GET)
	public Compte getByRef(@PathVariable("id")Long ref){
		return compteRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/cherchercompte",method=RequestMethod.GET)
	public Page<Compte> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return compteRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	@RequestMapping(value = "/connexion",method=RequestMethod.GET)
	public Compte connexion(
			@RequestParam(name="login", defaultValue="") String login,
			@RequestParam(name="pwd", defaultValue="") String pwd){
		return compteRepository.compteByusername(login, pwd) ;
		
	}
	
	
	
	@RequestMapping(value = "/savecompte",method=RequestMethod.POST)
	public Compte saveProduit(@RequestBody Compte c){
		
		return compteRepository.save(c);
	}
	@RequestMapping(value = "/editcompte",method=RequestMethod.PUT)
	public Compte updateProduit(@RequestBody Compte compte){
		return compteRepository.saveAndFlush(compte);
	}
	@RequestMapping(value = "/deletecompte/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		compteRepository.deleteById(id);
		return true ;
	}
	

}


