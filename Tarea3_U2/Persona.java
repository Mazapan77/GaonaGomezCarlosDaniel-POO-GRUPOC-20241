package Tarea3_U2;
public class Persona {
    //atributos
    String nombre, genero;
    int edad ;
    //constructor
    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    String getInfo(){
        return String.format(
                "Nombre: %s" + "\n" +
                "Edad: %d "+ "\n"  + "Genero: %s",
                nombre,edad,genero);
    }

}
