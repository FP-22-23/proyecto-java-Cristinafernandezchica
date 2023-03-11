package fp.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp.common.Arma;
import fp.common.Coordenadas;
import fp.common.Genero;
import fp.tipos.TiroteoFatalImpl;

public class TestTiroteoFatalImpl {

	public static void main(String[] args) {
		
		List<String> policias1 = new ArrayList<>(Arrays.asList("Charita Edmett", "Yetty Klass", "Lacy Scantlebury"));
		
		TiroteoFatalImpl t1 = new TiroteoFatalImpl("3", "Tim Elliot", LocalDate.of(2015, 1, 2), "shot", Arma.gun,
				53, Genero.M, "Shelton", new Coordenadas(-123.1007066,47.2150945), true, false, policias1, 697.64);
		TiroteoFatalImpl t2 = new TiroteoFatalImpl(" 4,Lewis Lee Lembke,2/1/2015,shot,gun,47,M,Aloha,"
				+ "-122.8670451,45.4942838,False,False,Guglielmo Burnage;Russell Carsey;Shannah Rubertis,1455.63");
		TiroteoFatalImpl t3 = new TiroteoFatalImpl("100,Kristiana Coignard,22/1/2015,shot and Tasered,knife,17,F,"
				+ "Longview,-94.7404891,32.5007038,True,False,Karine Hamlyn;Corrie Tollerfield;Myca Wrathmall,2452.37");
		
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1.equals(t2));
		System.out.println(t3.menorMayor());
		System.out.println(t2.añoNacimiento());
		System.out.println(t1.getCoordenadas());
		System.out.println(t3.getCoordenadas());
		System.out.println(t3.getDistancia(t2));
		System.out.println(t3.getPolicias());
	}

}
