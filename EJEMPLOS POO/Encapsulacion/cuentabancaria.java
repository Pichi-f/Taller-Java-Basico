package Encapsulacion;

public class cuentabancaria {
    // Atributos privados
    private String numeroCuenta;
    private double saldo;
    
    // Constructor
    public cuentabancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    
    // Getter para número de cuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    // Getter para el saldo
    public double getSaldo() {
        return saldo;
    }
    
    // Método para depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }
    
    // Método para retirar dinero
    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }
}

