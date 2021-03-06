import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListaInfoComponent } from './info/lista-info/lista-info.component';
import { HomeComponent } from './navegacao/home/home.component';
import { TimelineComponent } from './info/timeline/timeline.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'info', component: ListaInfoComponent },
  { path: 'timeline', component: TimelineComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
