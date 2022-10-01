package java11_pruebas.pruebas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 /*
class AccionBotonMostrar implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Click en boton");
	}
}
*/
public class PruebaClaseInternaEnJavaSwing {
	public static void main(String[] args) {
		JFrame mensajeFrame = new JFrame();
		mensajeFrame.setLayout(new BoxLayout(mensajeFrame.getContentPane(), BoxLayout.Y_AXIS));
		mensajeFrame.setLocationRelativeTo(null);
		JLabel indicacionLbl = new JLabel("Presione el boton para mostrar mensaje");
		JLabel textoDeSalida = new JLabel("[TEXTO SALIDA]");
		JButton mostrarBtn = new JButton("Mostrar Mensaje");
		
		//AccionBotonMostrar accionBotonMostrar = new AccionBotonMostrar();
		//mostrarBtn.addActionListener(accionBotonMostrar);
		/*mostrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoDeSalida.setText("Hola a todos");
			}
		});*/
		mostrarBtn.addActionListener( e -> textoDeSalida.setText("Hola a todos"));
		
		indicacionLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		textoDeSalida.setAlignmentX(Component.CENTER_ALIGNMENT);
		mostrarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		mensajeFrame.add(indicacionLbl);
		mensajeFrame.add(mostrarBtn);
		mensajeFrame.add(textoDeSalida);
		mensajeFrame.setSize(300, 200);
		mensajeFrame.setVisible(true);
		
		
		
	}
}
