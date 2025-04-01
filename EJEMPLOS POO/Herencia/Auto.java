package Herencia;

public class Auto extends Vehiculo {
    private int puertas;

    // Constructor: inicializa atributos heredados con super()
    public Auto(String marca, int anio, int puertas) {
        super(marca, anio);
        this.puertas = puertas;
    }

    // Sobrescribe el método para incluir la información de puertas
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Puertas: " + puertas);
    }
}



/*Subclase Auto:
Hereda de Vehiculo y añade un atributo propio (puertas). 
En su constructor se utiliza super(marca, anio) para inicializar
la parte heredada. Además, se sobrescribe el método mostrarInfo() 
para ampliar la información mostrada. */