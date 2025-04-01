package Encapsulacion;

import java.util.Scanner;

public class DemoEncapsulamiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Se crea una cuenta con saldo inicial
        cuentabancaria cuenta = new cuentabancaria("123456789", 1000.0);
        
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\nMenú:");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    cuenta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
