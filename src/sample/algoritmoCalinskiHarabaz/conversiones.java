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
        ArrayList<String> aux = new ArrayList();
        //System.out.println(objetos.get(0));
        aux = (ArrayList<String>) objetos.get(numeroObjetos);
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

        System.out.println("Conversion ArrayList Objetos a matriz float");

        for (int i = 0; i < matrizObjetos.length; i++) {
            for (int j = 0; j < matrizObjetos[i].length ; j++) {
                System.out.print(matrizObjetos[i][j]+" ");
            }
            System.out.println();
        }

        return matrizObjetos;
    }


    public int [][] conversionGrupos(ArrayList grupos){

        Iterator it = grupos.iterator();
        int numeroGrupos = 0;
        int [][] matrizGrupos;
        ArrayList<String> aux= new ArrayList();
        matrizGrupos=new int[grupos.size()][];


        //System.out.println("Numero de Grupos: "+grupos.size());

        //System.out.println("Arraylist de String");
        while(it.hasNext()){
            //System.out.println(it.next());
            it.next();
            aux = (ArrayList<String>) grupos.get(numeroGrupos);
            matrizGrupos[numeroGrupos]=new int[aux.size()];
            for(int i=0;i<aux.size();i++){
                matrizGrupos[numeroGrupos][i]=Integer.parseInt(aux.get(i));
            }
            numeroGrupos++;
        }

        System.out.println("Conversion ArrayList de grupos a matriz int");

        for (int i = 0; i < matrizGrupos.length; i++) {
            for (int j = 0; j < matrizGrupos[i].length ; j++) {
                System.out.print(matrizGrupos[i][j]+" ");
            }
            System.out.println();
        }
        return matrizGrupos;
    }
}
