package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        ArrayList<Provincia> provincias=new ArrayList<Provincia>();
        String peticion;
        Interfaz.procesarPeticion("help",provincias);// para que muestre la ayuda al principio
        do {
            peticion=Interfaz.leerPeticion();
        } while (Interfaz.procesarPeticion(peticion,provincias));
    }
}
