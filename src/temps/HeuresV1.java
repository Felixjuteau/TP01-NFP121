package src.temps;

public class HeuresV1 implements Heure {
    byte heure = 12;
    byte minute = 0;
    byte seconde = 0;

    HeuresV1(byte heures, byte minutes, byte secondes) {
        this.heure = heures;
        this.minute = minutes;
        this.seconde = secondes;
    }

    public byte heure() {
        return heure;
    }

    public byte minute() {
        return minute;
    }

    public byte seconde() {
        return seconde;
    }

    public void minuteMoins1() {
        if (minute == 0) {
            heureMoins1();
            minute = 59;
        } else
            minute--;
    }

    public void minutePlus1() {
        if (minute == 59) {
            heurePlus1();
            minute = 0;
        } else
            minute++;
    }

    public void heureMoins1() {
        if (heure == 0)
            heure = 23;
        else
            heure--;
    }

    public void heurePlus1() {
        if (heure == 23)
            heure = 0;
        else
            heure++;
    }

    public void secondeMoins1() {
        if (seconde == 0) {
            minuteMoins1();
            seconde = 59;
        } else
            seconde--;
    }

    public void secondePlus1() {
        if (seconde == 59) {
            minutePlus1();
            seconde = 0;
        } else
            seconde++;
    }

    public String toString() {
        return heure + ":" + minute + ":" + seconde;
    }

}
