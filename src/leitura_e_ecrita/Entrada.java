package leitura_e_ecrita;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Entrada {

	FileInputStream fis;  // novo fluxo de entrada de dados no sistema (aqui entrarao os dados que foram salvos no arquivo presente no root do projeto de nome "filename").
	InputStreamReader isr;   // InputStreamReader é o decodificador dos elementos que estao no arquivo.
	BufferedReader br;  		  // BufferedReader concatena os diversos chars do arquivo, decodificados pelo InputStreamReader, para formar uma String através do método readLine
	
	public Entrada(String filename) throws FileNotFoundException{
		this.fis = new FileInputStream(filename);
		this.isr = new InputStreamReader(fis);
		this.br = new BufferedReader(isr);
	}
	
	
	public String entra() throws IOException{
		return this.br.readLine();
	}
	
	public void fecha() throws IOException{
		this.br.close();
	}
}
