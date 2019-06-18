package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AdministradorPersistencia 
{
	
	public AdministradorPersistencia()
	{
		
	}
	
	public void escribirRespuesta(String Forma, boolean trueOrFalse)
	{
		try
		{

			File file = new File("./data/resultados.txt");
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm");
			String date = sdf.format(new Date()); 
			
			String Respuesta = (trueOrFalse)? "Correcto":"Incorrecto";
			String toPrint = Forma + "_" + Respuesta + "_" + date;
			
			pw.println(toPrint);
			
			pw.close();
			fw.close();
		}
		
		catch(Exception j)
		{
			j.printStackTrace();
		}
		
	}

}
