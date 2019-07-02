package org.sid;
import org.sid.entity.Compte;
import org.sid.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiceMarketApplication implements CommandLineRunner{
	@Autowired
//private CompteRepository compteRepository ;
private CompteService cpts ;
	public static void main(String[] args) {
		SpringApplication.run(RiceMarketApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Compte c= cpts.getByRef(1L);
		System.out.println(c.getRole().getNomRole());
	}

}

