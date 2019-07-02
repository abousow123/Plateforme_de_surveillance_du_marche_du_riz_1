import { Component, OnInit } from '@angular/core';
import { UsineService } from 'src/services/usine.service';
import { UsineTransformation } from 'src/model/model.usine';

@Component({
  selector: 'app-gestion-local',
  templateUrl: './gestion-local.component.html',
  styleUrls: ['./gestion-local.component.css']
})
export class GestionLocalComponent implements OnInit {

  usines:UsineTransformation[] ;
  usine:UsineTransformation=new UsineTransformation() ;

  constructor(public uservicce:UsineService) { }

  
  ngOnInit() {

    this.uservicce.listusines ()
    .subscribe(data=>{
      this.usines=data ;
    },err=>{
      console.log(err) ;
    })


  }

  selected(local:UsineTransformation){
    this.usine=local ;
  }

}
