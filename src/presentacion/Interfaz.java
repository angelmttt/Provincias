package presentacion;
import dominio.*;
import java.io.*;
import java.util.*;
private static Scanner sc = new Scanner(System.in);
public class Interfaz {
    public static boolean procesarPeticion (String peticion, ArrayList<Provincia> l){
        String [] p=peticion.split(" ");
        if (p[0].equals("addProvincia"))
            if (p.length!=2)// peticion erronea
                System.out.print("peticion erronea. Pida la ayuda 'help'");
            else
                aniadirProvincia(p[1],l);
        else if (p[0].equals("addMunicipio"))
            if (p.length!=2)// peticion erronea
                System.out.print("peticion erronea. Pida la ayuda 'help'");
            else
                aniadirMunicipio(p[1],l);
        else if (p[0].equals("addLocalidad"))
            if (p.length!=2)// peticion erronea
                System.out.print("peticion erronea. Pida la ayuda 'help'");
            else
                aniadirLocalidad(p[1],l);
        else if (p.length!=1)// peticion erronea
            System.out.print("peticion erronea. Pida la ayuda 'help'");
        else if (p[0].equals("list"))
            System.out.print (l);
        else if (p[0].equals("help"))
            System.out.print("introduzca ua de las siguientes peticiones: \n addProvindia nombre: añadir provincia\n addMunicipio nombre: añadir Municipio\n addLocalidad nombre: añadir Localidad\n list: listar la agenda\n exit: salir\n");
        else if (p[0].equals("exit"))
            return false;
        else {
            System.out.print("petición erronea");
            procesarPeticion("help",l);
        }
        return true;//en todos los casos debe seguir pidiendo y procesando peticiones
    }
    public static void aniadirProvincia(String nombre, ArrayList<Provincia> l){
        Provincia p=new Provincia(nombre);
        l.add(p);
    }

    public static void aniadirMunicipio(String nombre, ArrayList<Provincia> l){
        Municipio m=new Municipio(nombre);
        for (int i=0;i<l.size();i++)
            System.out.println(i+": " + l.get(i)getNombre());
        System.out.print("Introduzca el número de la provincia: ");
        int i=sc.nextInt();
        sc.nextLine();
        l.get(i).add(m);
    }

    public static void aniadirLocalidad(String nombre, ArrayList<Provincia> l){
        Localidad l=new Localidad(nombre);
        for (int i=0;i<l.size();i++)
            System.out.println(i+": " + l.get(i)getNombre());
        System.out.print("Introduzca el número de la provincia: ");
        int i=sc.nextInt();
        sc.nextLine();
        for (int j=0;j<l.get(i).size();j++)
            System.out.println(j+": " + l.get(i).get(j)getNombre());
        System.out.print("Introduzca el número del municipio: ");
        int j=sc.nextInt();
        sc.nextLine();
        l.get(i).get(j).add(l);
    }
    public static String leerPeticion(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }

    public static ArrayList<Provincia>leer(){
        ArrayList<Provincia> provincias=new ArrayList<Provincia>();
        Scanner sc=new Scanner(System.in);
            String nombreP, nombreM, nombreL;
            do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar: ");
            nombreP=sc.nextLine();
            if(!nombreP.equals("")){
                Provincia provincia=new Provincia(nombreP);
                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar: ");
                    nombreM=sc.nextLine();
                    if(!nombreM.equals("")){
                        Municipio municipio=new Municipio(nombreM);
                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar: ");
                            nombreL=sc.nextLine();
                            if(!nombreL.equals("")){
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion=sc.nextInt();
                                sc.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                        provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
                provincias.add(provincia);
            }
    }
    while (!nombreP.equals(""));

    return provincias;
    }
}