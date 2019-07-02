package org.sid.service;

import java.util.List;

import org.sid.entity.CommandeImport;
import org.sid.entity.Compte;
import org.sid.repository.CommandeImportRepository;
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
public class CommandImportService {
	
	@Autowired
	private CommandeImportRepository comImportRepository;

	
	
	@RequestMapping(value = "/listcomimports",method=RequestMethod.GET)
	public List<CommandeImport> listCommandes(){
		return comImportRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listcomimports/{id}",method=RequestMethod.GET)
	public CommandeImport getByRef(@PathVariable("id")Long ref){
		return comImportRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/cherchercommandimport",method=RequestMethod.GET)
	public Page<Compte> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return comImportRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/savecommandimport",method=RequestMethod.POST)
	public CommandeImport saveProduit(@RequestBody CommandeImport c){
		
		return comImportRepository.save(c);
	}
	@RequestMapping(value = "/editcommandimport",method=RequestMethod.PUT)
	public CommandeImport updateProduit(@RequestBody CommandeImport com){
		return comImportRepository.saveAndFlush(com);
	}
	@RequestMapping(value = "/deletecommandimport/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		comImportRepository.deleteById(id);
		return true ;
	}
	

}


