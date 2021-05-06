import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule } from '@angular/material/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule} from '@angular/router';
import { APP_BASE_HREF } from '@angular/common';

import { MaterialModule } from './material.module';

import { AppComponent } from './app.component';
import { NavegacaoModule } from './navegacao/navegacao.module';
import { AppRoutingModule } from './app-routing.module';
import { InfoService } from './info/info.service';
import { ListaInfoComponent } from './info/lista-info/lista-info.component';
import { ReactiveFormsModule } from '@angular/forms';

export const httpInterceptorProviders = [
];

@NgModule({
  declarations: [
    AppComponent,
    ListaInfoComponent
  ],
  imports: [
    BrowserModule,
    [RouterModule],
    AppRoutingModule,
    NavegacaoModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  providers: [
    InfoService,
    MatNativeDateModule,
    httpInterceptorProviders,
    {provide: APP_BASE_HREF, useValue: '/'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
