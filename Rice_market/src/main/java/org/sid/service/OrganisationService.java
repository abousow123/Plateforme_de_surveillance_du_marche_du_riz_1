package org.sid.service;

import java.util.List;

import org.sid.entity.OrganisationInterprofessionel;
import org.sid.repository.OrganisationRepository;
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
public class OrganisationService {
	
	@Autowired
	private OrganisationRepository orgRepository;

	
	
	@RequestMapping(value = "/listorganisations",method=RequestMethod.GET)
	public List<OrganisationInterprofessionel> listproducteurs(){
		return orgRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listorganisations/{id}",method=RequestMethod.GET)
	public OrganisationInterprofessionel getByRef(@PathVariable("id")Long ref){
		return orgRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherorganisation",method=RequestMethod.GET)
	public Page<OrganisationInterprofessionel> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return orgRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/saveorganisation",method=RequestMethod.POST)
	public OrganisationInterprofessionel saveProduit(@RequestBody OrganisationInterprofessionel c){
		
		return orgRepository.save(c);
	}
	@RequestMapping(value = "/editorganisation",method=RequestMethod.PUT)
	public OrganisationInterprofessionel updateProduit(@RequestBody OrganisationInterprofessionel d){
		return orgRepository.saveAndFlush(d);
	}
	@RequestMapping(value = "/deleteorganisation/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		orgRepository.deleteById(id);
		return true ;
	}
	

}


