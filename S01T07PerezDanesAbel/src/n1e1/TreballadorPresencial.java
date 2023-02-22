package n1e1;

public class TreballadorPresencial extends Treballador {

    private static int benzina = 75;

    public TreballadorPresencial(String nom, String cognom, int preu_hora) {
        super(nom, cognom, preu_hora);
    }

    @Override
    public int calcularSou(int horesTreballadesAlMes) {
        return super.calcularSou(horesTreballadesAlMes) + benzina;
    }

}
