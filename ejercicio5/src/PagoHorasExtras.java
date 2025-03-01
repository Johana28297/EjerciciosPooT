import java.util.Scanner;

public class PagoHorasExtras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            // Solicita los datos del empleado
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el salario mensual del empleado: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, ingrese un número válido para el salario.");
                scanner.next();
            }
            double salario = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Ingrese el departamento (Gerencia, Auditoria, Tecnología, Contabilidad): ");
            String departamento = scanner.nextLine();

            System.out.print("Ingrese las horas extras realizadas en el mes (máximo 20): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número entero válido.");
                scanner.next();
            }
            int horasExtras = scanner.nextInt();
            scanner.nextLine();

            // Validar que las horas extras no superen 20
            if (horasExtras > 20) {
                System.out.println("Error: No se pueden registrar más de 20 horas extras.");
                horasExtras = 20;
            }

            // Obtener el bono por hora según el departamento
            double bonoPorHora = obtenerBonoPorDepartamento(departamento);

            // Calcular pago de horas extras
            double pagoHorasExtras = ((salario / 30) * horasExtras) + (bonoPorHora * horasExtras);

            // Mostrar resultados
            System.out.println("\n--- Resumen del Empleado ---");
            System.out.println("Nombre: " + nombre);
            System.out.println("Salario: $" + salario);
            System.out.println("Departamento: " + departamento);
            System.out.println("Horas extras trabajadas: " + horasExtras);
            System.out.println("Pago total de horas extras: $" + pagoHorasExtras);
            System.out.println("----------------------------\n");

            // Preguntar si desea ingresar otro empleado
            System.out.print("¿Desea ingresar otro empleado? (Sí/No): ");
            continuar = scanner.nextLine().trim(); // Eliminamos espacios innecesarios

        } while (continuar.equalsIgnoreCase("Sí"));

        System.out.println("Fin del programa.");
        scanner.close();
    }

    // Método para obtener el bono por departamento
    public static double obtenerBonoPorDepartamento(String departamento) {
        return switch (departamento.toLowerCase()) {
            case "gerencia" -> 3.50;
            case "auditoria" -> 1.75;
            case "tecnología" -> 2.25;
            case "contabilidad" -> 2.00;
            default -> 0.00; // Si el departamento no es válido, se asigna 0
        };
    }
}
