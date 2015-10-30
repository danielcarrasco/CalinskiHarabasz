package sample.algoritmoCalinskiHarabaz;

/**
 * Created by Villegas on 03/10/2015.
 */
public class centros {

    public double[] centros(Double[][] objetos){
        int numeroObjetos = objetos.length;
        int numeroAtributos = objetos[0].length;
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


        for(int i = 0;i < mediaCentro.length; i++){
            mediaCentro[i] = (mediaCentro[i]/objetosConValor[i]);
        }

        return mediaCentro;
    }


}