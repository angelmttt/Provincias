package dominio;
import java.util.ArrayList;
import java.io.Serializable;
public class Provincia extends Serializable
    private String nombre;
    private ArrayList<Municipio> municipios;
    public Provincia(String nombre_) {
        nombre=nombre_;
        municipios=new ArrayList<Municipio>();
    }
    public Provincia add(Municipio municipio){
        municipios.add(municipio);
        return this;
    }
    public int getPoblacion(){
        int poblacion=0;
        for(Municipio municipio:municipios){
        poblacion+=municipio.getPoblacion();
        }
        return poblacion;
    }
    public int getMunicipios(){
        return municipios.size();
    }
    public Municipio getMunicipio(int i){
        return municipios.get(i);
    }
    public String toString(){
        return "Provincia: "+nombre+" Población: "+getPoblacion() +" habitantes\n"+municipios.toString();
    }

}