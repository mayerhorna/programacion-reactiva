package java11_pruebas.pruebas.patron_observer.swing_con_observer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
 
public class GUIConObserver {
	public static void main(String[] args) {
		int nroFilasEnFormulario = 0;
		int nroColumnasEnFormulario = 2;
		    
	    JPanel p = new JPanel(new SpringLayout());
	    JLabel nombreLabel = new JLabel("Ingrese su nombre: ", JLabel.TRAILING);
	    p.add(nombreLabel);
	    JTextField nombreTextField = new JTextField(10);
	    nombreLabel.setLabelFor(nombreTextField);
	    p.add(nombreTextField);
	    ++nroFilasEnFormulario;
	    
	    JLabel mayusculaLabel = new JLabel("En mayuscula se ve: ", JLabel.TRAILING);
	    p.add(mayusculaLabel);
	    AppJTextField mayusculaTextField = new AppJTextField(10);
	    mayusculaLabel.setLabelFor(mayusculaTextField);
	    p.add(mayusculaTextField);
	    mayusculaTextField.setjTextFieldEspejo(nombreTextField);
	    ++nroFilasEnFormulario;
	    
	    JLabel minusculaLabel = new JLabel("En minuscula se ve: ", JLabel.TRAILING);
	    p.add(minusculaLabel);
	    AppJTextField minusculaTextField = new AppJTextField(10);
	    minusculaTextField.setjTextFieldEspejo(nombreTextField);
	    minusculaLabel.setLabelFor(minusculaTextField);
	    p.add(minusculaTextField);
	    ++nroFilasEnFormulario;
	    
	    SpringUtilities.makeCompactGrid(p, nroFilasEnFormulario, nroColumnasEnFormulario, //rows, cols
	        6, 6, //initX, initY
	        6, 6); //xPad, yPad
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("SpringForm");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    p.setOpaque(true);  
	    frame.setLocationRelativeTo(null);
	    frame.setContentPane(p);
	    frame.pack();
	    frame.setVisible(true);
    }
    
    
}
