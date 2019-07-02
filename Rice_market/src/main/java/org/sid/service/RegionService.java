package org.sid.service;

import java.util.List;

import org.sid.entity.Region;
import org.sid.repository.RegionRepository;
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
public class RegionService {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@RequestMapping(value = "/listregions",method=RequestMethod.GET)
	public List<Region> listRegions(){
		return regionRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listregions/{id}",method=RequestMethod.GET)
	public Region getProduitByRef(@PathVariable("id")Long ref){
		return regionRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherregion",method=RequestMethod.GET)
	public Page<Region> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return regionRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@RequestMapping(value = "/saveregion",method=RequestMethod.POST)
	public Region saveRegion(@RequestBody Region r){
		return regionRepository.save(r);
	}
	@RequestMapping(value = "/editregion",method=RequestMethod.PUT)
	public Region updateProduit(@RequestBody Region r){
		return regionRepository.saveAndFlush(r);
	}
	@RequestMapping(value = "/deleteregion/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		regionRepository.deleteById(id);
		return true ;
	}

}
