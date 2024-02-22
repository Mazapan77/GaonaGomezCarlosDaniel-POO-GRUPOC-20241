package Tarea3_U2;

public class Main {
    public static void main(String[] args) {
    Persona persona = new Persona("Daniel", 5, "No binario");
    Persona persona2 = new Persona("Jose Jose", 99, "Hombre");
    Persona persona3= new Persona("Maria Rosario", 51, "Mujer");
    Persona persona4 = new Persona("Emilio Hernandez", 18, "Homosexual");

    System.out.println("**PERSONAS**" + "\n" + persona.getInfo() + "\n" + "********" + "\n" +
                    persona2.getInfo() + "\n" + "********" + "\n" +
                    persona3.getInfo() + "\n" + "********" + "\n" +
                    persona4.getInfo());

    System.out.println("*********************************************");

    Libro libro1 = new Libro();
    Libro libro2 = new Libro();
    Libro libro3 = new Libro();
    Libro libro4 = new Libro();

    System.out.println("**LIBROS**");
    libro1.mostrarInformacion("El Principito", "Antoine de Saint-Exupéry", 1943 );
    System.out.println("********");
    libro1.mostrarInformacion("Cien años de soledad", "Gabriel García Márquez", 1967);
    System.out.println("********");
    libro1.mostrarInformacion("El señor de los anillos", "J. R. R. Tolkien", 1954);
    System.out.println("********");
    libro1.mostrarInformacion("París despertaba tarde", "Máximo Huerta", 2024);

    System.out.println("*********************************************");


    System.out.println("RECTANGULOS");
    Rectangulo rectangulo1 = new Rectangulo(15,5);
    Rectangulo rectangulo2 = new Rectangulo(841,561.5);
    Rectangulo rectangulo3 = new Rectangulo(5.5,97.9);
    Rectangulo rectangulo4 = new Rectangulo(9.4,75);

    rectangulo1.mostrarInformacion();
    System.out.println("*******");
    rectangulo2.mostrarInformacion();
    System.out.println("*******");
    rectangulo3.mostrarInformacion();
    System.out.println("*******");
    rectangulo4.mostrarInformacion();

    }
}
