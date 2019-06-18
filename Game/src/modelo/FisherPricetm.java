package modelo;

public class FisherPricetm
{
	
	private int numRandom;
	
	public FisherPricetm()
	{
		numRandom = -1;
		generarNumeroRamdom();
	}
	
	public void generarNumeroRamdom()
	{
		int solved = -1;
		
		solved = (int) (Math.random() * 3) + 1;
		
		numRandom = solved;
	}
	
	public int darNumeroRandom()
	{
		return numRandom;
	}

}
