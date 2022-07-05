package modelo;

public class Colectivo {
    private String modelo;
    private int internoID;
    private static int sigID = 0;
    
    public Colectivo(String modelo){
        this.modelo=modelo;
        this.internoID = sigID;
        sigID++;
        
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public int getInternoID() {
        return internoID;
    }
}
