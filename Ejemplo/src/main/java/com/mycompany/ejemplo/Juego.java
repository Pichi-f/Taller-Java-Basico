/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pichi
 */
public class Juego {
    private final Scanner sc;
    private final ArrayList<Jugador> historialJugadores;
    private ArrayList<String> palabras;
    private char[][] tablero;
    private boolean[][] posicionesOcupadas;

    public Juego() {
        sc = new Scanner(System.in);
        historialJugadores = new ArrayList<>();
        palabras = new ArrayList<>();
    }

    public void nuevaPartida() {
        System.out.println("\n===== NUEVA PARTIDA =====");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el tamaño del tablero (n x n): ");
        int tamaño;
        try {
            tamaño = Integer.parseInt(sc.nextLine());
            if (tamaño < 5) {
                System.out.println("El tamaño mínimo permitido es 5x5.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Tamaño inválido.");
            return;
        }

        // Aquí luego continuamos con el menú de palabras y el tablero
        System.out.println("¡Partida creada para " + nombre + " con tablero de " + tamaño + "x" + tamaño + "!");
        // Aquí crearemos un objeto Jugador y guardaremos la partida cuando termine
        
        while (true) {
            System.out.println("\n1. Menú Palabras");
            System.out.println("2. Jugar");
            System.out.println("3. Terminar Partida");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                menuPalabras();
            } else if (opcion.equals("2")) {
                jugarPartida(nombre, tamaño);
            } else if (opcion.equals("3")) {
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n===== HISTORIAL DE PARTIDAS =====");
        if (historialJugadores.isEmpty()) {
            System.out.println("No hay partidas registradas todavía.");
        } else {
            for (Jugador j : historialJugadores) {
                System.out.println(j);
            }
        }
    }
    
    private void menuPalabras() {
        while (true) {
            System.out.println("\n--- MENÚ DE PALABRAS ---");
            System.out.println("1. Insertar Palabras");
            System.out.println("2. Modificar Palabra");
            System.out.println("3. Eliminar Palabra");
            System.out.println("4. Mostrar Palabras");
            System.out.println("5. Salir al menú de Nueva Partida");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    insertarPalabras();
                    break;
                case "2":
                    modificarPalabra();
                    break;
                case "3":
                    eliminarPalabra();
                    break;
                case "4":
                    mostrarPalabras();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
    
    private void insertarPalabras() {
        System.out.print("¿Cuántas palabras desea ingresar?: ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            while (true) {
                System.out.print("Ingrese palabra #" + (i + 1) + ": ");
                String palabra = sc.nextLine().toUpperCase(); 

                if (palabra.length() >= 5 && palabra.length() <= 10) {
                    palabras.add(palabra);
                    break;
                } else {
                    System.out.println("La palabra debe tener entre 5 y 10 caracteres.");
                }
            }
        }
    }

    private void modificarPalabra() {
        System.out.print("Ingrese la palabra que desea modificar: ");
        String original = sc.nextLine().toUpperCase();

        if (palabras.contains(original)) {
            System.out.print("Ingrese la nueva palabra: ");
            String nueva = sc.nextLine().toUpperCase();
            if (nueva.length() >= 5 && nueva.length() <= 10) {
                int index = palabras.indexOf(original);
                palabras.set(index, nueva);
                System.out.println("Palabra modificada.");
            } else {
                System.out.println("La nueva palabra debe tener entre 5 y 10 caracteres.");
            }
        } else {
            System.out.println("Palabra no encontrada.");
        }
    }

    private void eliminarPalabra() {
        System.out.print("Ingrese la palabra que desea eliminar: ");
        String palabra = sc.nextLine().toUpperCase();
        if (palabras.remove(palabra)) {
            System.out.println("Palabra eliminada.");
        } else {
            System.out.println("Palabra no encontrada.");
        }
    }

    private void mostrarPalabras() {
        System.out.println("\n--- Palabras actuales ---");
        if (palabras.isEmpty()) {
            System.out.println("No hay palabras registradas.");
        } else {
            for (String p : palabras) {
                System.out.println("- " + p);
            }
        }
    }
    
    private void jugarPartida(String nombre, int tamaño) {
        if (palabras.isEmpty()) {
            System.out.println("No hay palabras registradas. Vuelva al menú y agréguelas.");
            return;
        }

        tablero = new char[tamaño][tamaño];
        posicionesOcupadas = new boolean[tamaño][tamaño];

        colocarPalabrasEnTablero(tamaño);
        rellenarTableroConLetras(tamaño);
        imprimirTablero(tamaño);

        Jugador jugador = new Jugador(nombre);
        int errores = 0;
        
        int totalPalabras = palabras.size();

        while (errores < 3 && jugador.getPalabrasEncontradas() < totalPalabras) {
            System.out.print("Ingrese una palabra: ");
            String intento = sc.nextLine().toUpperCase();

            if (palabras.contains(intento)) {
                marcarPalabraEnTablero(intento);
                jugador.sumarPuntos(intento.length());
                jugador.palabraEncontrada();
                palabras.remove(intento); // Ya fue encontrada
                System.out.println("¡Correcto! +"+intento.length()+" puntos.");
            } else {
                errores++;
                jugador.restarPuntos(5);
                jugador.aumentarFallos();
                System.out.println("Incorrecto. -5 puntos. Fallos: " + errores + "/3");
            }

            imprimirTablero(tamaño);
        }

        System.out.println("\nFin de la partida.");
        System.out.println(jugador);
        historialJugadores.add(jugador);
    }
    
    private void colocarPalabrasEnTablero(int tamaño) {
        for (String palabra : palabras) {
            boolean colocada = false;
            int intentos = 0;

            while (!colocada && intentos < 100) {
                intentos++;
                boolean horizontal = Math.random() < 0.5;
                int fila = (int)(Math.random() * tamaño);
                int col = (int)(Math.random() * tamaño);

                if (horizontal && col + palabra.length() <= tamaño) {
                    boolean espacioLibre = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        if (posicionesOcupadas[fila][col + i]) {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int i = 0; i < palabra.length(); i++) {
                            tablero[fila][col + i] = palabra.charAt(i);
                            posicionesOcupadas[fila][col + i] = true;
                        }
                        colocada = true;
                    }
                } else if (!horizontal && fila + palabra.length() <= tamaño) {
                    boolean espacioLibre = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        if (posicionesOcupadas[fila + i][col]) {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int i = 0; i < palabra.length(); i++) {
                            tablero[fila + i][col] = palabra.charAt(i);
                            posicionesOcupadas[fila + i][col] = true;
                        }
                        colocada = true;
                    }
                }
            }

            if (!colocada) {
                System.out.println("No se pudo colocar la palabra: " + palabra);
            }
        }
    }
    
    private void rellenarTableroConLetras(int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (!posicionesOcupadas[i][j]) {
                    tablero[i][j] = (char) ('A' + Math.random() * 26);
                }
            }
        }
    }

    private void imprimirTablero(int tamaño) {
        System.out.println("\nTABLERO:");
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void marcarPalabraEnTablero(String palabra) {
        // Recorremos el tablero buscando coincidencias horizontales o verticales
        int n = tablero.length;

        // Horizontal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - palabra.length(); j++) {
                boolean match = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (tablero[i][j + k] != palabra.charAt(k)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int k = 0; k < palabra.length(); k++) {
                        tablero[i][j + k] = '$';
                    }
                    return;
                }
            }
        }

        // Vertical
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= n - palabra.length(); i++) {
                boolean match = true;
                for (int k = 0; k < palabra.length(); k++) {
                    if (tablero[i + k][j] != palabra.charAt(k)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int k = 0; k < palabra.length(); k++) {
                        tablero[i + k][j] = '$';
                    }
                    return;
                }
            }
        }
    }
}
