package Rectangulo;

public class rectangulo {

    String area(int largo, int ancho){
        int area = largo * ancho;
        return String.format("El área del rectangulo es: %d", area);
    }

    String area(double largo, double ancho){
        double area = largo * ancho;
        return String.format("El área del rectangulo es: %f", area);
    }

    String perimetro(int largo, int ancho){
        int perimetro = 2*largo + 2*ancho;
        return String.format("El perimetro  del rectangulo es: %d", perimetro);
    }

    String perimetro(double largo, double ancho){
        double perimetro = 2*largo + 2*ancho;
        return String.format("El perimetro del rectangulo es: %f", perimetro);
    }




}
