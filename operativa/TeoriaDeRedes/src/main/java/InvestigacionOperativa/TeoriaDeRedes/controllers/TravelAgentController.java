package InvestigacionOperativa.TeoriaDeRedes.controllers;

import InvestigacionOperativa.TeoriaDeRedes.models.City;
import InvestigacionOperativa.TeoriaDeRedes.models.TravelAgent;
import InvestigacionOperativa.TeoriaDeRedes.models.TravelReturn;
import lombok.Data;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static java.util.Objects.isNull;

@Data

public class TravelAgentController {
    private HashMap<Integer,ArrayList<TravelAgent>> matriz;
    private HashMap<Integer,City>cities;
    public TravelAgentController(HashMap<Integer,City>cit){
        this.matriz=new HashMap<>();
        cities=cit;
        initialize(cit);
    }

    public void initialize(HashMap<Integer, City> cities){
        //TravelAgent oneTravelAgent=new TravelAgent();
        ArrayList<TravelAgent> columnMatriz=new ArrayList<>();
        for (HashMap.Entry<Integer,City> column: cities.entrySet()) {
            ArrayList<TravelAgent> finalColumnMatriz = columnMatriz;
            column.getValue().getDistances().forEach((k, v) -> {
                TravelAgent oneTravelAgent=new TravelAgent();
                oneTravelAgent.setColumn(column.getKey());
                oneTravelAgent.setRow((Integer) k);
                oneTravelAgent.setName(column.getValue().getName());
                if ((Integer) v > 0) {
                    oneTravelAgent.setDistance((Integer) v);
                    oneTravelAgent.setDistanceOriginal((Integer) v);
                } else {
                    oneTravelAgent.setDistance(100000);
                    oneTravelAgent.setDistanceOriginal(0);
                }
                oneTravelAgent.setPivote(-1);
                finalColumnMatriz.add(oneTravelAgent);
            });
            this.matriz.put(column.getKey(),columnMatriz);
            columnMatriz=new ArrayList<TravelAgent>();
        }
    }

    public Integer getMinValueColumn(Integer column, Integer rowActual){
        ArrayList<TravelAgent> columnTravel=new ArrayList<>();
        columnTravel=this.matriz.get(column);
        Integer min[]={-1};
        columnTravel.forEach(v->{
            if(v.getRow()!=rowActual) {
                if (min[0] == -1) {
                    min[0] = v.getDistance();
                } else {
                    if (v.getDistance() < min[0]) {
                        min[0] = v.getDistance();
                    }
                }
            }
        });
        return min[0];
    }

    public Integer getMinValueRow(Integer row, Integer columnActual){
        Integer min[]={-1};
        this.matriz.forEach((k,v)->{
            v.forEach(vr->{
                if(vr.getColumn()!=columnActual) {
                    if (vr.getRow() == row) {
                        if (min[0] == -1) {
                            min[0] = vr.getDistance();
                        } else {
                            if (vr.getDistance() < min[0]) {
                                min[0] = vr.getDistance();
                            }
                        }
                    }
                }
            });
        });
        return min[0];
    }

    public void getZeroColumn(Integer column){
        Integer min=getMinValueColumn(column,10000);
        ArrayList<TravelAgent> columnTravel=new ArrayList<>();
        columnTravel=this.matriz.get(column);
        columnTravel.forEach(va->{
            va.setDistance(va.getDistance()-min);
        });
    }


    public Boolean haveZeroRow (Integer row){
        Integer haveZero[]={0};
        this.matriz.forEach((k,v)->{
            v.forEach(vd->{
                if(vd.getRow()==row){
                    if(vd.getDistance()==0){
                        haveZero[0]=1;
                    }
                }
            });
        });
        return (haveZero[0]==1);
    }

    public void getZeroRow(Integer row){
        Integer min=getMinValueRow(row,10000);
        this.matriz.forEach((k,v)->{
            v.forEach(vc->{
                if(vc.getRow()==row){
                    vc.setDistance(vc.getDistance()-min);
                }
            });
        });
    }

    public void getZeroMatriz(){
        this.matriz.forEach((k,v)->{
            getZeroColumn(k);
        });
        ArrayList<TravelAgent> lista=new ArrayList<>();
        Iterator it = matriz.keySet().iterator();
        while(it.hasNext()){
            lista=matriz.get(it.next());
        }
        lista.forEach(v->{
                if(!haveZeroRow(v.getRow())){
                    getZeroRow(v.getRow());
                }
        });
    }

    public void getSumMinPivote(){
        this.matriz.forEach((k,v)->{
            v.forEach(vr->{
                if(vr.getDistance()==0){
                    vr.setPivote(getMinValueColumn(vr.getColumn(),vr.getRow())+getMinValueRow(vr.getRow(),vr.getColumn()));
                }
            });
        });
    }

    public TravelAgent getMaxPivote(){
        Integer max=-1;
        TravelAgent one=new TravelAgent();
        for (HashMap.Entry<Integer, ArrayList<TravelAgent>> entry : matriz.entrySet()) {
            for (TravelAgent vr: entry.getValue()) {
                if(vr.getPivote()>max){
                    max=vr.getPivote();
                    one=vr;
                }
            };
        };
        return one;
    }

    public void initializePivote(){
        matriz.forEach((k,v)->{
                v.forEach(t->{
                    t.setPivote(-1);
                });
        });
    }

    public boolean cierra(TravelAgent one, ArrayList<TravelAgent>travel){
        boolean res=false;
        for (TravelAgent v: travel) {
            if ((v.getColumn() == one.getRow()) && matriz.size() > 2) {
                res = true;
            }
        }
        return res;
    }

    public TravelAgent oneTravelAgent(ArrayList<TravelAgent> travel) {
        initializePivote();
        getZeroMatriz();
        getSumMinPivote();
        TravelAgent oneTravel = getMaxPivote();
        if (cierra(oneTravel,travel)){
            ArrayList<TravelAgent> aux= matriz.get(oneTravel.getColumn());
            TravelAgent finalOneTravel2 = oneTravel;
            aux.forEach(v->{
                if(v.getRow()== finalOneTravel2.getRow()){
                    v.setDistance(100000);
                    v.setPivote(-1);
                }
            });
            initializePivote();
            getZeroMatriz();
            getSumMinPivote();
            oneTravel = getMaxPivote();
        }
        boolean aux;
        this.matriz.remove(oneTravel.getColumn());
        for (HashMap.Entry<Integer, ArrayList<TravelAgent>> entry : matriz.entrySet()) {
            TravelAgent finalOneTravel = oneTravel;
            aux = entry.getValue().removeIf(v1->(v1.getRow()== finalOneTravel.getRow()));
        }
        ArrayList<TravelAgent> inverso;
        if (this.matriz.containsKey(oneTravel.getRow())) {
            inverso = this.matriz.get(oneTravel.getRow());
            TravelAgent finalOneTravel1 = oneTravel;
            inverso.forEach(v->{
                if(v.getRow()== finalOneTravel1.getColumn()) {
                    v.setDistance(1000000);
                    v.setPivote(-1);
                }
            });
        }
        return oneTravel;
    }



    public TravelAgent getCity(Integer row, ArrayList<TravelAgent> oneRoad){
        TravelAgent oneCity=new TravelAgent();
        for (TravelAgent one:oneRoad) {
            if(one.getRow()==row){
                oneCity=one;

            }
        }
        oneRoad.remove(oneCity);
        //System.out.println(oneCity);
        return  oneCity;
    }

    public TravelAgent last (ArrayList<TravelAgent> orderTravel){
        TravelAgent last=new TravelAgent();
        for (TravelAgent one: orderTravel){
            last=one;
        }
        return last;
    }

    public ArrayList<TravelAgent> orderTravel(ArrayList<TravelAgent> oneRoad){
        ArrayList<TravelAgent> orderTravel= new ArrayList<>();
        TravelAgent one;
        orderTravel.add(getCity(0,oneRoad));
        while (oneRoad.size()>0){
            one=last(orderTravel);
            //System.out.println(one.getColumn());
            orderTravel.add(getCity(one.getColumn(),oneRoad));
        }
        return orderTravel;
    }


    public ArrayList metodTravelAgent (){
        ArrayList<TravelAgent> travel=new ArrayList<>();
        while(this.matriz.size()>1){
            travel.add(oneTravelAgent(travel));
        }
        if(matriz.size()>0) {
            ArrayList<TravelAgent> finalTravel = travel;
            matriz.forEach((v, k) -> {
                k.forEach(ultimo -> {
                    finalTravel.add(ultimo);
                });
            });
        }

        return travel;
    }

   public TravelReturn getTravel (){
        TravelReturn oneTravel=new TravelReturn();
        Integer dist[]={0};
        ArrayList<String> listTravel=new ArrayList<>();
        ArrayList<TravelAgent> oneRoad= metodTravelAgent();
       /*oneRoad.forEach(v->{
           System.out.println("column "+v.getColumn()+"row"+v.getRow());
       });*/
        oneRoad=orderTravel(oneRoad);

        listTravel.add("Mar del Plata");
       final TravelAgent[] first = {new TravelAgent()};
        oneRoad.forEach(v->{
            listTravel.add(v.getName());
            dist[0]=dist[0]+v.getDistanceOriginal();
        });
        oneTravel.setKm(dist[0]);
        oneTravel.setTravel(listTravel);
        return oneTravel;
    }
}
