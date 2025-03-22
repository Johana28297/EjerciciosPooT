package sv.edu.udb.Prototipo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ModulodeEmpleados modulo = new ModulodeEmpleados();
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Inactivar empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Documento de Identificación: ");
                    String documento = scanner.nextLine();

                    System.out.print("Tipo de Persona (Natural/Jurídica): ");
                    String tipoPersona = scanner.nextLine();

                    System.out.print("Tipo de Contratación (Permanente/Por Horas): ");
                    String tipoContratacion = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();

                    System.out.print("Estado (Activo/Inactivo): ");
                    String estado = scanner.nextLine();

                    System.out.print("Creador: ");
                    String creador = scanner.nextLine();

                    Empleado nuevoEmpleado = new Empleado(id, nombre, documento, tipoPersona, tipoContratacion, telefono, correo, direccion, estado, creador);
                    modulo.agregarEmpleado(nuevoEmpleado);
                    break;

                case 2:
                    System.out.println("\nLista de empleados:");
                    modulo.listarEmpleados();
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();

                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = scanner.nextLine();

                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = scanner.nextLine();

                    System.out.print("Nuevo estado (Activo/Inactivo): ");
                    String nuevoEstado = scanner.nextLine();

                    modulo.actualizarEmpleado(idActualizar, nuevoTelefono, nuevoCorreo, nuevaDireccion, nuevoEstado);
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado a inactivar: ");
                    int idInactivar = scanner.nextInt();
                    modulo.inactivarEmpleado(idInactivar);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

