package inicio.loteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {

    private static final int QUANTIDADE_NUMEROS_SORTEADOS = 6;
    private static final int MIN_NUMERO = 1;
    private static final int MAX_NUMERO = 60;

    private final Random random;

    public Sorteio() {
        this(new Random());
    }

    public Sorteio(Random random) {
        this.random = random;
    }

    public List<Integer> sortear() {
        List<Integer> numerosSorteados = new ArrayList<>();
        while (numerosSorteados.size() < QUANTIDADE_NUMEROS_SORTEADOS) {
            int numero = random.nextInt(MAX_NUMERO - MIN_NUMERO + 1) + MIN_NUMERO;
            if (!numerosSorteados.contains(numero)) {
                numerosSorteados.add(numero);
            }
        }
        return List.copyOf(numerosSorteados);
    }
}
