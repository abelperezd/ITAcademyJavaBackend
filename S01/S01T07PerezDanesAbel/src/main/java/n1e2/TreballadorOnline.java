package n1e2;

public class TreballadorOnline extends Treballador {

    private static final int TARIFA_PLANA = 50;

    public TreballadorOnline(String nom, String cognom, int preu_hora) {
        super(nom, cognom, preu_hora);
    }

    @Override
    public int calcularSou(int horesTreballadesAlMes) {
        return super.calcularSou(horesTreballadesAlMes) + TARIFA_PLANA;
    }

    @Deprecated
    public int calcularSouDiari(int horesTreballadesAlDia) {
        return super.calcularSou(horesTreballadesAlDia) + TARIFA_PLANA / 28;
    }

}
