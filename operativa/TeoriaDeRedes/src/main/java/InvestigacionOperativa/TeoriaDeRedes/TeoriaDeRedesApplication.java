package InvestigacionOperativa.TeoriaDeRedes;

import InvestigacionOperativa.TeoriaDeRedes.controllers.CityController;
import InvestigacionOperativa.TeoriaDeRedes.controllers.Initialize;
import InvestigacionOperativa.TeoriaDeRedes.models.City;
import InvestigacionOperativa.TeoriaDeRedes.models.TravelAgent;
import InvestigacionOperativa.TeoriaDeRedes.models.TravelReturn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TeoriaDeRedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeoriaDeRedesApplication.class, args);
		CityController road=new CityController();
		TravelReturn oneRoad=new TravelReturn();
		List cities=new ArrayList();
		cities.add(1);
        cities.add(2);
        cities.add(3);
		cities.add(5);
		cities.add(7);
		cities.add(9);
        cities.add(11);
        cities.add(12);
        cities.add(4);
        cities.add(10);
		cities.add(11);

		oneRoad=road.getEconomicPath(cities);
		oneRoad.getTravel().forEach(v->{
			System.out.println(v.toString());
		});
		System.out.println(oneRoad.getKm());
	}

}
