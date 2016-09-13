package e.z;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class App {

	private JFrame frame;
	private JTextField input1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 249);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		input1 = new JTextField();
		input1.setBounds(60, 39, 66, 21);
		frame.getContentPane().add(input1);
		input1.setColumns(10);
		
		JLabel show1 = new JLabel("");
		show1.setBounds(60, 133, 54, 15);
		frame.getContentPane().add(show1);
		
		
		JButton setBt = new JButton("Set");
		setBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JLabel show1 =frame.getContentPane()
//				JButton bt=((JButton) e.getSource());
//				 String butName = bt.getText();
//				 JOptionPane.showMessageDialog(null, butName, "标题",JOptionPane.INFORMATION_MESSAGE);  
				copy();
			}
		});
		setBt.setBounds(60, 76, 93, 23);
		frame.getContentPane().add(setBt);
		

	}
	public void copy(){
		String i=input1.getText();
		
		input1.setText("i="+i);
		SQLiteHelper.pre();
		if(SQLiteHelper.isInitiated())
		JOptionPane.showMessageDialog(null, i, "标题",JOptionPane.INFORMATION_MESSAGE);  
		SQLiteHelper.closeDb();
	}
	
}
