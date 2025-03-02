import java.util.Scanner;

public class EncomiendasExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos de paquete
        double peso, distancia, costoPeso = 0, costoDistancia = 0, costoTotal = 0;
        double costoExpress = 0, descuentoVIP = 0;
        boolean esExpress, tieneVIP;

        // Ingreso de datos
        System.out.println("Ingrese el peso del paquete (kg): ");
        peso = scanner.nextDouble();
        while (peso <= 0) {
            System.out.println("El peso debe ser un número positivo. Ingrese nuevamente el peso del paquete (kg): ");
            peso = scanner.nextDouble();
        }

        System.out.println("Ingrese la distancia de envío (km): ");
        distancia = scanner.nextDouble();
        while (distancia <= 0) {
            System.out.println("La distancia debe ser un número positivo. Ingrese nuevamente la distancia de envío (km): ");
            distancia = scanner.nextDouble();
        }

        // Validación de opción express
        System.out.println("¿Desea un envío Express? (true/false): ");
        esExpress = scanner.nextBoolean();

        // Validación de tarjeta VIP
        System.out.println("¿Posee tarjeta VIP? (true/false): ");
        tieneVIP = scanner.nextBoolean();

        // Cálculo del costo por peso
        if (peso >= 1 && peso <= 4) {
            costoPeso = peso * 1.0;  // $1.00 por kg
        } else if (peso >= 5 && peso <= 10) {
            costoPeso = peso * 1.20;  // $1.20 por kg
        } else if (peso >= 11 && peso <= 20) {
            costoPeso = peso * 1.35;  // $1.35 por kg
        } else if (peso > 20) {
            costoPeso = peso * 1.75;  // $1.75 por kg
        }

        // Cálculo del costo por distancia
        if (distancia >= 1 && distancia <= 20) {
            costoDistancia = distancia * 0.20;  // $0.20 por km
        } else if (distancia >= 21 && distancia <= 40) {
            costoDistancia = distancia * 0.08;  // $0.08 por km
        } else if (distancia >= 41 && distancia <= 60) {
            costoDistancia = distancia * 0.06;  // $0.06 por km
        } else if (distancia > 60) {
            costoDistancia = distancia * 0.04;  // $0.04 por km
        }

        // Cálculo del costo total sin express ni descuento VIP
        costoTotal = costoPeso + costoDistancia;

        // Cálculo de costo express
        if (esExpress) {
            costoExpress = costoTotal * 0.13;  // 13% adicional
            costoTotal += costoExpress;
        }

        // Cálculo de descuento VIP
        if (tieneVIP) {
            descuentoVIP = costoTotal * 0.10;  // 10% de descuento
            costoTotal -= descuentoVIP;
        }

        // Mostrar los resultados
        System.out.println("\n********** Datos del paquete **********");
        System.out.println("Peso del paquete: " + peso + " kg");
        System.out.println("Tarifa aplicada por peso: $" + costoPeso);

        System.out.println("\n********** Datos del envío **********");
        System.out.println("Distancia de envío: " + distancia + " km");
        System.out.println("Tarifa aplicada por distancia: $" + costoDistancia);

        System.out.println("\n********** Precio de envío **********");
        System.out.println("Subtotal de peso: $" + costoPeso);
        System.out.println("Subtotal de distancia: $" + costoDistancia);
        System.out.println("Subtotal general (Peso + Distancia): $" + (costoPeso + costoDistancia));

        if (esExpress) {
            System.out.println("Costo por envío Express (13%): $" + costoExpress);
        }

        if (tieneVIP) {
            System.out.println("Descuento por tarjeta VIP (10%): -$" + descuentoVIP);
        }

        System.out.println("\nPrecio total a pagar por el envío: $" + costoTotal);

        scanner.close();
    }
}
