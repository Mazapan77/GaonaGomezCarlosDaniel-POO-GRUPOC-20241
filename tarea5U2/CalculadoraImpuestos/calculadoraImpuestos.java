package CalculadoraImpuestos;

public class calculadoraImpuestos {

    private int ingresos;

    public calculadoraImpuestos(int ingresos){
        this.ingresos = ingresos;
    }

    String calcularImpuestos(){
        return  String.format("Ingresos: %f", ingresos + 0.15);
    }

    String calcularImpuestos(int ventas, double porcentajeImpuestos){
        return String.format("El total de ventas y el porcentaje de impuestos es de: %f", ventas * (porcentajeImpuestos/100));
    }

    String calcularImpuestos(double dividendos, double porcentajeImpuestos, double exencion){
        double impuestos = dividendos * (porcentajeImpuestos/100);
        System.out.println("Impuestos: " + impuestos);
        if (impuestos > exencion) {
            return String.format("Impuestos menos la exencion: %f", impuestos - exencion);
        } else {
            return String.format("%d",0);
        }
    }
}
