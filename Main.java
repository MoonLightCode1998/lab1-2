public class Main {
    static int iloscSamochodow=10;
    static int iloscMiejsc=500;
    static Parking parking;

    public static void main(String[] args) {
       Parking parking=new Parking(iloscMiejsc, iloscSamochodow);
        for(int i=0;i<iloscSamochodow;i++)
            new Samochod(2000,i,parking).start();


    }

}
