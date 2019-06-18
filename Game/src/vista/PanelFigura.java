package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelFigura extends JPanel 
{
	
	private static final long serialVersionUID = 1L;
	private JButton btnCirculo;
	private JButton btnCuadrado;
	private JButton btnTriangulo;
	private ImageIcon icono1;
	private ImageIcon icono2;
	private ImageIcon icono3;
	
	private Interfaz inerfaz;
	
	public PanelFigura(Interfaz i)
	{
		inerfaz = i;
		
		setLayout(new GridLayout(3, 1));
		setBorder(new TitledBorder("Figuras"));
		setBackground(Color.WHITE);
		
		icono1 = new ImageIcon(new ImageIcon("./data/Circulo.png").getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
		icono2 = new ImageIcon(new ImageIcon("./data/Cuadrado.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
		icono3 = new ImageIcon(new ImageIcon("./data/Triangulo rojo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		
		btnCirculo = new JButton();
		btnCirculo.addActionListener(inerfaz);
		btnCirculo.setActionCommand(Interfaz.CIRCULO);
		btnCirculo.setIcon(icono1);
		btnCirculo.setOpaque(false);
		btnCirculo.setContentAreaFilled(false);
		btnCirculo.setBorderPainted(false);
		add(btnCirculo);
		
		btnCuadrado = new JButton();
		btnCuadrado.addActionListener(inerfaz);
		btnCuadrado.setActionCommand(Interfaz.CUADRADO);
		btnCuadrado.setIcon(icono2);
		btnCuadrado.setOpaque(false);
		btnCuadrado.setContentAreaFilled(false);
		btnCuadrado.setBorderPainted(false);
		add(btnCuadrado);
		
		btnTriangulo = new JButton();
		btnTriangulo.addActionListener(inerfaz);
		btnTriangulo.setActionCommand(Interfaz.TRIANGULO);
		btnTriangulo.setIcon(icono3);
		btnTriangulo.setOpaque(false);
		btnTriangulo.setContentAreaFilled(false);
		btnTriangulo.setBorderPainted(false);
		add(btnTriangulo);
	}

}
