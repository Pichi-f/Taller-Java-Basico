package Herencia;

public class Vehiculo {
    // Atributos protegidos para permitir acceso desde subclases
    protected String marca;
    protected int anio;

    // Constructor
    public Vehiculo(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    // Método para mostrar información del vehículo
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + " - Año: " + anio);
    }
}

