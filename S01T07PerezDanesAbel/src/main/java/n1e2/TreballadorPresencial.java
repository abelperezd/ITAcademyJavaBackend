package n1e2;

public class TreballadorPresencial extends Treballador {

    private static int benzina = 75;

    public TreballadorPresencial(String nom, String cognom, int preu_hora) {
        super(nom, cognom, preu_hora);
    }

    @Override
    public int calcularSou(int horesTreballadesAlMes) {
        return super.calcularSou(horesTreballadesAlMes) + benzina;
    }

    @Deprecated
    public int calcularSouDiari(int horesTreballadesAlDia) {
        return super.calcularSou(horesTreballadesAlDia) + benzina / 28;
    }

}
