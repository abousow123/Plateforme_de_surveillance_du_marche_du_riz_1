import { Utilisateur } from "./model.contact";

export class Gies2 {

    idGies2:number ;

    nomGie:string ;

    siege:string ;

    status:string ;

    
}

export class OrganisationInterprofessionel {

    idOrg:number ;

    nomOrganisation:string ;

    vocation:string ;

    siege:string ;

    status:string ;

    email:string ;

    telephone:number ;

    
}

export class Annes {

    idAnnees:number ;

    annes:number ;
 
}

export class Region {

    idRegion:number ;

    nomRegion:string ;
   
 
}
export class Departement {

    idDepartement:number ;

    nomDepartement:string ;

    region:Region=new Region();

}
export class Compte {

    idCompte:number ;

    login:string ;

    pwd:string ;
    
    role:Role ;

    utilisateur:Utilisateur= new Utilisateur() ;
    

    
}

export class Role {

    idRole:number ;

    nomRole:string ;
 
}


