package modelo;

import java.security.AccessControlContext;

public class Jugador extends Thread
{
    private String nombre;
    private BlackJack blackJack;
    private int puntos;
    
    public Jugador(String nombre, BlackJack blackJack)
    {
        this.nombre = nombre;
        this.blackJack = blackJack;
        this.puntos = 0;
    }

    public void setPuntos(int puntos)
    {
        this.puntos = puntos;
    }

    public int getPuntos()
    {
        return puntos;
    }

    public String getNombre()
    {
        return nombre;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }

    @Override
    public void run()
    {
        while ( ! this.blackJack.finJuego())
        {
            this.blackJack.tomarCartas(this);
            this.blackJack.plantar(this);
        }
    }
}

