package org.sid.service;

import java.util.List;

import org.sid.entity.Role;
import org.sid.repository.Rolerepository;
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
public class RoleService {
	
	@Autowired
	private Rolerepository roleRepository;
	
	@RequestMapping(value = "/listroles",method=RequestMethod.GET)
	public List<Role> listRoles(){
		return roleRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listrole/{id}",method=RequestMethod.GET)
	public Role getProduitByRef(@PathVariable("id")Long ref){
		return roleRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherrole",method=RequestMethod.GET)
	public Page<Role> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return roleRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@RequestMapping(value = "/saverole",method=RequestMethod.POST)
	public Role saveProduit(@RequestBody Role role){
		return roleRepository.save(role);
	}
	@RequestMapping(value = "/editrole",method=RequestMethod.PUT)
	public Role updateProduit(@RequestBody Role role){
		return roleRepository.saveAndFlush(role);
	}
	@RequestMapping(value = "/deleterole/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		roleRepository.deleteById(id);
		return true ;
	}

}
