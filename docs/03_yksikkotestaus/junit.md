[⇦ takaisin kurssin etusivulle](../)

# Yksikkötestauksen perusteet ja koodin laatu 

Tähän mennessä olemme ohjelmointikursseilla testanneet kirjoittamiamme ohjelmia suorittamalla niitä, antamalla niille syötteitä ja tarkistamalla ohjelman tulosteita manuaalisesti. Tehtävien arvioinnissa on hyödynnetty Viope-järjestelmää, jossa testausmenetelmä on hyvin samankaltainen: ohjelma suoritetaan, sille annetaan syötteitä ja lopulta ohjelman tulosteet tarkistetaan.

Vaikka käyttämämme testaustapa auttaa sinua ratkaisemaan tehtävät, vähänkään isompien ohjelmistojen testaaminen tulosteiden manuaalisen läpikäynnin avulla olisi hyvin työlästä, jopa lähes mahdotonta. Jokaisen isomman muutoksen jälkeen ohjelma täytyisi myös testata uudelleen, jotta varmistutaan siitä, että muutos ei aiheuttanut virheitä jo toimineisiin osiin. Tämän vuoksi ohjelmistoja testataan usein ohjelmallisesti kirjoitettujen testien avulla.

Ohjelmistotestauksen käsitteistöön kuuluu oleellisena osana eri testausmenetelmät, joilla erityisesti automatisoitua testausta suoritetaan. Yleisesti käytettyyn jakoon kuuluvat **järjestelmätestaus**, **integraatiotestaus** ja **yksikkötestaus**. Lisäksi testauksessa voidaan keskittyä tiettyihin tarkempiin kohteisiin, kuten käytettävyyteen, tietoturvaan tai tehokkuuteen. Voit lukea näistä lisää esimerkiksi Vertics Oy:n blogikirjoituksesta ["Ohjelmistotestauksen perusteet"](https://vertics.co/ohjelmistotestauksen-perusteet/).

Tällä viikolla perehdymme tarkemmin yksikkötestaukseen ja Javan [JUnit-kirjastoon](https://junit.org/junit5/), joka on vakiintunut ratkaisu yksikkötestien toteuttamiseksi Javalla. JUnit integroituu moniin laadunvarmistusjärjestelmiin ja sovelluskehittimiin, minkä vuoksi samat testit voidaan suorittaa automatisoidusti niin kehittäjän omalla koneella kuin erillisessä testausympäristössä. Myös Eclipsessä on erittäin hyvät työkalut JUnit-testien kirjoittamiseksi ja suorittamiseksi. Lisäksi tutustumme koodin laatuun vaikuttaviin tekijöihin ja sovellamme niitä annetun valmiin koodin parantamiseksi.


## Yksikkötestaus

> *"Yksikkötestauksella tarkoitetaan **pienimmän mahdollisen ohjelman osan**, esimerkiksi aliohjelman, toiminnan testaamista. Yksikkötesteillä varmistetaan, että ohjelman pienimmät osat toimivat odotetulla tavalla, ja että mahdolliset virhetilanteet on niiden osalta ennakoitu."*
>
> *"Yksikkötestauksen hyödyt näkyvät kehitysprosessin aikana erityisesti silloin, kun jo kirjoitettuun koodiin joudutaan tekemään muutoksia. Automatisoiduilla yksikkötesteillä voidaan **nopeasti** todeta, aiheuttavatko tehdyt muutokset virheitä."*
>
> Jyväskylän Yliopisto, Informaatioteknologian tiedekunta. Testauksen tasot. http://smarteducation.jyu.fi/projektit/systech/Periaatteet/suunnittelun-periaatteet/testaus/testauksen-tasot

Mikäli olisimme kehittämässä esimerkiksi verkkokauppaa ja siihen liittyvää laskujen viitenumeroiden generointia, voisi viitenumeroiden generoinnin testaaminen käyttöliittymän kautta edellyttää meiltä esimerkiksi sisäänkirjautumista, tuotteiden lisäämistä ostoskoriin, toimitustavan valintaa ja lukuisia muita erillisiä työvaiheita ennen pääsyä varsinaiseen testattavaan osaan. Testaus käyttöliittymän kautta onkin monessa tapauksessa erittäin aikaavievää. Yksikkötestauksen avulla voimme testata viitenumeroiden generoinnin erillään kaikesta muusta koodista, omana yksikkönään.


## Oppimateriaalit

[PowerPoint-kalvot (PDF)](./yksikkotestaus.pdf)

### JUnit-teoriavideot

[**JUnit-testin luonti ja assertiot**](https://video.haaga-helia.fi/media/JUnit-testin+luonti+ja+assertiot/0_pl76xbuy) <small>9:21</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_pl76xbuy&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_bvt6dx1t" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

Testiluokan luominen ja suorittaminen sekä käsitteet **testiluokka**, **annotaatio**, **testimetodi** ja **assertio**.

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

Tällä videolla toteutetaan ja yksikkötestataan EtunimiTilasto-tehtävän tiedostojenkäsittelyä koskeva osuus. Videolla käsitellään aineistona [etunimet.csv-tiedostoa](https://gist.githubusercontent.com/swd1tn002/f6b4c367cba9eecce0c2a1ba9de6854a/raw/fecefc85b1915bfcaf9aaf2ede7bf7503c2bffb0/etunimet.csv). Valmis TiedostonLukija.java -apuluokka löytyy [täältä](https://gist.github.com/swd1tn002/5842d9bb5d4152799e11d0f7742ecc91).

*Aineiston lisenssi: [Digi- ja väestötietovirasto](https://www.avoindata.fi/data/fi/organization/digi_ja_vaestotietovirasto) on julkaissut tietoaineiston [Väestötietojärjestelmän suomalaisten nimiaineistot](https://www.avoindata.fi/data/fi/dataset/none) lisenssillä [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).*

&nbsp;

### Lisämateriaali

Lisäksi sinun kannattaa tutustua tämän viikon tehtävän alkuperäiseen lähteeseen, josta löydät tekstimateriaaleja sekä videoita tehtävään liittyen: [https://web.mit.edu/6.005/www/fa16/classes/04-code-review/](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/)


# Tehtävä

Tämän viikon tehtävänäsi on toteuttaa JUnit-yksikkötestit tälle heikosti toteutetulle esimerkkiluokalle:

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

Metodissa on oletettavasti bugeja, jotka tulee löytää omilla testeillä. Saatat lisäksi huomata luokan koodaustyylissä merkittäviä heikkouksia, joihin paneudutaan tehtävässä 3.


## Vaihe 1: kirjoita dayOfYear-metodille JUnit-yksikkötestit

Tallenna itsellesi kopio testattavasta luokasta omaan koodieditoriisi. Kirjoita uusi testiluokka `DayOfYearTest`, jossa hyödynnät opetusvideoilla esiteltyä JUnit-testikirjastoa testataksesi valmiin metodin toimivuuden osoittamiseksi vaadittavat testitapaukset.

**Kirjoittamasi testiluokan tulee osoittaa testattavan luokan virheellisyys**. Testiluokkasi saa sijaita projektissasi vapaasti valitsemassasi paketissa. Virheiden etsimiseksi sinun kannattaa testata ainakin erilaisia päivämääriä vuoden alussa, keskellä ja lopussa niin tavallisina- kuin karkausvuosina.


## Vaihe 2: korjaa dayOfYear-luokan bugi(t)

Korjattuasi `DayOfYear`-luokkaan löytämäsi bugit. Bugien korjaamisen jälkeen edellisessä vaiheessa kirjoittamasi testiluokan kaikkien testien tulee mennä hyväksytysti läpi.


## Vaihe 3: koodin refaktorointi hyvien käytäntöjen mukaiseksi

Tähän asti olet ohjelmointiopinnoissasi kenties keskittynyt lähinnä saamaan ohjelmasi toimimaan tehtävänannon mukaisesti kiinnittämättä suurempaa huomiota sen ymmärrettävyyteen tai jatkokehitettävyyteen. Voimme olettaa myös `dayOfYear`-metodin syntyneen näin. Ammatillisessa ohjelmistokehityksessä on harvinaista, että samaa koodia työstettäisiin vain kerran tai vain yhden kehittäjän toimesta. Päinvastoin, koodia kirjoitetaan isoissa tiimeissä, joissa kehittäjät vaihtuvat ja olemassa oleviin ominaisuuksiin tehdään jatkuvasti muutoksia. 

Tulet siis itse jatkokehittämään jonkun toisen vuosia sitten kirjoittamaa koodia, aivan kuten joku muu tulee jatkokehittämään sinun koodiasi. Tällöin on erittäin tärkeää, että koodi on muokattavissa ilman odottamattomia rikkoutumisia ja että muut kehittäjät ymmärtävät toistensa koodia ja pystyvät muokkaamaan sitä uusien vaatimusten mukaiseksi.

Kun luet `dayOfYear`-metodin sisältämää koodia tarkemmin, huomaat, että siinä on käytetty ohjelmoinnin perusrakenteita melko suppeasti. Koodi koostuukin erittäin pitkästä `if-else`-rakenteesta sekä samanlaisista kokonaislukujen yhteenlaskuista. Samat numerot myös esiintyvät koodissa toistuvasti ja saattavat olla virheellisiä.

Tämän viikon tehtävien viimeinen osa on refaktoroida koodi hyvien ohjelmointitapojen mukaiseksi. Refaktoroidun koodin tulee siis olla ymmärrettävämpää ja ylläpidettävämpää kuin alkuperäinen koodi, mutta toimia ulkoisesti samalla tavalla.


> *"Refaktorointi tarkoittaa prosessia, jossa tietokoneohjelman lähdekoodia muutetaan siten, että sen toiminnallisuus säilyy, mutta sen sisäinen rakenne muuttuu. Muutokset voivat koskea esimerkiksi luettavuutta tai ohjelmakomponenttien työnjaon selkeyttämistä."*
>
> Wikipedia. [Refaktorointi](https://fi.wikipedia.org/wiki/Refaktorointi). Viitattu 5.11.2020. [CC BY–SA 3.0](https://fi.wikipedia.org/wiki/Wikipedia:Creative_Commons_Attribution-Share_Alike_3.0_Unported_-lisenssiehdot)

Tutustu seuraaviin "koodin hajuihin" esimerkkikoodissa ja parantele koodia parhaasi mukaan:

- Don't Repeat Yourself
- Comments Where Needed
- Fail Fast
- Avoid Magic Numbers
- One Purpose For Each Variable

Edellä mainittu lista on käyty läpi tämän saman esimerkkikoodin avulla osoitteessa [https://web.mit.edu/6.005/www/fa16/classes/04-code-review/](https://web.mit.edu/6.005/www/fa16/classes/04-code-review/). Voit käyttää myös muita lähteitä. Tehtävässä on suositeltavaa lisätä koodiin tarpeen mukaan uusia tietorakenteita ja metodeja.

&nbsp;

**Huom!** Javan standardikirjastossa on olemassa useita valmiita toimivia toteutuksia päivän järjestysnumeron laskemiselle. Oikeassa ohjelmistoprojektissa sinun tulisi luonnollisesti käyttää tällaisessa tapauksessa valmista ratkaisua, eikä yrittää toteuttaa omaa versiotasi. Tämän harjoituksen tavoitteena on kuitenkin opetella testaamaan ja jäsentämään koodi uudella tavalla.

**Huom!** Javan `java.time`-paketista löytyvät `Month`-, `YearMonth` ja `Year`-luokat voivat olla refaktoroinnissa hyödyllisiä. `Year`-luokan `isLeap`-metodin avulla voit selvittää onko tietty vuosi karkausvuosi, ja `length()` sekä `lengthOfMonth()`-metodit auttavat kuukauden pituuden selvittämisessä ilman kovakoodattuja numeroita.

Linkit:

* [Year-luokka](https://docs.oracle.com/javase/8/docs/api/java/time/Year.html)
* [Month-luokka](https://docs.oracle.com/javase/8/docs/api/java/time/Month.html)
* [YearMonth-luokka](https://docs.oracle.com/javase/8/docs/api/java/time/YearMonth.html)

## Tehtävän palauttaminen

Palauta luokat `DayOfYear` ja `DayOfYearTest` Teamsissa olevaan palautuslaatikkoon erillisinä tiedostoina (ei pakattuna). Riittää että palautat tehtävien lopputuloksen. Eri vaiheiden tuloksia ei tarvitse palauttaa erikseen.


## Arviointi

Tehtävä arvioidaan asteikolla 0-5. Arvioinnissa suurin painoarvo on testien kirjoittamisella sekä bugien korjauksella (60 %). Koodin laadun parantamisella on pienempi painoarvo (40 %).

Täysiin pisteisiin tehtävässä riittää, että kirjoitat muutaman toimivan testimetodin, korjaat löytämäsi bugit ja parannat annettua koodia yhden laatuongelman osalta. Osittain valmiit ratkaisut pisteytetään suhteessa niiden valmiusasteeseen.
