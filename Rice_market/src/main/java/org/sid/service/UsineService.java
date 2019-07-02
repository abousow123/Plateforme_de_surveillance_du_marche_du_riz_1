package org.sid.service;

import java.util.List;

import org.sid.entity.UsineTransformation;
import org.sid.repository.UsineTransformationRepository;
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
public class UsineService {
	
	@Autowired
	private UsineTransformationRepository usineRepository;

	
	
	@RequestMapping(value = "/listusines",method=RequestMethod.GET)
	public List<UsineTransformation> listtrans(){
		return usineRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listusines/{id}",method=RequestMethod.GET)
	public UsineTransformation getByRef(@PathVariable("id")Long ref){
		return usineRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherusine",method=RequestMethod.GET)
	public Page<UsineTransformation> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return usineRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/saveusine",method=RequestMethod.POST)
	public UsineTransformation saveProduit(@RequestBody UsineTransformation c){
		
		return usineRepository.save(c);
	}
	@RequestMapping(value = "/editusine",method=RequestMethod.PUT)
	public UsineTransformation updateProduit(@RequestBody UsineTransformation g){
		return usineRepository.saveAndFlush(g);
	}
	@RequestMapping(value = "/deleteusine/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		usineRepository.deleteById(id);
		return true ;
	}
	

}


