
package logic;

public class Bruch {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        if (nenner == 0) throw new IllegalArgumentException("Nenner darf nicht 0 sein.");
        this.zaehler = zaehler;
        this.nenner = nenner;
        kuerzen();
    }

    public Bruch add(Bruch b) {
        int z = this.zaehler * b.nenner + b.zaehler * this.nenner;
        int n = this.nenner * b.nenner;
        return new Bruch(z, n);
    }

    public Bruch sub(Bruch b) {
        int z = this.zaehler * b.nenner - b.zaehler * this.nenner;
        int n = this.nenner * b.nenner;
        return new Bruch(z, n);
    }

    public Bruch mul(Bruch b) {
        return new Bruch(this.zaehler * b.zaehler, this.nenner * b.nenner);
    }

    public Bruch div(Bruch b) {
        if (b.zaehler == 0) throw new IllegalArgumentException("Division durch 0 ist nicht erlaubt.");
        return new Bruch(this.zaehler * b.nenner, this.nenner * b.zaehler);
    }

    private void kuerzen() {
        int ggt = ggt(Math.abs(zaehler), Math.abs(nenner));
        zaehler /= ggt;
        nenner /= ggt;
        if (nenner < 0) {
            zaehler = -zaehler;
            nenner = -nenner;
        }
    }

    private int ggt(int a, int b) {
        return b == 0 ? a : ggt(b, a % b);
    }

    @Override
    public String toString() {
        return zaehler + "/" + nenner;
    }
}