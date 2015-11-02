package sample.algoritmoCalinskiHarabazMatrices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Villegas on 03/10/2015.
 */
public class quitaJuanito {
    public ArrayList<List<String>> getOutJuanito(ArrayList juan, Integer val) {

        if(val == 0) {
            ArrayList<List<String>> nueva;
            nueva = (ArrayList<List<String>>) juan.clone();
            Iterator it = nueva.iterator();
            while (it.hasNext()) {
                ArrayList<String> aux = (ArrayList<String>) it.next();
                aux.remove(0);
            }
            return nueva;
        }
        else
            return juan;
    }
}

//matriz de objetos
// 1,2,4,5
// 1,2,4,5

//Grupos objetos
// +50000,1,2,3
// -50000,4,5,6