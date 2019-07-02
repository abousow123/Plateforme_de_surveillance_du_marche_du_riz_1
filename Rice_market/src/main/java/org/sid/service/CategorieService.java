package org.sid.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.sid.entity.Categorie;
import org.sid.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin("*")
public class CategorieService {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	private CategorieRepository catRepository;

	
	
	@RequestMapping(value = "/listcategories",method=RequestMethod.GET)
	public List<Categorie> listCommandes(){
		return catRepository.findAll();
		
	}
	
	
	@RequestMapping(value = "/listcategories/{id}",method=RequestMethod.GET)
	public Categorie getByRef(@PathVariable("id")Long ref){
		return catRepository.getOne(ref) ;
	}
//	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "/cherchercommandimport",method=RequestMethod.GET)
//	public Page<Compte> chercher(
//			@RequestParam(name="mc", defaultValue="") String mc,
//			@RequestParam(name="page", defaultValue="0") int page,
//			@RequestParam(name="size", defaultValue="5") int size){
//		return comImportRepository.chercher("%"+mc+"%", new PageRequest(page, size));
//		
//	}
	
	
	
	@RequestMapping(value = "/savecategorie",method=RequestMethod.POST)
	public Categorie saveProduit(@RequestBody Categorie c){
		
		return catRepository.save(c);
	}
	@RequestMapping(value = "/editcategorie",method=RequestMethod.PUT)
	public Categorie updateProduit(@RequestBody Categorie com){
		return catRepository.saveAndFlush(com);
	}
	@RequestMapping(value = "/deletecategorie/{id}", method = RequestMethod.DELETE)
	public boolean deleteProduit(@PathVariable("id")Long id){		
		catRepository.deleteById(id);
		return true ;
	}
	
	String getPhoto(String fileName) {
		String image = null;
		String filesPath = context.getRealPath("/images");
		File fileFolder = new File(filesPath);
		if (fileFolder != null) {
			for (final File file : fileFolder.listFiles()) {
				if (!file.isDirectory()) {
					String encodeBase64 = null;
					try {
						if (fileName.equals(file.getName())) {
							String extension = FilenameUtils.getExtension(file.getName());
							// String nom =
							// FilenameUtils.getBaseName(file.getName()) ;
							//System.out.println("nom photo = " + file.getName());
							FileInputStream fileInputStream = new FileInputStream(file);
							byte[] bytes = new byte[(int) file.length()];
							fileInputStream.read(bytes);
							encodeBase64 = Base64.getEncoder().encodeToString(bytes);
							image = "data:image/"+extension+";base64," + encodeBase64;
							fileInputStream.close();
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		//System.out.println(image);
		return image;
	}
	
	
	//ajout avec photo
	
	@RequestMapping(value = "/categoriesaved", method = RequestMethod.POST)
	public ResponseEntity<String> postCategorie(@RequestParam("file1") MultipartFile file,
			@RequestParam("categorie") String categorie) throws JsonParseException, JsonMappingException, IOException {
		Categorie c = new ObjectMapper().readValue(categorie, Categorie.class);
		boolean isExist = new File(context.getRealPath("/images/")).exists();
		if (!isExist) {
			new File(context.getRealPath("/images/")).mkdir();
		}
		String fileName = file.getOriginalFilename();
		String modifyFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "."
				+ FilenameUtils.getExtension(fileName);
		File serverFile = new File(context.getRealPath("/images/"+File.separator+modifyFileName));
		try {
			FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}
		c.setPhoto(modifyFileName);
		// personne2.setPhoto(file.getBytes());

		Categorie dbc = catRepository.save(c);

		if (dbc != null) {
			return new ResponseEntity<>("personne is saved successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("personne is not saved", HttpStatus.BAD_REQUEST);
		}

	}
	

}


