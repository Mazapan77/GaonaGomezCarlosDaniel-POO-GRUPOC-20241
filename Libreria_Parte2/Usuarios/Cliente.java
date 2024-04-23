package Usuarios;
import java.time.LocalDate;
import Usuarios.Utils.Rol;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;
    
    public Cliente (String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now(); 
    }

    @Override
    public String toString() { 
        return String.format("%s, Fecha de registro: %s", super.toString(), this.fechaRegistro);
    }

}