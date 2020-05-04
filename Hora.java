
/**
 * Write a description of class Hora here.
 * 
 * @author Roberto Salazar Márquez 
 * @version 1.1
 */

import java.awt.*;
import java.awt.event.*;

public class Hora extends Frame implements Runnable
{
    private TextField Texto;
    private Thread hilo;
    private int Segundos;

  public Hora()
  {
      setHoras(0);
      setMinutos(0);
      setSegundos(0);
  }
    
  public Hora(int h)
  {
      setHoras(h);
      setMinutos(0);
      setSegundos(0);
  }
  
  public Hora(int h, int m)
  {
      setHoras(h);
      setMinutos(m);
      setSegundos(0);
  }
  
  public Hora(int h, int m, int s, String nombre)
  {
      super(nombre);
      setHoras(h);
      setMinutos(m);
      setSegundos(s);
      setLayout(new  FlowLayout());
      Texto = new TextField(8);
      Texto.setEditable(false);
      add(Texto);
      addWindowListener(new CW());
      setSize(170,80);
      setVisible(true);
      
      hilo = new Thread(this);
      hilo.start();
  }
  
  
  private class CW extends  WindowAdapter
  {
      public void windowClosing(WindowEvent e)
      {
          System.exit(0);
      }
  }
    
  public void setHoras(int h)
  {
      int seg;
      if(h >= 0 && h < 24) {
          seg = Segundos / 3600;
          Segundos -= seg * 3600;
          Segundos += h * 3600;
        }
      
  }
  
  public void run()
  {
      int count = 0;
      while(count < 100)
      {
          tick();
          try {
              hilo.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
          Texto.setText(toString());
          count++;
      }
      
  }
  
  public int getHoras() 
  {
      return Segundos / 3600;
  }

  public void setMinutos(int m) 
  {
      int min;
      if(m >= 0 && m < 60) {
          min = ((Segundos % 3600) / 60);
          Segundos -= min * 60;
          Segundos += m * 60;
    }
  }

  public int getMinutos() 
  {
      return ((Segundos % 3600) / 60);
  }

  public void setSegundos(int s) 
  {
      int seg;
      if(s >= 0 && s < 60) {
          seg = ((Segundos % 3600) % 60);
          Segundos -= seg;
          Segundos += s;
    }
  }

  public int getSegundos() 
  {
      return ((Segundos % 3600) % 60);
  }

  public String toString() 
  {
      return ((getHoras() == 0 || getHoras()  == 12) ? 12 : getHoras()%12) + ":" 
              + (getMinutos() < 10 ? "0" : "") + getMinutos() + ":" 
              + (getSegundos() < 10 ? "0" : "") + getSegundos() 
              + (getHoras() < 12 ? " AM" : " PM");
  }
  
  public String toMilitaryString() 
  {
      return (getHoras() < 12 ? "0" : "") + getHoras()
            + (getMinutos() < 10 ? "0" : "" + getMinutos()) + " Hrs";
  }

  public void tick() 
  {
      Segundos++;
      if(Segundos >= 86400) Segundos = 0; 
  }
  
  
  public static void main(String Args[])
  {

  }

}



