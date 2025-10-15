package aagustini.poo;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
			
		// Cria dicionário que mapeia código DDI (int) para nome do país (String)
		Map<Integer, String> dic = new HashMap<>();

		// Adiciona algumas entradas...
		dic.put(55, "Brasil");
		dic.put(1, "EUA");
		dic.put(44, "UK");
		dic.put(34, "Espanha");
		dic.put(41, "Suíça");
		dic.put(39, "Itália");

		System.out.println("\nNro de elementos no dicionário: " + dic.size());

		// Se o dicionário contém a chave 55...
		if (dic.containsKey(55)) {
			// Exibe o valor (Brasil)
			System.out.println("\nChave 55 é: " + dic.get(55));
		}

		// Retorna null, pois a chave 33 não existe
		//String p = dic.get(33);
		System.out.println("Chave 33? " + dic.get(33));
		//System.out.println("Chave 33? " + p.toUpperCase());

		dic.remove(1); // tenta remover o elemento cuja chave é 1

		// Exibe todas as chaves na tela (keySet retorna um Set<Integer>)
		System.out.println("\nTodas entradas do dicionário:");
		for (int k : dic.keySet())
			System.out.printf("K: %d  V: %s\n", k, dic.get(k));

		// se realmente precisa fazer isso escolheu a estrutura de dados errada
		for (String V : dic.values()) {
			if ( V.equals("Brasil"))
				System.out.println("\nBrasil está no dicionário");
		}


		// refatprando para usar a classe Pais
		Map<Integer, Pais> dic2 = new HashMap<>();

		// Adiciona algumas entradas...
		dic2.put(55, new Pais(55, "Brasil", 500));
		dic2.put(1, new Pais(1, "EUA", 400));
		dic2.put(44, new Pais(44, "Reino Unido", 500));


		System.out.println("\nTamanho do dic2:" + dic2.size());

		// Se o dicionário contém a chave 55...
		if (dic2.containsKey(55)) {
			// Exibe o valor (Brasil)
			System.out.println("Chave 55 é: " + dic2.get(55));
		}

		// Retorna null, pois a chave 33 não existe
		System.out.println("Chave 33? " + dic2.get(33));

		dic2.remove(1); // tenta remover o elemento cuja chave é 1

		// Exibe todas as chaves na tela (keySet retorna um Set<Integer>)
		System.out.println("\nConteúdo do dic2:");
		for (int k : dic2.keySet())
			System.out.printf("K: %d  V: %s\n", k, dic2.get(k));

		// se realmente precisa fazer isso escolheu a estrutura de dados errada
		for (Pais V : dic2.values()) {
			if ( V.getNome().equals("Brasil"))
				System.out.printf("\n5Brasil está no dic2");
		}
    
    }
}

