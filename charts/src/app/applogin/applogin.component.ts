import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-applogin',
  templateUrl: './applogin.component.html',
  styleUrls: ['./applogin.component.css']
})
export class ApploginComponent implements OnInit {
connect:number= 1 ;
  constructor() { }

  ngOnInit() {
  }
  connexion(r:number){
this.connect= r ;
  }

}
