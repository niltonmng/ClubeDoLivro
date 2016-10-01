package clube;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClubeDoLivro {

	private Set<Livro> livros;
	private List<String> aux;

	public ClubeDoLivro() {
		this.aux = new ArrayList<String>();
		this.livros = new HashSet<Livro>();
	}

	public void adicionaLivro(String titulo, String autor, int ano, String isbn) throws Exception {
		if (this.livros.contains(buscaLivro(isbn))) {
			throw new Exception("Livro ja pertence ao acervo.");
		}
		Livro livro = new Livro(titulo, autor, ano, isbn);
		this.livros.add(livro);
	}

	public void importaLivros(String filename) throws Exception {
		FileInputStream fis = new FileInputStream(filename);  // novo fluxo de entrada de dados no sistema (aqui entrarao os dados que foram salvos no aquivo).
		InputStreamReader isr = new InputStreamReader(fis);   // InputStreamReader é o decodificador dos elementos que estao no arquivo.
		BufferedReader br = new BufferedReader(isr);  		  // BufferedReader concatena os diversos chars do arquivo, decodificados pelo InputStreamReader, para formar uma String através do método readLine
		
		String s = br.readLine();
		this.aux.add(s);
		while(s != null){
			s = br.readLine();                  // PASSOU NOS TESTES     FEITO DA FORMA CORRETA
			if(s != null){
				this.aux.add(s);
			}
		}
		br.close();
		this.resgataLivros();
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
		return 0.0;
	}

	public void listaOpinioes(String isbn) throws Exception {
		FileOutputStream os = new FileOutputStream("Opinioes.txt", true); // novo fluxo de saida de dados no sistema (aqui sairao vao ser salvos/escritos no aquivo).
		OutputStreamWriter osw = new OutputStreamWriter(os);              // OutputStreamReader é o decodificador dos elementos que irao ser salvos/escritos no arquivo.
		BufferedWriter bw = new BufferedWriter(osw);                // BufferedWriter concatena os diversos chars do arquivo, decodificados pelo OutputStreamReader, para formar uma String através do método write();
		
		Livro livro = buscaLivro(isbn);
		for (int i = 0; i < livro.getOpinioes().size(); i++) {
			String opiniao = livro.getOpinioes().get(i).toString(); // escrevemos cada opiniao da lista no arquivo
			bw.write(opiniao);			
		}
		bw.close();
	}

	public void ranking(int n) throws Exception {
	}
	
	
	private void resgataLivros(){
		for (int i = 0; i < this.aux.size(); i++) {
			String[] antesLivro = this.aux.get(i).split(",");
			
			String titulo = antesLivro[0].trim();
			String autor = antesLivro[1].trim();
			int ano = Integer.parseInt(antesLivro[2].trim());
			String isbn = antesLivro[3].trim();
			
			Livro livro = new Livro(titulo, autor, ano, isbn);
			this.livros.add(livro);
		}
	}

}
