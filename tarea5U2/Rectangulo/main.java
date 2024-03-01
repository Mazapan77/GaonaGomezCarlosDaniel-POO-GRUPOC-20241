package Rectangulo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        rectangulo rectangulo = new rectangulo();
        System.out.println("Ingrese el largo y ancho");
        double largo = leer.nextDouble();
        double ancho = leer.nextDouble();

        System.out.println(rectangulo.area((int) largo,(int) ancho));
        System.out.println(rectangulo.area(largo, ancho));

        System.out.println(rectangulo.perimetro((int) largo,(int) ancho));
        System.out.println(rectangulo.perimetro(largo,ancho));

    }
}
