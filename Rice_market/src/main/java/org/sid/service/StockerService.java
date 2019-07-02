package org.sid.service;

import java.io.IOException;
import java.util.List;

import org.sid.entity.Categorie;
import org.sid.entity.StockLocal;
import org.sid.entity.Stocke;
import org.sid.entity.StockeId;
import org.sid.repository.CategorieRepository;
import org.sid.repository.StockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin("*")
public class StockerService {
	
	@Autowired
	private StockerRepository sRepository; 
//	@Autowired
//	private CategorieRepository catRepository;

	
	
	@RequestMapping(value = "/liststockcategories",method=RequestMethod.GET)
	public List<Stocke> listdepot(){
		return sRepository.findAll();
		
	}
	
	@RequestMapping(value = "/liststockcategories/{id}",method=RequestMethod.GET)
	public Stocke getByRef(@PathVariable("id")StockeId ref){
		return sRepository.getOne(ref) ;
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
	
	
	
	@RequestMapping(value = "/savestockcategorie",method=RequestMethod.POST)
	public Stocke saveProduit( @RequestBody Stocke s){
//			@RequestParam("categorie") String categorie,
//			@RequestParam("stocker") String stocker,@RequestParam("stock") String stock) throws JsonParseException, JsonMappingException, IOException{
//	
//	
//		Categorie c= new ObjectMapper().readValue(categorie, Categorie.class);
//		Stocke s= new ObjectMapper().readValue(stocker, Stocke.class);
//		StockLocal stocklocal= new ObjectMapper().readValue(stocker, StockLocal.class);
//		StockeId idstock= new StockeId(Integer.parseInt(stocklocal.getIdStock()+""), Integer.parseInt(c.getIdcategorie()+"")) ;
//		
//		s.setId(idstock);
//		s.setCategorie(c);
//		s.setStockLocal(stocklocal);
//		
//		System.out.println("quantité "+s.getQuantite());
	
	return sRepository.save(s);
	}
	@RequestMapping(value = "/editstockcategorie",method=RequestMethod.PUT)
	public Stocke updateProduit(@RequestBody Stocke d){
		return sRepository.saveAndFlush(d);
		
	}
	@RequestMapping(value = "/deletestockcategorie/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")StockeId id){		
		sRepository.deleteById(id);
		return true ;
	}
	
}

