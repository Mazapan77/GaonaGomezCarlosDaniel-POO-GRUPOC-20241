import java.time.Period;

public class Visitante {
    public int id;
    public String nombre;
    public String apellidos;
    private String fechaDeNacimiento;
    private String CURP;
    public int numeroDeVisitas;
    private String fechaDeRegistro;
    public boolean esMayor;
    Visitante(int id, String nombre, String apellidos, String fechaDeNacimiento, String CURP, String fechaDeRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.CURP = CURP;
        this.fechaDeRegistro = fechaDeRegistro;

        String[] fecha1 = fechaDeNacimiento.split("/");
        String[] fecha2 = fechaDeRegistro.split("/");
        int diferenciaA = Integer.parseInt(fecha2[2]) - Integer.parseInt(fecha1[2]);
        int diferenciaM = Integer.parseInt(fecha2[1]) - Integer.parseInt(fecha1[1]);
        int diferenciaD = Integer.parseInt(fecha2[0]) - Integer.parseInt(fecha1[0]);
        if (diferenciaA > 18 && diferenciaM >= 0 && diferenciaD >= 0) {
            esMayor = true;
        } else if (diferenciaA == 18 && diferenciaM >= 0 && diferenciaD >= 0) {
            esMayor = true;
        } else {
            esMayor = false;
        }
    }


    public double obtenerPrecioBoleto() {
        double precioBoleto;
        double descuento = .2 * Math.round(numeroDeVisitas/5);

        if (esMayor == true) {
            precioBoleto = 100 - 100*descuento;
        } else {
            precioBoleto = 50 - 50*descuento;
        }
        return precioBoleto;
    }

    public void aumentarVisitas() {
        this.numeroDeVisitas += 1;
    }

    public String consultarVisitante() {
        return String.format("|ID> %d|Nombre: %s %s|CURP: %s|Fecha de Nacimiento: %s|Fecha de Registro: %s|",
                id, nombre, apellidos, CURP, fechaDeNacimiento, fechaDeRegistro);
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

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public int getNumeroDeVisitas() {
        return numeroDeVisitas;
    }

    public void setNumeroDeVisitas(int numeroDeVisitas) {
        this.numeroDeVisitas = numeroDeVisitas;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public boolean isEsMayor() {
        return esMayor;
    }

    public void setEsMayor(boolean esMayor) {
        this.esMayor = esMayor;
    }
}
