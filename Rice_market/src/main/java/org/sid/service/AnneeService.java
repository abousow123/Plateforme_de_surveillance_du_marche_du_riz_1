package org.sid.service;

import java.util.List;

import org.sid.entity.Annes;
import org.sid.repository.AnneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class AnneeService {
	
	@Autowired
	private AnneeRepository anRepository;

	
	
	@RequestMapping(value = "/listans",method=RequestMethod.GET)
	public List<Annes> listProduits(){
		return anRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listan/{id}",method=RequestMethod.GET)
	public Annes getByRef(@PathVariable("id")Long ref){
		return anRepository.getOne(ref) ;
	}
//	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "/chercheranentGouv",method=RequestMethod.GET)
//	public Pane<anentGouv> chercher(
//			@RequestParam(name="mc", defaultValue="") String mc,
//			@RequestParam(name="pane", defaultValue="0") int pane,
//			@RequestParam(name="size", defaultValue="5") int size){
//		return anRepository.chercher("%"+mc+"%", new PaneRequest(pane, size));
//		
//	}
	
	
	
	@RequestMapping(value = "/savean",method=RequestMethod.POST)
	public Annes saveProduit(@RequestBody Annes c){
		
		return anRepository.save(c);
	}
	@RequestMapping(value = "/editan",method=RequestMethod.PUT)
	public Annes updateProduit(@RequestBody Annes anentGouv){
		return anRepository.saveAndFlush(anentGouv);
	}
	@RequestMapping(value = "/deletean/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		anRepository.deleteById(id);
		return true ;
	}
	

}


