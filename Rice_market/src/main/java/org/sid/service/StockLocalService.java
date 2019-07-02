package org.sid.service;

import java.util.List;

import org.sid.entity.StockLocal;
import org.sid.repository.StockLocalRepository;
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
public class StockLocalService {
	
	@Autowired
	private StockLocalRepository stockRepository;

	
	
	@RequestMapping(value = "/liststocklocals",method=RequestMethod.GET)
	public List<StockLocal> listtrans(){
		return stockRepository.findAll();
		
	}
	
	@RequestMapping(value = "/liststocklocals/{id}",method=RequestMethod.GET)
	public StockLocal getByRef(@PathVariable("id")Long ref){
		return stockRepository.getOne(ref) ;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/chercherstocklocal",method=RequestMethod.GET)
	public Page<StockLocal> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return stockRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/stocklocalregion",method=RequestMethod.GET)
	public Page<StockLocal> searchregion(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		return stockRepository.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	
	
	@RequestMapping(value = "/savestocklocal",method=RequestMethod.POST)
	public StockLocal saveProduit(@RequestBody StockLocal c){
		
		return stockRepository.save(c);
	}
	@RequestMapping(value = "/editstocklocal",method=RequestMethod.PUT)
	public StockLocal updateProduit(@RequestBody StockLocal g){
		return stockRepository.saveAndFlush(g);
	}
	@RequestMapping(value = "/deletestocklocal/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		stockRepository.deleteById(id);
		return true ;
	}
	

}


