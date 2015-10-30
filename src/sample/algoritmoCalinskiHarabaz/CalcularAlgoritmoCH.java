package sample.algoritmoCalinskiHarabaz;

import java.util.ArrayList;

/**
 * Created by Villegas on 03/10/2015.
 */
public class CalcularAlgoritmoCH {

    public double calcularAlgoritmo(ArrayList obj, ArrayList grp, Integer val){


        conversiones conv = new conversiones();
        centros cen = new centros();
        formarGrupos fg = new formarGrupos();
        distanciaEuclidiana de = new distanciaEuclidiana();
        algoritmosCH ach = new algoritmosCH();
        quitaJuanito qJ =new quitaJuanito();

        int nObjetos;
        int nAtributos;
        int nGrupos;
        Double [][] objetos;
        conv.conversionObjetos(obj);
        int [][] grupos;
        double [] cGlobal;

        //-----Objetos-------------------
        objetos = conv.conversionObjetos(obj);
        nObjetos = objetos.length;
        nAtributos = objetos[0].length;
        cGlobal = cen.centros(objetos);
        Double[] cGlobalT = new Double [cGlobal.length];
        for(int i = 0; i< cGlobal.length; i++){
            cGlobalT[i] = cGlobal[i];
        }


        //----Grupos
        //grupos = conv.conversionGrupos(grupoa);

        grupos = conv.conversionGrupos(qJ.getOutJuanito(grp, val));
        nGrupos = grupos.length;
        double [][] cGrupos = new double[nGrupos][nAtributos];
        //--Formar Grupos
        fg.formarGrupos(cGrupos,grupos, objetos);


        //------Distancia euclidiana
        double[] distanciasE = new double[nGrupos];
        distanciasE = de.distanciaEuclidianas(distanciasE,grupos,objetos,cGrupos);

        //---------Distancia euclidiana Cnetros centros
        double[] distanciasCC = new double [cGrupos.length];
        distanciasCC = de.distanciaECentros(distanciasCC, cGlobalT, cGrupos);


        //--------Resultado algoritmo
        double aNumerador;
        double aDenominador;
        aNumerador = ach.algoritmoNumerador(nObjetos, nGrupos, grupos, distanciasCC);
        aDenominador = ach.algoritmoDenominador(nGrupos, distanciasE);


        return (aNumerador/aDenominador);
    }

}
