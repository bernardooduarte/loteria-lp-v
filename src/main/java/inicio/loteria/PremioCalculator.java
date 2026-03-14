package inicio.loteria;

import java.util.List;

public class PremioCalculator {

    private static final double PREMIO_SENA   = 1.0;
    private static final double PREMIO_QUINA  = 0.2;
    private static final double PREMIO_QUADRA = 0.05;

    public double calcular(Aposta aposta, List<Integer> numerosSorteados, double valorApostado) {
        long acertos = aposta.numeros().stream()
                .filter(numerosSorteados::contains)
                .count();

        return switch ((int) acertos) {
            case 6 -> valorApostado * PREMIO_SENA;
            case 5 -> valorApostado * PREMIO_QUINA;
            case 4 -> valorApostado * PREMIO_QUADRA;
            default -> 0.0;
        };
    }
}