/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo;

import java.util.Scanner;

/**
 *
 * @author pichi
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();

        while (true) {
            System.out.println("====== MENÚ PRINCIPAL ======");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Historial de Partidas");
            System.out.println("3. Mostrar Información del Estudiante");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    juego.nuevaPartida();
                    break;
                case "2":
                    juego.mostrarHistorial();
                    break;
                case "3":
                    mostrarInformacionEstudiante();
                    break;
                case "4":
                    System.out.println("¡Gracias por jugar!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void mostrarInformacionEstudiante() {
        System.out.println("\n===== INFORMACIÓN DEL ESTUDIANTE =====");
        System.out.println("Nombre: [Tu nombre aquí]");
        System.out.println("Carnet: [Tu carnet aquí]");
        System.out.println("Sección: P");
        System.out.println("======================================\n");
    }
}
