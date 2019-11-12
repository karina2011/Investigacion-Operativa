import { Component, OnInit } from '@angular/core';
import { City } from 'src/app/models/city';
import { CityService } from 'src/app/services/city.service';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-cities-select',
  templateUrl: './cities-select.component.html',
  styleUrls: ['./cities-select.component.css']
})
export class CitiesSelectComponent implements OnInit {
  city : City;
  cityForm : FormGroup;

  cityList : Array<City>;
  selectedCities : Array<City>;
  selectedCityError : Boolean = true;

  results : any = false; // para los resultados

  constructor(private cityService : CityService, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.cityList = this.cityService.getAll();
    console.log(this.cityList);

    this.cityForm = this.formBuilder.group({
        cities : this.addCitiesControl()
    
    });

  }

  addCitiesControl(){
    const arr = this.cityList.map(element => {
      return this.formBuilder.control(false);
    })
    return this.formBuilder.array(arr);
  }

  get citiesArray(){
    return <FormArray>this.cityForm.get('cities');
  }

  // esta funcion es llamada cada vez que hay un cambio en los checkbox del form
  getSelectedCities(){
    this.selectedCities = new Array<City>();
    this.citiesArray.controls.forEach((control, i) => {
      if(control.value){ // el valor de cada checkbox va a ser True o False
        this.selectedCities.push(this.cityList[i]);
      }
    })
    console.log(this.selectedCities);
    this.selectedCityError = this.selectedCities.length > 0 ? false : true; // si el tamaño es mayor a 0, false, sino true
  }

  submit(){
    let citiesIds = new Array();
    this.selectedCities.forEach(city => {
      citiesIds.push(city.id);
    });
    console.log(citiesIds);

    this.cityService.calculateTrip(citiesIds).subscribe( response =>{
      this.results = response;
      console.log(response);
    }, 
    error => {
      console.log(error);
    })
    // llamar al metodo para calcular ruta, guardar el resultado
  }

}
