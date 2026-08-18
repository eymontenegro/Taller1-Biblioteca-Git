package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Crear libro");
            System.out.println("6. Listar libros");
            System.out.println("7. Actualizar libro");
            System.out.println("8. Eliminar libro");
            System.out.println("9. Registrar préstamo");
            System.out.println("10. Registrar devolución");
            System.out.println("11. Listar préstamos activos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    crearLibro();
                    break;
                case 6:
                    listarLibros();
                    break;
                case 7:
                    actualizarLibro();
                    break;
                case 8:
                    eliminarLibro();
                    break;
                case 9:
                    crearPrestamo();
                    break;
                case 10:
                    devolucion();
                    break;
                case 11:
                    listarPrestamos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
    
    //CLIENTE
    
    static void crearCliente() {
        System.out.println("--- Crear Cliente ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente c = new Cliente(id, nombre, telefono, email);
        clientes.add(c);
        System.out.println("Cliente creado con éxito.");
    }
    
    static void listarClientes() {
        System.out.println("--- Lista de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }
    
    static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    static void actualizarCliente() {
        System.out.print("ID del cliente a actualizar: ");
        String id = sc.nextLine();
        Cliente c = buscarCliente(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
        c.setNombre(sc.nextLine());
        System.out.print("Nuevo teléfono (" + c.getTelefono() + "): ");
        c.setTelefono(sc.nextLine());
        System.out.print("Nuevo email (" + c.getEmail() + "): ");
        c.setEmail(sc.nextLine());

        System.out.println("Cliente actualizado.");
    }
    
    static void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        String id = sc.nextLine();
        Cliente c = buscarCliente(id);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clientes.remove(c);
        System.out.println("Cliente eliminado.");
    }
    
    //LIBRO
        static void crearLibro() {
        System.out.println("--- Crear Libro ---");
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro l = new Libro(codigo, titulo, anio, autor);
        libros.add(l);
        System.out.println("Libro creado con éxito.");
    }
 
    static void listarLibros() {
        System.out.println("--- Lista de Libros ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l.toString());
        }
    }
    
    static Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    static void actualizarLibro() {
        System.out.print("Código del libro a actualizar: ");
        String codigo = sc.nextLine();
        Libro l = buscarLibro(codigo);

        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.print("Nuevo título (" + l.getTitulo() + "): ");
        l.setTitulo(sc.nextLine());
        System.out.print("Nuevo año (" + l.getAnioPublicacion() + "): ");
        l.setAnioPublicacion(Integer.parseInt(sc.nextLine()));
        System.out.print("Nuevo autor (" + l.getAutor() + "): ");
        l.setAutor(sc.nextLine());

        System.out.println("Libro actualizado.");
    }
   
    static void eliminarLibro() {
        System.out.print("Código del libro a eliminar: ");
        String codigo = sc.nextLine();
        Libro l = buscarLibro(codigo);

        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        libros.remove(l);
        System.out.println("Libro eliminado.");
    }
    
    //PRESTAMO
      static void crearPrestamo() {
        System.out.println("--- Registrar Préstamo ---");
        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();
        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();
        Cliente c = buscarCliente(idCliente);

        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Código del libro: ");
        String codigoLibro = sc.nextLine();
        Libro l = buscarLibro(codigoLibro);

        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!l.isDisponible()) {
            System.out.println("El libro no está disponible actualmente.");
            return;
        }

        Prestamo p = new Prestamo(idPrestamo, c, l, LocalDate.now(), "ACTIVO");
        prestamos.add(p);
        l.setDisponible(false);
        System.out.println("Préstamo registrado con éxito.");
    }

    static void devolucion() {
        System.out.print("ID del préstamo a devolver: ");
        String idPrestamo = sc.nextLine();

        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo) && p.getEstado().equals("ACTIVO")) {
                p.setEstado("DEVUELTO");
                p.getLibro().setDisponible(true);
                System.out.println("Devolución registrada con éxito.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado o ya fue devuelto.");
    }

    static void listarPrestamos() {
        System.out.println("--- Préstamos Activos ---");
        boolean hay = false;
        for (Prestamo p : prestamos) {
            if (p.getEstado().equals("ACTIVO")) {
                System.out.println(p.toString());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay préstamos activos.");
        }
    }

}
