package src.main;

import java.util.Scanner;

import src.main.java.Inventario;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO ===");
            System.out.println("1. Registrar o reponer producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Mostrar inventario completo");
            System.out.println("4. Mostrar stock critico");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = teclado.nextInt();
                    teclado.nextLine();

                    inventario.agregarProducto(nombre, cantidad);

                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Nombre del producto: ");
                    nombre = teclado.nextLine();

                    System.out.print("Cantidad a vender: ");
                    cantidad = teclado.nextInt();
                    teclado.nextLine();

                    if (inventario.venderProducto(nombre, cantidad)) {
                        System.out.println("Venta realizada correctamente.");
                    } else {
                        System.out.println("Venta rechazada. Revise el stock.");
                    }
                    break;

                case 3:
                    inventario.mostrarInventario();
                    break;

                case 4:
                    inventario.mostrarStockCritico();
                    break;

                case 0:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
