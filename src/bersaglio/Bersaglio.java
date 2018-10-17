
package bersaglio;
//PACKAGES RESPONSABILI DELLA GRAFICA!!!
import javax.swing.JFrame;
import javax.swing.JPanel;
//PER COSTANTI ED EVENTI, DEL PASSATO, AWT, si vede perchè fa parte del package java!!!
//.* ogni cosa
import java.awt.*;

public class Bersaglio 
{

    
    public static void main(String[] args) 
    {
        //creo una nuova finestra e ne metto il titolo
        JFrame jf = new JFrame("IL MIO BERSAGLIO");
        
        //SELEZIONO L'AZIONE DA FARE SULLA CHIUSURA
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JBersaglio panel = new JBersaglio();
        jf.setContentPane(panel); // getContentPane().add
        //necessario
        jf.pack();
        //necessario
        jf.setVisible(true);
        
    }
    //CLASSI STATICI INTERNE!!! solo se le metto nel main!!! come se fosse un metodo
//  public static class JBersaglio extends JPanel
//    {
//   
//        //JPanel ha una serie non piccola di settaggi
//        //na merda secondo me, perchè tiene variabili al suo interno
//      
//        //costruttore
//      public JBersaglio()
//      {
//        setBackground(Color.pink);
//        setPreferredSize(new Dimension(300,300));
//        
//      }
//    
//    }
    
}

//o , se publiche, esterne
class JBersaglio extends JPanel
    {
//   
        //JPanel ha una serie non piccola di settaggi
        //na merda secondo me, perchè tiene variabili al suo interno
      
        //costruttore
      public JBersaglio()
      {
        setBackground(Color.pink);
        setPreferredSize(new Dimension(300,300));
      }
      
      //polimorfismo per ereditarietà, faccio l'override del metodo paint
      public void paintComponent(Graphics g)
      {
          //ma allo stesso tempo chiamo il metodo della classe base!!! perchè voglio eseguua le sue istruzioni!!!
          super.paintComponent(g);
          //il PAINT PRIMA DISEGNA IL LIVELLO SOTTO
          //ORA DISEGNO IL PEZZO SOPRA
          int x = 0, y = 0, diametro = 300;
          g.setColor(Color.red);
          //DRAW DALLE COORDINATE IN ALTO A SINISTRA DI UN RETTANGOLO, all'interno 
          g.fillOval(x,y,300,300);
          g.setColor(Color.black);
          g.fillOval(25,25,250,250);
          g.setColor(Color.red);
          g.fillOval(50,50,200,200);
          g.setColor(Color.black);
          g.fillOval(75,75,150,150);
          int lastposizione = 75;
          int lastdiametro = 150;
          int delta = 5;
          for(int i = 0; i < 30; i++)
          {
              if(i%2 == 0)
              {
                  Color c = new Color(125+i*3,10+i*6,125);
                 g.setColor(c);
              }
              else
              {
               g.setColor(Color.MAGENTA);
              }
              
             lastposizione += delta;
             lastdiametro -= 2*delta;
             
                g.fillOval(lastposizione,lastposizione,lastdiametro,lastdiametro);
          }
          
      }
    
}