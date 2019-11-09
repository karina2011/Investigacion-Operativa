package InvestigacionOperativa.TeoriaDeRedes.controllers;

import InvestigacionOperativa.TeoriaDeRedes.models.City;

import InvestigacionOperativa.TeoriaDeRedes.models.TravelReturn;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class CityController {
    List<City> cities;

    public CityController() {
        Initialize ini = new Initialize();
        this.cities = ini.getCiudades();
    }

    public TravelReturn getEconomicPath(int origin, List travel){
        //recibe la lista con lo id un hash con el numero de id de la ciudad como key
        travel.add(origin);
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
