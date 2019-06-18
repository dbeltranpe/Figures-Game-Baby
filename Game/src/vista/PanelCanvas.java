package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JPanel;

import com.sun.glass.events.MouseEvent;

import controlador.Controlador;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class PanelCanvas extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private Controlador controlador;
	private String forma;

	public PanelCanvas(Controlador c)
	{
		setBackground(Color.WHITE);

		controlador = c;
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		
		this.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(java.awt.event.MouseEvent e) 
			{
			}
			
			public void mousePressed(java.awt.event.MouseEvent e) 
			{	
			}
			
			public void mouseExited(java.awt.event.MouseEvent e) 
			{	
			}
			
			public void mouseEntered(java.awt.event.MouseEvent e) 
			{	
			}
			
			public void mouseClicked(java.awt.event.MouseEvent e) 
			{
				
				if(forma.equals("Circulo"))
				{
					String path = "./data/Circulo.wav";
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
				}
				
				else if(forma.equals("Cuadrado"))
				{
					String path = "./data/Cuadrado.wav";
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
				}
				
				else if(forma.equals("Triangulo"))
				{
					String path = "./data/Triangulo.wav";
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
				}
			}
		});

		add(canvas);
	}

	public void paint(Graphics g, int num)
	{
		Graphics2D g2d = (Graphics2D) g;

		if(num == 1)
		{
			g2d.setPaint(Color.YELLOW);
			g2d.fillOval(25, 15, 300, 300);
			forma = "Circulo";
		}
		else if(num == 2)
		{
			g2d.setPaint(Color.RED);
			g2d.fillPolygon(new int[] {175, 60 ,290}, new int[] {60,280,280} , 3);
			forma = "Triangulo";
		}
		else if(num == 3)
		{
			g2d.setPaint(Color.BLUE);
			g2d.fillRect(58, 50, 250, 250);
			forma = "Cuadrado";
		}
	}

	public void paintComponent(Graphics g) 
	{
		if(controlador.darRandom()==1)
		{
			super.paintComponent(g);
			paint(g, 1);
		}
		
		if(controlador.darRandom()==2)
		{
			super.paintComponent(g);
			paint(g, 2);
		}
		
		if(controlador.darRandom()==3)
		{
			super.paintComponent(g);
			paint(g, 3);
		}
	} 
	
	public String darFormaPintada()
	{
		return forma;
	}

}
