import { Annes, Departement } from "./model.acteur";
import { Importateurs, Distributeurs } from "./model.contact";

export class StockImportation {

    idImportation:number ;

    annes: Annes ;

    importateurs: Importateurs ;

    departement:Departement ;

    quatite:number ;

    qualite:string ;

    lieuStock:string ;

    prixKg:number ;

    seuilMax:number ;

    seuilMin:number ;

    nomRole:string ;
 
}
export class CommandeImport {

    idcomImport:number ;

    distributeurs:Distributeurs ;

    StockImportation:StockImportation ;

    FactureImport:FactureImport ;

    qualite:string ;

    quantite:number ;

    
}
export class FactureImport {

    idfactImport:number ;

    prixUnit:number ;

    prixTotal:number ;

    
}