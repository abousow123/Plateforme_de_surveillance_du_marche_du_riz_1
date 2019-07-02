import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.css']
})
export class StatistiquesComponent implements OnInit {

  constructor() { }

  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels = ['Dakar', 'Thiés', 'Diourbel', 'Saint Louis', 'Matam', 'Fatick', 'Kaffrine', 'Kaooulack', 'Kédougou', 'Kolda', 'Sédiou', 'Tambacounda', 'Zinguinchor', 'Louga'];
  public barChartType = 'bar';
  public barChartLegend = true;

  public barChartData = [
    { data: [65, 59, 80, 81, 56, 55, 40, 36, 17, 43, 67, 9, 17], label: 'Series importé en Quantité de tonnes / Régions' },
    { data: [28, 48, 40, 19, 86, 27, 90, 12, 11, 33, 47, 19, 7], label: 'Riz importé en Quantité de tonnes/Régions' }
  ];

  public doughnutChartLabels = ['Complet parfumé', 'Brisé non parfumé', 'Brisé parfumé', 'Petit grain'];
  public doughnutChartData = [120, 150, 180, 90];
  public doughnutChartType = 'doughnut';

  public pieChartLabels = ['Complet parfumé', 'Brisé non parfumé', 'Brisé parfumé', 'Petit grain'];
  public pieChartData = [120, 150, 180, 90];
  public pieChartType = 'pie';


  public pieChartLabelss = ['Riz Importé', 'Riz Local'];
  public pieChartDatas = [170, 105];
  public pieChartTypes = 'pie';


  ngOnInit() {
  }

  updateb() {

    this.barChartData = [
      { data: [65, 59, 80, 81, 56, 55, 40, 36, 17, 43, 67, 9, 17], label: 'Series importé en Quantité de tonnes / Régions' },
      { data: [28, 48, 40, 19, 86, 27, 90, 12, 11, 33, 47, 19, 7], label: 'Riz importé en Quantité de tonnes/Régions' }
    ];

  }

  updatep(){
    this.pieChartLabels = ['Complet parfumé', 'Brisé non parfumé', 'Brisé parfumé', 'Petit grain'];
    this.pieChartData = [120, 150, 180, 90];
    this.pieChartType = 'pie';
  } 

  updated(){
   
    this.doughnutChartLabels = ['Complet parfumé', 'Brisé non parfumé', 'Brisé parfumé', 'Petit grain'];
    this.doughnutChartData = [120, 150, 180, 90];
    this.doughnutChartType = 'doughnut';
  
  } 

  

}
