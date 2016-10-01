package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clube.ClubeDoLivro;
import clube.Livro;

public class TestClubeLivro {

	private ClubeDoLivro clube;
	
	@Before
	public void setup(){
		clube = new ClubeDoLivro();
	}
	
	@Test
	public void testePasso1(){
		try {
			Livro aCoroa = new Livro("A coroa","Kiera Cass",2016,"9788555340048");
			Livro alice = new Livro("Alice no pais das maravilhas","Lewis Caroll",1865,"9783791535661");
			
			Assert.assertEquals("A coroa", aCoroa.getTitulo());
			Assert.assertEquals("Kiera Cass", aCoroa.getAutor());
			Assert.assertEquals(2016, aCoroa.getAnoLancamento());
			Assert.assertEquals("9788555340048", aCoroa.getISBN());

			Assert.assertEquals("Alice no pais das maravilhas", alice.getTitulo());
			Assert.assertEquals("Lewis Caroll", alice.getAutor());
			Assert.assertEquals(1865, alice.getAnoLancamento());
			Assert.assertEquals("9783791535661", alice.getISBN());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testePasso2(){
		try {
			clube.importaLivros("resources_p2.csv");
			//testeGambiarra();// use esse metodo se nao souber resolver o artigo. 
			
			Livro aCoroa = clube.buscaLivro("9788555340048");
			Livro horaEstrela = clube.buscaLivro("9780586086926");
			Livro vigiarPunir = clube.buscaLivro("9787108017949");
			
			Assert.assertEquals("A coroa", aCoroa.getTitulo());
			Assert.assertEquals("Kiera Cass", aCoroa.getAutor());
			Assert.assertEquals(2016, aCoroa.getAnoLancamento());
			Assert.assertEquals("9788555340048", aCoroa.getISBN());

			Assert.assertEquals("A hora da estrela", horaEstrela.getTitulo());
			Assert.assertEquals("Clarice Lispector", horaEstrela.getAutor());
			Assert.assertEquals(1977, horaEstrela.getAnoLancamento());
			Assert.assertEquals("9780586086926", horaEstrela.getISBN());

			Assert.assertEquals("Vigiar e punir", vigiarPunir.getTitulo());
			Assert.assertEquals("Michel Foucault", vigiarPunir.getAutor());
			Assert.assertEquals(1975, vigiarPunir.getAnoLancamento());
			Assert.assertEquals("9787108017949", vigiarPunir.getISBN());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testePasso3e4(){
		try {
			//Razao e Sensibilidade
			clube.adicionaOpiniao("9788499080291", 1, "Marcos", "Livro muito chato!");
			clube.adicionaOpiniao("9788499080291", 4, "Marcela", "");
						
			//Harry Potter
			clube.adicionaOpiniao("9780747560777", 5, "Alice", "Excelente livro. Ja li umas 4 vezes.");
			clube.adicionaOpiniao("9780747560777", 4, "Denise", "Melhor livro da serie.");
			clube.adicionaOpiniao("9780747560777", 5, "Daniel", "Historia muito bem construida e com varias reviravoltas na trama.");
			Assert.assertEquals(5, clube.getNotaGeral("9780747560777"), 0.1);
			
			clube.adicionaOpiniao("9780747560777", 2, "Martha", "Livro divertido, mas muito infantil");
			clube.adicionaOpiniao("9780747560777", 3, "Andre", "");
			clube.adicionaOpiniao("9780747560777", 4, "Felicia", "Quero um hipogrifo. <3");
			
			//Dom Casmurro
			clube.adicionaOpiniao("9788508125975", 4, "Xenia", "Livro genial, mudou completamente quando li pela segunda vez.");
			clube.adicionaOpiniao("9788508125975", 2, "Natalya", "Achei a linguagem chata e confusa.");
			clube.adicionaOpiniao("9788508125975", 4, "George", "Nao eh a toa que eh classico da literatura.");
			clube.adicionaOpiniao("9788508125975", 4, "Tony", "#TeamBentinho");
			
			Assert.assertEquals(4.0, clube.getNotaGeral("9788499080291"), 0.1);
			Assert.assertEquals(3.8, clube.getNotaGeral("9780747560777"), 0.1);
			Assert.assertEquals(4.0, clube.getNotaGeral("9788508125975"), 0.1);
			

			//Opinioes de Razao e Sensibilidade
			clube.listaOpinioes("9788499080291");			
			//Opinioes de Harry Potter
			clube.listaOpinioes("9780747560777");
			//Opinioes de Dom Casmurro
			clube.listaOpinioes("9788508125975");
			
		} catch (Exception e) {
			//e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testePasso5(){
		try {
			clube.ranking(1);
			clube.ranking(3);
			
		} catch (Exception e) {
			//e.printStackTrace();
			Assert.fail();
		}
	}
	

	@Test
	public void testExceptions(){
		try {
			clube.adicionaLivro("A coroa","Kiera Cass",2016,"9788555340048");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Livro ja pertence ao acervo.", e.getMessage());
		}
		
		try {
			//Agua viva de Clarice Lispector - nao cadastrado ainda.
			clube.buscaLivro("9788478447831");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("O livro nao esta no nosso acervo.", e.getMessage());
		}
		
		try {
			clube.adicionaOpiniao("9788508125975", -5, "Neto", "Noa gostei. Li so porque caia no vestibular.");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nota fora do intervalo de 1 a 5.", e.getMessage());
		}		
		
		try {
			clube.ranking(100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nao ha livros suficientes no acervo.", e.getMessage());
		}
	}
	
	@Test
	public void testeGambiarra() throws Exception{
		try {
			clube.adicionaLivro("A origem das especies","Charles Darwin",1859,"9781481958813");
			clube.adicionaLivro("Depois de você","Jojo Moyes",2016,"9788580578645");
			clube.adicionaLivro("Herobrine - A Lenda","Pac e Mike",2016,"9788581303437");
			clube.adicionaLivro("Uma Aprendizagem ou O Livro dos Prazeres","Clarice Lispector",1969,"9789727085330");
			clube.adicionaLivro("Harry Potter e o Prisioneiro de Azkaban","J. K. Rowling",1999,"9780747560777");
			clube.adicionaLivro("Senhor dos aneis: o retorno do rei","J. R. R. Tolkien",1955,"9780884833642");
			clube.adicionaLivro("A hora da estrela","Clarice Lispector",1977,"9780586086926");
			clube.adicionaLivro("Tieta do agreste","Jorge Amado",1977,"9789721021945");
			clube.adicionaLivro("Entrevista com o vampiro","Anne Rice",1996,"9780345337665");
			clube.adicionaLivro("Frankenstein","Mary Shelley",1818,"9781608438037");
			clube.adicionaLivro("Vigiar e punir","Michel Foucault",1975,"9787108017949");
			clube.adicionaLivro("A fundacao","Isaac Asimov",1951,"9780553900347");
			clube.adicionaLivro("Dom casmurro","Machado de Assis",1899,"9788508125975");
			clube.adicionaLivro("Os irmaos karamazov","Fiodor Dostoievski",1880,"9788422503552");
			clube.adicionaLivro("Morangos mofados","Caio Fernando Abreu",1982,"9788522006465");
			clube.adicionaLivro("O pequeno príncipe","Antoine de Saint-Exupery",1943,"9781463704346");
			clube.adicionaLivro("Cem anos de solidao","Gabriel Garcia Marquez",1967,"9785267006323");
			clube.adicionaLivro("A coroa","Kiera Cass",2016,"9788555340048");
			clube.adicionaLivro("Como eu era antes de voce","Jojo Moyes",2013,"9788580573299");
			clube.adicionaLivro("Orlando","Virginia Woolf",1928,"9780143566458");
			clube.adicionaLivro("Razao e sensibilidade","Jane Austen",1811,"9788499080291");
		} catch (Exception e) {
			//e.printStackTrace();
			Assert.fail();
		}
	}
}
