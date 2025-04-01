package Abstraccion;

public class Abstraccion {
    public static void main(String[] args) {
        Empleado empleado1 = new EmpleadoTiempoCompleto("Ana", 3000);
        Empleado empleado2 = new EmpleadoPorHoras("Luis", 15, 160);

        empleado1.mostrarInformacion();
        System.out.println("---------------------");
        empleado2.mostrarInformacion();
    }
}
