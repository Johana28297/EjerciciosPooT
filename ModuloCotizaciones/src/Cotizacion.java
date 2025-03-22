import java.util.Date;

public class Cotizacion {
    private int idCotizacion;
    private String cliente;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado; // "En proceso" o "Finalizada"
    private double costoTotal;

    public Cotizacion(int idCotizacion, String cliente, Date fechaInicio, double costoTotal) {
        this.idCotizacion = idCotizacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
        this.estado = "En proceso";
        this.costoTotal = costoTotal;
    }

    public void agregarAsignacion(double costo) {
        if (estado.equals("En proceso")) {
            this.costoTotal += costo;
        }
    }

    public void finalizarCotizacion() {
        this.estado = "Finalizada";
        this.fechaFin = new Date();
    }

    // Getters y Setters
    public int getIdCotizacion() { return idCotizacion; }
    public String getCliente() { return cliente; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public String getEstado() { return estado; }
    public double getCostoTotal() { return costoTotal; }
}

