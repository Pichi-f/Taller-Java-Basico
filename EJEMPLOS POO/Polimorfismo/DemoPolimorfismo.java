package Polimorfismo;

public class DemoPolimorfismo {
    public static void main(String[] args) {
        Figura figura1 = new Rectangulo(5, 3);  
        Figura figura2 = new Circulo(4);
        
        System.out.println("Área del Rectángulo: " + figura1.calcularArea());
        System.out.println("Área del Círculo: " + figura2.calcularArea());
    }
}
