public class Mantenimiento {
    public int idMantenimiento;
    private String nombreMantenimiento;
    private int id_animal;
    private String proceso;
    private String fechaProceso;
    private String observaciones;
    Mantenimiento(int idMantenimiento, String nombreMantenimiento, int id_animal, String proceso, String fechaProceso, String observaciones) {
        this.idMantenimiento = idMantenimiento;
        this.nombreMantenimiento = nombreMantenimiento;
        this.id_animal = id_animal;
        this.proceso = proceso;
        this.fechaProceso = fechaProceso;
        this.observaciones = observaciones;
    }


    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getNombreMantenimiento() {
        return nombreMantenimiento;
    }

    public void setNombreMantenimiento(String nombreMantenimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
