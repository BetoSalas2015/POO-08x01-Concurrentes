
/**
 * Write a description of class Almacen here.
 * 
 * @author Roberto Salazar Márquez
 * @version 1.0
 */
public class Almacen
{
    // instance variables - replace the example below with your own
    private int valor;
    private boolean libre = true;

    /**
     * Constructor for objects of class Almacen
     */
    public Almacen()
    {
        // initialise instance variables

    }
    
    public synchronized void setValor(int val)
    {
        while(!libre) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();  }
        }
        valor = val;
        libre = false;
        notify();
    }
    
    public synchronized int getValor()
    {
        while(libre) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();  }
        }
        libre = true;
        notify();
        return valor;
    }

}



