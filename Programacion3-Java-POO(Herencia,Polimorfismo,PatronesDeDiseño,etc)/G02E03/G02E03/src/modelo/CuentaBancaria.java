package modelo;

public class CuentaBancaria {
    public CuentaBancaria() {
        super();
    }
    private double saldo;
    private String titular;


    public CuentaBancaria(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }
    
    public boolean extraer(double monto){
        if(this.saldo<monto){
            return false;
        }
        else{
            this.saldo -= monto;
            return true;
        }
            
    }
}
