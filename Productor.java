
/**
 * Write a description of class Productor here.
 * 
 * @author Roberto Salazar Márquez
 * @version 1.0
 */
public class Productor extends Thread
{
    // instance variables - replace the example below with your own
    
    private Almacen dato;

    /**
     * Constructor for objects of class Productor
     */
    public Productor(Almacen d)
    {
        // initialise instance variables
        dato = d;
    }
    
    public void run()
    {
        for(int i = 1; i <= 10; ++i)
        {
            dato.setValor(i);
            System.out.println("Se guardo en el almacen el valor " + i);
            try {
                sleep( (int) Math.random() * 500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}








