package leitura_e_ecrita;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Saida {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream os = new FileOutputStream("arquivo.txt", true);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);

		String saida = "";
		for (int i = 0; i < 30; i++) {
			saida += "A saida que queremos que seja escrita no arquivo" + System.lineSeparator();			
		}
		bw.write(saida);
		bw.close();

	}
}
