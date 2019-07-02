package org.sid.service;

import java.util.List;

import org.sid.entity.Departement;
import org.sid.repository.DepartementRepository;
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
public class DepartementService {
	
	@Autowired
	private DepartementRepository depRepository;
	
	@RequestMapping(value = "/listdepartements",method=RequestMethod.GET)
	public List<Departement> listdepartements(){
		return depRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listdepartements/{id}",method=RequestMethod.GET)
	public Departement getProduitByRef(@PathVariable("id")Long ref){
		return depRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherdepartement",method=RequestMethod.GET)
	public Page<Departement> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return depRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@RequestMapping(value = "/savedepartement",method=RequestMethod.POST)
	public Departement savedepartement(@RequestBody Departement r){
		return depRepository.save(r);
	}
	@RequestMapping(value = "/editdepartement",method=RequestMethod.PUT)
	public Departement updateProduit(@RequestBody Departement r){
		return depRepository.saveAndFlush(r);
	}
	@RequestMapping(value = "/deletedepartement/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		depRepository.deleteById(id);
		return true ;
	}

}
