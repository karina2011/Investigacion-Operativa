import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; // para hacer llamadas http
import { City } from '../models/city';

@Injectable({
  providedIn: 'root'
})
export class CityService {
  private url = "http://localhost:8080/cities";

  constructor(private http : HttpClient) { }

  calculateTrip(citiesIds){
    const httpOptions = {
      headers : new HttpHeaders({
        'Content-Type' : 'application/json'
      })
    };
    return this.http.post(this.url, citiesIds, httpOptions);
  }

  getAll(){
    let city = new City();
    let cityList = new Array<City>();

    city.id = 1;
    city.name = "La Plata";
    city.imageUrl = "https://media-cdn.tripadvisor.com/media/photo-s/10/6f/91/ed/vista-aerea-de-la-ciudad.jpg";
    cityList.push(city);
    
    city = new City(); // hay q generar una nueva referencia, sino el push() toma siempre la misma referencia del objeto
    city.id = 2;
    city.name = "San Fernando del Valle de Catamarca";
    city.imageUrl = "https://1.bp.blogspot.com/-QvulrCgqVRI/Ve9NLugk8JI/AAAAAAAAJqk/avKouD_gBzA/s1600/Fotos%2Bimagenes%2BPaisajes%2Bciudad%2BCatamarca%2Bnevada%2Bnieve%2Bmonta%25C3%25B1a%2BArgentina%2Bmountains%2Bsnow%2Blandscapes%2B%25284%2529.jpg";
    cityList.push(city);

    city = new City();
    city.id = 3;
    city.name = "Resistencia";
    city.imageUrl = "http://www.aguapeynoticias.com/wp-content/uploads/2017/02/untitled-10.jpg";
    cityList.push(city);

    city = new City();
    city.id = 4;
    city.name = "Rawson";
    city.imageUrl = "https://www.welcomeargentina.com/rawson/imagenes/vista-aerea-ciudad.jpg";
    cityList.push(city);
    
    city = new City();
    city.id = 5;
    city.name = "Cordoba";
    city.imageUrl = "https://ceca-blogs-sp.s3.amazonaws.com/blogs/zurich-seguros-en-cordoba-capital400965.jpg";
    cityList.push(city);

    city = new City();
    city.id = 6;
    city.name = "Corrientes";
    city.imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Ciudaddecorrientes2.jpg/300px-Ciudaddecorrientes2.jpg";
    cityList.push(city);

    city = new City();
    city.id = 7;
    city.name = "Parana";
    city.imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Paran%C3%A1_%28Argentina%29_2537.jpg/250px-Paran%C3%A1_%28Argentina%29_2537.jpg";
    cityList.push(city);

    city = new City();
    city.id = 8;
    city.name = "Formosa";
    city.imageUrl = "https://i.pinimg.com/originals/bc/e7/f7/bce7f7cc38b47389f0a82f9bb9f9f396.jpg";
    cityList.push(city);

    city = new City();
    city.id = 9;
    city.name = "San Salvador de Jujuy";
    city.imageUrl = "https://media.todojujuy.com/adjuntos/227/imagenes/001/081/0001081988.jpg";
    cityList.push(city);

    city = new City();
    city.id = 10;
    city.name = "Santa Rosa";
    city.imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/SantaRosa006.JPG/245px-SantaRosa006.JPG";
    cityList.push(city);

    city = new City();
    city.id = 11;
    city.name = "Neuquen";
    city.imageUrl = "http://infonews.tv/subportals/static/f/YWR2Zi9pbWFnZW5lcy8yMDE2LzA4LzU3YTUyZTk5NDNhZDkuanBnfHw4MDB8fDgwMHx8dGh1bWI/57a52e9943ad9.jpg?v1.020";
    cityList.push(city);

    city = new City();
    city.id = 12;
    city.name = "San Luis";
    city.imageUrl = "https://sanluisopina.com/wp-content/uploads/2019/09/IMG-SL-CUD-733x380.jpg";
    cityList.push(city);

    return cityList;
    
  }
}
