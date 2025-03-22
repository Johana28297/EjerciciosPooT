package Cliente;

import java.util.Date;

public class ClienteInfo {
    private int idCliente;
    private String nombre;
    private String documentoIdentificacion;
    private String tipoPersona;
    private String telefono;
    private String correo;
    private String direccion;
    private String estado;
    private String creadoPor;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaInactivacion;


    public ClienteInfo(int idCliente, String nombre, String documentoIdentificacion, String tipoPersona, String telefono, String correo, String direccion, String estado, String creadoPor, Date fechaCreacion) {
        validarDatos(nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado);
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documentoIdentificacion = documentoIdentificacion;
        this.tipoPersona = tipoPersona;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.creadoPor = creadoPor;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = null;
        this.fechaInactivacion = null;
    }


    public void actualizarCliente(String nombre, String documentoIdentificacion, String tipoPersona, String telefono, String correo, String direccion, String estado) {
        validarDatos(nombre, documentoIdentificacion, tipoPersona, telefono, correo, direccion, estado);
        this.nombre = nombre;
        this.documentoIdentificacion = documentoIdentificacion;
        this.tipoPersona = tipoPersona;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaActualizacion = new Date();
    }

    public void inactivarCliente() {
        this.estado = "Inactivo";
        this.fechaInactivacion = new Date();
    }

    private void validarDatos(String nombre, String documentoIdentificacion, String tipoPersona, String telefono, String correo, String direccion, String estado) {
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
        if (correo == null || correo.isEmpty() || !correo.matches("^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,4}$")) {
            throw new IllegalArgumentException("El correo no puede estar vacío y debe tener un formato válido.");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        if (estado == null || estado.isEmpty() || (!estado.equals("Activo") && !estado.equals("Inactivo"))) {
            throw new IllegalArgumentException("El estado debe ser 'Activo' o 'Inactivo'.");
        }
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Date fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    @Override
    public String toString() {
        return "ClienteInfo{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", documentoIdentificacion='" + documentoIdentificacion + '\'' +
                ", tipoPersona='" + tipoPersona + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", creadoPor='" + creadoPor + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                ", fechaInactivacion=" + fechaInactivacion +
                '}';
    }
}
