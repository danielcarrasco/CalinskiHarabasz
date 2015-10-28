package sample.algoritmoCalinskiHarabaz;

/**
 * Created by Villegas on 03/10/2015.
 */
public class formarGrupos {
    public double[][] formarGrupos(double [][] cGrupos,int [][] grupos, Double [][] objetos){
        //System.out.println(grupos.length);
        System.out.println("");
        System.out.println("Formando Grupos");
        for(int i = 0; i < grupos.length; i++){//Numero de grupos
            int [] g = new int [grupos[i].length];
            for(int j = 0; j < grupos[i].length; j++){//Numero de elementos de cada grupo
                g[j] = grupos[i][j];
            }
            double [] cGrup;
            cGrup = matrizGrupo(g, objetos);
            System.out.println("Centro de grupo");
            for(int k =0; k <objetos[0].length;k++){
                cGrupos[i][k] = cGrup[k];
                System.out.print(cGrupos[i][k]+" ");
            }
            System.out.println("");
            System.out.println("");
        }
        return cGrupos;
    }

    public double[] matrizGrupo(int [] g, Double[][] objetos){
        //recibo un arreglo con los objetos que componen un grupo

        int filas = g.length;
        int columnas = objetos[0].length;
        System.out.println("Filas " + filas + " Columnas" + columnas);
        double [][] matrizGrupo = new double[filas][columnas];

        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                if(objetos[g[i]][j]!=null) {
                    matrizGrupo[i][j] = objetos[g[i]][j];
                }
            }
            //System.out.print(g[i]+ " ");
        }

        for(int i = 0; i < filas; i++){
            //System.out.println( + " ");
            for(int j = 0; j < columnas; j++){
                System.out.print(matrizGrupo[i][j] + " ");
            }
            System.out.println("");
        }

        double[] mediaCentro = centros(matrizGrupo);
        //for(int i =0; i < mediaCentro.length; i++)
        //  System.out.print("Centro: " + mediaCentro[i] + " ");

        return mediaCentro;

    }

    //******************************************************************************************

    public double[] centros(double[][] objetos){
        int numeroObjetos = objetos.length;
        int numeroAtributos = objetos[0].length;
        //System.out.println("Objetos: " + numeroObjetos + " Atributos: " + numeroAtributos);
        double mediaAritmetica = 0;
        double mediaCentro[] = new double[numeroAtributos];

        for (int k=0; k<numeroAtributos; k++)
            for (int i=0; i<numeroObjetos; i++)
                /*if(objetos[i][k]!=null) {
                    mediaCentro[k] = mediaCentro[k] + objetos[i][k];
                }*/
                mediaCentro[k] = mediaCentro[k] + objetos[i][k];
        for(int i = 0;i < mediaCentro.length; i++){
            mediaCentro[i] = (mediaCentro[i]/numeroObjetos);
            //System.out.println("Media Atributo " + (i+1) + " : " + mediaCentro[i]);
        }
        return mediaCentro;
    }
}
