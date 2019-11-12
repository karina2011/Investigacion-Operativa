package InvestigacionOperativa.TeoriaDeRedes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private Integer origin;
    private List cities;
}
