

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TamilFontDemo extends JFrame{

	public TamilFontDemo(){
		
		// Anish--->"\u0B85\u0BA9\u0BC0\u0BB7\u0B82";
		// Gopi --->"\u0BC7\u0B95\u0BBE\u0BAA\u0BBF";
					
		// Amma--->"\u0B85\u0BAE\u0BCD\u0BAE\u0BBE";
		// Ashok-->"\u0B85\u0BC7\u0BB7\u0B95\u0B82"
				
		ResourceBundle bundle=ResourceBundle.getBundle("ApplicationResources_tam_IN");
		
		String name = bundle.getString("Amma");
		JLabel label = new JLabel(name);
		
		
		label.setFont(new Font("SooriyanDotCom", Font.BOLD, 16));
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(label);
		
		setVisible(true);
		setSize(300, 300);
		setTitle("Tamil Font");
		
		
	}
	
	public static void main(String[] args) {
		new TamilFontDemo();
	}

}
