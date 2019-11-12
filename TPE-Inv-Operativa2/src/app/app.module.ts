import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // para usar ngModel y reactive forms
import { HttpClientModule } from '@angular/common/http'; // para hacer peticiones http

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CitiesSelectComponent } from './components/cities-select/cities-select.component';
import { CitiesResultsComponent } from './components/cities-results/cities-results.component';

@NgModule({
  declarations: [
    AppComponent,
    CitiesSelectComponent,
    CitiesResultsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
