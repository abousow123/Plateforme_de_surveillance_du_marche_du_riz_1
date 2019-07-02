import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChartsModule } from 'ng2-charts';
import { HttpClientModule } from '@angular/common/http';
import { MyBarChartComponent } from './my-bar-chart/my-bar-chart.component';
import { MyDoughnutChartComponent } from './my-doughnut-chart/my-doughnut-chart.component';
import { MyRadarChartComponent } from './my-radar-chart/my-radar-chart.component';
import { MyPieChartComponent } from './my-pie-chart/my-pie-chart.component';
import { UsineService } from 'src/services/usine.service';
import { ApploginComponent } from './applogin/applogin.component';
import { HomeComponent } from './usine/home/home.component';
import { CommandesComponent } from './usine/commandes/commandes.component';
import { FacturesComponent } from './usine/factures/factures.component';
import { PaddyComponent } from './usine/paddy/paddy.component';
import { StockComponent } from './usine/stock/stock.component';
import { UsineComponent } from './usine/usine.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppheaderComponent } from './components/appheader/appheader.component';
import { AppfooterComponent } from './components/appfooter/appfooter.component';
import { AppmenuComponent } from './components/appmenu/appmenu.component';
import { AppsettingsComponent } from './components/appsettings/appsettings.component';
import { DistributeursComponent } from './distributeurs/distributeurs.component';
import { GouvernementComponent } from './gouvernement/gouvernement.component';
import { GestionLocalComponent } from './gouvernement/gestion-local/gestion-local.component';
import { GestionImportComponent } from './gouvernement/gestion-import/gestion-import.component';
import { GestionUserComponent } from './gouvernement/gestion-user/gestion-user.component';
import { StatistiquesComponent } from './gouvernement/statistiques/statistiques.component';

const routes: Routes = [
  {path: 'bar-chart', component: MyBarChartComponent},
  {path: 'doughnut-chart', component: MyDoughnutChartComponent},
  {path: 'radar-chart', component: MyRadarChartComponent},
  {path: 'pie-chart', component: MyPieChartComponent},

  {path:'login' , component:ApploginComponent} ,
  {path:'' , redirectTo:'',pathMatch:'full'} ,
  {path:'homeusine' , component:HomeComponent},
  {path:'commandes' , component:CommandesComponent},
  {path:'commandes/:id' , component:CommandesComponent},
  {path:'factures/:id' , component:FacturesComponent},
  {path:'factures' , component:FacturesComponent},
  {path:'paddy' , component:PaddyComponent},
  {path:'paddy/:id' , component:PaddyComponent},
  {path:'stock' , component:StockComponent},
  {path:'stock/:id' , component:StockComponent},
  {path:'distributeur' , component:DistributeursComponent},
  {path:'local' , component:GestionLocalComponent},
  {path:'import' , component:GestionImportComponent},
  {path:'user' , component:GestionUserComponent},
  {path:'statistique' , component:StatistiquesComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MyBarChartComponent,
    MyDoughnutChartComponent,
    MyRadarChartComponent,
    MyPieChartComponent,
    ApploginComponent,
    UsineComponent,
    HomeComponent,
    CommandesComponent,
    FacturesComponent,
    PaddyComponent,
    StockComponent,
    AppheaderComponent,
    AppfooterComponent,
    AppmenuComponent,
    AppsettingsComponent,
    DistributeursComponent,
    GouvernementComponent,
    GestionLocalComponent,
    GestionImportComponent,
    GestionUserComponent,
    StatistiquesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ChartsModule,
    FormsModule,ReactiveFormsModule
  ],
  providers: [UsineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
