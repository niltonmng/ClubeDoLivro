package clube;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClubeDoLivro {

	private static final String FIM_DE_LINHA = System.lineSeparator();
	
	private Set<Livro> livros;
	private List<String> aux;
	private List<Livro> aux2;

	public ClubeDoLivro() {
		this.aux = new ArrayList<String>();
		this.livros = new HashSet<Livro>();
		this.aux2 = new ArrayList<Livro>();
	}
	
	public Set<Livro> getLivros(){
		return this.livros;
	}

	public void adicionaLivro(String titulo, String autor, int ano, String isbn) throws Exception {
		if (this.pesquisaLivro(isbn) == true) {
			throw new Exception("Livro ja pertence ao acervo.");
		}
		Livro livro = new Livro(titulo, autor, ano, isbn);
		this.livros.add(livro);
	}
	
	private boolean pesquisaLivro(String isbn) throws Exception{
		for (Livro livro : this.getLivros()) {
			if(livro.getISBN().equals(isbn)){
				return true;
			}
		}
		throw new Exception("O livro nao esta no nosso acervo.");
	}

	public void importaLivros(String filename) throws Exception {
		FileInputStream fis = new FileInputStream(filename);  // novo fluxo de entrada de dados no sistema (aqui entrarao os dados que foram salvos no arquivo presente no root do projeto de nome "filename").
		InputStreamReader isr = new InputStreamReader(fis);   // InputStreamReader é o decodificador dos elementos que estao no arquivo.
		BufferedReader br = new BufferedReader(isr);  		  // BufferedReader concatena os diversos chars do arquivo, decodificados pelo InputStreamReader, para formar uma String através do método readLine
		
		String entrada = br.readLine();
		this.aux.add(entrada);
		while(entrada != null){
			entrada = br.readLine();
			if(entrada != null){
				this.aux.add(entrada);
			}
		}
		br.close();
		
		for (int i = 0; i < this.aux.size(); i++) {
			String[] antesLivro = this.aux.get(i).split(",");
			
			String titulo = antesLivro[0].trim();
			String autor = antesLivro[1].trim();
			int ano = Integer.parseInt(antesLivro[2].trim());
			String isbn = antesLivro[3].trim();
			
			Livro livro = new Livro(titulo, autor, ano, isbn);
			this.livros.add(livro);
			this.aux2.add(livro);
		}
	}

	public Livro buscaLivro(String isbn) throws Exception {
		for (Livro livro : this.livros) {
			if (livro.getISBN().equals(isbn)) {
				return livro;
			}
		}
		throw new Exception("O livro nao esta no nosso acervo.");
	}

	public void adicionaOpiniao(String isbn, int nota, String autor, String comentario) throws Exception {
		Livro livro = buscaLivro(isbn);
		Opiniao opiniao = new Opiniao(nota, comentario, autor);
		livro.getOpinioes().add(opiniao);
	}

	public double getNotaGeral(String isbn) throws Exception {
		Livro livro = buscaLivro(isbn);
		double media = 0.0;
		for (int i = 0; i < livro.getOpinioes().size(); i++) {
			media += livro.getOpinioes().get(i).getNota();
		}
		media /= livro.getOpinioes().size();
		return media;
	}

	public void listaOpinioes(String isbn) throws Exception {		
		FileOutputStream os = new FileOutputStream("Opinioes", true); // novo fluxo de saida de dados no sistema (aqui sairao vao ser salvos/escritos no aquivo).
		OutputStreamWriter osw = new OutputStreamWriter(os); // OutputStreamReader é o decodificador dos elementos que irao ser salvos/escritos no arquivo.
		BufferedWriter bw = new BufferedWriter(osw); // BufferedWriter concatena os diversos chars do arquivo, decodificados pelo OutputStreamReader, para formar uma String através do método write();
		
		Livro livro = buscaLivro(isbn);
		String saida = livro.toString() + FIM_DE_LINHA + FIM_DE_LINHA + "Opinioes:" + FIM_DE_LINHA;
		for (int i = 0; i < livro.getOpinioes().size(); i++) {
			String opiniao = livro.getOpinioes().get(i).toString();
			saida += opiniao + FIM_DE_LINHA;
		}
		bw.write(saida); // aqui escrevemos/salvamos todas as opinioes em um arquivo de saida essas opinioes a respeito de um livro.
		bw.close();
	}

	public void ranking(int n) throws Exception {
		if(n > this.aux2.size()){
			throw new Exception("Nao ha livros suficientes no acervo.");			
		}
		Collections.sort(aux2);
	}
}