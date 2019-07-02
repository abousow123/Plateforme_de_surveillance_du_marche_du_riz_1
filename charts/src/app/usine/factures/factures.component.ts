import { Component, OnInit } from '@angular/core';
import { UsineService } from '../../../services/usine.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FactureLocal, CommandeLocal } from '../../../model/model.usine';

@Component({
  selector: 'app-factures',
  templateUrl: './factures.component.html',
  styleUrls: ['./factures.component.css']
})
export class FacturesComponent implements OnInit {

  idfact:number;
  id:number=0 ;
  facture:FactureLocal=new FactureLocal() ;
  commande:CommandeLocal=new CommandeLocal() ;
  factures:any ;
  q:number ;
  selected:boolean=false ;

  constructor(public service:UsineService,private activatedRoute:ActivatedRoute,public router: Router) {

    this.idfact=activatedRoute.snapshot.params['id'] ;
    if(this.idfact===undefined){
      this.id=2 ;
      this.idfact=1 ;
      console.log("pardon"+this.id) ;
    }
    console.log(this.idfact) ;
    
    
  }


  ngOnInit() {
  
    if(this.id===0){
      this.service.getcommandlocal(this.idfact)
      .subscribe(data=>{
        this.commande=data ;
      }) ;
    }

  this.service.getfacturelocals()
  .subscribe(data=>{

    this.factures=data ;

  } ,err=>{
    console.log(err) ;
  })
  

  }
  isSelected(Facture:FactureLocal){
    this.selected = !this.selected;
    this.facture=Facture ;
    if(this.selected==false){
      this.facture=null ;
    }

  }
  creerFacture(){
    let c=new CommandeLocal() ;
    c.idcomLocal=this.commande.idcomLocal ;
    this.facture.commandeLocal=c ;
    this.facture.prixTotal=this.commande.quantite*this.facture.prixUnitaire ;
    console.log(this.facture.prixTotal) ;
    this.service.savefacturelocal(this.facture).subscribe(data=>{
      
      console.log(data)
    },err=>{
      console.log(err) ;
    }) ;
   
    
  }
  confirm(){
    this.router.navigate(['factures']) ;
  }

}
