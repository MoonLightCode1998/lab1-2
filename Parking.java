public class Parking {
    int iloscMiejsc;
    int ilscSamochodow;
    int iloscZajetychMiejsc;

    public Parking(int iloscMiejsc, int ilscSamochodow) {
        this.iloscMiejsc = iloscMiejsc;
        this.ilscSamochodow = ilscSamochodow;
        this.iloscZajetychMiejsc =0;
    }
    synchronized Stan start(int numer){

        iloscZajetychMiejsc--;
        System.out.println("wyjazd "+numer);
        return Stan.Start;

    }
    synchronized Stan parkuj(){

        try{

            Thread.currentThread().sleep(1000);

        }
        catch(Exception ie){
        }
        if(iloscZajetychMiejsc<iloscMiejsc){
            iloscZajetychMiejsc++;
            System.out.println("Parkowanie w miejscu:  "+iloscZajetychMiejsc);
            return Stan.Parking;
        }
        else
        {return Stan.KoniecJazdy;}

    }
    synchronized void zmniejsz(){

        ilscSamochodow--;
        System.out.println("Wypadek");
        if(ilscSamochodow==iloscMiejsc) System.out.println("ilość samochodów taka jak miejsc _______________________________");


    }
}
