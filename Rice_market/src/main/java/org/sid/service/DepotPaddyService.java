package org.sid.service;

import java.io.IOException;
import java.util.List;

import org.sid.entity.Deposerpaddy;
import org.sid.entity.DeposerpaddyId;
import org.sid.entity.Producteurs;
import org.sid.entity.UsineTransformation;
import org.sid.entity.Utilisateur;
import org.sid.repository.DepotPaddyRepository;
import org.sid.repository.ProducteurRepository;
import org.sid.repository.UtilisateurRepository;
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
public class DepotPaddyService {
	
	@Autowired
	private DepotPaddyRepository depotRepository; 
	@Autowired
	private ProducteurRepository prodRepository;
	@Autowired
	private UtilisateurRepository userRepository ;

	
	
	@RequestMapping(value = "/listdepots",method=RequestMethod.GET)
	public List<Deposerpaddy> listdepot(){
		return depotRepository.findAll();
		
	}
	
	@RequestMapping(value = "/listdepots/{id}",method=RequestMethod.GET)
	public Deposerpaddy getByRef(@PathVariable("id")DeposerpaddyId ref){
		return depotRepository.getOne(ref) ;
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
	
	
	
	@RequestMapping(value = "/savedepot",method=RequestMethod.POST)
	public Deposerpaddy saveProduit(@RequestParam("utilisateur") String utilisateur,
			@RequestParam("producteur") String producteur,@RequestParam("paddy") String paddy) throws JsonParseException, JsonMappingException, IOException{
	
	
		Producteurs u= new ObjectMapper().readValue(producteur, Producteurs.class);
		Utilisateur user= new ObjectMapper().readValue(utilisateur, Utilisateur.class);
		Deposerpaddy deposerpaddy= new ObjectMapper().readValue(paddy, Deposerpaddy.class);
		Utilisateur u1= userRepository.saveAndFlush(user);
		u.setUtilisateur(u1);
		Producteurs producteurs=prodRepository.saveAndFlush(u);
		UsineTransformation transformation= new UsineTransformation();
		transformation.setIdUsine(45L);//On doit donner l'usine dans les paramétres
		deposerpaddy.setUsineTransformation(transformation);
		DeposerpaddyId prodPaddy = new DeposerpaddyId(Integer.parseInt(transformation.getIdUsine()+""),
				Integer.parseInt(u1.getIdUser()+""), Integer.parseInt(producteurs.getIdProd()+""));
		deposerpaddy.setId(prodPaddy);
		deposerpaddy.setProducteurs(producteurs);
		
		System.out.println(" id usine "+deposerpaddy.getUsineTransformation().getIdUsine());
	
	return depotRepository.save(deposerpaddy);
	}
	@RequestMapping(value = "/editdepot",method=RequestMethod.PUT)
	public Deposerpaddy updateProduit(@RequestBody Deposerpaddy d){
		return depotRepository.saveAndFlush(d);
		
	}
	@RequestMapping(value = "/deletedepot/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")DeposerpaddyId id){		
		depotRepository.deleteById(id);
		return true ;
	}
	
}

