package com.iudigital.actividad.compra.thread;

import com.iudigital.actividad.compra.cliente.producto.ClienteProducto;
import com.iudigital.actividad.compra.cliente.producto.Producto;
import javax.swing.JOptionPane;

public class CajeraThreadProducto extends Thread {
    private String nombre;
    private ClienteProducto cliente;
    private long tiempoInicial;

    public CajeraThreadProducto(String nombre, ClienteProducto cliente, long tiempoInicial) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoInicial = tiempoInicial;
    }
    
    @Override
    public void run() {
        float costoTotalCompra = 0; // Variable para almacenar el costo total de la compra
        
        // Mostrar mensaje de inicio del proceso de compra
        JOptionPane.showMessageDialog(null, "La Cajera " + this.nombre 
                + " Comienza a Procesar la Compra del Cliente " 
                + this.cliente.getNombre() + " En el Tiempo: " 
                + (System.currentTimeMillis() -  this.tiempoInicial) / 1000 +  " Seg");
         
        int contCliente = 1;
        
        for (Producto producto : cliente.getProductos()) {
            // Agregar el costo del producto al costo total de la compra
            costoTotalCompra += producto.getCantidad() * producto.getPrecio();
            
            // Esperar un segundo entre cada producto
            esperarXsegundos();
               
            // Mostrar información del producto procesado
            String mensajeProducto = "Compra realizada para " + cliente.getNombre()
                    +" - Producto "  + contCliente 
                    + " - Nombre: " + producto.getNombre() 
                    + " - Precio: " + producto.getPrecio() 
                    + " - Cantidad: " + producto.getCantidad() 
                    + " - Costo Total: " + producto.getCantidad() * producto.getPrecio() 
                    + " --> Tiempo: " + (System.currentTimeMillis() -  this.tiempoInicial) / 1000 + " Seg";
            JOptionPane.showMessageDialog(null, mensajeProducto);
            contCliente++;
        }
        
        // Mostrar el costo total de la compra
        String mensajeCostoTotal = "Costo total de la compra para " + cliente.getNombre() + ": " + costoTotalCompra;
        JOptionPane.showMessageDialog(null, mensajeCostoTotal);
         
        // Mostrar mensaje de finalización del proceso de compra
        String mensajeFinalizacion = "La cajera " +  this.nombre + " Ha Terminado de Procesar a el Cliente " 
                + this.cliente.getNombre() + " En el Tiempo " 
                + (System.currentTimeMillis() -  this.tiempoInicial) / 1000 + " Seg";
        JOptionPane.showMessageDialog(null, mensajeFinalizacion); 
    }
    
    private void esperarXsegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
