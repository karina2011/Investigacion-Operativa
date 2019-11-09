package InvestigacionOperativa.TeoriaDeRedes.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.HashMap;

@Data

public class City {
    private Integer id;
    private String name;
    private HashMap<Integer,Integer> distances;

    public City(Integer id, String name, HashMap<Integer, Integer> distances) {
        this.id = id;
        this.name = name;
        this.distances = distances;
    }

    @Override
    public String toString() {
        return this.name+distances.get(1);
    }

    public HashMap getDistances(){
        return this.distances;
    }

    public void setDistances(HashMap<Integer,Integer> newDistances){
        this.distances=newDistances;
    }

    public String getName() {
        return name;
    }
}
