import java.time.LocalDate;

public class Empleado {
    public int id;
    public String nombre;
    public String apellidos;
    private String fechaDeNacimiento;
    private String fechaDeIngreso;
    private String RFC;
    private String CURP;
    private double salario;
    private int horaIngreso;
    private int horaSalida;
    public String rol;

    Empleado(int id, String nombre, String apellidos, String fechaDeNacimiento, String fechaDeIngreso, String RFC, String CURP, double salario, int horaIngreso, int horaSalida, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeIngreso = fechaDeIngreso;
        this.RFC = RFC;
        this.CURP = CURP;
        this.salario = salario;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.rol = rol;
    }

    public String consultarEmpleado() {
        return String.format("|ID: %d|" +
                        "Nombre: %s %s|" +
                        "Fecha de Nacimiento: %s|" +
                        "Fecha de Ingreso: %s|" +
                        "RFC: %s|" +
                        "CURP: %s|" +
                        "Salario: %f|" +
                        "Hora de Entrada: %d|" +
                        "Hora de Salida: %d|" +
                        "Rol: %s|",
                id, nombre, apellidos, fechaDeNacimiento, fechaDeIngreso, RFC, CURP, salario, horaIngreso, horaSalida, rol);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

