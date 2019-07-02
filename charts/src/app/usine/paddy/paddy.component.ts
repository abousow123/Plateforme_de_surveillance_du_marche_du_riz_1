import { Component, OnInit } from '@angular/core';
import { UsineService } from '../../../services/usine.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Deposerpaddy, DeposerpaddyId, UsineTransformation, ProdPaddy } from '../../../model/model.usine';
import { Utilisateur, Producteurs } from '../../../model/model.contact';

@Component({
  selector: 'app-paddy',
  templateUrl: './paddy.component.html',
  styleUrls: ['./paddy.component.css']
})
export class PaddyComponent implements OnInit {

  constructor( public usineService: UsineService,
    public router: Router, public activatedRoute: ActivatedRoute) { }

  idpage: number = 0;
  depots: Deposerpaddy[];
  depotSelected: Deposerpaddy = new Deposerpaddy();
  paddy: Deposerpaddy = new Deposerpaddy();
  user: Utilisateur = new Utilisateur();
  id: DeposerpaddyId = new DeposerpaddyId();
  prod: Producteurs = new Producteurs();
  selected = false;
  condition: number = 0;

  ngOnInit() {

    this.usineService.getusine(45).subscribe(data => {
      this.depots = data.deposerpaddies
    }, err => {
      console.log(err);
    })


  }

  isSelected(depot: Deposerpaddy) {
    this.selected = !this.selected;
    this.depotSelected = depot;
    //this.CommandSelected = Commad;
    //if (this.selected == false) {
    //this.CommandSelected = null;


  }
  annuaire(i: number) {
    this.condition = i;
  }

  newdepot() {
    let identifier: DeposerpaddyId = new DeposerpaddyId();
    // let user: Utilisateur = new Utilisateur();
    let usine: UsineTransformation = new UsineTransformation();
    // let prod: Producteurs = new Producteurs();
    usine.idUsine = 45;
    //this.paddy.usineTransformation=usine;
    //this.id.idUsine =45;
    this.paddy.usineTransformation = usine;
    this.prod.utilisateur = this.user;
    this.paddy.id = this.id;
    let prodPaddy: ProdPaddy = new ProdPaddy();
    prodPaddy.producteurs = this.prod;
    prodPaddy.deposerpaddy = this.paddy;
    console.log(prodPaddy);
    const formData: FormData = new FormData();
    formData.append('producteur', JSON.stringify(this.prod));
    formData.append('utilisateur', JSON.stringify(this.user));
    formData.append('paddy', JSON.stringify(this.paddy));
    this.usineService.savepaddy(formData)
      .subscribe(data => {
        console.log(data);
        this.depotSelected=data ;
        this.depots.push(this.depotSelected) ;
      }, err => {
        console.log("Enregistrement dépot" + err);
      });
  }
}
