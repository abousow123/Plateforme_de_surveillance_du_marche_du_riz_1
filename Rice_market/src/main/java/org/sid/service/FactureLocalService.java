package org.sid.service;

import java.util.List;


import org.sid.entity.FactureImport;
import org.sid.entity.FactureLocal;
import org.sid.repository.FactureImportRepository;
import org.sid.repository.FactureLocalRepository;
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
public class FactureLocalService {
	
	@Autowired
	private FactureLocalRepository factRepository;

	
	
	@RequestMapping(value = "/listfacturelocals",method=RequestMethod.GET)
	public List<FactureLocal> listCommandes(){
		return factRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listfacturelocals/{id}",method=RequestMethod.GET)
	public FactureLocal getByRef(@PathVariable("id")Long ref){
		return factRepository.getOne(ref) ;
	}
//	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "/chercherfactureimport",method=RequestMethod.GET)
//	public Page<FactureImport> chercher(
//			@RequestParam(name="mc", defaultValue="") String mc,
//			@RequestParam(name="page", defaultValue="0") int page,
//			@RequestParam(name="size", defaultValue="5") int size){
//		return factRepository.chercher("%"+mc+"%", new PageRequest(page, size));
//		
//	}
//	
	
	
	@RequestMapping(value = "/savefacturelocal",method=RequestMethod.POST)
	public FactureLocal saveProduit(@RequestBody FactureLocal c){
		
		return factRepository.save(c);
	}
	@RequestMapping(value = "/editfacturelocal",method=RequestMethod.PUT)
	public FactureLocal updateProduit(@RequestBody FactureLocal com){
		return factRepository.saveAndFlush(com);
	}
	@RequestMapping(value = "/deletefacturelocal/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		factRepository.deleteById(id);
		return true ;
	}
	

}


