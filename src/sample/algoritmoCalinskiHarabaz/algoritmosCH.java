package sample.algoritmoCalinskiHarabaz;
/**
 * Created by Villegas on 03/10/2015.
 */
public class algoritmosCH {
    public double algoritmoNumerador(int nObjetos, int nGrupos, int [][] grupos, double [] distanciasCC){
        double e1 = (nObjetos-nGrupos);
        double e2=0;
        for (int i = 0; i < nGrupos; i++){
            e2 = e2 + ((grupos[i].length)*(distanciasCC[i]));
        }

        return (e1*e2);
    }

    public  double algoritmoDenominador(int nGrupos, double [] distanciasCC){
        double e1 = (nGrupos-1);
        double e2 = 0;
        for (int i = 0; i < distanciasCC.length; i++){
            e2 = e2 + distanciasCC[i];
        }

        return (e1*e2);
    }
}
