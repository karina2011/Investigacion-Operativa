package InvestigacionOperativa.TeoriaDeRedes.controllers;

import InvestigacionOperativa.TeoriaDeRedes.models.City;

import InvestigacionOperativa.TeoriaDeRedes.models.TravelReturn;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Data
@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST}) // soluciona el problema de CORS al hacer la peticion desde Angular
public class CityController {
    List<City> cities;

    public CityController() {
        Initialize ini = new Initialize();
        this.cities = ini.getCiudades();
    }

    @PostMapping("")
    public TravelReturn getEconomicPath(@RequestBody List<Integer> travel){
        System.out.println("Solicitud recibida");
        //recibe la lista con lo id un hash con el numero de id de la ciudad como key
        travel.add(0); // 0 porq siempre es el origen
        HashMap<Integer, City> citiesTravel= getPath(travel);
        TravelReturn road;
        TravelAgentController travelAgent=new TravelAgentController(citiesTravel);
        road=travelAgent.getTravel();
        return road;
    }

    //citiesPath contien la lista con los id de ciudades por donde debe pasar el viajante
    //este metodo genera una nueva lista de ciudades que solo contien los lugares por donde debe pasar el viajante y las distancias solo contienen las distancias a donde debe ir
    private HashMap<Integer, City> getPath (List<Integer> citiesPathId){
        HashMap<Integer,City> newCities=new HashMap<>();
        City oneCity;
        for (Integer cityId : citiesPathId) {
            oneCity = cities.get(cityId);
            oneCity.setDistances(newDistances(oneCity.getDistances(),citiesPathId));
            newCities.put(cityId, oneCity);
        }
        return newCities;
    }

    private HashMap<Integer,Integer> newDistances(HashMap<Integer, Integer> distances, List<Integer> citiesPathId){
        HashMap<Integer,Integer> newDistances=new HashMap<>();
        for (Integer cityId : citiesPathId){
            newDistances.put(cityId,distances.get(cityId));
        }
        return  newDistances;
    }

}
