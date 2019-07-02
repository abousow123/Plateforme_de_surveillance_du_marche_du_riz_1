import { Transformateurs, Producteurs, Distributeurs } from "./model.contact";
import { Departement, Annes } from "./model.acteur";

export class UsineTransformation {

    idUsine:number ;

    transformateurs: Transformateurs ;

    departement: Departement=new Departement() ;

    nomUsine:string ;

    login:string ;

    pwd:string ;

    location:string ;

    email:string ;

    telephone:number ;

    stockLocals?:StockLocal[] ;

    deposerpaddies?:Deposerpaddy[] ;


 
}

export class StockLocal {

    idStock:number ;

    annes: Annes ;

    usineTransformation:UsineTransformation=new UsineTransformation();

    quatite:number ;

    qualite:string ;

    lieuStock:string ;

    prixKg:number ;

    seuilMax:number ;

    seuilMin:number ;

    commandeLocals?:CommandeLocal[] ;

    stockes?:Stocke[]

   
}

export class Deposerpaddy {

    id:DeposerpaddyId=new DeposerpaddyId () ;
	usineTransformation?: UsineTransformation=new UsineTransformation() ;
	producteurs?: Producteurs=new Producteurs() ;
	quantite:number ;
	categorie: string ;
	dateDepot: Date ;
	prixKg: number ;
    prixTransKg: Number ;

}
 export class ProdPaddy{
    producteurs:Producteurs;
    deposerpaddy: Deposerpaddy;
}
export class DeposerpaddyId  {

    idUsine:number ;
    idUser: number;
	idProd:number ;
    idDepot:number  ;

}
export class CommandeLocal {

    idcomLocal:number ;

    distributeurs:Distributeurs=new Distributeurs() ;

    stockLocal:StockLocal=new StockLocal() ;

    factureLocal:FactureLocal ;

    qualite:string ;

    quantite:number ;

    statut:number ;

    

}
export class FactureLocal {

    idfactLocal:number ;

    prixUnitaire:number ;

    prixTotal:number ;

    commandeLocal?:CommandeLocal=new CommandeLocal() ;


}

export class Categorie{

    idcategorie:number ;

    categorie:string ;

    description:string ;
    
	photo:string ;
}
export class StockeId{
    idcategories:number ;
    idstock:number ;
}
export class Stocke{

    id:StockeId=new StockeId() ;

    Stock:StockLocal=new StockLocal() ;

    categorie:Categorie=new Categorie() ;

    quatité:number ;

}