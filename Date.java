import java.util.function.BooleanSupplier;

public class Date {

    int jour = 01;
    int mois = 01;
    int annee = 2025;

    public Date() {
    };

    public Date(
            int jour,
            int mois,
            int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public int jour() {
        return jour;
    }

    public int mois() {
        return mois;
    }

    public int annee() {
        return annee;
    }

    public void jourPlus1() {
        switch (mois) {
            case 1, 3, 5, 7, 8, 10:
                if (/* dernierjour(mois) */ jour == 31) {
                    jour = 1;
                    mois++;
                } else
                    jour++;
                break;

            case 4, 6, 9, 11:
                if (jour == 30) {
                    jour = 1;
                    mois++;
                } else
                    jour++;
                break;
            case 2:
                if ((bissextile(annee) && jour == 29) || (!bissextile(annee) && jour == 28)) {
                    jour = 1;
                    mois++;
                } else
                    jour++;
                break;
            case 12:
                if (jour == 31) {
                    jour = 1;
                    mois = 1;
                    annee++;
                } else
                    jour++;
                break;
            default:
                if (dernierjour()) {
                    jour = 1;
                    mois++;
                } else
                    jour++;
                break;
        }

    }

    public void moisPlus1() {
        switch (mois) {
            case 2, 3, 5, 7, 8, 10:
                if (jour == 31) {
                    jour = 1;
                    mois++;
                } else
                    jour++;
                break;

            case 4, 6, 9, 11:
                if (jour == 30) {
                    jour = 1;
                    mois++;
                } else
                    jour++;
                break;
            case 1:
                if ((bissextile(annee) && jour == 29) || (!bissextile(annee) && jour == 28)) {
                    jour = 1;
                    mois = 3;
                } else
                    jour++;
                break;
            case 12:
                if (jour == 31) {
                    jour = 1;
                    mois = 1;
                    annee++;
                } else
                    jour++;
                break;
            default:
                break;
        }
    }

    public static Boolean bissextile(int annee) {
        if ((annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0)
            return true;
        else
            return false;
    }

    private Boolean dernierjour() {
        switch (mois) {
            case 1, 3, 5, 7, 8, 10:
                if (jour == 31)
                    return true;
                break;

            case 4, 6, 9, 11:
                if (jour == 30)
                    return true;
                break;
            case 2:
                if ((bissextile(annee) && jour == 29) || (!bissextile(annee) && jour == 28))
                    return true;

            default:
                return false;
        }
        return false;
    }
}