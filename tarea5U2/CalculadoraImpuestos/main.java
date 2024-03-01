package CalculadoraImpuestos;

public class main {
    public static void main(String[] args) {
        calculadoraImpuestos calculadoraImpuestos = new calculadoraImpuestos(1000);

        System.out.println(calculadoraImpuestos.calcularImpuestos());
        //Puede poner hasta 3 parametros, cuando ponga 2 parametros cambiara a ventas y porcentajeImpuestos
        System.out.println(calculadoraImpuestos.calcularImpuestos(15,5));



    }
}
