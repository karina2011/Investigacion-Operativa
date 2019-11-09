package InvestigacionOperativa.TeoriaDeRedes.models;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TravelAgent {
    private Integer row;
    private Integer column;
    private Integer distance;
    private Integer distanceOriginal;
    private Integer pivote;
    private String name;

    public Integer getRow() {
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getDistanceOriginal() {
        return distanceOriginal;
    }

    public Integer getPivote() {
        return pivote;
    }

    public String getName() { return  name; }

    public void setName(String name) { this.name=name; }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setDistanceOriginal(Integer distanceOriginal) {
        this.distanceOriginal = distanceOriginal;
    }

    public void setPivote(Integer pivote) {
        this.pivote = pivote;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TravelAgent){
            TravelAgent temp=(TravelAgent)obj;
            if(this.getColumn()==temp.getColumn()){
                if(this.getRow()==temp.getRow()){
                    //System.out.println("true");
                    return true;
                }
            }
        }
        //System.out.println("false");
        return false;
    }
}
