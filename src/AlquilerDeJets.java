import java.util.Scanner;

public class AlquilerDeJets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del cliente: ");
        String apellido = scanner.nextLine();


        String tipoJet;
        while (true) {
            System.out.print("Tipo de jet (Light Jet o Super Jet): ");
            tipoJet = scanner.nextLine();
            if (tipoJet.equalsIgnoreCase("Light Jet") || tipoJet.equalsIgnoreCase("Super Jet")) {
                break; // Entrada válida
            } else {
                System.out.println("Error: Debe ingresar 'Light Jet' o 'Super Jet'. Intente de nuevo.");
            }
        }


        int horas;
        while (true) {
            System.out.print("Cantidad de horas de alquiler: ");
            horas = scanner.nextInt();
            if (horas > 0) {
                break; // Entrada válida
            } else {
                System.out.println("Error: La cantidad de horas debe ser mayor a 0. Intente de nuevo.");
            }
        }


        double precioPorHora = tipoJet.equalsIgnoreCase("Light Jet") ? 3000 : 4500;

        // Cálculo del descuento
        double descuento = 0;
        if (horas >= 4 && horas <= 8) {
            descuento = 0.15;
        } else if (horas >= 9 && horas <= 12) {
            descuento = 0.20;
        } else if (horas >= 13 && horas <= 16) {
            descuento = 0.25;
        } else if (horas >= 17) {
            descuento = 0.30;
        }


        double precioTotal = precioPorHora * horas;
        double montoDescuento = precioTotal * descuento;
        double montoFinal = precioTotal - montoDescuento;


        System.out.println("\n--- Información del Cliente ---");
        System.out.println("Nombre y Apellido: " + nombre + " " + apellido);
        System.out.println("Tipo de Jet: " + tipoJet);
        System.out.println("Cantidad de Horas: " + horas);
        System.out.println("Precio sin descuento: $" + precioTotal);
        System.out.println("Descuento aplicado: $" + montoDescuento);
        System.out.println("Monto total a pagar: $" + montoFinal);
    }
}
