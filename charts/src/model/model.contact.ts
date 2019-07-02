export class Produit{

    id:any=null ;
    
	reference: String=""  ;
	
    designation:String ="" ;
	
	prix:number =0 ;
	
    quantite :number=0;

   
}
export class Utilisateur{

    idUser:any=null ;
    
	nom: String=""  ;
	
    prenom:String ="" ;

    email:String ="" ;

    adresse:String ="" ;
	
	telephone:number =0 ;
	
    bp :number=0;
   
}

export class AgentGouv{

    idGouv:String="" ;

    utilisateur:Utilisateur= new Utilisateur() ;
    
	ministere: String=""  ;
	
    direction:String ="" ;

    fonction:String ="" ;

   
   
}
export class Distributeurs{

    idDist:any=null ;

    utilisateur:Utilisateur= new Utilisateur() ;
    
	ncCommercant: String=""  ;
	
   commandeLocales:any ;

   commandeImports:any ;

   
   
}

export class Importateurs {

    idImport:any=null ;

    utilisateur:Utilisateur= new Utilisateur() ;
    
	ncImport: String=""  ;
	
    stockImportations:any ;

    gie:any ;

    
   
}
export class Producteurs {

    idProd:any=null ;

    utilisateur:Utilisateur= new Utilisateur() ;
    
	
    deposerpaddies:any ;

    gie:any ;

    
}

export class Transformateurs {

    idTransf:any=null ;

    nom:String ;
    
	
    prenom:String ;

    gie:any ;

    
}