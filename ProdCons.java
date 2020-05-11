
/**
 * Write a description of class ProdCons here.
 * 
 * @author Roberto Salazar Márquez
 * @version 1.0
 */
public class ProdCons
{
    // instance variables - replace the example below with your own
    private Productor p;
    private Consumidor c;
    private Almacen alm;

    /**
     * Constructor for objects of class ProdCons
     */
    public ProdCons()
    {
        // initialise instance variables
        alm = new Almacen();
        p = new Productor(alm);
        c = new Consumidor(alm);
        
        p.start();
        c.start();
    }

}