package sample.algoritmoCalinskiHarabazMatrices;


/**
 * Created by Villegas on 03/10/2015.
 */
public class distanciaEuclidiana {
    public double[] distanciaEuclidianas(double [] distanciasE,int [][] grupos, Double [][] objetos,double [][] cGrupos){

        for(int i = 0; i < grupos.length; i++){//Numero de grupos
            int [] g = new int [grupos[i].length];
            for(int j = 0; j < grupos[i].length; j++){//Numero de elementos de cada grupo
                g[j] = grupos[i][j];
            }

            distanciasE[i] = calculoEuclidianaG(g, i, objetos, cGrupos);
        }
        return distanciasE;
    }

    public double calculoEuclidianaG(int [] g, int ng, Double[][] objetos, double [][] cGrupos){
        double [] distanciaEG = new double[g.length];
        double rsum = 0;
        for (int i=0; i < g.length; i++){
            distanciaEG[i] = distanciaEOC(objetos[g[i]], cGrupos[ng]);
        }
        for (int i =0; i < distanciaEG.length; i++){
            rsum = rsum + distanciaEG[i];
        }
        return rsum;
    }

    //saca distancia de un objeto a centro
    public double distanciaEOC(Double [] objeto, double [] cGrupo){

        double [] r = new double [objeto.length];
        for (int i = 0; i < objeto.length; i++){
            if(objeto[i]!=null) {
                r[i] = Math.pow((objeto[i] - cGrupo[i]), 2);
            }
        }
        double r2 =0;
        for (int i = 0; i < r.length; i++){
            r2 = r2 + r[i];
        }
        return Math.sqrt(r2);
    }

    //saca distancia de un conjunto de objetos con centro de su grupo
    public double[] distanciaECentros(double [] distanciasCC, Double [] cGlobal, double[][] cGrupos){
        for(int i = 0; i < cGrupos.length; i++){
            distanciasCC[i] = distanciaEOC(cGlobal, cGrupos[i]);
        }
        return distanciasCC;
    }
}
