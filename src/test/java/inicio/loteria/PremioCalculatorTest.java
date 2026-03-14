package inicio.loteria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PremioCalculatorTest {

    private PremioCalculator calculator;
    private static final double VALOR_APOSTADO = 1000.0;
    private static final double DELTA = 0.001;

    @BeforeEach
    void setUp() {
        calculator = new PremioCalculator();
    }

    @Test
    void deveRetornarPremioIntegralComSeiAcertos() {
        var aposta = new Aposta(List.of(1, 2, 3, 4, 5, 6));
        var sorteados = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(VALOR_APOSTADO, calculator.calcular(aposta, sorteados, VALOR_APOSTADO), DELTA);
    }

    @Test
    void deveRetornar20PorCentoComCincoAcertos() {
        var aposta = new Aposta(List.of(1, 2, 3, 4, 5, 6));
        var sorteados = List.of(1, 2, 3, 4, 5, 99);
        assertEquals(200.0, calculator.calcular(aposta, sorteados, VALOR_APOSTADO), DELTA);
    }

    @Test
    void deveRetornar5PorCentoComQuatroAcertos() {
        var aposta = new Aposta(List.of(1, 2, 3, 4, 5, 6));
        var sorteados = List.of(1, 2, 3, 4, 50, 60);
        assertEquals(50.0, calculator.calcular(aposta, sorteados, VALOR_APOSTADO), DELTA);
    }

    @Test
    void deveRetornarZeroComTresAcertos() {
        var aposta = new Aposta(List.of(1, 2, 3, 4, 5, 6));
        var sorteados = List.of(1, 2, 3, 40, 50, 60);
        assertEquals(0.0, calculator.calcular(aposta, sorteados, VALOR_APOSTADO), DELTA);
    }

    @Test
    void deveRetornarZeroSemAcertos() {
        var aposta = new Aposta(List.of(1, 2, 3, 4, 5, 6));
        var sorteados = List.of(7, 8, 9, 10, 11, 12);
        assertEquals(0.0, calculator.calcular(aposta, sorteados, VALOR_APOSTADO), DELTA);
    }
}