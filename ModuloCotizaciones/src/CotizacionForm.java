import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CotizacionForm extends JFrame {
    private CotizacionDAO dao = new CotizacionDAO();
    private JTextField txtCliente, txtCosto;
    private JTextArea txtCotizaciones;

    public CotizacionForm() {
        setTitle("Gestión de Cotizaciones");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Cliente:"));
        txtCliente = new JTextField(20);
        add(txtCliente);

        add(new JLabel("Costo Inicial:"));
        txtCosto = new JTextField(10);
        add(txtCosto);

        JButton btnCrear = new JButton("Crear Cotización");
        btnCrear.addActionListener(e -> crearCotizacion());
        add(btnCrear);

        txtCotizaciones = new JTextArea(15, 30);
        txtCotizaciones.setEditable(false);
        add(new JScrollPane(txtCotizaciones));

        actualizarLista();
    }

    private void crearCotizacion() {
        String cliente = txtCliente.getText();
        double costo;
        try {
            costo = Double.parseDouble(txtCosto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un costo válido");
            return;
        }
        dao.crearCotizacion(cliente, costo);
        actualizarLista();
    }

    private void actualizarLista() {
        txtCotizaciones.setText("");
        for (Cotizacion c : dao.obtenerCotizaciones()) {
            txtCotizaciones.append("ID: " + c.getIdCotizacion() + " Cliente: " + c.getCliente() +
                    " Estado: " + c.getEstado() + " Costo: $" + c.getCostoTotal() + "\n");
        }
    }
}
