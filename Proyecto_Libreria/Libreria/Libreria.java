package Libreria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import Usuarios.*;
import Usuarios.Utils.Rol;

public class Libreria {
    
    //@SuppressWarnings("rawTypes") //sirve para poder meter lo que quieras a un arrayList
    
    public static final ArrayList<Libro> libros = new ArrayList<Libro>();
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private static String usuarioEnSesion;

    public Libreria() {
        Gerente gerente = new Gerente("Daniel", "Gomez", "4434682205", 1500, "123456ABC", "AEIOU", "Mazapan", "123");
        Asistente asistente = new Asistente("Bloquesito", "Duarte", "443485850", 15000, "JUJUI", "ITADORI", "Sukuna");
        if(!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());   //eso va a entrar cuando la llave no exista, o sea que el hash este vacio, si no lo va a ignorar (en la segunda vez)
            usuarios.get(Rol.ASISTENTE).add(asistente); //agregar
        }
        if(!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());   //eso va a entrar cuando la llave no exista, o sea que el hash este vacio, si no lo va a ignorar (en la segunda vez)
            usuarios.get(Rol.GERENTE).add(gerente); //agregar
        }
    }

    Usuario verificarInicioSesion(String nombreUsuario, String contrasena) { 
        for(Rol key : usuarios.keySet()) {
            for(Usuario usuario : usuarios.get(key)) {
                if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                    if(usuario.getContrasena().equals(contrasena)) {
                        usuarioEnSesion = usuario.getNombreUsuario();
                        return usuario; //puede ser retornar el usuario
                    }
                }
            }
        }
        return null; //si no retornar un null
    }


    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente"; //operador ternario, es lo mismo que un if y es para no tantas condiciones
       
        System.out.println(String.format("\nBienvenido al registro del %s", rolUsuario));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña)); //te agrega todos estos datos de un jalon
        return datosComun;
    }


    public static void eliminarUsuario (Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean band = false;
        System.out.println("\n---- Eliminar usuario ----\n");
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String nombreUsuario = scanner.nextLine();
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente"; //operador ternario, es lo mismo que un if y es para no tantas condiciones

        if(nombreUsuario.equals(usuarioEnSesion)) {
            System.out.println("\nNo puedes eliminarte a ti mismo");
            band = true;
        }
        else if(usuarios.containsKey(rol)) {
            Usuario usuarioEliminado = null;
            for(Usuario usuario : usuarios.get(rol)) {
                if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                    usuarioEliminado = usuario;
                    int y = usuarioEliminado.getId();
                    usuarioEliminado.setCANTIDAD_USUARIOS();
                    band = true;
                    for(Rol key : usuarios.keySet()) {
                        for(Usuario i : usuarios.get(key)) {
                            if(i.getId() > y) {
                                i.setId();
                            }
                        }
                    }
                }
            }
            if(band) {
                usuarios.get(rol).remove(usuarioEliminado);
                System.out.println("\nUsuario eliminado");
            }
        }
        if(band == false) {
            System.out.println(String.format("\nEste nombre no pertenece a ningún %s", rolUsuario));
        }
    }


    public static String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono = "";

        do {
            System.out.println("\nIngresa el telefono: ");
            telefono = scanner.nextLine();
            telefonoExistente = false;
            for(Rol key : usuarios.keySet()) {
                for(Usuario usuario : usuarios.get(key))
                    if(usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        break;
                    }
            }
            if(telefonoExistente) {
                System.out.println("\nEl telefono ya se encuentra registrado. Intenta de nuevo.");
            }
        }
        while(telefonoExistente);
        return telefono;
    }


    public static String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.println("\nIngresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;
            for(Rol key : usuarios.keySet()) {
                for(Usuario usuario : usuarios.get(key)) {
                    if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }
            }
            if(nombreUsuarioExistente) {
                System.out.println("\nYa existe un registro con ese nombre de usuario. Intenta de nuevo.");
            }
        }
        while(nombreUsuarioExistente);
        return nombreUsuario;
    }
}
