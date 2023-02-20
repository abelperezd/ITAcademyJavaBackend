package n1e1;


import java.util.ArrayList;

public class Venda {
    private class VendaBuidaException extends Exception {
        private String message;

        public VendaBuidaException(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private ArrayList<Producte> productes = new ArrayList<>();

    private float totalPrice;
    public float getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Producte prod){
        productes.add(prod);
    }

    public void calcularTotal() throws Exception {
        if (productes.size() > 0) {
            totalPrice = 0;
            for (Producte p : productes) {
                totalPrice += p.getPreu();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(new VendaBuidaException("Per fer una venda primer has d'afegir productes").getMessage());
        }
    }
}
