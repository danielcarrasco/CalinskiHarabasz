package sample.Clases;

import java.util.ArrayList;

/**
 * Created by JJCD on 03/10/15.
 */
public class Normalizar {

    public Normalizar(){}

    public static ArrayList<ArrayList> Discretizar(ArrayList<ArrayList> matriz, ArrayList<ArrayList<String>> dominio){

        ArrayList<ArrayList> matrizDiscretizada = new ArrayList<>();

        //FOR para los dominios
        for(int i=0; i<dominio.size(); i++){
            ArrayList<String> aux;
            aux = dominio.get(i); //aux vector dominio


            //FOR Para registros
            for(int j=0; j<matriz.size(); j++)
            {
                ArrayList<String> aux2;
                aux2 = (ArrayList<String>) matriz.get(j); //aux vector matriz

                //FOR para el dominio
                for(int k=1; k<aux.size(); k++)
                {
                    if (aux2.get(Integer.parseInt(aux.get(0))).equals(aux.get(k))) {
                        aux2.remove(Integer.parseInt(aux.get(0)));
                        aux2.add(Integer.parseInt(aux.get(0)), k + "");
                        if (i > 0)
                            matrizDiscretizada.remove(j);
                        matrizDiscretizada.add(j, aux2);
                        break;
                    } else {
                        if(k==aux.size()-1)
                            if (!isNumeric(aux2.get(Integer.parseInt(aux.get(0))))) {
                                aux2.remove(Integer.parseInt(aux.get(0)));
                                aux2.add(Integer.parseInt(aux.get(0)), null);

                                if (i > 0)
                                    matrizDiscretizada.remove(j);
                                matrizDiscretizada.add(j, aux2);
                                break;
                            }
                    }



                }
            }

        }

        if(matrizDiscretizada.size()==0) {
            matrizDiscretizada = (ArrayList) matriz;
        }
        doubleTranformar(matrizDiscretizada);

        return  matrizDiscretizada;
    }




    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static ArrayList<ArrayList> doubleTranformar (ArrayList<ArrayList> matriz){

        ArrayList<ArrayList> normalizado = new ArrayList<>();
        ArrayList<Double> vector;


        for(int i=0; i<matriz.size(); i++)
        {
            ArrayList<String> aux;
            aux = matriz.get(i);
            vector = new ArrayList<>();
            for(int j=0; j<aux.size(); j++)
            {
                try {
                    vector.add(j, Double.parseDouble(aux.get(j)));
                }catch (Exception e)
                {
                    vector.add(j, null);
                }
            }
            normalizado.add(vector);

        }

        return normalizado;
    }
}