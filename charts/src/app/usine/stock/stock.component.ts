import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsineService } from '../../../services/usine.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Stocke, UsineTransformation } from '../../../model/model.usine';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  categories:Stocke[] ;
  cat:Stocke=new Stocke() ;
  usine:UsineTransformation=new UsineTransformation ;

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType = 'bar';
  public barChartLegend = true;
  public barChartData = [
    {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'},
    {data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B'}
  ];
  public pieChartLabels = ['Riz brisé non parfumé', 'Riz semi-brisé', 'Riz brisé complet parfumé', 'Riz petit grain'];
  public pieChartData = [120, 150, 180, 90];
  public pieChartType = 'pie';
  

  constructor( public usineService: UsineService,
    public router: Router, public activatedRoute: ActivatedRoute) {


  }


  ngOnInit() {
    
    this.usineService.getusine(45).subscribe(data=>{
      this.usine=data ;
      this.categories=this.usine.stockLocals[0].stockes
    })
  
  }
  select(categorie:Stocke){

this.cat=categorie

  }
 


}
