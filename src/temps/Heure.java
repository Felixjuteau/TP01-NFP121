package src.temps;

public interface Heure {
    byte heure();

    byte minute();

    byte seconde();

    void heureMoins1();

    void heurePlus1();

    void minuteMoins1();

    void minutePlus1();

    void secondeMoins1();

    void secondePlus1();

    String toString();
}
