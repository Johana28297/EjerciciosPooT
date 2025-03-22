import java.util.ArrayList;
import java.util.List;

public class CotizacionDAO {
    private List<Cotizacion> cotizaciones;
    private int contadorId = 1;

    public CotizacionDAO() {
        this.cotizaciones = new ArrayList<>();
    }

    public void crearCotizacion(String cliente, double costoTotal) {
        Cotizacion cotizacion = new Cotizacion(contadorId++, cliente, new java.util.Date(), costoTotal);
        cotizaciones.add(cotizacion);
    }

    public List<Cotizacion> obtenerCotizaciones() {
        return cotizaciones;
    }

    public Cotizacion buscarCotizacion(int id) {
        return cotizaciones.stream().filter(c -> c.getIdCotizacion() == id).findFirst().orElse(null);
    }
}

