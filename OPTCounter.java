import java.text.ParseException;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class OPTCount extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1, label2;
    private JTextField jTextField1, jTextField2,jTextField3;
    private JButton button1, button2;
    final JPanel panel = new JPanel(); 
    JFrame f = new JFrame();
	int days = 0;
	public OPTCount(){
		 super("OPT Count");
		 label1= new JLabel("This calculates the amount of days it has taken to process your OPT ");  
	     label1.setFont(new Font("Arial",Font.BOLD,20));
	     label2= new JLabel("Input date received by USCIS");
	     label2.setFont(new Font("Arial",Font.BOLD,14));
	     jTextField1= new JTextField("mm");	 
	     jTextField1.setFont(new Font("Arial",Font.ITALIC,14));
	     jTextField2= new JTextField("dd");	 
	     jTextField2.setFont(new Font("Arial",Font.ITALIC,14));
	     jTextField3= new JTextField("yyyy");	 
	     jTextField3.setFont(new Font("Arial",Font.ITALIC,14));
	     button1= new JButton("Calculate");
	     button2= new JButton("Exit");
	     panel.setBackground(Color.BLUE);
	     panel.setLayout(null);
	     panel.add(button1);
	     panel.add(button2);	        
	     panel.add(label1);
	     panel.add(label2);
	     panel.add(jTextField1);
	     panel.add(jTextField2);
	     panel.add(jTextField3);
	     Insets insets = panel.getInsets();	        
	     label1.setBounds( 10+ insets.left, 5 + insets.top, 350, 20);
	     label2.setBounds( 10+ insets.left, 65 + insets.top, 350, 20);
	     button1.setBounds(10 + insets.left, 105 + insets.top, 130, 25);
	     button2.setBounds(150 + insets.left, 105 + insets.top,130, 25);
	     jTextField1.setBounds( 250+ insets.left, 65 + insets.top, 30, 20);
	     jTextField2.setBounds( 280+ insets.left, 65 + insets.top, 30, 20);
	     jTextField3.setBounds( 310+ insets.left, 65 + insets.top, 40, 20);
	     JPanel panel2 = new JPanel();
	     panel2.setBackground(Color.GRAY);
	     panel2.setLayout(null);   
	     panel2.add(panel);
	     Insets inset = panel2.getInsets();
	     panel.setBounds(10 + inset.left, 10 + inset.top, 370, 150);     
	     add(panel2);
	     button1.addActionListener(this);
	     button2.addActionListener(this);	
	}
	
	@Override	
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() ==button1)
        {
        	days = 90;
            int a = Integer.parseInt(jTextField1.getText());
            int b = Integer.parseInt(jTextField2.getText());
            int c = Integer.parseInt(jTextField3.getText());
    		Calendar y = Calendar.getInstance();
    		y.set(Calendar.YEAR, c);
    		y.set(Calendar.MONTH, a - 1);
    		y.set(Calendar.DAY_OF_MONTH, b);    		
    		Date z = y.getTime();
    		Calendar t = Calendar.getInstance();
    		t.set(Calendar.YEAR, c);
    		t.set(Calendar.MONTH, a - 1);
    		t.set(Calendar.DAY_OF_MONTH, b + days);    		
    		Date v = t.getTime();
            Date x = new Date();    		
    		long g = x.getTime() - z.getTime();
    		long h = g / (24 * 60 * 60 * 1000);
    		JOptionPane.showMessageDialog(null, "The amount of days your OPT has been undergoing processing is: " + h + "\n and the "+ days +" days is due on: " + v);
        }
        else if (event.getSource() ==button2)
        {
            dispose();
        }
        
    }
	
	public static void main(String[] args) throws ParseException{
		OPTCount in = new OPTCount();
		in.setSize(400, 200);
        in.setVisible(true);
        in.setResizable(false);
        in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
