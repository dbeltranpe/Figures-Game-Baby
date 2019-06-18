package vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.Controlador;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Interfaz extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	public final static String FIGURA = "Figura";
	public final static String CIRCULO = "Circulo";
	public final static String CUADRADO = "Cuadrado";
	public final static String TRIANGULO = "Triangulo";

	private Controlador controlador;
	private PanelBoton panelBoton;
	private PanelCanvas panelCanvas;
	private PanelFigura panelFigura;

	public Interfaz(Controlador c)
	{
		controlador = c;

		setTitle("MiFisherPrice");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		panelBoton = new PanelBoton(this);
		panelCanvas = new PanelCanvas(controlador);
		panelFigura = new PanelFigura(this);

		add(panelCanvas, BorderLayout.CENTER);
		add(panelFigura, BorderLayout.EAST);
		add(panelBoton, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) 
	{
		String command = e.getActionCommand();

		if(command.equals(FIGURA))
		{
			String path = "./data/Figura.wav";
			try
			{
				InputStream in = new FileInputStream(path);
				AudioStream audioStream = new AudioStream(in);
				AudioPlayer.player.start(audioStream);
			}
			catch(Exception h)
			{
				h.getMessage();
			}

			controlador.generarRandom();
			controlador.darRandom();
			repaint();
		}

		else if(command.equals(CIRCULO))
		{
			controlador.asignarCirculo();
		}

		else if(command.equals(CUADRADO))
		{
			controlador.asignarCuadrado();
		}

		else if(command.equals(TRIANGULO))
		{
			controlador.asignarTriangulo();
		}

		if(!(command.equals(FIGURA)))
		{
			final ImageIcon icono1 = new ImageIcon("./data/CaritaFeliz.png");
			final ImageIcon icono2 = new ImageIcon(new ImageIcon("./data/CaritaTriste.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			
			if(controlador.darFigura().darForma() == panelCanvas.darFormaPintada())
			{
				String path = "./data/Correcto.wav";
				try
				{
					InputStream in = new FileInputStream(path);
					AudioStream audioStream = new AudioStream(in);
					AudioPlayer.player.start(audioStream);
				}
				catch(Exception h)
				{
					h.getMessage();
				}
				
				boolean trueOrFalse = true;
				controlador.escribirRespuesta(controlador.darFigura().darForma(), trueOrFalse);
				JOptionPane.showMessageDialog(this, "¡Correcto!", "¿Ganaste?", JOptionPane.INFORMATION_MESSAGE, icono1);
			}
			else
			{
				String path = "./data/Incorrecto.wav";
				try
				{
					InputStream in = new FileInputStream(path);
					AudioStream audioStream = new AudioStream(in);
					AudioPlayer.player.start(audioStream);
				}
				catch(Exception h)
				{
					h.getMessage();
				}
				
				boolean trueOrFalse = false;
				controlador.escribirRespuesta(controlador.darFigura().darForma(), trueOrFalse);
				JOptionPane.showMessageDialog(this, "¡Incorrecto!", "¿Ganaste?", JOptionPane.INFORMATION_MESSAGE, icono2);
			}

		}



	}

}
