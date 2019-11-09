package InvestigacionOperativa.TeoriaDeRedes.controllers;

import InvestigacionOperativa.TeoriaDeRedes.models.City;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*id   ciudad
 *  0  Mar del Plata
 *  1  La Plata
 *  2  San Fernando del Valle de Catamarca
 *  3  Resistencia
 *  4  Rawson
 *  5  Cordoba
 *  6  Corrrientes
 *  7  Parana
 *  8  Formosa
 *  9  San Salvador de Jujuy
 * 10  Santa Rosa
 * 11  Neuquen
 * 12  San Luis
*/

@Data
public class Initialize {
    private List<City> cities;
    public Initialize() {
        cities= new ArrayList<>();
        HashMap distances;

        int[] dist = new int[] {0,374,1588,1386,1181,1151,1366,968,1554,1996,749,979,1113};
        distances=initializeOne(dist);
        City oneCity = new City(0, "Mar del Plata", distances);
        cities.add(oneCity);

        dist = new int[] {374,0,1228,1026,1384,791,1006,608,1194,1636,651,1197,872};
        distances=initializeOne(dist);
        oneCity = new City(1, "La Plata", distances);
        cities.add(oneCity);

        dist = new int[] {1588,1228,0,826,1866,437,846,814,994,598,1042,979,648};
        distances=initializeOne(dist);
        oneCity = new City(2, "San Fernando del Valle de Catamarca", distances);
        cities.add(oneCity);

        dist = new int[] {1386,1026,826,0,2158,870,20,566,168,876,1334,1854,1166};
        distances=initializeOne(dist);
        oneCity = new City(3, "Resistencia", distances);
        cities.add(oneCity);

        dist = new int[] {1181,1384,1866,2158,0,1429,2275,1652,2326,2309,824,741,1349};
        distances=initializeOne(dist);
        oneCity = new City(4, "Rawson", distances);
        cities.add(oneCity);

        dist = new int[] {1151,791,437,870,1429,0,890,377,1038,880,605,1116,443};
        distances=initializeOne(dist);
        oneCity = new City(5, "Cordoba", distances);
        cities.add(oneCity);

        dist = new int[] {1366,1006,846,20,2275,890,0,586,188,896,1451,1874,1186};
        distances=initializeOne(dist);
        oneCity = new City(6, "Corrientes", distances);
        cities.add(oneCity);

        dist = new int[] {968,608,814,566,1652,377,586,0,734,1120,828,1361,673};
        distances=initializeOne(dist);
        oneCity = new City(7, "Parana", distances);
        cities.add(oneCity);

        dist = new int[] {1554,1194,994,168,2326,1038,188,734,0,953,1502,2022,1334};
        distances=initializeOne(dist);
        oneCity = new City(8, "Formosa", distances);
        cities.add(oneCity);

        dist = new int[] {1996,1636,598,876,2309,880,896,1120,953,0,1485,1998,1182};
        distances=initializeOne(dist);
        oneCity = new City(9, "San Salvador de Jujuy", distances);
        cities.add(oneCity);

        dist = new int[] {749,651,1042,1334,824,605,1451,828,1502,1485,0,546,525};
        distances=initializeOne(dist);
        oneCity = new City(10, "Santa Rosa", distances);
        cities.add(oneCity);


        dist = new int[] {979,1197,979,1854,741,1116,1874,1361,2022,1998,546,0,774};
        distances=initializeOne(dist);
        oneCity = new City(11, "Neuquen", distances);
        cities.add(oneCity);

        dist = new int[] {1113,872,648,1166,1349,443,1186,673,1334,1182,525,774,0};
        distances=initializeOne(dist);
        oneCity = new City(12, "San Luis", distances);
        cities.add(oneCity);

    }

    public HashMap initializeOne(int[] dist){
        HashMap distances= new HashMap<>();
        for (int i = 0; i < dist.length; i++) {
            distances.put(i,dist[i]);
        }
        return distances;
    }

    public List<City> getCiudades(){
        return this.cities;
    }
}
