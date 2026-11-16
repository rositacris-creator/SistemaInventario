package src.main.java;

import java.util.ArrayList;

import src.main.Producto;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Registrar o reponer productos
    public void agregarProducto(String nombre, int cantidad) {

        for (Producto producto : productos) {

            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setStock(producto.getStock() + cantidad);
                return;
            }
        }

        productos.add(new Producto(nombre, cantidad));
    }

    // Vender productos
    public boolean venderProducto(String nombre, int cantidad) {

        for (Producto producto : productos) {

            if (producto.getNombre().equalsIgnoreCase(nombre)) {

                if (cantidad > 0 && producto.getStock() >= cantidad) {
                    producto.setStock(producto.getStock() - cantidad);
                    return true;
                }

                return false;
            }
        }

        return false;
    }

    // Mostrar inventario completo
    public void mostrarInventario() {

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("-------------------");
        }
    }

    // Mostrar productos con stock critico
    public void mostrarStockCritico() {

        for (Producto producto : productos) {

            if (producto.getStock() <= 5) {
                System.out.println(producto.getNombre()
                        + " - Stock: " + producto.getStock());
            }
        }
    }
}
