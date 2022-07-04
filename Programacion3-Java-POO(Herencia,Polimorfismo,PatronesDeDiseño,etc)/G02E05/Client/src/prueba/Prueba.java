package prueba;

import java.util.ArrayList;

import modelo.Categoria;
import modelo.Chofer;
import modelo.Colectivo;
import modelo.Domicilio;
import modelo.Empresa;


public class Prueba {


    public static void main(String[] args) {

        Empresa empresa = Empresa.getInstancia("Colemar");
        Categoria cat1 = new Categoria("Corto",1000);
        Categoria cat2 = new Categoria("Medio",1500);
        Categoria cat3 = new Categoria("Largo",2000);
        empresa.agregarCategorias(cat1);
        empresa.agregarCategorias(cat2);
        empresa.agregarCategorias(cat3);
        Chofer chof1 = new Chofer(cat1, new Domicilio("Scaglia",5573), "Aureliano");
        Chofer chof2 = new Chofer(cat2, new Domicilio("Torini",2945), "Martina");
        Chofer chof3 = new Chofer(cat3, new Domicilio("Avellaneda",9834), "Julia");
        Chofer chof4 = new Chofer(cat1, new Domicilio("Escobar",7824), "Leon");
        empresa.agregarChofer(chof1);
        empresa.agregarChofer(chof2);
        empresa.agregarChofer(chof3);
        empresa.agregarChofer(chof4);
        Colectivo col1 = new Colectivo("Ford");
        Colectivo col2 = new Colectivo("Suzuki");
        Colectivo col3 = new Colectivo("Fiat");
        Colectivo col4 = new Colectivo("Honda");
        Colectivo col5 = new Colectivo("Peugeot");
        empresa.agregarColectivo(col1);
        empresa.agregarColectivo(col2);
        empresa.agregarColectivo(col3);
        empresa.agregarColectivo(col4);
        empresa.agregarColectivo(col5);
                        
        chof1.asignarColectivo(col1);
        chof2.asignarColectivo(col2);
        chof3.asignarColectivo(col3);
                        
        ArrayList<Chofer> choferes= empresa.getChoferes();
        ArrayList<Colectivo> colectivos= empresa.getColectivos();
                        
        int cant=0;
        for(int i=0; i<choferes.size();i++)
        if(choferes.get(i).getColectivo()==null)
            cant++;
        System.out.println(cant+" choferes no tienen colectivo asignado");
                        
        System.out.println("La empresa tiene "+colectivos.size()+" colectivos");
                        
        for(int i=0; i<choferes.size();i++)
        {
            if(choferes.get(i).getCategoria()==cat1)
            System.out.println(choferes.get(i).getNombre()+" pertenece a "+cat1.getNombreCategoria());
        }
                        
        ArrayList<Categoria> categorias = empresa.getCategorias();
        for(int i=0; i<categorias.size(); i++)
            if(categorias.get(i).getSueldo()>1200)
                System.out.println("La categoria "+categorias.get(i).getNombreCategoria()+" supera el sueldo de $1200");
                        
        for(int i=0; i<choferes.size();i++)
            if(choferes.get(i).getCategoria().getSueldo()>1200)
                System.out.println("El chofer "+choferes.get(i).getNombre()+" tiene un sueldo superior a 1200");
                }

}
