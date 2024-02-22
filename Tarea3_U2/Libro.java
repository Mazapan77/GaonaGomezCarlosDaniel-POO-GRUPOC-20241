package Tarea3_U2;
public class Libro {

    public String titulo;
    public String autor;
    public int añoPublicacion;

    public void mostrarInformacion(String titulo, String autor, int añoPublicacion) {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + añoPublicacion);
    }
}

