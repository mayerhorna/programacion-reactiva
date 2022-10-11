package java11_pruebas.pruebas.patron_observer.swing_con_observer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class AppJTextField extends JTextField{
	private JTextField jTextFieldEspejo;
	
	public AppJTextField() {
	}
	
	public AppJTextField(int columns) {
		super(columns);
	}
	
	public void setjTextFieldEspejo(JTextField jTextFieldEspejo) {
		this.jTextFieldEspejo = jTextFieldEspejo;
		jTextFieldEspejo.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = ((JTextField)e.getSource()).getText();
				AppJTextField.this.setText(texto);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}
}
