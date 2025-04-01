package Abstraccion;

public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: cada subclase debe implementarlo
    public abstract double calcularSalario();

    // Método concreto para mostrar información
    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Salario: " + calcularSalario());
    }
}
