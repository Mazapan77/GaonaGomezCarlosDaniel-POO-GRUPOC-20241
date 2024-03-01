package Empleado;

public class main {
    public static void main(String[] args) {

        Employee employee = new Employee(1500);

        System.out.println(employee.calcularSalario());
        System.out.println(employee.calcularSalario(8440));
        System.out.println(employee.calcularSalario(8440,15));


    }
}
