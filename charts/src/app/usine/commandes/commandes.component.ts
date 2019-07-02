import { Component, OnInit } from '@angular/core';
import { UsineService } from '../../../services/usine.service';
import { Router, ActivatedRoute } from '@angular/router';
import { StockLocal, CommandeLocal, UsineTransformation, FactureLocal, Categorie } from '../../../model/model.usine';
import { Utilisateur, Distributeurs } from '../../../model/model.contact';
import { Gies2 } from '../../../model/model.acteur';


@Component({
  selector: 'app-commandes',
  templateUrl: './commandes.component.html',
  styleUrls: ['./commandes.component.css']
})
export class CommandesComponent implements OnInit {

  commandes: CommandeLocal[];
  commandesatisfait: CommandeLocal[];
  historique: CommandeLocal[];
  stocklocal: StockLocal[];
  gies:Gies2[] ;
  categories:Categorie[] ;
  distributeurs:Distributeurs[] ;
  usines: UsineTransformation = new UsineTransformation();
  CommandSelected: CommandeLocal = new CommandeLocal();
  CommandSelect: CommandeLocal = new CommandeLocal();
  FactureLoacal: FactureLocal = new FactureLocal();
  user :Utilisateur =new Utilisateur () ;
  stock:StockLocal=new StockLocal() ;
  motcle: string = "";
  page: number = 0;
  size: number = 5;
  nombrePage: any;
  selected = false;
  i: number = 1;
  idpage: number = 0;
  condition:number=0 ;
  gieid:number ;
  dist:Distributeurs=new Distributeurs() ;
  constructor( public usineService: UsineService,
    public router: Router, public activatedRoute: ActivatedRoute) {

    /*    if (this.activatedRoute.snapshot.params['id'] !== undefined ) {
        this.idpage = 2;
        console.log("page" + this.idpage + " route" + this.activatedRoute.snapshot.params['id']);
      }    */

  }

  ngOnInit() {

    if (this.activatedRoute.snapshot.params['id'] !== undefined) {

      if (this.activatedRoute.snapshot.params['id'] === "2") {
        this.idpage = 2;
        console.log(this.idpage);

      }

      if (this.activatedRoute.snapshot.params['id'] === "3") {
        this.idpage = 3;
        console.log(this.idpage);

      }


    }

    this.usineService.getgies().subscribe(data=>{
      this.gies=data ;
    },err=>{
      console.log("Erreur gies"+err) ;
    }) ;
    this.usineService.getdistributeurs().subscribe(data=>{
      this.distributeurs=data ;
    },err=>{
      console.log("Erreur distributeurs"+err) ;
    }) ;
    
    this.usineService.getusine(45)
      .subscribe(data => {
        this.usines = data;
        this.stock=this.usines.stockLocals[0] ;
        this.historique=this.usines.stockLocals[0].commandeLocals ;
        // this.commandes=this.usines.stockLocals[0].commandeLocals ;
        this.usineService.getcommandlocalsnf(this.usines.idUsine)
          .subscribe(data => {
            this.commandes = data;
          }, err => {
            console.log("commandes non facturé" + err);
          });
        //
        this.usineService.getcommandlocalsf(this.usines.idUsine)
          .subscribe(data => {
            this.commandesatisfait = data;
          }, err => {
            console.log(err);
          });
        //
        console.log('voila ' + this.commandes);
        //this.commandes=new Array(this.stocklocal[0].commandeLocals) ;
        //this.nombrePage=new Array(data.totalPages) ;
      }, err => {
        console.log(err);
      })



  }
  isSelected(Commad: CommandeLocal) {
    this.selected = !this.selected;
    this.CommandSelected = Commad;
    if (this.selected == false) {
      this.CommandSelected = null;
    }
  }
  validerCommand(Commad: CommandeLocal) {
    alert("Etes vous sur de vouloir valider la commande");
    this.i = 2;
    let com: CommandeLocal = new CommandeLocal();
    com.idcomLocal = Commad.idcomLocal;
    com.statut = 1;
    com.stockLocal.idStock = this.usines.stockLocals[0].idStock;
    // let d:Distributeurs=new Distributeurs() ;
    let id: number = Commad.distributeurs.idDist;
    com.distributeurs.idDist = id;
    let idpers: number = Commad.distributeurs.utilisateur.idUser;
    com.distributeurs.utilisateur.idUser = idpers;
    if(Commad.quantite<=this.stock.quatite){

      this.usineService.updatecommandlocal(com).subscribe(data => {
        com = data;
      }, err => {
        console.log("update commande" + err);
      })
      this.router.navigate(['factures', Commad.idcomLocal]);

    }
   else{
     alert ("La commande ne peut pas etre effectué car la qantité demandé n'est pas disponible en stock !"+
     " La quantité disponible est de "+this.stock.quatite) ;

   } 

  }
  nouveau() {
    this.idpage = 1;
  }
  annuaire(i: number) {
    this.condition = i;
  }
  newcommande(){
    let u:Utilisateur=new Utilisateur ;
    u= this.user ;
    let d: Distributeurs=new Distributeurs() ;
    d.utilisateur=u ;
    console.log(d) ;
    this.CommandSelect.stockLocal.usineTransformation.idUsine=45 ;
    this.CommandSelect.stockLocal.idStock=this.stock.idStock ;
    this.CommandSelect.distributeurs=d ;
    this.usineService.savecommandlocal(this.CommandSelect)
    .subscribe(data=>{
      this.CommandSelect=data ;
      this.commandes.push(this.CommandSelect) ;
      console.log(this.CommandSelect) ;
    },err=>{
      console.log("enregistrement commande"+err) ;
    })
    
    
    
  }
  deletecom(command:CommandeLocal){

    alert("Etes vous sur de vouloir supprimer la commande !") ;
    this.usineService.deletecoommadlocal(command.idcomLocal) ;
    this.commandes.splice(this.commandes.indexOf(command),1) ;
    
  }

}