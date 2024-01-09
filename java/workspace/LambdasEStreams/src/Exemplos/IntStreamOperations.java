package Exemplos;

import java.util.stream.IntStream;

public class IntStreamOperations {

	public static void main(String[] args) {
		
		int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
		
		System.out.println("Valores originais:");
		IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
		
		System.out.println();
		
		System.out.printf("%nCount (contar): %d%n", IntStream.of(values).count());
		System.out.printf("Min (máximo): %d%n", IntStream.of(values).min().getAsInt());
		System.out.printf("Max (mínimo): %d%n", IntStream.of(values).max().getAsInt());
		System.out.printf("Sum (soma): %d%n", IntStream.of(values).sum());
		System.out.printf("Average (média): %.2f%n", IntStream.of(values).average().getAsDouble());
		
		System.out.printf("%nSoma via reduce method: %d%n", 
				IntStream.of(values).reduce(0, (x, y) -> x + y));

		System.out.printf("Soma dos quadrados via reduce method: %d%n", 
				IntStream.of(values).reduce(0, (x, y) -> x + y * y));

		System.out.printf("Produto via reduce method: %d%n", 
				IntStream.of(values).reduce(1, (x, y) -> x * y));
		
		System.out.printf("%nValores pares exibidos em ordem de crescente: ");
		IntStream.of(values).filter(value -> value % 2 == 0)
			.sorted().forEach(value -> System.out.printf("%d ", value));
		
		System.out.println();
		
		System.out.printf("%nValores ímpares multiplicados e ordenados: ");
		IntStream.of(values).filter(value -> value % 2 != 0)
			.map(value -> value * 10)
			.sorted().forEach(value -> System.out.printf("%d ", value));
		
		System.out.println();
		
		System.out.printf("%nSoma dos inteiros de 1 a 10, exclusivo: %d%n", 
				IntStream.range(1, 10).sum()); //Não inclui o 10 na soma
		
		System.out.printf("%nSoma dos inteiros de 1 a 10, inclusivo: %d%n", 
				IntStream.rangeClosed(1, 10).sum()); //Inclui o 10 na soma

	}

}
 