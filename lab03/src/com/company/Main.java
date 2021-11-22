package com.company;

import java.util.Date;

class Biblioteka {
    Uzytkownik uzytkownik;
    Zamowienie zamowienie;

    Uzytkownik getUzytkownik() {
        return uzytkownik;
    };
    Zamowienie getZamowienie(){
        return zamowienie;
    }
    static class Wyszukiwarka extends Ksiazka {
        void getKsiazka(){
            getAutor();
            getTytul();
            getLiczbaSztuk();
        }
    }
}

class Ksiazka {
    String tytul;
    String autor;
    Integer liczbaSztuk;

    String getTytul(){
        return tytul;
    }
    String getAutor(){
        return autor;
    }
    Integer getLiczbaSztuk(){
        return liczbaSztuk;
    }
}

class Uzytkownik {
    String imie;
    String nazwisko;
    String nazwaUzytkownika;
    Integer rodzajKonta;

    String getImie() {
        return imie;
    }
    String getNazwisko() {
        return nazwisko;
    }
    String getNazwaUzytkownika(){
        return nazwaUzytkownika;
    }
    Integer getRodzajKonta(){
        return rodzajKonta;
    }
}


class Zamowienie extends Data{
    Date dataWypozyczenia;
    Uzytkownik Klient;
    Date dataZwrotu;

    Date getDataWypozyczenia(){
        return dataWypozyczenia;
    };
    Uzytkownik getKlient() {
        return Klient;
    };
    Date getDataZwrotu(){
        return dataZwrotu;
    };

}
class Oplata extends Zamowienie {
    double getOplata(){
        getAktualnaData();
        getDataZwrotu();
    };
}


class Konto extends Uzytkownik {
    String nazwaRodzajuKonta;

    String getNazwaRodzajuKonta(){
        return nazwaRodzajuKonta;
    }
}

class Data {
    Date aktualnaData;

    Date getAktualnaData(){
        return aktualnaData;
    };

    Integer porownajDaty(){
    };
}
