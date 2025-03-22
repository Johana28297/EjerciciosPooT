package sv.edu.udb.Prototipo;

public class Persona {
    private int id;
    private String nombre;
    private String documento;
    private String tipoPersona; // Natural o Jurídica
    private String telefono;
    private String correo;
    private String direccion;
    private String estado; // Activo o Inactivo

    public Persona(int id, String nombre, String documento, String tipoPersona, String telefono, String correo, String direccion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.tipoPersona = tipoPersona;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTipoPersona() { return tipoPersona; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
