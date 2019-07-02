import { Component } from '@angular/core';
import { Chart } from 'chart.js';
import { Compte } from 'src/model/model.acteur';
import { UsineService } from 'src/services/usine.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'charts';
  chart = []; // This will hold our chart info
  i:number=0 ;
  login:string="" ;
  pwd:string="" ;
  user:Compte=new Compte() ;

  constructor(public apservice:UsineService) {}

  ngOnInit() {
   
  }

connexion(){
  
  console.log(this.login+" et "+this.pwd) ;
  this.apservice.connecter(this.login,this.pwd)
  .subscribe(data=>{
    console.log(data) ;
    this.user=data ;
   // console.log(this.user.role.nomRole)
   if(this.user===null){
    this.i=0 ;
    alert("Login ou mot de passe incorrect !")
    this.login="" ;
    this.pwd="" ;
    console.log(this.i) ;
  }
  else if(this.user.role.nomRole==="admin"){
    this.i=2 ;
    console.log(this.i) ;
  }
  else if(this.user.role.nomRole==="USER"){
    this.i=1 ;
    console.log(this.i) ;
  }
  else if(this.user.role.nomRole==="distributeur"){
    this.i=3 ;
    console.log(this.i) ;
  }
  });

 
   
  


}
}
