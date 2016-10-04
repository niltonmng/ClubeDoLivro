package clube;

public class Opiniao {
	private static final String FIM_DE_LINHA = System.lineSeparator();
	
	private int nota;
	private String comentarioTexto;
	private String autor;
	
	public Opiniao(int nota, String comentario, String autor) throws Exception{
		if(nota < 1 || nota > 5){
			throw new Exception("Nota fora do intervalo de 1 a 5.");
		}
		this.nota = nota;
		this.comentarioTexto = comentario;
		this.autor = autor;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentarioTexto() {
		return comentarioTexto;
	}

	public void setComentarioTexto(String comentarioTexto) {
		this.comentarioTexto = comentarioTexto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((comentarioTexto == null) ? 0 : comentarioTexto.hashCode());
		result = prime * result + nota;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opiniao other = (Opiniao) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (comentarioTexto == null) {
			if (other.comentarioTexto != null)
				return false;
		} else if (!comentarioTexto.equals(other.comentarioTexto))
			return false;
		if (nota != other.nota)
			return false;
		return true;
	}

	public String toString(){
		String recomendacao = "";
		if(nota > 3){
			recomendacao += " recomendou esse livro.";
		}else{
			recomendacao += " nao recomendou esse livro.";
		}
		return this.getAutor() + recomendacao + FIM_DE_LINHA + "Nota: " + this.getNota() + FIM_DE_LINHA + this.getComentarioTexto();
	}
}