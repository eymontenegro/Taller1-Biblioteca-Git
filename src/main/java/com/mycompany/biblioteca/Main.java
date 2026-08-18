package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Aquí irá el menú (Fase 8)
    }
    
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
    
}
