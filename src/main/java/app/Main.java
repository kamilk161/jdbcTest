package app;

import domain.Klasa;
import domain.Uczen;
import service.KlasaService;
import service.UczenService;

import java.sql.Date;


/**
 * Created by kamil on 25.10.14.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        KlasaService klasaService = new KlasaService();
        UczenService uczenService = new UczenService();
        Uczen uczen = new Uczen("Kamil", "Kowalski", Date.valueOf("1995-09-13"));
        Klasa klasa = new Klasa(5, 'a');
        System.out.println(klasa);
        klasaService.zapisz(klasa);
        System.out.println(klasa);
        uczen.setKlasa(klasa);
        uczenService.zapisz(uczen);
        for(Uczen u : uczenService.pobierzWszystkich()) {
            System.out.println(u);
        }
        uczen.setImie("Marek");
        uczenService.zapisz(uczen);
        for(Klasa k : klasaService.pobierzWszystkie()) {
            System.out.println(k.getUczniowie());
        }
        uczenService.usun(uczen);
        klasaService.usun(klasa);
        klasaService.close();
        uczenService.close();
    }
}
