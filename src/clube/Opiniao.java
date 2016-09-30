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
	
	
	public String toString(){
		String recomendacao = "";
		if(nota > 3){
			recomendacao += " recomendou este livro";
		}else{
			recomendacao += " nao recomendou este livro";
		}
		return this.getAutor() + recomendacao + FIM_DE_LINHA + "Nota: " + this.getNota() + FIM_DE_LINHA + this.getComentarioTexto();
	}
}
