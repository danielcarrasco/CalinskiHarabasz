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

        int nObjetos = 0;
        int nAtributos = 0;
        int nGrupos = 0;
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

        System.out.println("No. Objetos:" + nObjetos + " No. Atributos:" + nAtributos);
        System.out.println("Centro Global");
        for(int i = 0; i < cGlobal.length; i++)
            System.out.print(cGlobal[i] + " ");
        System.out.println("");
        System.out.println("");

        //----Grupos
        //grupos = conv.conversionGrupos(grupoa);

        grupos = conv.conversionGrupos(qJ.getOutJuanito(grp, val));
        nGrupos = grupos.length;
        double [][] cGrupos = new double[nGrupos][nAtributos];
        System.out.println("No. Grupos:" + nGrupos);
        //--Formar Grupos
        fg.formarGrupos(cGrupos,grupos, objetos);
        //---Centros de cada grupo
        System.out.println("Centros de todos los grupos");
        for(int i = 0;i < cGrupos.length; i++){
            for(int j = 0; j <cGrupos[0].length;j++){
                System.out.print(cGrupos[i][j]+" ");
            }
            System.out.println("");
        }

        //------Distancia euclidiana
        double[] distanciasE = new double[nGrupos];
        System.out.println("Distancias euclidianas objetos centros");
        distanciasE = de.distanciaEuclidianas(distanciasE,grupos,objetos,cGrupos);
        //System.out.println(c.calculoEuclidianaG(grupos[0],0,objetos,cGrupos));
        //System.out.println(c.calculoEuclidianaG(grupos[1],1,objetos,cGrupos));
        for (int i = 0; i < distanciasE.length; i++)
            System.out.println(distanciasE[i]);

        //---------Distancia euclidiana Cnetros centros
        System.out.println("Distancias centros-centros");
        double[] distanciasCC = new double [cGrupos.length];
        distanciasCC = de.distanciaECentros(distanciasCC, cGlobalT, cGrupos);
        for (int i = 0; i < distanciasCC.length; i++)
            System.out.println(distanciasCC[i]);

        //--------Resultado algoritmo
        double aNumerador = 0;
        double aDenominador = 0;
        System.out.println("Numerador de algoritmo");
        aNumerador = ach.algoritmoNumerador(nObjetos, nGrupos, grupos, distanciasCC);
        System.out.println(aNumerador);
        System.out.println("denominador de algoritmo");
        aDenominador = ach.algoritmoDenominador(nGrupos, distanciasE);
        System.out.println(aDenominador);
        System.out.println("Resultado del algoritmo :" + (aNumerador/aDenominador));

        return (aNumerador/aDenominador);
    }

}
