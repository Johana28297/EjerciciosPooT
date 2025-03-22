package sv.edu.udb.Prototipo;

import java.util.ArrayList;
import java.util.List;

public class ModulodeEmpleados {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    // Agregar un nuevo empleado
    public void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
        System.out.println("Empleado agregado correctamente.");
    }

    // Listar empleados
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : empleados) {
                System.out.println(emp);
            }
        }
    }

    // Actualizar un empleado
    public void actualizarEmpleado(int id, String telefono, String correo, String direccion, String estado) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                emp.setTelefono(telefono);
                emp.setCorreo(correo);
                emp.setDireccion(direccion);
                emp.setEstado(estado); // Si el estado cambia a "Inactivo", actualizará fechaInactivacion
                emp.setFechaActualizacion(); // Establecer la fecha de actualización
                System.out.println("Empleado actualizado correctamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Inactivar un empleado
    public void inactivarEmpleado(int id) {
        for (Empleado emp : empleados) {
            if (emp.getId() == id) {
                emp.setEstado("Inactivo"); // Establecer el estado a "Inactivo"
                System.out.println("Empleado inactivado correctamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }
}
