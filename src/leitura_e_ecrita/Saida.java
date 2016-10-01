package leitura_e_ecrita;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Saida {
	
	private FileOutputStream os;
	private OutputStreamWriter osw;
	private BufferedWriter bw;
	
	public Saida(String nomeArquivo) throws FileNotFoundException{
		this.os = new FileOutputStream(nomeArquivo /*"arquivo.txt"*/, true);
		this.osw = new OutputStreamWriter(os);
		this.bw = new BufferedWriter(osw);
	}
	
	public void escreve(String saida) throws IOException{
		this.bw.write(saida);
		this.bw.close();
	}
}

	/*
	public static void main(String[] args) throws IOException {
		Saida s = new Saida();
		String saida = "";
		for (int i = 0; i < 30; i++) {
			saida += "A saida que queremos que seja escrita no arquivo" + System.lineSeparator();			
		}
		s.escreve(saida);
	}*/