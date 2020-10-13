## src/main/java/map/Sanakirja.java

```java
package map;

import java.util.HashMap;
import java.util.Map;

public class Sanakirja {

    private Map<String, String> kaannokset = new HashMap<>();

    public void lisaa(String sana, String kaannos) {
        this.kaannokset.put(sana, kaannos);
    }

    public String kaanna(String sana) {
        return this.kaannokset.get(sana);
    }

}
```

## src/test/java/map/SanakirjaTest.java

```java
package map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SanakirjaTest {

    @Test
    public void testaaSanakirja() {
        Sanakirja sanakirja = new Sanakirja();
        sanakirja.lisaa("apina", "monkey");
        sanakirja.lisaa("banaani", "banana");
        sanakirja.lisaa("cembalo", "harpsichord");

        // apinalle pitää löytyä käännös:
        assertEquals("monkey", sanakirja.kaanna("apina"));

        // porkkanalle ei ole käännöstä:
        assertEquals(null, sanakirja.kaanna("porkkana"));
    }
}
```

## src/test/java/map/EtunimiTilastoTest.java

```java
package map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class EtunimiTilastoTest {

    @Test
    public void lueEtunimiPalauttaaRivinEnsimmaisenArvon() {
        String syote = "Agnetha;20;nainen";
        String oikeaNimi = "Agnetha";

        String metodinTulos = EtunimiTilasto.lueNimi(syote);

        assertEquals(oikeaNimi, metodinTulos);
    }

    @Test
    public void rivinToinenArvoOnNimienLukumaara() {
        String syote = "Agnetha;20;nainen";

        int lukumaara = EtunimiTilasto.lueLukumaara(syote);

        assertEquals(20, lukumaara);
    }

    @Test
    public void rivinLukumaaraVoiSisaltaaValilyonnin() {
        String syote = "Timo;45 647;mies";

        int lukumaara = EtunimiTilasto.lueLukumaara(syote);

        assertEquals(45647, lukumaara);
    }

    @Test
    public void kokoaTilastoPalauttaaEtunimiTilaston() {
        List<String> rivit = List.of("Pekka;33 630;mies", "Tuula;31 863;nainen", "Hannu;31 001;mies",
                "Anne;30 683;nainen");

        Map<String, Integer> tilasto = EtunimiTilasto.kokoaTilasto(rivit);
        Integer pekkaLukumaara = tilasto.get("Pekka");

        // yhdessä testimetodissa voidaan tehdä monta assertiota:
        assertEquals(33630, pekkaLukumaara);
        assertEquals(31863, tilasto.get("Tuula"));
    }

    @Test
    public void kokoaTilastoLaskeeNimienLukumaaratYhteen() {
        List<String> rivit = List.of("Tuisku;102;nainen", "Pekka;33 630;mies", "Tuisku;94;mies");

        Map<String, Integer> tilasto = EtunimiTilasto.kokoaTilasto(rivit);

        assertEquals(196, tilasto.get("Tuisku"));
    }

    @Test
    public void lueTilastoTiedostosta() {
        Map<String, Integer> tilasto = EtunimiTilasto.lueTilastoTiedostosta();

        assertEquals(31863, tilasto.get("Tuula"));
        assertEquals(196, tilasto.get("Tuisku"));
        assertEquals(null, tilasto.get("Wolverine"));
    }
}
```

## src/main/java/map/EtunimiTilasto.java

```java
package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EtunimiTilasto {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Map<String, Integer> tilasto = lueTilastoTiedostosta();

        System.out.print("Anna etunimi: ");
        String nimi = lukija.nextLine();

        int lkm = tilasto.getOrDefault(nimi, 0);
        System.out.println(nimi + ": " + lkm + " kappaletta.");
    }

    public static Map<String, Integer> lueTilastoTiedostosta() {
        // luetaan tiedosto:
        TiedostonLukija lukija = new TiedostonLukija("etunimet.csv");
        List<String> csvRivit = lukija.lueRivit();

        // muutetaan rivit mapiksi:
        return kokoaTilasto(csvRivit);
    }

    public static Map<String, Integer> kokoaTilasto(List<String> csvRivit) {
        Map<String, Integer> tilasto = new HashMap<>();

        // luetaan rivit ja lisätään nimet ja lukumäärät mappiin
        for (String rivi : csvRivit) {
            String nimi = lueNimi(rivi);
            int lukumaara = lueLukumaara(rivi);

            if (tilasto.containsKey(nimi)) {
                // kasvatetaan arvoa
                int edellinenLukumaara = tilasto.get(nimi);
                tilasto.put(nimi, edellinenLukumaara + lukumaara);
            } else {
                // asetetaan ensimmäinen arvo
                tilasto.put(nimi, lukumaara);
            }
        }

        return tilasto;
    }

    /**
     * @param csvRivi puolipistein eroteltu rivi, esim. "Agnetha;20;nainen"
     * @return rivin ensimmäinen arvo, esim "Agnetha"
     */
    public static String lueNimi(String csvRivi) {
        String[] osat = csvRivi.split(";");
        return osat[0];
    }

    /**
     * @param csvRivi puolipistein eroteltu rivi, esim. "Agnetha;20;nainen"
     * @return rivin toinen arvo muutettuna kokonaisluvuksi, esim. 20
     */
    public static int lueLukumaara(String csvRivi) {
        String[] osat = csvRivi.split(";");
        String numero = osat[1].replace(" ", "");
        return Integer.parseInt(numero);
    }
}
```

## src/main/java/map/Tekstikayttoliittyma.java

```java
package map;

import java.util.Scanner;

public class Tekstikayttoliittyma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Sanakirja sanakirja = new Sanakirja();

        System.out.println("Komennot:\r\n" + "  lisaa - lisää sanaparin sanakirjaan\r\n"
                + "  kaanna - kysyy sanan ja tulostaa sen käännöksen\r\n" + "  lopeta - poistuu käyttöliittymästä\r\n"
                + "");

        while (true) {
            System.out.print("Komento: ");
            String komento = lukija.nextLine();

            if (komento.equals("lopeta")) {
                System.out.println("Hei hei!");
                break;
            } else if (komento.equals("kaanna")) {
                System.out.print("Anna sana: ");
                String kaannettava = lukija.nextLine();
                String kaannetty = sanakirja.kaanna(kaannettava);
                System.out.println("Käännös: " + kaannetty);
            } else if (komento.equals("lisaa")) {
                System.out.print("Suomeksi: ");
                String suomeksi = lukija.nextLine();
                System.out.print("Käännös: ");
                String kaannos = lukija.nextLine();

                sanakirja.lisaa(suomeksi, kaannos);
            }
            System.out.println();
        }
    }

}
```