package org.sid.service;

import java.util.List;

import org.sid.entity.StockImportation;
import org.sid.repository.StockImportRepository;
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
public class StockImportService {
	
	@Autowired
	private StockImportRepository stockRepository;

	
	
	@RequestMapping(value = "/liststockimports",method=RequestMethod.GET)
	public List<StockImportation> listtrans(){
		return stockRepository.findAll();
		
	}
	
	@RequestMapping(value = "/liststockimports/{id}",method=RequestMethod.GET)
	public StockImportation getByRef(@PathVariable("id")Long ref){
		return stockRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherstockimport",method=RequestMethod.GET)
	public Page<StockImportation> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return stockRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/savestockimport",method=RequestMethod.POST)
	public StockImportation saveProduit(@RequestBody StockImportation c){
		
		return stockRepository.save(c);
	}
	@RequestMapping(value = "/editstockimport",method=RequestMethod.PUT)
	public StockImportation updateProduit(@RequestBody StockImportation g){
		return stockRepository.saveAndFlush(g);
	}
	@RequestMapping(value = "/deletestockimport/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		stockRepository.deleteById(id);
		return true ;
	}
	

}


