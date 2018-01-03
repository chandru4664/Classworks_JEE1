 

import java.util.ResourceBundle;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class TamilResourceDemo extends JFrame
   implements ActionListener 
{
  

  Container       c;
  JButton         show,query;
  JTextArea       display;
  JScrollPane     scroll;
  JPanel          panel;

    public TamilResourceDemo()
    {
     c = getContentPane();
     show = new JButton("Show");
     show.addActionListener(this);
     query= new JButton("Query");
     query.addActionListener(this);

     panel = new JPanel();
     panel.add(show);
      panel.add(query);
     c.add(panel,"South");
     display = new JTextArea();
     Font fnt = new Font("SooriyanDotCom",Font.BOLD,18);
     display.setFont(fnt);
     scroll = new JScrollPane(display);
     c.add(scroll,"Center");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

   
   public void actionPerformed(ActionEvent ae)
   {
      String res = ae.getActionCommand();
     Locale lc = new Locale("ta","IN");
     ResourceBundle bundle = null;
     if(res.equalsIgnoreCase("show"))
     {   
      bundle = ResourceBundle.getBundle("samp2",lc);
      display.setText("");
      display.append(bundle.getString("message"));
      }
     else if(res.equalsIgnoreCase("query"))
     {   
      bundle = ResourceBundle.getBundle("samp",lc);
      display.setText("");
      display.append(bundle.getString("message"));
      } 
   }

   public static void main(String[] args)
   {
    TamilResourceDemo trd = new TamilResourceDemo();
    trd.setSize(500,230);
    trd.setVisible(true);
   }      
 
 }   