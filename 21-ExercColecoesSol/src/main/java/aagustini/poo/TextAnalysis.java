package aagustini.poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;


public class TextAnalysis {

  private Set<String> allFiles;
	
  // palavra1 --> arq1, arq2, .., arqn
	// ..
	// palavraK --> arq3, arq7,...
  private Map<String, Set<String>> pals2arqs;


	// arq1 --> <p1, n1>, <p2, n2> ...
	// ..
	// arqn --> <p7, n7>, <p8, n8>

  private Map<String, Map<String,Integer>> arqs2pals;
  
	public TextAnalysis(String[] files) {

    allFiles = new HashSet<>();
    pals2arqs = new HashMap<>();
    arqs2pals = new HashMap<>();

		for (String fname : files ) {
			this.carregaDados(fname);
      allFiles.add(fname);      
		}
	}
	
	public void listarArquivos(String palavra) {
    palavra = palavra.toLowerCase();
    if(!pals2arqs.containsKey(palavra)){
      System.out.println("\nNenhum arquivo encontrado para a palavra: "+palavra);
    //  return;
    } else {

    System.out.println("\nArquivos que contém a palavra: "+palavra);

		Set<String> arquivos = pals2arqs.get(palavra);
    for(String arquivo : arquivos){
      System.out.printf("\t%s", arquivo);
    }

    System.out.println();
  }
	}

  public void listarArquivos(String p1, String p2) {
    // strings são imutáveis, precisamos trocar e atribuir
    p1 = p1.toLowerCase();
    p2 = p2.toLowerCase();
    if ( !(pals2arqs.containsKey(p1) && pals2arqs.containsKey(p2))) {
       System.out.printf("\n%s ou %s não está no dicionário\n",
                        p1, p2);
        return;
      }
      // conjuntos são mutáveis, se não fizermos uma cópia 
      // o conunto que está no dicionário é perdido

      //Set<String> conj1 = new HashSet<>(pals2arqs.get(p1));
      Set<String> conj1 = new HashSet<>();
      conj1.addAll(pals2arqs.get(p1));
      Set<String> conj2 = pals2arqs.get(p2);

      conj1.retainAll(conj2);
      System.out.printf("\nArquivos que contém %s e %s \n",
                        p1, p2);
      for (String arq: conj1) {
        System.out.println(arq);
      }                   
      System.out.println();
  }
	
	public void listarArquivos(String[] palavras) {
    System.out.print("\nArquivos que contém as palavras: ");
		for (String pal : palavras) {
			System.out.print(pal + " ");
		}
		System.out.println(" ");
  
  }


	public void listarPalavras(String fileName) {
    		System.out.println("\nPalavras e frequencias do arquivo: "+ fileName);

		Map<String, Integer> freqs = arqs2pals.get(fileName);
		for (String pal : (freqs.keySet()).stream()
                            .sorted().toList()) {
			System.out.println("\t" + freqs.get(pal) + "\t" + pal);
		}
		System.out.println(" ");

	}

	private void carregaDados(String fileName) {
  
    arqs2pals.put(fileName, new HashMap<>());
		Path path1 = Paths.get(fileName);
		//System.out.println("\nArquivo: "+fileName);

		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("utf8"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				line = line.toLowerCase().replaceAll("[^a-zA-Z0-9áéíóúçãõà-]"," ");
				
        String[] palavras = line.split(" ");

        for(String palavra : palavras){
          if (palavra.isEmpty()) continue;
          
          if(!pals2arqs.containsKey(palavra)){
            //auxSet = new HashSet<>();
            //pals2arqs.put(palavra, auxSet);
            pals2arqs.put(palavra, new HashSet<>());
          }
          //Set<String> aux = pals2arqs.get(palavra);
          //aux.add(fileName);
          pals2arqs.get(palavra).add(fileName);
          
          Map<String,Integer> aux = arqs2pals.get(fileName);
          if(!aux.containsKey(palavra)){
            aux.put(palavra, 0);
          }
          //aux.get(palavra)++;
          aux.put(palavra, aux.get(palavra) + 1);
        }

			}

		} catch (IOException e) {
			System.out.println("Erro na leitura: "+e.getMessage());
		}
	}


}

