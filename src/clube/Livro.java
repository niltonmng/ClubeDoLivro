package clube;

import java.util.ArrayList;
import java.util.List;

public class Livro {

	private static final String FIM_DE_LINHA = System.lineSeparator();
	
	private List<Opiniao> opinioes;
	private String titulo;
	private String autor;
	private int anoLancamento;
	private String isbn; // chave do registro, pois somente cada livro possui um isbn independente, que o identifica independentemente dos outros livros.
						 // registros sao armazenados na ordem pelo campo chave de registro.
	
	public Livro(String titulo, String autor, int anoLancamento,String isbn){
		this.titulo = titulo;
		this.autor = autor;
		this.anoLancamento = anoLancamento;
		this.isbn = isbn;
		this.opinioes = new ArrayList<Opiniao>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getISBN() {
		return isbn;
	}
	
	public List<Opiniao> getOpinioes(){
		return this.opinioes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Livro){
			Livro novoLivro = (Livro)obj;
			if(this.getISBN().equalsIgnoreCase(novoLivro.getISBN())){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return 	this.getTitulo() + " (ISBN " + this.getISBN() + "), " + this.getAnoLancamento() + ".  " + FIM_DE_LINHA + this.getAutor();
	}
}
