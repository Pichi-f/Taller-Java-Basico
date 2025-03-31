/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo;

/**
 *
 * @author pichi
 */
public class Jugador {
    private String nombre;
    private int puntos;
    private int fallos;
    private int palabrasEncontradas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 20; // Puntos iniciales
        this.fallos = 0;
        this.palabrasEncontradas = 0;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getFallos() {
        return fallos;
    }

    public int getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void sumarPuntos(int cantidad) {
        puntos += cantidad;
    }

    public void restarPuntos(int cantidad) {
        puntos -= cantidad;
        if (puntos < 0) {
            puntos = 0;
        }
    }

    public void aumentarFallos() {
        fallos++;
    }

    public void palabraEncontrada() {
        palabrasEncontradas++;
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " | Puntos: " + puntos + " | Fallos: " + fallos + " | Palabras encontradas: " + palabrasEncontradas;
    }
}
