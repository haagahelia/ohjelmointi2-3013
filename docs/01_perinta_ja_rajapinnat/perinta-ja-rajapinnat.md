[⇦ takaisin kurssin etusivulle](../)

# Perintä ja rajapinnat


## Perintä

> *"Perintä on väline käsitehierarkioiden rakentamiseen ja erikoistamiseen; aliluokka on aina yliluokan erikoistapaus. Jos luotava luokka on olemassaolevan luokan erikoistapaus, voidaan uusi luokka luoda perimällä olemassaoleva luokka. Esimerkiksi auton osiin liittyvässä esimerkissä moottori on osa, mutta moottoriin liittyy lisätoiminnallisuutta mitä jokaisella osalla ei ole."*
>
> https://ohjelmointi-20.mooc.fi/osa-9/1-perinta

### Video: [perintä](https://video.haaga-helia.fi/media/Olio-ohjelmointiA+toisen+luokan+periminen/0_7kvfzdro) <small>10:41</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_7kvfzdro&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_urm3ihed" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

&nbsp;

```java
public class Auto {

    private String valmistaja;
    private String rekisterinumero;

    public Auto(String valm, String rekkari) {
        this.valmistaja = valm;
        this.rekisterinumero = rekkari;
    }

    public String getValmistaja() {
        return valmistaja;
    }

    public String getRekisterinumero() {
        return rekisterinumero;
    }
}
```

```java
public class Taksi extends Auto {

    private String taksinumero;

    public Taksi(String valm, String rekkari, String numero) {
        super(valm, rekkari); // `super` kutsuu yliluokan konstruktoria!
        this.taksinumero = numero;
    }

    public String getTaksinumero() {
        return taksinumero;
    }
}
```

```java
Auto auto = new Auto("Opel", "ABC-123");
Taksi taksi = new Taksi("Skoda", "DEF-456", "H123");

String rek1 = auto.getRekisterinumero();

// Taksi-luokalla on myös getRekisterinumero-metodi!
String rek2 = taksi.getRekisterinumero();

// Tavallisen auton metodien lisäksi taksilla on oma getTaksinumero-metodi.
String taksinumero = taksi.getTaksinumero();
```

# Rajapinnat

> *"Rajapinnan (engl. interface) avulla määritellään luokalta vaadittu käyttäytyminen, eli sen metodit. Rajapinnat määritellään kuten normaalit Javan luokat, mutta luokan alussa olevan määrittelyn "public class ..." sijaan käytetään määrittelyä "public interface ...". Rajapinnat määrittelevät käyttäytymisen metodien niminä ja palautusarvoina, mutta ne eivät aina sisällä metodien konkreettista toteutusta. Näkyvyysmäärettä rajapintoihin ei erikseen merkitä, sillä se on aina public."*
>
> https://ohjelmointi-20.mooc.fi/osa-9/2-rajapinta


### [Rajapinnat](https://video.haaga-helia.fi/media/Rajapinnat/0_aojswqwn), 7:43

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_aojswqwn&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_jafkkkos" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

Tällä videolla verrataan rajapintoja abstrakteihin luokkiin, jotka eivät kuulu tämän kurssitoteutuksen sisältöön.

&nbsp;

```java
public interface Message {

    public String getRecipient();
    public String getContent();
}
```

```java
public class EMail implements Message {

    private String recipient, content;

    public EMail(String recipient, String content) {
        this.recipient = recipient;
        this.content = content;
    }

    @Override
    public String getRecipient() {
        return this.recipient;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
```

```java
Message email = new EMail("user@example.com", "This is an email!");
Message sms = new SMS("+35850555555", "This is an SMS!");

String emailOsoite = email.getRecipient();
String puhelinnumero = sms.getRecipient();
```

Myöhemmin tällä kurssilla tulemme käsittelemään ostoslistoja.

```java
package database;

import java.util.List;

import model.ShoppingListItem;

public interface ShoppingListItemDao {

    public List<ShoppingListItem> getAllItems();

    public ShoppingListItem getItem(long id);

    public boolean addItem(ShoppingListItem newItem);

    public boolean removeItem(ShoppingListItem item);
}
```

Tämä rajapinta määrittelee metodit, jotka sen toteuttavien luokkien on toteutettava samoilla parametriarvoilla  ja paluuarvoilla.


# Viope-tehtävä
Täydennä ohessa esitettyä `Country`-luokkaa siten, että luokka täyttää `Comparable<Country>`-rajapinnan. Maat tulee järjestää siten, että väkiluvultaan pienempi maa on järjestyksessä ennen väkiluvulta suurempaa maata.Palauta ratkaisusi Viopeen.

```java
public class Country implements Comparable<Country> {

    private final String name;
    private final int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return this.name + ", population: " + this.population;
    }

    // Toteuta compareTo-metodi tänne!
}
```

Tässä tehtävässä sinun ei tarvitse toteuttaa lainkaan käyttöliittymää omaan ohjelmaasi. Voit Testata ratkaisuasi erillisellä testiluokalla, jonka main-metodissa lisäät `Country`-olioita listalle ja järjestät listan. Yksi mahdollisuus järjestelylogiikan testaamiseksi olisi esim. seuraava `main`-metodi:

```java
public static void main(String[] args) {
    Country d = new Country("Denmark", 5_724_456);
    Country f = new Country("Finland", 5_498_211);
    Country i = new Country("Iceland", 335_878);
    Country n = new Country("Norway", 5_265_158);
    Country s = new Country("Sweden", 10_103_843);

    List<Country> countries = Arrays.asList(d, f, i, n, s);
    Collections.sort(countries);

    for (Country c : countries) {
        System.out.println(c);
    }
}
```

### Ohjelmalogiikan testaamisesta

Vaikka yllä oleva ratkaisu saattaa auttaa sinua ratkaisemaan tämän tehtävän, ohjelmistojen testaaminen `System.out.println`-metodin tulosteiden ja niiden manuaalisen läpikäynnin avulla on varsin työlästä. Vähänkään isomman ohjelman testeissä tulosteita olisi nopeasti satoja ellei tuhansia. Parempi tapa ohjelmistojen testaamiseen onkin ns. yksikkötestit, joihin perehdymme tämän kurssin seuraavassa aiheessa.