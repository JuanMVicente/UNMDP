package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Semaphore;

public class BlackJack
{
    private Stack<Integer> baraja;
    private String primeroMano, jugadorMax;
    private Semaphore semaforo;
    private ArrayList<Jugador> jugadores;
    private int maxPuntos;
    private boolean hayEmpate;
    
    public BlackJack()
    {
        this.baraja = new Stack<Integer>();
        this.mezclar();               // ESTA MAL LLAMAR A METODO DESDE BUILDER ??
        this.primeroMano = null;
        this.semaforo = new Semaphore(1, true);
        this.jugadores = new ArrayList<Jugador>();
        this.maxPuntos = -1;
        this.hayEmpate = false;
    }
    
    private void mezclar()
    {
        int[] arreglo = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,
                         10,10,10,10,10,10,10,10,10};
        int i, j, aux;
        Random rnd = new Random();
        
        for (i = arreglo.length - 1; i > 0; i--) /* mezclo cartas */
        {
            j = rnd.nextInt(i + 1);
            aux = arreglo[j];
            arreglo[j] = arreglo[i];
            arreglo[i] = aux;
        }
        for (i = 0; i < arreglo.length; i++) /* apilo cartas */
            this.baraja.push(arreglo[i]);
    }
    
    public boolean finJuego()
    {
        return this.baraja.isEmpty();
    }
    
    public void tomarCartas(Jugador jugador)
    {
        int i = 1, paro, puntos = 0;
        Random rnd = new Random();
        
        try
        {
            System.out.println(jugador + " está esperando su turno.");
            semaforo.acquire();
            System.out.println(jugador + " está tomando cartas.");
            paro = rnd.nextInt(11); /* mayor cant cartas necesarias para sumar 21 es 11: 21 = 4*1 + 4*2 + 3*3 */
            while ((puntos < 21) && (i < paro) && (! this.baraja.isEmpty())) 
            { // PUEDE SUCEDER QUE PAREN MUCHO ANTES DE 21 Q HAGO ??
                puntos += this.baraja.pop();
                i++;
            }
            jugador.setPuntos(puntos);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public void plantar(Jugador jugador)
    {
        if (this.primeroMano == null)
            this.primeroMano = jugador.getNombre();
        else
            if (this.primeroMano == jugador.getNombre()) /* terminó mano anterior */
            {    
                //if (! this.hayEmpate)
                    //this.manosGanadas.put(this.jugadorMax, this.manosGanadas.get(this.jugadorMax) + 1);
                this.hayEmpate = false; 
                this.maxPuntos = -1;
            }    
        if ( (jugador.getPuntos() <= 21) && (jugador.getPuntos() > this.maxPuntos))
        {
            this.maxPuntos = jugador.getPuntos();
            this.jugadorMax = jugador.getName();
            this.hayEmpate = false;
        }
        else
            if (jugador.getPuntos() == this.maxPuntos)
                hayEmpate = true;
        System.out.println(jugador + " se plantó.");   
        semaforo.release();
    }
    
    public void resultados()
    {
        
    }
}