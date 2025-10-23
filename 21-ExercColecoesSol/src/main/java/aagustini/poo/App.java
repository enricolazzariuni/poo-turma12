package aagustini.poo;

public class App {

	 public static void main(String[]  args) {
		
		 String[] files = new String[]{ "texto01.txt","texto02.txt", "texto03.txt",
				 "texto04.txt", "texto05.txt","texto06.txt", "texto07.txt",
				 "texto08.txt", "texto09.txt","texto10.txt" };

		 TextAnalysis dicionario = new TextAnalysis(files);
		 
	
		dicionario.listarArquivos("POO");
		dicionario.listarArquivos("Arquimedes");
		dicionario.listarArquivos("Beatles");
		dicionario.listarArquivos("física");
		dicionario.listarArquivos("nome");

		dicionario.listarArquivos("arquimedes", "beatles");
	    dicionario.listarArquivos("Arquimedes", "física");

		dicionario.listarPalavras("texto04.txt");

		dicionario.listarArquivos("Arquimedes", "física");

		// ao escrever um método que recebe uma lista os anteriores
		// ficam obsoletos

		 dicionario.listarArquivos(new String[]{"matemática"});
		 dicionario.listarArquivos(new String[]{"Arquimedes"});
	
		 dicionario.listarArquivos(new String[]{"Arquimedes", "matemática"});
		 dicionario.listarArquivos(new String[]{"Arquimedes", "física", "nome"});
		 
		 dicionario.listarPalavras("texto04.txt");
		 
		}
	
}
