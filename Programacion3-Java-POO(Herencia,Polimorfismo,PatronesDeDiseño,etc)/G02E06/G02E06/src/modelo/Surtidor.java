package modelo;

public class Surtidor {
    private int cantGasoil;
    private int cantPremium;
    private int cantSuper;
    private int ventaGasoil;
    private static int maximaCarga=20000;
    
    public Surtidor(){
        this.cantGasoil=maximaCarga;
        this.cantPremium=maximaCarga;
        this.cantSuper=maximaCarga;
    }
    
    public boolean extraerGasoil(int litros){
        if(litros<this.cantGasoil)
            return true;
        else
            return false;        
    }
    public boolean extraerPremium(int litros){
        if(litros<this.cantPremium)
            return true;
        else
            return false;        
    }
    public boolean extraerSuper(int litros){
        if(litros<this.cantSuper)
            return true;
        else
            return false;        
    }
    public ventaGasoil(boolean )
    
    public int getCantGasoil() {
        return cantGasoil;
    }

    public int getCantPremium() {
        return cantPremium;
    }

    public int getCantSuper() {
        return cantSuper;
    }
    public void llenarDepositoGasoil(){
        this.cantGasoil=maximaCarga;
    }
    public void llenarDepositoPremium(){
        this.cantPremium=maximaCarga;
    }
    public void llenarDepositoSuper(){
        this.cantSuper=maximaCarga;
    }
    
    //lo mismo para las tres
    public void ventaGasoil(int litros){
        if(this.extraerGasoil(litros)){
            this.ventaGasoil+=litros;
            this.cantGasoil -= litros;            
        }
        else{
            this.ventaGasoil += this.cantGasoil;
            this.cantGasoil =0;
        }
        
    }
    
    
}
