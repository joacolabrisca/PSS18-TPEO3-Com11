package Principal;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class GUIMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton bJugar,bSalir;
	private JDialog comentariosDialog;
	private JTextField comentariosText;
	private JPanel panel;

	public GUIMenu() {
		
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
		
		
		
	}
	
	private void cerrar() {
		this.setVisible(false);
		this.dispose();
	}
	
	////OYENTES
	private class oyenteJugar implements ActionListener{
		
		public void actionPerformed(ActionEvent evt){
			GUI game= new GUI();
			game.setVisible(true);
			cerrar();
        }	
	}
	
	private class oyenteSalir implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			cerrar();
		}
	}
	
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
