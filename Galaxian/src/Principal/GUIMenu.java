package Principal;


import java.awt.*;
import java.awt.event.*;
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;

=======
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
>>>>>>> refs/remotes/origin/Galaxian.v1.2
import javax.swing.*;

public class GUIMenu extends JFrame{
	
<<<<<<< HEAD
	private static final long serialVersionUID = 1L;
	private JButton bJugar,bSalir,bSesion;
=======
	private JButton bJugar,bSalir;
	private JDialog comentariosDialog;
	private JTextField comentariosText;
>>>>>>> refs/remotes/origin/Galaxian.v1.2
	private JPanel panel;
	private User user;
	
	public GUIMenu() {
		
		user = new User("", 0);
		
		setResizable(false);
		setBounds(100, 20, 600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel= new JPanel();
		panel.setLayout(null);
		JLabel imagenFondo= new JLabel(new ImageIcon(this.getClass().getResource("/img/panelFinal.jpg")));
		imagenFondo.setSize(600, 700);
		imagenFondo.setLocation(0, 0);
		panel.add(imagenFondo);
		getContentPane().add(panel);
		
		bSesion = new JButton();
		bSesion.setBorder(null);
		bSesion.setBackground(new Color(0, 0, 0));
		bSesion.setIcon(new ImageIcon(GUIMenu.class.getResource("/img/login.png")));
		bSesion.setBounds(185, 250, 230, 50);
		oyenteSesion ose= new oyenteSesion();
		bSesion.addActionListener(ose);
		panel.add(bSesion);
		
		bJugar = new JButton();
		bJugar.setBorder(null);
		bJugar.setBackground(new Color(0, 0, 0));
		bJugar.setIcon(new ImageIcon(GUIMenu.class.getResource("/img/play1.png")));
		bJugar.setBounds(185, 325, 230, 50);
		oyenteJugar oj= new oyenteJugar();
		bJugar.addActionListener(oj);
		panel.add(bJugar);
		
		bSalir = new JButton();
		bSalir.setBorder(null);
		bSalir.setBackground(new Color(0, 0, 0));
		bSalir.setIcon(new ImageIcon(GUIMenu.class.getResource("/img/exit.png")));
		bSalir.setBounds(194, 471, 200, 50);
		oyenteSalir os= new oyenteSalir();
		bSalir.addActionListener(os);
		panel.add(bSalir);
<<<<<<< HEAD
=======
		
		JButton bComentarios = new JButton();
		bComentarios.setBorder(null);
		bComentarios.setBackground(new Color(0, 0, 0));
		bComentarios.setBounds(0, 600, 260, 50);
		bComentarios.addActionListener(new oyenteAgregarComentarios());
		bComentarios.setIcon(new ImageIcon(GUIMenu.class.getResource("/img/enviarcomentario.png")));
		panel.add(bComentarios);
		
		
		comentariosText = new JTextField();
		comentariosText.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton enviarButton = new JButton("Enviar");
		enviarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		enviarButton.addActionListener(new oyenteEnviarComentarios());
		
		comentariosDialog = new JDialog();
		comentariosDialog.setSize(200, 100);
		comentariosDialog.setLocationRelativeTo(null);
		comentariosDialog.getContentPane().setLayout(new BoxLayout(comentariosDialog.getContentPane(), BoxLayout.PAGE_AXIS));
		comentariosDialog.getContentPane().add(comentariosText);
		comentariosDialog.getContentPane().add(enviarButton);
		
		
		
>>>>>>> refs/remotes/origin/Galaxian.v1.2
	}
	
	private class LoginForm extends JFrame{
		
		JLabel usernameLabel, passwordLabel;
		JTextField usernameField;
		JButton botonLogin;
		JPasswordField passwordField;
		JFrame frame;
		
		LoginForm(){
		
		  frame = new JFrame("Enter Username and Password");
		  usernameLabel = new JLabel("Username");
		  passwordLabel = new JLabel("Password");
		  usernameField = new JTextField();
		  passwordField = new JPasswordField();
		  botonLogin = new JButton("Login");
		  OyenteBotonLogin oblg = new OyenteBotonLogin();
		  botonLogin.addActionListener(oblg);
		  
		  usernameLabel.setBounds(10, 10, 200, 30);
		  passwordLabel.setBounds(10, 40, 200, 30);
		  usernameField.setBounds(80, 10, 200, 30);
		  passwordField.setBounds(80, 40, 200, 30);
		  botonLogin.setBounds(95, 80, 100, 30);
		 
		  frame.add(usernameLabel);
		  frame.add(usernameField);
		  frame.add(passwordLabel);
		  frame.add(passwordField);
		  frame.add(botonLogin);
		 
		  frame.setBounds(250, 150, 300, 150);
		  frame.setResizable(false);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  
		 }
		 
		 class OyenteBotonLogin implements ActionListener{
			
			public void actionPerformed(ActionEvent evt){
				
				String userName = usernameField.getText();
				char[] passwordIngresada = passwordField.getPassword();
				
				if(!userName.equals("") && !java.util.Arrays.equals(passwordIngresada, "".toCharArray())) {
				
					char[] passwordArchivo = getFilePassword(userName.toCharArray());
					
					if(java.util.Arrays.equals(passwordIngresada, passwordArchivo)){
						
					     user.setUsername(userName);
					     JOptionPane.showMessageDialog(panel,
					    		    "Bienvenido " + userName + "!");
					    
					     frame.dispose();
					}				
					
					else{
						
					    JOptionPane.showMessageDialog(panel,
					    		"Nombre de usuario o contraseña incorrectos",
					    		"Error",
					    		JOptionPane.ERROR_MESSAGE);
					}
				}
	        }
			
			private char[] getFilePassword(char[] usuarioIngresado){
				
				LinkedList<String> usuarios = readUsersFile();
				String password = "";
						
				for(String usuario : usuarios) {
					
					String username = getUsername(usuario.toCharArray());
					char[] usernameChar = username.toCharArray();
					
				    if(java.util.Arrays.equals(usernameChar, usuarioIngresado)) {
				    	password = getPassword(usuario.toCharArray());
				    	break;
				    }
				}
				
				
				return password.toCharArray();
			}
			
			private String getUsername(char[] linea) {
				
				String username = "";
				int i = 0;
				boolean listo = false;
				
				while(!listo & i < linea.length) {
					if(linea[i] != '&') {
						username += linea[i];
						i++;
					}
					else {
						listo = true;
					}
				}
				
				return username;
			}
			
			private String getPassword(char[] linea) {
				
				String password = "";
				int i = 0;
				
				while(linea[i] != '&')
					i++;
				i++;
				
				while(i < linea.length) {
					password += linea[i];
					i++;
				}
				
				return password;
			}
			
			private LinkedList<String> readUsersFile(){
				
				String ruta = "users.txt";
				LinkedList<String> usuarios = new LinkedList<String>();
				
				try {
					
					File users = new File(ruta);
				    BufferedReader reader = new BufferedReader(new FileReader(users));
				    String line;
				    
				    while ((line = reader.readLine()) != null)
				    	usuarios.add(line);
				    
				    reader.close();
				    
				    return usuarios;
				  }
				  
				  catch (Exception e) {
					  
				    System.err.format("Exception occurred trying to read '%s'.", "/PSS18-TPEO3-Com11/Galaxian/src/Data/users.txt");
				    e.printStackTrace();
				    return null;
				  }
			}
		}
	}
	
	////OYENTES
	private class oyenteSesion implements ActionListener{
		
		public void actionPerformed(ActionEvent evt){
			
			LoginForm loginform = new LoginForm();
        }
	}
	
	private class oyenteJugar implements ActionListener{
		
		public void actionPerformed(ActionEvent evt){
			GUI game= new GUI(user);
			game.setVisible(true);
			cerrar();
        }
	}
	
	private class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			cerrar();
		}
	}
<<<<<<< HEAD

	private void cerrar(){
		this.setVisible(false);
		this.dispose();
	}
}
=======
	
	private class oyenteAgregarComentarios implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			comentariosDialog.setVisible(true);
		}
	}
	
	private class oyenteEnviarComentarios implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			comentariosDialog.setVisible(false);
			StringBuilder builder = new StringBuilder(comentariosText.getText());
			builder.append(System.lineSeparator());
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("comentarios.txt", true));
				writer.append(builder.toString());
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			comentariosText.setText("");
		}
	}
}
>>>>>>> refs/remotes/origin/Galaxian.v1.2
