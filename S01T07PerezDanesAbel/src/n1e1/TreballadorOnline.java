package n1e1;

public class TreballadorOnline extends Treballador {

    private static final int TARIFA_PLANA = 50;

    public TreballadorOnline(String nom, String cognom, int preu_hora) {
        super(nom, cognom, preu_hora);
    }

    @Override
    public int calcularSou(int horesTreballadesAlMes) {
        return super.calcularSou(horesTreballadesAlMes) + TARIFA_PLANA;
    }

}
