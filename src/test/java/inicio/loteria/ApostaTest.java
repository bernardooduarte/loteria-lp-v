package inicio.loteria;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApostaTest {

    @Test
    void deveCriarApostaValida() {
        var numeros = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new Aposta(numeros));
    }

    @Test
    void deveLancarExcecaoQuandoListaNula() {
        assertThrows(IllegalArgumentException.class, () -> new Aposta(null));
    }

    @Test
    void deveLancarExcecaoComMenosDe6Numeros() {
        var numeros = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numeros));
    }

    @Test
    void deveLancarExcecaoComMaisDe15Numeros() {
        var numeros = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numeros));
    }

    @Test
    void deveLancarExcecaoComNumeroAbaixoDoMinimo() {
        var numeros = List.of(0, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numeros));
    }

    @Test
    void deveLancarExcecaoComNumeroAcimaDoMaximo() {
        var numeros = List.of(1, 2, 3, 4, 5, 61);
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numeros));
    }

    @Test
    void deveLancarExcecaoComNumerosDuplicados() {
        var numeros = List.of(1, 1, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new Aposta(numeros));
    }

    @Test
    void deveAceitarApostaCom15Numeros() {
        var numeros = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        assertDoesNotThrow(() -> new Aposta(numeros));
    }
}