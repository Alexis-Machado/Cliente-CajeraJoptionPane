package com.iudigital.actividad.compra;
import com.iudigital.actividad.compra.cliente.producto.ClienteProducto;
import com.iudigital.actividad.compra.cliente.producto.Producto;
import javax.swing.JOptionPane;

public class CajeraProducto {

    // Atributo
    private String nombre;

    // Constructor
    public CajeraProducto(String nombre) {
        this.nombre = nombre;
    }

    // Método para procesar la compra del cliente
    public void procesarCompra(ClienteProducto cliente, long timeStamp) {
        float costoTotalCompra = 0; // Variable para almacenar el costo total de la compra

        // Mostrar mensaje de inicio del proceso de compra
        JOptionPane.showMessageDialog(null, "<html>La Cajera: <font color='blue'>" + this.nombre
                + "</font><br>Comienza a procesar la compra del cliente: <font color='blue'>"
                + cliente.getNombre()
                + "</font><br>Tiempo transcurrido: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + " Seg</html>");

        // Procesar cada producto del cliente
        for (Producto producto : cliente.getProductos()) {
            // Esperar 1 segundo (simulando el procesamiento)
            esperarXsegundos();

            // Agregar el costo del producto al costo total de la compra
            costoTotalCompra += producto.getCantidad() * producto.getPrecio();

            // Mostrar información del producto procesado
            String mensajeProducto = "<html>Compra realizada - Producto<br>"
                    + "Nombre: " + producto.getNombre()
                    + "<br>Precio: " + producto.getPrecio()
                    + "<br>Cantidad: " + producto.getCantidad()
                    + "<br>Costo Total: " + producto.getCantidad() * producto.getPrecio()
                    + "<br>Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " Seg</html>";
            JOptionPane.showMessageDialog(null, mensajeProducto);
        }

        // Mostrar el costo total de la compra
        String mensajeCostoTotal = "Costo total de la compra: " + costoTotalCompra;
        JOptionPane.showMessageDialog(null, mensajeCostoTotal);

        // Mostrar mensaje de finalización del proceso de compra
        String mensajeFinalizacion = "<html>La cajera: <font color='blue'>" + this.nombre
                + "</font><br>ha terminado de procesar al cliente: <font color='blue'>"
                + cliente.getNombre()
                + "</font><br>en el tiempo transcurrido de: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + " Seg</html>";
        JOptionPane.showMessageDialog(null, mensajeFinalizacion);
    }

    // Método privado para esperar 1 segundo
    private void esperarXsegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
