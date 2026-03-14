package inicio.loteria;

import java.util.List;

public record Aposta(List<Integer> numeros) {

    private static final int MIN_NUMERO = 1;
    private static final int MAX_NUMERO = 60;
    private static final int MIN_NUMEROS = 6;
    private static final int MAX_NUMEROS = 15;

    public Aposta {
        validar(numeros);
        numeros = List.copyOf(numeros);
    }

    private static void validar(List<Integer> numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("A lista de números não pode ser nula.");
        }

        int tamanho = numeros.size();
        if (tamanho < MIN_NUMEROS || tamanho > MAX_NUMEROS) {
            throw new IllegalArgumentException(
                    "A aposta deve conter entre %d e %d números. Recebido: %d"
                            .formatted(MIN_NUMEROS, MAX_NUMEROS, tamanho)
            );
        }

        for (Integer numero : numeros) {
            if (numero < MIN_NUMERO || numero > MAX_NUMERO) {
                throw new IllegalArgumentException(
                        "Número fora do intervalo permitido (%d-%d): %d"
                                .formatted(MIN_NUMERO, MAX_NUMERO, numero)
                );
            }
        }

        long numerosDistintos = numeros.stream().distinct().count();
        if (numerosDistintos != tamanho) {
            throw new IllegalArgumentException("A aposta contém números duplicados.");
        }
    }
}