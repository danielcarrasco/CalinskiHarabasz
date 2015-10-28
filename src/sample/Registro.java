package sample;

/**
 * Created by JJCD on 30/09/15.
 */
public class Registro {

    private String nombre;
    private String tipo;
    private String dominio;

    public Registro(){

        this.nombre = "";
        this.tipo = "";
        this.dominio = "";

    }

    public Registro(String nombre, String tipo, String dominio){

        this.nombre = nombre;
        this.tipo = tipo;
        this.dominio = dominio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

}
