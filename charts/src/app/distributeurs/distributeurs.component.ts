import { Component, OnInit } from '@angular/core';
import { UsineService } from 'src/services/usine.service';
import { UsineTransformation, StockLocal, CommandeLocal } from 'src/model/model.usine';
import { StockImportation } from 'src/model/model.import';
import { Command } from 'protractor';
import { Distributeurs, Utilisateur } from 'src/model/model.contact';

@Component({
  selector: 'app-distributeurs',
  templateUrl: './distributeurs.component.html',
  styleUrls: ['./distributeurs.component.css']
})
export class DistributeursComponent implements OnInit {

  locals:StockLocal[] ;
  imports:StockImportation[] ;
  slocal:StockLocal=new StockLocal() ;
  Command:CommandeLocal=new CommandeLocal() ;
  dist:string="" ;
  distributeur:Distributeurs=new Distributeurs() ;
  stocklocal:StockLocal=new StockLocal() ;


  constructor(public usineservice:UsineService) { }


  ngOnInit() {

    this.usineservice.getstocklocals().subscribe(data=>{
      this.locals=data ;
      
    },err=>{
      console.log("erreur stockLocal"+err) ;
    }) ;
    this.usineservice.getstockimports().subscribe(data=>{
      this.imports=data ;
    },err=>{
      console.log("erreur stockImorts"+err) ;
    }) ;

    //recupérer le distributeur en renseignant l'ID
    this.usineservice.getdistributeur(240).subscribe(data=>{
      this.distributeur=data ;
    },err=>{
      console.log(err) ;
    })


  }

  selected(l:StockLocal){

    this.slocal=l ;

  }
  newcommande(){
    let s:StockLocal=new StockLocal () ;
    let d:Distributeurs=new Distributeurs() ;
    
    s.idStock=this.slocal.idStock ;
    s.usineTransformation.idUsine=this.slocal.usineTransformation.idUsine ;
    d.idDist=this.distributeur.idDist ;
    d.utilisateur.idUser=this.distributeur.utilisateur.idUser ;

    this.Command.distributeurs=d ;
    this.Command.stockLocal=s ;

    this.Command.qualite=this.dist ;
   
    console.log(this.Command) ;
    this.usineservice.savedcommandlocal(this.Command).subscribe(data=>{
      this.Command=data ;
      console.log(this.Command) ;
    },err=>{
      console.log("enregistrement"+err) ;
      
    })
    alert("Nouvelle commande"+this.Command.quantite+" en "+this.Command.qualite) ;
  }

 

}
