import{Injectable} from "@angular/core" ;

import { UsineTransformation, CommandeLocal, Deposerpaddy, FactureLocal, StockLocal, ProdPaddy, Categorie, Stocke } from "../model/model.usine";
import {map} from "rxjs/operators" ;
import { AgentGouv, Distributeurs, Importateurs, Producteurs, Transformateurs } from "../model/model.contact";
import { CommandeImport, FactureImport, StockImportation } from "../model/model.import";
import { Compte, Gies2, Role } from "../model/model.acteur";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable()
export class UsineService{

    url:string='http://localhost:8080/' ;

    constructor(public http:HttpClient){


    }
    
//CRUD USINE
    listusines() :Observable<any> {

        return this.http.get(this.url+'listusines') ;
        
        
    }

    saveusine(ag:UsineTransformation):Observable<any>{

        return this.http.post(this.url+'saveusine',ag);
        
    }

    getusine(id:number):Observable<any>{

        return this.http.get(this.url+'listusines/'+id);
        
    }

    updateusine(ag:UsineTransformation):Observable<any>{

        return this.http.put(this.url+'editusine',ag);

    }
    deleteusine(id:number):Observable<any>{
        return this.http.delete(this.url+'deleteusine/'+id);
    }

//CRUD Agent Gouv
    getagents():Observable<any>{

    return this.http.get(this.url+'listAgentGouvs');  
    }

    saveagent(ag:AgentGouv):Observable<any>{

    return this.http.post(this.url+'saveAgentGouv',ag) ;

    }

    getagent(id:String):Observable<any>{

    return this.http.get(this.url+'listAgentGouv/'+id) ;
    
    }

    updateagent(ag:AgentGouv):Observable<any>{

    return this.http.put(this.url+'editAgentGouv',ag) ;

    }
    deleteAg(id:String):Observable<any>{

    return this.http.delete(this.url+'deleteAgentGouv/'+id) ;
      
    }

//CRUD Commandes Import

    getcommandimports():Observable<any>{

    return this.http.get(this.url+'listcomimports') ;  
    }
    savecommandimport(ag:CommandeImport){

        return this.http.post(this.url+'savecommandimport',ag) ;
    }
    
    getcommandimport(id:String):Observable<any>{
    
        return this.http.get(this.url+'listAgentGouv/'+id) ;
    }
    
    updatecommandimport(ag:AgentGouv):Observable<any>{
    
        return this.http.put(this.url+'editcommandimport',ag) ;
    
    }
    deletecommandimport(id:String):Observable<any>{
    
        return this.http.delete(this.url+'deletecommandimport/'+id) ;
          
    }

//CRUD Commandes Local
    getcommandlocals():Observable<any>{

    return this.http.get(this.url+'listcomlocals') ;
   
    }
    getcommandlocalsf(id:number):Observable<any>{

        return this.http.get(this.url+'listcomlocalfacts?idUsine='+id) ;
       
 }
 getcommandlocalsnf(id:number):Observable<any>{

    return this.http.get(this.url+'listcomlocalnfacts?idUsine='+id) ;
   
}
    

    savecommandlocal(ag:CommandeLocal):Observable<any>{

    return this.http.post(this.url+'savecommandlocal',ag) ;

    }

    savedcommandlocal(ag:CommandeLocal):Observable<any>{

        return this.http.post(this.url+'savecommandlocald',ag) ;
    
        }

    getcommandlocal(id:number):Observable<any>{

    return this.http.get(this.url+'listcomlocals/'+id) ;

    }

    updatecommandlocal(ag:CommandeLocal):Observable<any>{

    return this.http.put(this.url+'editcommandlocal',ag) ;
    }
    deletecoommadlocal(id:number):Observable<any>{

    return this.http.delete(this.url+'deletecommandlocal/'+id) ;
    
    }

//CRUD Compte
    getcomptes():Observable<any>{

        return this.http.get(this.url+'listcomptes') ;
       
    }



    savecompte(ag:Compte):Observable<any>{

        return this.http.post(this.url+'savecompte',ag) ;

    }

    getcompte(id:number):Observable<any>{

        return this.http.get(this.url+'listcompte/'+id) ;

    }

    updatecompte(ag:Compte):Observable<any>{

        return this.http.put(this.url+'editcompte',ag) ;

    }
    deletecompte(id:number):Observable<any>{

        return this.http.delete(this.url+'deletecompte/'+id) ;    
    }
    connecter(login:string,pwd:string):Observable<any>{

        return this.http.get(this.url+'connexion?login='+login+'&pwd='+pwd) ;    
    }
   



//CRUD Departement
    getdepartements():Observable<any>{

        return this.http.get(this.url+'listdepartements') ; 

    }
    getdepartement(id:number):Observable<any>{

        return this.http.get(this.url+'listdepartements/'+id) ; 

    }

//CRUD Depot de Paddy

    getpaddys():Observable<any>{

        return this.http.get(this.url+'listdepots') ; 
 
    }

    savepaddy(ag:FormData):Observable<any>{

        return this.http.post(this.url+'savedepot',ag) ; 

    }

    getpaddy(id:any):Observable<any>{

        return this.http.get(this.url+'listdepots/'+id) ; 

    }

    updatepaddy(ag:Deposerpaddy):Observable<any>{

        return this.http.put(this.url+'editdepot',ag) ; 

    }
    deletepaddy(id:any):Observable<any>{

        return this.http.delete(this.url+'deletedepot/'+id) ; 
        
    }

//CRUD Distributeur
    getdistributeurs():Observable<any>{

        return this.http.get(this.url+'listdistributeurs') ; 

    }

    savedistributeur(ag:Distributeurs):Observable<any>{

        return this.http.post(this.url+'savedistributeur',ag) ; 

    }

    getdistributeur(id:number):Observable<any>{

        return this.http.get(this.url+'listdistributeurs/'+id) ; 

    }

    updatedistributeur(ag:Distributeurs):Observable<any>{

        return this.http.put(this.url+'editdistributeur',ag) ; 

    }
    deletedistributeur(id:String):Observable<any>{

        return this.http.delete(this.url+'deletedistributeur/'+id) ; 
        
    }

//CRUD FactureImport
    getfactureimports():Observable<any>{

        return this.http.get(this.url+'listfactureimports') ; 

    }

    savefactureimport(ag:FactureImport):Observable<any>{

        return this.http.post(this.url+'savefactureimport',ag) ; 

    }

    getfactureimport(id:number):Observable<any>{

        return this.http.get(this.url+'listfactureimports/'+id) ; 
    
    }

    updatefactureimport(ag:FactureImport):Observable<any>{

        return this.http.put(this.url+'editfactureimport',ag) ; 

    }
    deletefactureimport(id:number):Observable<any>{

        return this.http.delete(this.url+'deletefactureimport/'+id) ; 
        
    }

//CRUD FactureLocal
    getfacturelocals():Observable<any>{

        return this.http.get(this.url+'listfacturelocals') ; 

    }

    savefacturelocal(ag:FactureLocal):Observable<any>{

        return this.http.post(this.url+'savefacturelocal',ag) ; 

    }

    getfacturelocal(id:number):Observable<any>{

        return this.http.get(this.url+'listfacturelocals/'+id) ; 

    }

    updatefacturelocal(ag:FactureLocal):Observable<any>{

        return this.http.put(this.url+'editfacturelocal',ag) ; 

    }
    deletefacturelocal(id:number):Observable<any>{

        return this.http.delete(this.url+'deletefacturelocal/'+id) ; 
        
    }

//CRUD Gies
    getgies():Observable<any>{

        return this.http.get(this.url+'listgies') ; 

    }

    savegie(ag:Gies2):Observable<any>{

        return this.http.post(this.url+'saveGie',ag) ; 

    }

    getgie(id:number):Observable<any>{

        return this.http.get(this.url+'listGies/'+id) ; 

    }

    updategie(ag:Gies2):Observable<any>{

        return this.http.put(this.url+'editGie',ag) ; 

    }
    deletegie(id:number):Observable<any>{

        return this.http.delete(this.url+'deleteGie/'+id) ; 
        
    }

//CRUD Importateur
    getImportateurs():Observable<any>{
        return this.http.get(this.url+'listimportateurs') ; 

    }

    saveImportateur(ag:Importateurs):Observable<any>{

        return this.http.post(this.url+'saveimportateur',ag) ; 

    }

    getImportateur(id:number):Observable<any>{

        return this.http.get(this.url+'listimportateurs/'+id) ; 

    }

    updateImportateur(ag:Importateurs):Observable<any>{

        return this.http.put(this.url+'editimportateur',ag) ; 

    }
    deleteImportateur(id:number):Observable<any>{

        return this.http.delete(this.url+'deleteimportateur/'+id) ; 
    
    }

//CRUD Producteur
    getProducteurs():Observable<any>{

        return this.http.get(this.url+'listproducteurs') ; 

    }

    saveProducteur(ag:Producteurs):Observable<any>{

        return this.http.post(this.url+'saveproducteur',ag) ; 
    }

    getProducteur(id:number):Observable<any>{

        return this.http.get(this.url+'listproducteurs/'+id) ; 

    }

    updateProducteur(ag:Producteurs):Observable<any>{

        return this.http.put(this.url+'editproducteur',ag) ; 

    }
    deleteProducteur(id:number):Observable<any>{

        return this.http.delete(this.url+'deleteproducteur/'+id) ; 
    }

//CRUD Region
    getregions():Observable<any>{

        return this.http.get(this.url+'listregions') ;
    }
    getregion(id:number):Observable<any>{

        return this.http.get(this.url+'listregions/'+id) ;

    }

//CRUD Role
    getroles():Observable<any>{

        return this.http.get(this.url+'listroles') ;

    }

    saverole(ag:Role):Observable<any>{

        return this.http.post(this.url+'saverole',ag) ;

    }

    getrole(id:number):Observable<any>{

        return this.http.get(this.url+'listrole/'+id) ;

    }

    updaterole(ag:Role):Observable<any>{

        return this.http.put(this.url+'editrole',ag) ;

    }
    deleterole(id:number):Observable<any>{

        return this.http.delete(this.url+'deleterole/'+id) ;
        
    }

//CRUD stockImport
    getstockimports():Observable<any>{

        return this.http.get(this.url+'liststockimports') ;
    }

    savestockimport(ag:StockImportation):Observable<any>{

        return this.http.post(this.url+'savestockimport',ag) ;

    }

    getstockimport(id:number):Observable<any>{

        return this.http.get(this.url+'liststockimports/'+id) ;

    }

    updatestockimport(ag:StockImportation):Observable<any>{

        return this.http.put(this.url+'editstockimport',ag) ;

    }
    deletestockimport(id:number):Observable<any>{

        return this.http.delete(this.url+'deletestockimport/'+id) ;
        
    }

//CRUD stockLocal
    getstocklocals():Observable<any>{

        return this.http.get(this.url+'liststocklocals') ;

    }

    savestocklocal(ag:StockLocal):Observable<any>{

        return this.http.post(this.url+'savestocklocal',ag) ;

    }

    getstocklocal(id:number):Observable<any>{

        return this.http.get(this.url+'liststocklocals/'+id) ;

    }

    updatestocklocal(ag:StockLocal):Observable<any>{

        return this.http.put(this.url+'editstocklocal',ag) ;

    }
    deletestocklocal(id:number):Observable<any>{

        return this.http.delete(this.url+'deletestocklocal/'+id) ;

    }

//CRUD Transformateur
    gettransformateurs():Observable<any>{

        return this.http.get(this.url+'listtrans') ;

    }
    savetransformateur(ag:Transformateurs):Observable<any>{

        return this.http.post(this.url+'savetran',ag) ;

    }
    gettransformateur(id:number):Observable<any>{

        return this.http.get(this.url+'listtrans/'+id) ;

    }
    updatetransformateur(ag:Transformateurs):Observable<any>{

        return this.http.put(this.url+'edittran',ag) ;

    }
    deletetransformateur(id:number):Observable<any>{

        return this.http.delete(this.url+'deletetran/'+id) ;
        
    }

    //CRUD Categories
    getcategories():Observable<any>{

        return this.http.get(this.url+'listcategories') ;

    }
    savecategorie(ag:Categorie):Observable<any>{

        return this.http.post(this.url+'savecategorie',ag) ;

    }
    getcategorie(id:number):Observable<any>{

        return this.http.get(this.url+'listcategories/'+id) ;

    }
    updatecategories(ag:Categorie):Observable<any>{

        return this.http.put(this.url+'editcategorie',ag) ;

    }
    deletecategorie(id:number):Observable<any>{

        return this.http.delete(this.url+'deletecategorie/'+id) ;
        
    }

      //CRUD Stoker catégories dans stock
      getstockercategories():Observable<any>{

        return this.http.get(this.url+'liststockcategories') ;

    }
    savestockercategories(ag:Stocke):Observable<any>{

        return this.http.post(this.url+'savecategorie',ag) ;

    }
    getstockercategorie(id:any):Observable<any>{

        return this.http.get(this.url+'liststockcategories/'+id) ;

    }
    updatestockercategories(ag:Stocke):Observable<any>{

        return this.http.put(this.url+'editcategorie',ag) ;

    }
    deletestockercategories(id:any):Observable<any>{

        return this.http.delete(this.url+'deletecategorie/'+id) ;
        
    }





}
