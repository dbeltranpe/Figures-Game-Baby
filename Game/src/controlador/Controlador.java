package controlador;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.FisherPricetm;
import modelo.Triangulo;
import vista.Interfaz;

public class Controlador 
{
	private FisherPricetm modelo;
	private Interfaz interfaz;
	private Figura figura;
	private AdministradorPersistencia admon;

	public Controlador()
	{
		modelo = new FisherPricetm();
		
		admon = new AdministradorPersistencia();

		interfaz = new Interfaz(this);
		interfaz.setVisible(true);
	}

	public int darRandom()
	{
		return modelo.darNumeroRandom();
	}

	public void generarRandom()
	{
		modelo.generarNumeroRamdom();
	}

	public void asignarCuadrado()
	{
		figura = new Cuadrado();
	}
	
	public void asignarCirculo()
	{
		figura = new Circulo();
	}
	
	public void asignarTriangulo()
	{
		figura = new Triangulo();
	}
	
	public Figura darFigura()
	{
		return figura;
	}
	
	public void escribirRespuesta(String Forma, boolean trueOrFalse)
	{
		admon.escribirRespuesta(Forma, trueOrFalse);
	}
}