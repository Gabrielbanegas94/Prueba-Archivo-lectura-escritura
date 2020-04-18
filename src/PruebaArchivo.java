
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;


public class PruebaArchivo {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		try {
			Scanner lectura = new Scanner(new File("ejemplo.txt"));
			while (lectura.hasNextLine()) {
				    
				if (lectura.hasNextInt()) {
					int cant = lectura.nextInt();
					double[] vec = new double[cant];
					for (int i = 0; i < cant; i++) {
						vec[i] = lectura.nextDouble();
						
						System.out.println("Se carga el valor "+ vec[i]);
					}//guarda datos en vector
					
					double min = vec[0], max = vec[0], sum = vec[0];
					for (int i = 1; i < cant; i++) {
						if (vec[i] < min)
							min = vec[i];

						if (vec[i] > max)
							max = vec[i];

						sum += vec[i];
					}///realiza las comprobaciones
				  	
					System.out.println("el promedio es: "+ (sum/cant));
					System.out.println("el maximo es: " + max);
					System.out.println("el minimo es: "+ min);
					System.out.println("-----el array ordenado queda-----");
					//Escribo archivo
					FileWriter fw = new FileWriter("Salida.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Minimo:" + Double.toString(min));
					bw.newLine();
					bw.write("Maximo:" + Double.toString(max));
					bw.newLine();
					bw.write("Promedio:" + Double.toString(sum/cant));
					bw.newLine();
					bw.newLine();
					Arrays.sort(vec);//ordena
					for (int i = 0; i < cant; i++) {
						bw.write("Vector ordenado:");
						bw.write(Double.toString(vec[i])+"\n");
						System.out.println("el valor en orden es: "+ vec[i]);
					  }
					//cierro archivo de escritura
					bw.close();
                    System.out.println("grabo el archivo");					
				}
			}
			lectura.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}