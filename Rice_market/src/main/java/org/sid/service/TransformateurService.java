package org.sid.service;

import java.util.List;

import org.sid.entity.Transformateurs;

import org.sid.repository.TransformateurRepository;
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
public class TransformateurService {
	
	@Autowired
	private TransformateurRepository tranRepository;

	
	
	@RequestMapping(value = "/listtrans",method=RequestMethod.GET)
	public List<Transformateurs> listtrans(){
		return tranRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listtrans/{id}",method=RequestMethod.GET)
	public Transformateurs getByRef(@PathVariable("id")Long ref){
		return tranRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/cherchertran",method=RequestMethod.GET)
	public Page<Transformateurs> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return tranRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/savetran",method=RequestMethod.POST)
	public Transformateurs saveProduit(@RequestBody Transformateurs c){
		
		return tranRepository.save(c);
	}
	@RequestMapping(value = "/edittran",method=RequestMethod.PUT)
	public Transformateurs updateProduit(@RequestBody Transformateurs g){
		return tranRepository.saveAndFlush(g);
	}
	@RequestMapping(value = "/deletetran/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		tranRepository.deleteById(id);
		return true ;
	}
	

}


