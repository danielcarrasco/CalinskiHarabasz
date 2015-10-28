package sample.algoritmoCalinskiHarabaz;

/**
 * Created by Villegas on 03/10/2015.
 */
public class centros {

    public double[] centros(Double[][] objetos){
        int numeroObjetos = objetos.length;
        //int objetosConValor=1;
        int numeroAtributos = objetos[0].length;
        //System.out.println("Objetos: " + numeroObjetos + " Atributos: " + numeroAtributos);
        //Double mediaAritmetica = 0;
        double mediaCentro[] = new double[numeroAtributos];
        int objetosConValor[] = new int[numeroAtributos];
        int oCV= 0;
        for (int k=0; k<numeroAtributos; k++) {
            for (int i = 0; i < numeroObjetos; i++) {
                if (objetos[i][k] != null) {
                    mediaCentro[k] = mediaCentro[k] + objetos[i][k];
                    oCV++;
                }
            }
            objetosConValor[k] = oCV;
            oCV =0;

        }
        for(int i =0; i< objetosConValor.length; i++) {
            System.out.println("No elementos que no son null o indefinidos");
            System.out.println(objetosConValor[i]);
        }

        System.out.println("Media Centro"+mediaCentro.length);

        for(int i = 0;i < mediaCentro.length; i++){
            mediaCentro[i] = (mediaCentro[i]/objetosConValor[i]);
            //mediaCentro[i] = (mediaCentro[i]/numeroObjetos);
            //System.out.println("Media Atributo " + (i+1) + " : " + mediaCentro[i]);
        }

        return mediaCentro;
    }

    /*public double[] centros(Double[][] objetos){
        int numeroObjetos = objetos.length;
        int numeroAtributos = objetos[0].length;
        //System.out.println("Objetos: " + numeroObjetos + " Atributos: " + numeroAtributos);
        //Double mediaAritmetica = 0;
        double mediaCentro[] = new double[numeroAtributos];

        for (int k=0; k<numeroAtributos; k++)
            for (int i=0; i<numeroObjetos; i++)
                if(objetos[i][k]!=null) {
                    mediaCentro[k] = mediaCentro[k] + objetos[i][k];
                }

        for(int i = 0;i < mediaCentro.length; i++){
            mediaCentro[i] = (mediaCentro[i]/numeroObjetos);
            //System.out.println("Media Atributo " + (i+1) + " : " + mediaCentro[i]);
        }
        return mediaCentro;
    }*/

}