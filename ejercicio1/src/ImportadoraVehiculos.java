import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ImportadoraVehiculos{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //tarifas

        Map<String, Map<String, Double>> tarifasAlquiler = new HashMap<>();
        tarifasAlquiler.put("China", Map.of("Sedan", 1700.0, "Pickups", 1900.0, "Microbuses", 2400.0, "Motos", 1300.0));
        tarifasAlquiler.put("Estados Unidos", Map.of("Sedan", 1200.0, "Pickups", 1500.0, "Microbuses", 1700.0, "Motos", 900.0));

        //Solicitar datos del vehiculo

        System.out.println("Ingrese el tipo de vehiculo(Sedan, Pickups, Microbuses, Motos): ");
        String tipoVehiculo = scanner.nextLine();
        System.out.println("Ingrese la marca del vehiculo: ");
        String Marca = scanner.nextLine();
        System.out.println("Ingrese el año del vehiculo: ");
        int añoVehiculo = scanner.nextInt();
        scanner.nextLine(); //Limpiar
        System.out.println("Ingrese el pais origen (Estados unidos o China)");
        String paisOrigen = scanner.nextLine();

        //Validaciones

        int añoActual = 2025;
        int edadVehiculo = añoActual = añoVehiculo;

        if (edadVehiculo > 2015 || edadVehiculo < 2000){
            System.out.println("No se aceptan vehiculos con mas de 15 años de fabricacion o menos de 1 año de fabricacion.");
            return;
        }
        if (!tarifasAlquiler.containsKey(paisOrigen) || !tarifasAlquiler.get(paisOrigen).containsKey(tipoVehiculo)){
            System.out.println("Datos de pais o tipo de vehiculo invalido,");
            return;
        }

        //Calculo de impuestos

        double impuestosPorcentaje;
        if (edadVehiculo >= 2010 ) {
            impuestosPorcentaje = 16;
        } else if (edadVehiculo >=2005) {
            impuestosPorcentaje = 13;
        } else {
            impuestosPorcentaje = 11;
        }

        //Obtener costo del alquiler

        double costoAlquiler = tarifasAlquiler.get(paisOrigen).get(tipoVehiculo);

        //calculo de matricula inicial

        double matriculaInicial;
        if (añoVehiculo >= 2020){
            matriculaInicial = 11.99;
        } else if (añoVehiculo >= 2016) {
            matriculaInicial = 13.99;
        } else {
            matriculaInicial = 15.99;
        }

        //Calculo del costo del impuesto

        double valorVehiculoEstimado = costoAlquiler *2; //suposicion del valor
        double costoImpuesto = (impuestosPorcentaje / 100) * valorVehiculoEstimado;

        //Calculo total de importacion

        double totalImportacion = costoImpuesto + costoAlquiler + matriculaInicial;

        //Mostrar resultados

        System.out.println("\n--- Resumen de importacion ---");
        System.out.println("Tipo de vehiculo: " + tipoVehiculo);
        System.out.println("Marca: "+ Marca);
        System.out.println("Año: " + añoVehiculo);
        System.out.println("Pais origen; " + paisOrigen);
        System.out.println("Porcentaje de impuestos "+ impuestosPorcentaje + "%");
        System.out.println("Costo de impuestos $ " + String.format("%.2f", costoImpuesto));
        System.out.println("Costo de alquiler: $" +String.format("%.2f", costoAlquiler) );
        System.out.println("Matricula inicial: $" + String.format("%.2f", matriculaInicial));
        System.out.println("Total de importacion: $" + String.format("%.2f", totalImportacion));
    }

}
