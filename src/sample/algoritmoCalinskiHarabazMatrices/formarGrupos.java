package sample.algoritmoCalinskiHarabazMatrices;

/**
 * Created by Villegas on 03/10/2015.
 */
public class formarGrupos {
    public double[][] formarGrupos(double [][] cGrupos,int [][] grupos, Double [][] objetos){
        for(int i = 0; i < grupos.length; i++){//Numero de grupos
            int [] g = new int [grupos[i].length];
            for(int j = 0; j < grupos[i].length; j++){//Numero de elementos de cada grupo
                g[j] = grupos[i][j];
            }
            double [] cGrup;
            cGrup = matrizGrupo(g, objetos);
            for(int k =0; k <objetos[0].length;k++){
                cGrupos[i][k] = cGrup[k];
            }
        }
        return cGrupos;
    }

    public double[] matrizGrupo(int [] g, Double[][] objetos){
        //recibo un arreglo con los objetos que componen un grupo

        int filas = g.length;
        int columnas = objetos[0].length;
        double [][] matrizGrupo = new double[filas][columnas];

        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(objetos[g[i]][j]!=null) {
                    matrizGrupo[i][j] = objetos[g[i]][j];
                }
            }
        }



        double[] mediaCentro = centros(matrizGrupo);

        return mediaCentro;

    }

    //******************************************************************************************

    public double[] centros(double[][] objetos){
        int numeroObjetos = objetos.length;
        int numeroAtributos = objetos[0].length;
        double mediaCentro[] = new double[numeroAtributos];

        for (int k=0; k<numeroAtributos; k++)
            for (int i=0; i<numeroObjetos; i++)
                mediaCentro[k] = mediaCentro[k] + objetos[i][k];

        for(int i = 0;i < mediaCentro.length; i++){
            mediaCentro[i] = (mediaCentro[i]/numeroObjetos);
        }
        return mediaCentro;
    }
}
