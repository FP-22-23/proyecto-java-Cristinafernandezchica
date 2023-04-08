package fp.test;

import fp.tipos.FactoriaTiroteosFatales;
import fp.tipos.TiroteosFatalesImpl;

public class TestFactoriaTiroteosFatales {

	public static void main(String[] args) {
		testLeerTiroteosFatales("data/fatalpoliceshootings.csv");

	}
	public static void testLeerTiroteosFatales(String fichero) {
		System.out.println("\nTestLeerTiroteosFatales =============");
		TiroteosFatalesImpl tiroteosFatales = FactoriaTiroteosFatales.leerTiroteosFatales(fichero);
		System.out.println("	Tiroteos Fatales: " +  tiroteosFatales);
	}

}
