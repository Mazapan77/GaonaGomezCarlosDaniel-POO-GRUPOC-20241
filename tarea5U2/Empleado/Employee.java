package Empleado;

public class Employee {

    private double sueldoBase;

    public Employee (double sueldoBase){
        this.sueldoBase = sueldoBase;
    }

    String calcularSalario(){
        return String.format("El sueldo base es de: %f", sueldoBase);
    }

    String calcularSalario(double bonificacion){
        return String.format("El sueldo más la bonificiacion es: %f", sueldoBase +bonificacion);
    }

    String calcularSalario(double bonificacion, double horasExtra){
        return String.format("El sueldo más la bonificacion y horas extras es de: %f", sueldoBase + bonificacion + horasExtra*20);
    }


}
