import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestion-import',
  templateUrl: './gestion-import.component.html',
  styleUrls: ['./gestion-import.component.css']
})
export class GestionImportComponent implements OnInit {

  constructor() { }

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels = ['Dakar', 'Thiés', 'Diourbel', 'Saint Louis', 'Matam', 'Fatick', 'Kaffrine' ,'Kaooulack' ,'Kédougou' , 'Kolda' , 'Sédiou' , 'Tambacounda' , 'Zinguinchor' , 'Louga'];
  public barChartType = 'bar';
  public barChartLegend = true;

  public barChartData = [
    {data: [65, 59, 80, 81, 56, 55, 40, 36, 17, 43, 67, 9, 17], label: 'Series importé en Quantité de tonnes / Régions'},
    {data: [28, 48, 40, 19, 86, 27, 90, 12, 11, 33, 47, 19, 7], label: 'Riz importé en Quantité de tonnes/Régions'}
  ];

  ngOnInit() {
  }

}
