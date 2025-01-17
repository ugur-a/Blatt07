public class Feld {

  public static Pflanze auswahl(PflanzenPaar pair) {
    Pflanze p =
        switch (pair) {
          case PflanzenPaar(Rosengewaechs x, _) -> x;
          case PflanzenPaar(_, Rosengewaechs x) -> x;
          case PflanzenPaar(BlauerEisenhut e, Salbei s) when s.getLaenge() >= 5 -> e;
          case PflanzenPaar(Salbei s, BlauerEisenhut e) when s.getLaenge() >= 5 -> e;
          default -> pair.a();
        };

    if (p instanceof Rosengewaechs) {
      while (p.getLaenge() < p.getMaxLaenge()) {
        p.waessern();
      }
      if (p instanceof Himbeere) {
        p.schneiden(1);
      }
    }

    return p;
  }

  public static void main(String[] args) {
    System.out.println("Start");
    Himbeere himbeere = new Himbeere();
    Lorbeerkirsche lorbeerkirsche = new Lorbeerkirsche();
    Salbei salbeiLang = new Salbei();
    lorbeerkirsche.waessern();
    lorbeerkirsche.schneiden(6);
    salbeiLang.waessern();
    salbeiLang.waessern();
    salbeiLang.waessern();
    salbeiLang.waessern();
    Salbei salbei = new Salbei();
    BlauerEisenhut blauerEisenhut = new BlauerEisenhut();
    blauerEisenhut.schneiden(1);

    PflanzenPaar pair1 = new PflanzenPaar(himbeere, salbei);
    PflanzenPaar pair2 = new PflanzenPaar(salbei, lorbeerkirsche);
    PflanzenPaar pair3 = new PflanzenPaar(lorbeerkirsche, blauerEisenhut);
    PflanzenPaar pair4 = new PflanzenPaar(salbeiLang, blauerEisenhut);
    PflanzenPaar pair5 = new PflanzenPaar(salbei, blauerEisenhut);

    System.out.println("Auswahl:" + auswahl(pair1) + ", Laenge:" + auswahl(pair1).getLaenge());
    System.out.println("Auswahl:" + auswahl(pair2) + ", Laenge:" + auswahl(pair2).getLaenge());
    System.out.println("Auswahl:" + auswahl(pair3) + ", Laenge:" + auswahl(pair3).getLaenge());
    System.out.println("Auswahl:" + auswahl(pair4) + ", Laenge:" + auswahl(pair4).getLaenge());
    System.out.println("Auswahl:" + auswahl(pair5) + ", Laenge:" + auswahl(pair5).getLaenge());
  }
}
