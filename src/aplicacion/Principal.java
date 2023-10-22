package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        ArrayList<Provincia> provincias=Interfaz.leer();
        for(Provincia provincia:provincias){
            System.out.println(provincia);
        }
    }
}
