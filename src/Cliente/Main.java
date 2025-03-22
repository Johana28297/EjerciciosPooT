package Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteManager clienteManager = new ClienteManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Inactivar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("ID Cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Documento Identificación: ");
                        String documentoIdentificacion = scanner.nextLine();
                        System.out.print("Tipo Persona: ");
                        String tipoPersona = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();
                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();
                        System.out.print("Dirección: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();
                        System.out.print("Creado Por: ");
                        String creadoPor = scanner.nextLine();
                        clienteManager.crearCliente(idCliente, nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado, creadoPor);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: ID Cliente debe ser un número entero.");
                        scanner.nextLine(); // Consumir la entrada incorrecta
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print("ID Cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Documento Identificación: ");
                        String documentoIdentificacion = scanner.nextLine();
                        System.out.print("Tipo Persona: ");
                        String tipoPersona = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();
                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();
                        System.out.print("Dirección: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Estado: ");
                        String estado = scanner.nextLine();
                        clienteManager.actualizarCliente(idCliente, nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: ID Cliente debe ser un número entero.");
                        scanner.nextLine(); // Consumir la entrada incorrecta
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("ID Cliente: ");
                        int idCliente = scanner.nextInt();
                        clienteManager.inactivarCliente(idCliente);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: ID Cliente debe ser un número entero.");
                        scanner.nextLine();
                    }
                    break;
                case 4:
                    for (ClienteInfo cliente : clienteManager.getClientes()) {
                        System.out.println(cliente);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}