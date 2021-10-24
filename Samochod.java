import java.util.Random;

public class Samochod extends Thread {
    Stan stan;

    int iloscPaliwa;
    int numer;
    int tankuj = 5000;
    Random rand;
    Parking p;

    public Samochod( int iloscPaliwa, int numer, Parking p) {
        this.stan = Stan.Jazda;
        this.iloscPaliwa = iloscPaliwa;
        this.numer = numer;
        this.rand = new Random();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            if (stan == Stan.Parking) {
                if (rand.nextInt(2) == 1) {
                    stan = Stan.Start;
                    iloscPaliwa = tankuj;
                    System.out.println("Wyjazd z parkingu" + numer);
                    p.start(numer);
                } else {
                    System.out.println("Na parkingu dobrze mi");
                }

            } else if (stan == Stan.Start) {
                stan = Stan.Jazda;
                System.out.println("jadym z tym koxem" + numer);
            } else if (stan == Stan.Jazda) {
                System.out.println("Jadę "+numer);
                iloscPaliwa -= rand.nextInt(500);
                if (iloscPaliwa <= 500) {
                    stan = Stan.KoniecJazdy;

                } else try {
                    sleep(rand.nextInt(1000));
                } catch (Exception e) {
                }

            } else if (stan == Stan.KoniecJazdy) {
                System.out.println("Proszę o pozwolenie na parkowanie tyłem");
                p.parkuj();
                if (stan == Stan.KoniecJazdy) {
                    iloscPaliwa -= rand.nextInt(500);
                    System.out.println("Ilość paliwa" + iloscPaliwa);
                    if (iloscPaliwa <= 0) stan = Stan.Wypadek;
                }
            } else if (stan == Stan.Wypadek) {
                System.out.println("Wypadek samochodu " + numer);
                p.zmniejsz();

                break;
            }
        }
    }
}