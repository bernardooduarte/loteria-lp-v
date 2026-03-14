package inicio.loteria;

public class LoteriaSorteioService {

    private final Sorteio sorteio;
    private final PremioCalculator premioCalculator;

    public LoteriaSorteioService() {
        this(new Sorteio(), new PremioCalculator());
    }

    public LoteriaSorteioService(Sorteio sorteio, PremioCalculator premioCalculator) {
        this.sorteio = sorteio;
        this.premioCalculator = premioCalculator;
    }

    public double realizarSorteio(Aposta aposta, double valorApostado) {
        var numerosSorteados = sorteio.sortear();
        return premioCalculator.calcular(aposta, numerosSorteados, valorApostado);
    }
}
