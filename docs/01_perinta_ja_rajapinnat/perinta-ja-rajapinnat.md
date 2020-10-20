[⇦ takaisin kurssin etusivulle](../)

# Perintä ja rajapinnat

Perintä ja rajapinnat ovat olio-ohjelmoinnin ratkaisuja koodin uudelleenkäytettävyyden ja yhteensopivuuden edistämiseksi.

Jos esimerkiksi netin kauppapaikalla on myynnissä monenlaisia tuotteita esineistä asuntoihin ja ajoneuvoihin, voidaan kaikille tuotteille yhteiset ominaisuudet toteuttaa yhteen luokkaan, jota voidaan laajentaa tapauskohtaisten aliluokkien avulla. Näin vältetään toteuttamasta samoja yhteisiä ominaisuuksia moneen luokkaan. Samalla koodin yhteensopivuus paranee, kun aliluokkien oliot ovat yhteensopivia yliluokan olioiden kanssa. Perinnän avulla sekä autoja, asuntoja että muita tuotteita voidaan tarvittaessa käsitellä esimerkiksi samalla listalla.

Perintää käytetään usein tilanteissa, joissa on olemassa jo jokin toteutus, jota halutaan laajentaa erityistapauksen avulla. Rajapintoja puolestaan käytetään usein tilanteissa, joissa selvää yhteistä toteutusta ei ole. Toisin kuin luokat, rajapinnat ovat abstrakteja, eli niistä ei voida luoda olioita. Rajapintojen avulla voidaan kuitenkin määritellä yksi tai useampia metodeja, jotka rajapinnan täyttävien luokkien on toteutettava.

## Perintä

> *"Perintä on väline käsitehierarkioiden rakentamiseen ja erikoistamiseen; aliluokka on aina yliluokan erikoistapaus. Jos luotava luokka on olemassaolevan luokan erikoistapaus, voidaan uusi luokka luoda perimällä olemassaoleva luokka. Esimerkiksi auton osiin liittyvässä esimerkissä moottori on osa, mutta moottoriin liittyy lisätoiminnallisuutta mitä jokaisella osalla ei ole."*
>
> [https://ohjelmointi-20.mooc.fi/osa-9/1-perinta](https://ohjelmointi-20.mooc.fi/osa-9/1-perinta)

### Video: [perintä](https://video.haaga-helia.fi/media/Olio-ohjelmointiA+toisen+luokan+periminen/0_7kvfzdro) <small>10:41</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_7kvfzdro&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_urm3ihed" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

[PowerPoint-kalvot](./perinta-ja-rajapinnat.pdf)

&nbsp;


# Rajapinnat

> *"Rajapinnan (engl. interface) avulla määritellään luokalta vaadittu käyttäytyminen, eli sen metodit. Rajapinnat määritellään kuten normaalit Javan luokat, mutta luokan alussa olevan määrittelyn "public class ..." sijaan käytetään määrittelyä "public interface ...". Rajapinnat määrittelevät käyttäytymisen metodien niminä ja palautusarvoina, mutta ne eivät aina sisällä metodien konkreettista toteutusta. Näkyvyysmäärettä rajapintoihin ei erikseen merkitä, sillä se on aina public."*
>
> [https://ohjelmointi-20.mooc.fi/osa-9/2-rajapinta](https://ohjelmointi-20.mooc.fi/osa-9/2-rajapinta)


### [Rajapinnat](https://video.haaga-helia.fi/media/Rajapinnat/0_aojswqwn), 7:43

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_aojswqwn&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_jafkkkos" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

[PowerPoint-kalvot](./perinta-ja-rajapinnat.pdf)

Yllä olevalla videolla mainitaan rajapintojen lisäksi abstraktit luokat, jotka eivät kuulu tämän kurssitoteutuksen sisältöön.


## Viope-tehtävä

Täydennä ohessa esitettyä `Country`-luokkaa siten, että luokka täyttää `Comparable<Country>`-rajapinnan:

```java
public interface Comparable<T> {
    /**
     * https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
     *
     * @return a negative integer, zero, or a positive integer as 
     *         this object is less than, equal to, or greater than 
     *         the specified object.
     */
    public int compareTo(T other);
}
```

Maat tulee järjestää siten, että väkiluvultaan pienempi maa on järjestyksessä ennen väkiluvulta suurempaa maata. Hyvä lähde Comparator-rajapinnan logiikan hahmottamiseksi on esimerkiksi [https://www.baeldung.com/java-comparator-comparable](https://www.baeldung.com/java-comparator-comparable).

Voit käyttää tehtävässä pohjana seuraavaa Country-luokkaa:

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

Palauta lopuksi Country-luokkasi Viopeen.


### Ohjelmalogiikan testaamisesta

Vaikka yllä oleva ratkaisu saattaa auttaa sinua ratkaisemaan tämän tehtävän, ohjelmistojen testaaminen `System.out.println`-metodin tulosteiden ja niiden manuaalisen läpikäynnin avulla on varsin työlästä. Vähänkään isomman ohjelman testeissä tulosteita olisi nopeasti satoja ellei tuhansia. Parempi tapa ohjelmistojen testaamiseen onkin ns. yksikkötestit, joihin perehdymme tämän kurssin seuraavassa aiheessa.