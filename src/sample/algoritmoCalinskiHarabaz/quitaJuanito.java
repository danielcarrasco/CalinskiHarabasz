package sample.algoritmoCalinskiHarabaz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Villegas on 03/10/2015.
 */
public class quitaJuanito {

    public int[][] getOutJuanito(String[][] grp) {
        int[][] grupos;
        grupos = new int[grp.length][];

        for (int i = 0; i < grp.length; i++){
            grupos[i] = new int[grp[i].length-1];
            for (int j = 1; j < grp[i].length; j++){
                grupos[i][j-1] = Integer.parseInt(grp[i][j]);
            }
        }

        //se imprime para verificar
        /*for(int i = 0; i < grupos.length; i++){
            for(int j = 0; j < grupos[i].length; j++){
                System.out.print(grupos[i][j]);
            }
            System.out.println();
        }*/
        return grupos;
    }
}
