package sv.edu.udb.Ejercicio4;
import java.util.Scanner;

//Un colegio necesita requiere de un programa Java Consola o Java Swing para poder otorgar un
//descuento a los estudiantes al momento de matricularse, sí es antiguo ingreso se le otorgará un
//descuento de 25% y si es nuevo ingreso no tendrá descuento. Se debe solicitar el Nombre, Apellido,
//tipo de ingreso (Antiguo Ingreso, Nuevo Ingreso) y la edad del estudiante. El costo de matrícula variará
//según la edad del estudiante.
//Edad Matrícula
//Más de 15 años $100
//Más de 10 años $125
//Más de 5 años $150
//Información a mostrar
//Muestre la siguiente información:
//1) Nombre del estudiante
//2) Apellido del estudiante
//3) El valor de la matrícula
//4) El descuento obtenido.
//5) El valor final de la matrícula ya con descuento agregado.

public class Descuento {

    static class Estudiante {
        String nombre;
        String apellido;
        int edad;
        String tipoIngreso;
        double matricula;
        double descuento;
        double totalPagar;

        public Estudiante(String nombre, String apellido, int edad, String tipoIngreso) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.tipoIngreso = tipoIngreso;
            this.matricula = calcularMatricula();
            this.descuento = calcularDescuento();
            this.totalPagar = matricula - descuento;
        }

        private double calcularMatricula() {
            if (edad > 15) return 100;
            if (edad > 10) return 125;
            return 150;
        }

        private double calcularDescuento() {
            return tipoIngreso.equalsIgnoreCase("Antiguo") ? matricula * 0.25 : 0;
        }

        public void mostrarInformacion() {
            System.out.println("\nInformación del estudiante:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Valor de la matrícula: $" + matricula);
            System.out.println("Descuento obtenido: $" + descuento);
            System.out.println("Valor final con descuento: $" + totalPagar);
        }
    }

    public static class MatriculaEstudiante {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String nombre, apellido, tipoIngreso;
            int edad;

            // Validar Nombre (solo letras)
            while (true) {
                System.out.print("Ingrese el nombre del estudiante: ");
                nombre = scanner.nextLine();
                if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) break;
                System.out.println("❌ Error: El nombre no puede contener números ni caracteres especiales.");
            }

            // Validar Apellido (solo letras)
            while (true) {
                System.out.print("Ingrese el apellido del estudiante: ");
                apellido = scanner.nextLine();
                if (apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) break;
                System.out.println("❌ Error: El apellido no puede contener números ni caracteres especiales.");
            }

            // Validar Edad (solo números)
            while (true) {
                System.out.print("Ingrese la edad del estudiante: ");
                if (scanner.hasNextInt()) {
                    edad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    break;
                } else {
                    System.out.println("❌ Error: La edad debe ser un número entero.");
                    scanner.nextLine(); // Limpiar buffer incorrecto
                }
            }

            // Validar Tipo de Ingreso (solo "Antiguo" o "Nuevo")
            while (true) {
                System.out.print("Ingrese el tipo de ingreso (Antiguo/Nuevo): ");
                tipoIngreso = scanner.nextLine();
                if (tipoIngreso.equalsIgnoreCase("Antiguo") || tipoIngreso.equalsIgnoreCase("Nuevo")) break;
                System.out.println("❌ Error: Solo puede ingresar 'Antiguo' o 'Nuevo'.");
            }

            // Crear instancia del estudiante y mostrar información
            Estudiante estudiante = new Estudiante(nombre, apellido, edad, tipoIngreso);
            estudiante.mostrarInformacion();

            scanner.close();
        }
    }
}
