package inicio.loteria;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorteioTest {

    @Test
    void deveSortearExatamenteSeiNumeros() {
        var sorteio = new Sorteio();
        List<Integer> resultado = sorteio.sortear();
        assertEquals(6, resultado.size());
    }

    @Test
    void deveSortearNumerosDistintos() {
        var sorteio = new Sorteio();
        List<Integer> resultado = sorteio.sortear();
        long distintos = resultado.stream().distinct().count();
        assertEquals(6, distintos);
    }

    @Test
    void deveSortearNumerosNointervaloValido() {
        var sorteio = new Sorteio();
        List<Integer> resultado = sorteio.sortear();
        assertTrue(resultado.stream().allMatch(n -> n >= 1 && n <= 60));
    }
}