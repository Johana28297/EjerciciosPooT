package Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteManager {
    private List<ClienteInfo> clientes;

    public ClienteManager() {
        this.clientes = new ArrayList<>();
    }

    public void crearCliente(int idCliente, String nombre, String documentoIdentificacion, String tipoPersona, String telefono, String correo, String direccion, String estado, String creadoPor) {
        validarDatos(nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado, creadoPor);

        ClienteInfo nuevoCliente = new ClienteInfo(idCliente, nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado, creadoPor, new Date());
        clientes.add(nuevoCliente);
    }

    public void actualizarCliente(int idCliente, String nombre, String documentoIdentificacion, String tipoPersona, String telefono, String correo, String direccion, String estado) {
        validarDatos(nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado, null);

        for (ClienteInfo cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                cliente.actualizarCliente(nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado);
                break;
            }
        }
    }

    public void inactivarCliente(int idCliente) {
        for (ClienteInfo cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                cliente.inactivarCliente();
                break;
            }
        }
    }

    public List<ClienteInfo> getClientes() {
        return clientes;
    }

    private void validarDatos(String nombre, String documentoIdentificacion, String tipoPersona, String telefono, String correo, String direccion, String estado, String creadoPor) {
        if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("El nombre no puede estar vacío y debe contener solo letras y espacios.");
        }
        if (documentoIdentificacion == null || documentoIdentificacion.isEmpty() || !documentoIdentificacion.matches("\\d+")) {
            throw new IllegalArgumentException("El documento de identificación no puede estar vacío y debe contener solo números.");
        }
        if (tipoPersona == null || tipoPersona.isEmpty() || (!tipoPersona.equals("Natural") && !tipoPersona.equals("Juridica"))) {
            throw new IllegalArgumentException("El tipo de persona debe ser 'Natural' o 'Juridica'.");
        }
        if (telefono == null || telefono.isEmpty() || !telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío y debe contener 10 dígitos.");
        }
        if (correo == null || correo.isEmpty() || !correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("El correo no puede estar vacío y debe tener un formato válido.");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        if (estado == null || estado.isEmpty() || (!estado.equals("Activo") && !estado.equals("Inactivo"))) {
            throw new IllegalArgumentException("El estado debe ser 'Activo' o 'Inactivo'.");
        }
        if (creadoPor != null && (creadoPor.isEmpty() || !creadoPor.matches("[a-zA-Z\\s]+"))) {
            throw new IllegalArgumentException("El campo 'Creado Por' no puede estar vacío y debe contener solo letras y espacios.");
        }
    }
}