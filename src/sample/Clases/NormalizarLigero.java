package sample.Clases;


/**
 * Created by JJCD on 01/11/15.
 */
public class NormalizarLigero {


    public NormalizarLigero(){
    }


    public Double[][] Discretizar(String[][] matriz, String[][] dominio, int nObjetos, int nAtributos){

        String[][] matrizDiscretizada = new String[nObjetos][nAtributos-1];

        //FOR para los dominios
        for(int i=0; i<dominio.length-1; i++){
            String[] aux_dom;
            aux_dom = dominio[i]; //aux vector dominio


            //FOR Para registros
            for(int j=0; j<matriz.length; j++)
            {
                String[] aux_reg;
                aux_reg =  matriz[j]; //aux vector matriz

                //FOR para el dominio
                for(int k=1; k<aux_dom.length; k++)
                {

                    if (aux_reg[Integer.parseInt(aux_dom[0])].equals(aux_dom[k])) {
                        aux_reg[Integer.parseInt(aux_dom[0])] = k + "";

                        matrizDiscretizada[j]=aux_reg;
                        break;
                    } else {
                        if(k==aux_dom.length-1)
                            if (!isNumeric(aux_reg[Integer.parseInt(aux_dom[0])])) {
                                aux_reg[0] = null;

                                matrizDiscretizada[j] = aux_reg;
                                break;
                            }
                    }

                }
            }

        }

        if(matrizDiscretizada.length==0) {
            matrizDiscretizada = matriz;
        }


        return  doubleTransformar(matrizDiscretizada, nObjetos, nAtributos-1);
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

    public Double[][] doubleTransformar (String [][] matriz2, int nObjetos, int nAtributos){

        Double [][] normalizado = new Double[nObjetos][nAtributos];
        Double [] vector;


        for(int i=0; i<matriz2.length; i++)
        {
            String[] aux;
            aux = matriz2[i];
            vector = new Double[nAtributos];
            for(int j=0; j<aux.length; j++)
            {
                try {
                    vector[j] =  Double.parseDouble(aux[j]);
                }catch (Exception e)
                {
                    vector[j] = null;
                }
            }
            normalizado[i] = vector;
        }

        imprimirNormalizado(normalizado);



        return normalizado;
    }

    public void imprimirNormalizado(Double[][] Normalizado){

        for(Double[] a : Normalizado){
            for (Double b :a)
            {
                System.out.println(b);
            }
            System.out.println("\n");
        }

    }


}
