package sample.Clases;
import javax.swing.JOptionPane;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by v on 3/11/15.
 */
public class CrearNormalizado extends Component {
    public void guardarObjetos(Double[][] objetos){
            //String ruta = "/home/v/Documentos/Objetos.txt";
        String ruta = "objetos.txt";
            try{
                FileWriter arch = new FileWriter(ruta);
                PrintWriter escribir = new PrintWriter(arch);
                for(int i=0; i<objetos.length; i++){
                    for(int j=0; j<objetos[i].length; j++){
                        escribir.print (objetos[i][j] + " ");
                    }
                    escribir.println();
                }
                escribir.close();
            }
            catch(IOException e){
                JOptionPane . showMessageDialog ( null , "Error \n" + e);
            }
    }

    public void guardarGruposObjetos(String[][] gruposObjetos){
        //String ruta = "/home/v/Documentos/RelacionGruposObjetos.txt";
        String ruta = "RelacionGruposObjetos.txt";
        try{
            FileWriter arch = new FileWriter(ruta);
            PrintWriter escribir = new PrintWriter(arch);
            for(int i=0; i<gruposObjetos.length; i++){
                for(int j=0; j<gruposObjetos[i].length; j++){

                    escribir.print (gruposObjetos[i][j] + " ");
                }
                escribir.println();
            }
            escribir.close();
        }
        catch(IOException e){
            JOptionPane . showMessageDialog ( null , "Error \n" + e);
        }
    }

}
