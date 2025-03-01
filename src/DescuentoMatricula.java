import java.util.Scanner;

public class DescuentoMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del estudiante: ");
        String apellido = scanner.nextLine();
        System.out.print("Tipo de ingreso (Antiguo Ingreso o Nuevo Ingreso): ");
        String tipoIngreso = scanner.nextLine();
        System.out.print("Edad del estudiante: ");
        int edad = scanner.nextInt();


        double costoMatricula;
        if (edad > 15) {
            costoMatricula = 100;
        } else if (edad > 10) {
            costoMatricula = 125;
        } else {
            costoMatricula = 150;
        }


        double descuento = tipoIngreso.equalsIgnoreCase("antiguo ingreso") ? 0.25 : 0.0;


        double montoDescuento = costoMatricula * descuento;
        double montoFinal = costoMatricula - montoDescuento;


        System.out.println("\n--- Información del Estudiante ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Costo de Matrícula: $" + costoMatricula);
        System.out.println("Descuento aplicado: $" + montoDescuento);
        System.out.println("Monto final a pagar: $" + montoFinal);
    }
}