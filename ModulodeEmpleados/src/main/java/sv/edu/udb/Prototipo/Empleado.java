package sv.edu.udb.Prototipo;


import java.util.Date;

public class Empleado {
    private int id;
    private String nombre;
    private String documento;
    private String tipoPersona; // Natural o Jurídica
    private String tipoContratacion; // Permanente o Por Horas
    private String telefono;
    private String correo;
    private String direccion;
    private String estado; // Activo o Inactivo
    private String creador;
    private Date fechaCreacion; // Fecha de creación del empleado
    private Date fechaActualizacion; // Fecha de última actualización
    private Date fechaInactivacion; // Fecha de inactivación

    // Constructor
    public Empleado(int id,
                    String nombre,
                    String documento,
                    String tipoPersona,
                    String tipoContratacion,
                    String telefono,
                    String correo,
                    String direccion,
                    String estado,
                    String creador) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.tipoPersona = tipoPersona;
        this.tipoContratacion = tipoContratacion;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.creador = creador;
        this.fechaCreacion = new Date(); // Fecha de creación
        this.fechaActualizacion = new Date(); // Fecha de actualización inicial (la misma que la de creación)
        this.fechaInactivacion = null; // Aún no está inactivo
    }

    // Métodos Getter y Setter
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTipoPersona() { return tipoPersona; }
    public String getTipoContratacion() { return tipoContratacion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) {
        this.estado = estado;
        if (estado.equals("Inactivo")) {
            this.fechaInactivacion = new Date(); // Si cambia a inactivo, actualiza la fecha
        }
    }
    public String getCreador() { return creador; }
    public Date getFechaCreacion() { return fechaCreacion; }
    public Date getFechaActualizacion() { return fechaActualizacion; }
    public Date getFechaInactivacion() { return fechaInactivacion; }

    // Establecer la fecha de actualización cuando se actualiza un empleado
    public void setFechaActualizacion() {
        this.fechaActualizacion = new Date(); // Actualiza la fecha de actualización
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Documento: " + documento +
                ", Tipo: " + tipoPersona + ", Contrato: " + tipoContratacion +
                ", Tel: " + telefono + ", Email: " + correo +
                ", Dirección: " + direccion + ", Estado: " + estado +
                ", Creador: " + creador + ", Fecha de Creación: " + fechaCreacion +
                ", Fecha de Actualización: " + fechaActualizacion +
                ", Fecha de Inactivación: " + (fechaInactivacion != null ? fechaInactivacion : "N/A");
    }
}


