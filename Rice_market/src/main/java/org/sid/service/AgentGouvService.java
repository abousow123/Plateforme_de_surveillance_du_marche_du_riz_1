package org.sid.service;

import java.util.List;

import org.sid.entity.AgentGouv;
import org.sid.repository.AgentGouvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class AgentGouvService {
	
	@Autowired
	private AgentGouvRepository agRepository;

	
	
	@RequestMapping(value = "/listAgentGouvs",method=RequestMethod.GET)
	public List<AgentGouv> listProduits(){
		return agRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listAgentGouv/{id}",method=RequestMethod.GET)
	public AgentGouv getByRef(@PathVariable("id")String ref){
		return agRepository.getOne(ref) ;
	}
//	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "/chercherAgentGouv",method=RequestMethod.GET)
//	public Page<AgentGouv> chercher(
//			@RequestParam(name="mc", defaultValue="") String mc,
//			@RequestParam(name="page", defaultValue="0") int page,
//			@RequestParam(name="size", defaultValue="5") int size){
//		return agRepository.chercher("%"+mc+"%", new PageRequest(page, size));
//		
//	}
//	
	
	
	@RequestMapping(value = "/saveAgentGouv",method=RequestMethod.POST)
	public AgentGouv saveProduit(@RequestBody AgentGouv c){
		
		return agRepository.save(c);
	}
	@RequestMapping(value = "/editAgentGouv",method=RequestMethod.PUT)
	public AgentGouv updateProduit(@RequestBody AgentGouv AgentGouv){
		return agRepository.saveAndFlush(AgentGouv);
	}
	@RequestMapping(value = "/deleteAgentGouv/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")String id){		
		agRepository.deleteById(id);
		return true ;
	}
	

}


