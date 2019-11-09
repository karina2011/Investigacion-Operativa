package InvestigacionOperativa.TeoriaDeRedes.models;

import java.util.ArrayList;

public class TravelReturn {
    private ArrayList<String> travel;
    private Integer km;

    public TravelReturn() {
        this.travel=new ArrayList<>();
        this.km = 0;
    }

    public ArrayList<String> getTravel() {
        return travel;
    }

    public Integer getKm() {
        return km;
    }

    public void setTravel(ArrayList<String> travel) {
        this.travel = travel;
    }

    public void setKm(Integer km) {
        this.km = km;
    }
}
