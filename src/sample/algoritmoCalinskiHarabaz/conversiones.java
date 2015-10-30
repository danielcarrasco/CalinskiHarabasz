package sample.algoritmoCalinskiHarabaz;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Villegas on 03/10/2015.
 */
public class conversiones {
    public Double[][] conversionObjetos(ArrayList objetos) {

        Iterator it = objetos.iterator();
        int numeroObjetos = 0;
        Double [][] matrizObjetos;
        ArrayList<String> aux;
        matrizObjetos = new Double[objetos.size()][];


        while (it.hasNext()) {
            it.next();
            aux = (ArrayList<String>) objetos.get(numeroObjetos);
            matrizObjetos[numeroObjetos] = new Double[aux.size()];
            for (int i = 0; i < aux.size(); i++) {

                if(aux.get(i)!=null){
                    if(aux.get(i).equals("?")){
                        matrizObjetos[numeroObjetos][i] = null;
                    }else{
                        matrizObjetos[numeroObjetos][i] = Double.parseDouble(aux.get(i));
                    }
                }

            }
            numeroObjetos++;
        }

        return matrizObjetos;
    }


    public int [][] conversionGrupos(ArrayList grupos){

        Iterator it = grupos.iterator();
        int numeroGrupos = 0;
        int [][] matrizGrupos;
        ArrayList<String> aux;
        matrizGrupos=new int[grupos.size()][];

        while(it.hasNext()){
            it.next();
            aux = (ArrayList<String>) grupos.get(numeroGrupos);
            matrizGrupos[numeroGrupos]=new int[aux.size()];
            for(int i=0;i<aux.size();i++){
                matrizGrupos[numeroGrupos][i]=Integer.parseInt(aux.get(i));
            }
            numeroGrupos++;
        }
        
        return matrizGrupos;
    }
}
