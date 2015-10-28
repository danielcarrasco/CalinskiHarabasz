package sample.Clases;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sample.Registro;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by mauricio on 7/10/15.
 */
public class BorrarRegistro {
    public void borrarTablaGrafica(TableView<Registro> tb) {
        //BORRAR DE LA TABLA
        ObservableList<Registro> allProducts, removeProducts;
        allProducts = tb.getItems();
        removeProducts = tb.getSelectionModel().getSelectedItems();
        removeProducts.forEach(allProducts::remove);
    }


    //Se recibe el valor seleccionador de fila y los objetos del cluster
    public ArrayList elimnarAtributo(int aEliminar, ArrayList objetos) {

        //**************************Segmento para eliminar atributos o columnas de lista de objetos o registros

        Iterator it = objetos.iterator();
        ArrayList<String> aux;
        int i= 0;
        while (it.hasNext()) {
            it.next();
            aux = (ArrayList<String>) objetos.get(i);
            //Eliminas la fila
            aux.remove(aEliminar);
            i++;
        }
        //imprimir resultado
        Iterator it2 = objetos.iterator();
        int j = 0;
        while (it2.hasNext()) {
            it2.next();
            j++;
        }

        return objetos;
    }
    //Se elimina el domino de los atributos
    public ArrayList elimnarDominio(int aEliminar, ArrayList aDominio){
        //**************************Segmento para eliminar atributos o fila de atributo-dominio

        aDominio.remove(aEliminar);
        ArrayList<String> auxb;


        for(int y = aEliminar; y < aDominio.size(); y++){
            auxb = (ArrayList<String>) aDominio.get(y);
            int nuevoV = Integer.parseInt(auxb.get(0));
            auxb.set(0,Integer.toString(nuevoV-1));
        }



        return aDominio;
    }

}

