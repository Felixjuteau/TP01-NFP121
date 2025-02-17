package src.temps;

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

        this.annee = annee;

        if (mois < 1)
            moisMoinsn(mois);
        else if (mois > 12)
            moisPlusn(mois);
        else
            this.mois = mois;
        if (jour < 1)
            jourMoinsn(jour);
        else if (jour > dernierJourDuMois(this.mois, this.annee))
            jourPlusn(jour);
        else
            this.jour = jour;
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

    public void jourMoins1() {
        jourMoinsn(-1);
    }

    public void jourPlus1() {

        jourPlusn(1);
    }

    public void moisMoins1() {
        moisMoinsn(-1);
    }

    public void moisPlus1() {
        moisPlusn(1);
    }

    public void anneePlus1() {
        this.annee++;
        this.jour = (this.jour > dernierJourDuMois(this.mois, this.annee)) ? dernierJourDuMois(this.mois, this.annee)
                : this.jour;
    }

    private void moisMoinsn(int mois) {
        while (mois != 0) {
            this.mois--;
            mois++;
            if (this.mois < 1) {
                this.mois = 12;
                this.annee--;
            }
        }
        this.jour = (this.jour > dernierJourDuMois(this.mois, this.annee))
                ? dernierJourDuMois(this.mois, this.annee)
                : this.jour;
    }

    private void moisPlusn(int mois) {
        while (mois != 0) {
            this.mois++;
            mois--;
            if (this.mois > 12) {
                this.mois = 1;
                this.annee++;
            }
        }
        this.jour = (this.jour > dernierJourDuMois(this.mois, this.annee)) ? dernierJourDuMois(this.mois, this.annee)
                : this.jour;
    }

    private void jourMoinsn(int jour) {
        while (jour != 0) {
            this.jour--;
            jour++;
            if (this.jour < 1) {
                if (this.mois == 1) {
                    this.jour = dernierJourDuMois(12, this.annee - 1);
                    this.moisMoinsn(-1);
                } else {
                    this.jour = dernierJourDuMois(this.mois - 1, this.annee);
                    this.moisMoinsn(-1);

                }
            }
        }
    }

    private void jourPlusn(int jour) {
        while (jour != 0) {
            if (this.jour >= dernierJourDuMois(mois, annee)) {
                this.jour = 1;
                if (this.mois != 12)
                    this.mois++;
                else {
                    this.mois = 1;
                    this.annee++;
                }
            } else
                this.jour++;
            jour--;
        }
    }

    public static Boolean bissextile(int annee) {
        if ((annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0)
            return true;
        else
            return false;
    }

    private static int dernierJourDuMois(int mois, int annee) {
        switch (mois) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return bissextile(annee) ? 29 : 28;
            default:
                return -1;
        }
    }

    public void anneeMoins1() {
        annee--;
        this.jour = (this.jour > dernierJourDuMois(this.mois, this.annee)) ? dernierJourDuMois(this.mois, this.annee)
                : this.jour;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(jour < 10 ? "0" + jour : jour)
                .append("/")
                .append(mois < 10 ? "0" + mois : mois)
                .append("/")
                .append((-10 < annee && annee < 10) ? "0" + annee : annee);

        return stringBuilder.toString();
    }

    public static Integer nombreDeJoursDuMois(int mois, int annee) {
        return dernierJourDuMois(mois, annee);
    }
}