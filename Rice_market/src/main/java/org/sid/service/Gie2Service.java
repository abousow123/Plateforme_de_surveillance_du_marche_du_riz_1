package org.sid.service;

import java.util.List;

import org.sid.entity.Gie2;
import org.sid.repository.Gies2Repository;
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
public class Gie2Service {
	
	@Autowired
	private Gies2Repository gieRepository;

	
	
	@RequestMapping(value = "/listgies",method=RequestMethod.GET)
	public List<Gie2> listgies(){
		return gieRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listgies/{id}",method=RequestMethod.GET)
	public Gie2 getByRef(@PathVariable("id")Long ref){
		return gieRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherGie",method=RequestMethod.GET)
	public Page<Gie2> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return gieRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/savegie",method=RequestMethod.POST)
	public Gie2 saveProduit(@RequestBody Gie2 c){
		
		return gieRepository.save(c);
	}
	@RequestMapping(value = "/editgie",method=RequestMethod.PUT)
	public Gie2 updateProduit(@RequestBody Gie2 g){
		return gieRepository.saveAndFlush(g);
	}
	@RequestMapping(value = "/deletegie/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		gieRepository.deleteById(id);
		return true ;
	}
	

}


