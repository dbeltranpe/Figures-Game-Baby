package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBoton extends JPanel  
{
	
	private JButton botonFigura;
	
	private Interfaz interfaz;
	
	public PanelBoton(Interfaz i)
	{
		interfaz = i;
		
		setLayout(new BorderLayout());
		Font font = new Font("Arial Black", 1, 15);
		
		botonFigura = new JButton("¡ F I G U R A !");
		botonFigura.setFont(font);
		botonFigura.setActionCommand(Interfaz.FIGURA);
		botonFigura.addActionListener(interfaz);
		botonFigura.setBackground(new Color(0, 255, 255));
		add(botonFigura);
	}

}
