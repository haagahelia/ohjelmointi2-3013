[⇦ takaisin kurssin etusivulle](../)

# Yksikkötestauksen perusteet ja koodin laatu 

Tällä viikolla tutustumme yksikkötestaukseen ja testaamme valmista virheellisesti toimivaa ja tyylillisesti heikosti toteutettua metodia. Tutustumme lisäksi koodin laatuun vaikuttaviin tekijöihin ja sovellamme niitä annetun valmiin koodin parantamiseksi.


## Koodin laatu: luettavuus, ymmärrettävyys ja jatkokehitettävyys

Tähän asti olet ohjelmointiopinnoissasi kenties keskittynyt lähinnä saamaan ohjelmasi toimimaan tehtävänannon mukaisesti kiinnittämättä suurempaa huomiota sen ymmärrettävyyteen tai jatkokehitettävyyteen. Ammatillisessa ohjelmistokehityksessä on harvinaista, että koodia kirjoitettaisiin kerran ja vain yhden kehittäjän toimesta. Päinvastoin, koodia kirjoitetaan isoissa tiimeissä, joissa kehittäjät vaihtuvat ja olemassa oleviin ominaisuuksiin tehdään jatkuvasti muutoksia. 

Tulet itse jatkokehittämään jonkun toisen vuosia sitten kirjoittamaa koodia, aivan kuten joku muu tulee jatkokehittämään sinun koodiasi. Tällöin on erittäin tärkeää, että koodi on muokattavissa ilman odottamattomia rikkoutumisia ja että muut kehittäjät ymmärtävät toistensa koodia ja pystyvät muokkaamaan sitä uusien vaatimusten mukaiseksi.


## Oppimateriaalit

[PowerPoint-kalvot (PDF)](./yksikkotestaus.pdf)

### JUnit-teoriavideot

[**JUnit-testin luonti ja assertiot**](https://video.haaga-helia.fi/media/JUnit-testin+luonti+ja+assertiot/0_pl76xbuy) <small>9:21</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_pl76xbuy&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_bvt6dx1t" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

Testiluokan luominen, annotaatiot, testimetodit, assertiot ja testin suorittaminen.

&nbsp;

[**Luokan testaaminen JUnit-työkalulla**](https://video.haaga-helia.fi/media/Luokan+testaaminen+JUnit-ty%C3%B6kalulla/0_1gkcscbe) <small>7:10</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_1gkcscbe&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_6si1l0my" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

Luokan metodien testaaminen erillisen testiluokan ja JUnit-kirjaston avulla.

&nbsp;

[**Testin alustaminen ja @BeforeEach**](https://video.haaga-helia.fi/media/Testin+alustaminen+ja+%40BeforeEach/0_poklvdms) <small>3:54</small>

<iframe id="kaltura_player" src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_poklvdms&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_reca7zwj" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

Useille testimetodeille yhteisten alustustoimenpiteiden tekeminen erillisessä alustusmetodissa.

&nbsp;

<!-- palindromi-video: https://video.haaga-helia.fi/media/t/0_m8y5zv8k -->


## Testaaminen käytännössä:

"Oikean ohjelman" testaamisessa haastetta tuo usein ohjelman rakenne, joka voi tehdä siitä vaikeasti testattavan. Seuraavilla videoesimerkeillä esitellään Map-aiheen yhteydessä luodun EtunimiTilasto-sovelluksen testausta yksikkötestien avulla ja muodostetaan ohjelman rakenne siten, että sen osat ovat testattavissa, laajennettavissa ja uudelleenkäytettävissä. 

Videoilla käsitellyt lähdekoodit löytyvät [täältä](./yksikkotestaus_lahdekoodit):

* [📝 `Sanakirja.java`](./yksikkotestaus_lahdekoodit)
* [📝 `SanakirjaTest.java`](./yksikkotestaus_lahdekoodit)
* [📝 `EtunimiTilastoTest.java`](./yksikkotestaus_lahdekoodit)
* [📝 `EtunimiTilasto.java`](./yksikkotestaus_lahdekoodit)
* [📝 `Tekstikayttoliittyma.java`](./yksikkotestaus_lahdekoodit)


**[EtunimiTilasto-tehtävän yksikkötestaus, osa 1/3](https://web.microsoftstream.com/video/80c680e7-a853-4962-a9fb-19e7ef1f8d0b)** <small>19:06</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/80c680e7-a853-4962-a9fb-19e7ef1f8d0b?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla sovelletaan yksikkötestausta käytännössä Map-tehtävistä tutun EtunimiTilasto-tehtävän kanssa. Videolla huomataan, että yksikkötestaus voi olla haastavaa, mikäli ohjelman rakenne ei mahdollista sen osien käsittelyä toisistaan irrallisina. Videolla pilkotaan ohjelma testattaviin paloihin, joille kirjoitetaan testejä.

&nbsp;

**[EtunimiTilasto-tehtävän yksikkötestaus, osa 2/3](https://web.microsoftstream.com/video/144d7504-7f0f-465d-a473-130e9fd3a2b8)** <small>17:56</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/144d7504-7f0f-465d-a473-130e9fd3a2b8?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla toteutetaan logiikka CSV-rivien muuttamiseksi `HashMap`-tietorakenteeksi siten, että logiikka on yksikkötesttavissa.

&nbsp;

**[EtunimiTilasto-tehtävän tiedostonkäsittely, osa 3/3](https://web.microsoftstream.com/video/2180450b-4663-430d-9cb4-a5aa89db17f3)** <small>12:26</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/2180450b-4663-430d-9cb4-a5aa89db17f3?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla toteutetaan ja yksikkötestataan EtunimiTilasto-tehtävän tiedostojenkäsittelyä koskeva osuus.

&nbsp;

### Lisämateriaali:

Lisäksi sinun kannattaa tutustua tämän viikon tehtävän alkuperäiseen lähteeseen, josta löydät tekstimateriaaleja sekä videoita tehtävään liittyen: [https://web.mit.edu/6.005/www/fa16/classes/04-code-review/](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/)


# Tehtävä

Tämän viikon tehtävänäsi on toteuttaa JUnit-testitapaukset tälle esimerkkiluokalle:

```java
/**
 * Smelly Example #1
 * 
 * https://web.mit.edu/6.005/www/fa16/classes/04-code-review/
 * 
 * Collaboratively authored with contributions from: Saman Amarasinghe, Adam
 * Chlipala, Srini Devadas, Michael Ernst, Max Goldman, John Guttag, Daniel
 * Jackson, Rob Miller, Martin Rinard, and Armando Solar-Lezama.
 * 
 * This work is licensed under CC BY-SA 4.0.
 */
public class DayOfYear {

    public static int dayOfYear(int month, int dayOfMonth, int year) {
        if (month == 2) {
            dayOfMonth += 31;
        } else if (month == 3) {
            dayOfMonth += 59;
        } else if (month == 4) {
            dayOfMonth += 90;
        } else if (month == 5) {
            dayOfMonth += 31 + 28 + 31 + 30;
        } else if (month == 6) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31;
        } else if (month == 7) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30;
        } else if (month == 8) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31;
        } else if (month == 9) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        } else if (month == 10) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
        } else if (month == 11) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
        } else if (month == 12) {
            dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 31;
        }

        return dayOfMonth;
    }
}
```

Yksinkertaisuudessaan `dayOfYear`-metodi saa parametreinaan päivämäärän kolmena kokonaislukuna, ja palauttaa annetun päivämäärän järjestysnumeron kyseisenä vuonna (1-366).


## Vaihe 1: kirjoita dayOfYear-metodille JUnit-yksikkötestit

Tallenna itsellesi kopio testattavasta luokasta omaan koodieditoriisi. Kirjoita uusi testiluokka `DayOfYearTest`, jossa hyödynnät opetusvideoilla esiteltyä JUnit-testikirjastoa testataksesi valmiin metodin toimivuuden osoittamiseksi vaadittavat testitapaukset.

**Kirjoittamasi testiluokan tulee osoittaa testattavan luokan virheellisyys**. Testiluokkasi saa sijaita projektissasi vapaasti valitsemassasi paketissa.

Virheiden etsimiseksi sinun kannattaa testata ainakin erilaisia päivämääriä vuoden alussa ja lopussa niin tavallisina- kuin karkausvuosina.


## Vaihe 2: korjaa dayOfYear-luokan bugi(t)

Korjattuasi löytämäsi bugit, edellisessä vaiheessa kirjoittamasi testiluokan kaikkien testien tulee mennä hyväksytysti läpi.


## Vaihe 3: Muokkaa koodi hyvien ohjelmointikäytäntöjen mukaiseksi

Kun luet koodia tarkemmin, huomaat, että `dayOfYear`-metodissa on käytetty ohjelmoinnin perusrakenteita melko suppeasti. Koodi koostuukin erittäin pitkästä `if-else`-rakenteesta sekä samanlaisista kokonaislukujen yhteenlaskuista. Samat numerot myös esiintyvät koodissa toistuvasti ja saattavat olla virheellisiä.

Tehtäväsi tässä vaiheessa on refaktoroida koodi hyvien ohjelmointitapojen mukaiseksi. Refaktoroidun koodin tulee siis olla ymmärrettävämpää ja ylläpidettävämpää kuin alkuperäinen koodi, mutta toimia ulkoisesti samalla tavalla.

Tutustu seuraaviin "koodin hajuihin" esimerkkikoodissa ja parantele koodia parhaasi mukaan:

- Don't Repeat Yourself
- Comments Where Needed
- Fail Fast
- Avoid Magic Numbers
- One Purpose For Each Variable

Edellä mainittu lista on käyty tämän esimerkkikoodin yhteydessä läpi osoitteessa [https://web.mit.edu/6.005/www/fa16/classes/04-code-review/](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/). Voit käyttää myös muita lähteitä.

**Huom!** Javan standardikirjastossa on olemassa useita valmiita toimivia toteutuksia päivän järjestysnumeron laskemiselle. Oikeassa ohjelmistoprojektissa sinun tulisi ehdottomasti käyttää tällaisessa tapauksessa valmista ratkaisua, eikä yrittää toteuttaa omaa versiotasi. Tämän harjoituksen tavoitteena on kuitenkin opetella testaamaan ja jäsentämään koodi uudella tavalla.

**Huom!** Javan `java.time`-paketista löytyvät `Month`-, `YearMonth` ja `Year`-luokat voivat olla refaktoroinnissa  erittäin hyödyllisiä. `Year`-luokan `isLeap`-metodin avulla voit selvittää onko tietty vuosi karkausvuosi, ja `length()` sekä `lengthOfMonth()`-metodit auttavat kuukauden pituuden selvittämisessä ilman kovakoodattuja numeroita.

Linkit:

* [https://docs.oracle.com/javase/8/docs/api/java/time/Year.html](https://docs.oracle.com/javase/8/docs/api/java/time/Year.html)
* [https://docs.oracle.com/javase/8/docs/api/java/time/Month.html](https://docs.oracle.com/javase/8/docs/api/java/time/Month.html)
* [https://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html](https://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html)

## Tehtävän palauttaminen

Palauta luokat `DayOfYear` ja `DayOfYearTest` Teamsissa olevaan palautuslaatikkoon erillisinä tiedostoina (ei pakattuna). Riittää että palautat tehtävien lopputuloksen, eri vaiheiden tuloksia ei tarvitse palauttaa erikseen.

## Arviointi

Tehtävä arvioidaan asteikolla 0-5. Arvioinnissa suurin painoarvo on testien kirjoittamisella sekä bugien korjauksella (60 %). Koodin laadun parantamisella on pienempi painoarvo (40 %).

Täysiin pisteisiin tehtävässä riittää, että kirjoitat muutaman toimivan testimetodin, korjaat löytämäsi bugit ja parannat annettua koodia yhden laatuongelman osalta.
