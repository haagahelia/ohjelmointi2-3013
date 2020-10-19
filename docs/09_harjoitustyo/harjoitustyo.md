[⇦ takaisin kurssin etusivulle](../)

# Harjoitustyö

Kurssin viimeisillä viikoilla vahvistatte aikaisempina viikkoina opittuja taitoja toteuttaessanne yksilötyönä oman tietokantapohjaisen web-sovelluksen. Harjoitustyö arvioidaan asteikolla 0-5 sen painoarvo on 50 % kurssin loppuarvosanasta. 

Vaikka harjoitustyö tehdään itsenäisesti, saatte keskustella siitä esimerkiksi Teamsissa kuten aikaisemmilla tehtäväkierroksilla. Kriteerinä on, että *jokainen kirjoittaa itse oman koodinsa*.


## Videot


**[Harjoitustyön tehtävänanto ja referenssitoteutus](https://web.microsoftstream.com/video/d2c07537-4300-493a-957b-61b5153b4a16)** 31:12

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/d2c07537-4300-493a-957b-61b5153b4a16?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

&nbsp;



**[Harjoitustyön pohja ja Chinook-tietokanta](https://web.microsoftstream.com/video/d24cfa32-754d-44da-b74f-52d768f8a4d7)** 52:18

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/d24cfa32-754d-44da-b74f-52d768f8a4d7?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

&nbsp;




## Harjoitustyön opppimistavoitteet

Harjoitustyön tarkoituksena on oppia ja syventää osaamista seuraavissa aiheissa:

1. HTTP-pyyntöjen käsittely Javalla (Servletit)
    * *käyttäjältä saadun datan käsittely (HTTP parametrit, lomakkeet)*
    * *datan välittäminen servletiltä käyttöliittymälle*
1. Tietokantojen käyttö Javassa (JDBC)
    * *tietokantakerroksen eriyttäminen muusta logiikasta (DAO, data access object)*
    * *kyselyiden kokoaminen turvallisesti (prepared statements)*
1. Dynaamisten HTML-sivujen toteutus JSP:llä (JavaServer Pages)
    * *sivujen muodostaminen dynaamisesti JSP-teknologialla*
    * *datan käsittely JSP-sivuilla JSTL-kirjaston avulla (JavaServer Pages Standard Tag Library)*

Lisäksi voit hyödyntää seuraavia kurssilla esiintyneitä menetelmiä ja teknologioita:

* versionhallinta (Git)
* yksikkötestaus (JUnit)
* Ajax-pyynnöt, JSON ja JavaScript


## Harjoitustyön aihe ja rajaus

Harjoitustyön aiheena on tietokantapohjainen verkkosivusto artistien ja albumien selaamiseksi ja hallinnoimiseksi. Halutessasi voit soveltaa tehtävänanota toteuttaaksesi teknisesti samankaltaisen palvelun itse valitsemastasi aiheesta. Vahvista tällöin aiheesi soveltuvuus lähettämällä viesti opettajalle Teamsissa tai sähköpostitse.

Harjoitustyön teknisen toteutuksen tavoitteet ovat seuraavat:

* palvelu hyödyntää SQL-tietokantaa
* tietokantaoperaatiot toteutetaan Javalla hyödyntäen JDBC-teknologiaa
* palvelun HTTP-pyyntöjen käsittely toteutetaan servletteillä
* palvelun käyttöliittymäkerros toteutetaan JSP-sivuina JSTL-kirjaston avulla.

Jotta harjoitustyö ei olisi tarpeettoman laaja ja jotta se vastaisi kurssin oppimistavoitteita, siinä minimoidaan ja rajataan seuraavia ominaisuuksia:

* ei tyylien koodausta (CSS)
* mahdollisimman yksinkertaiset HTML-rakenteet
* vain yksinkertaista SQL:ää.

Voit halutessasi tehdä hienot sivut ja tyylitellä ne, mutta **kurssin oppimistavoitteissa ja tehtävän arvioinnissa tyyleillä ei ole painoarvoa**. Saat palveluusi yksinkertaiset tyylit helposti käyttämällä [jotain näistä valmiista CSS-kirjastoista, jotka eivät edellytä lainkaan attribuuttien lisäämistä HTML-koodiisi](https://github.com/dbohdan/classless-css).


## Valmis musiikkitietokanta

Käytämme harjoitustyössä valmista musiikkitietokantaa nimeltä [Chinook](https://github.com/lerocha/chinook-database):

> "Chinook is a sample database available for SQL Server, Oracle, MySQL, etc."
> 
> "The Chinook data model represents a digital media store, including tables for artists, albums, media tracks, invoices and customers."
> 
> https://github.com/lerocha/chinook-database 

Lataa itsellesi valmis tietokanta [SQLite-muodossa tästä](https://github.com/lerocha/chinook-database/raw/master/ChinookDatabase/DataSources/Chinook_Sqlite.sqlite). 

Chinook-tietokanta sisältää lukuisia tauluja ja paljon valmista dataa, mutta **tässä harjoitustyössä tauluista ainoastaan `Artist`-taulu on luonteeltaan pakollinen**. Taulut `Album` ja `Track` tulevat tarpeellisiksi tähdätessäsi korkeampiin arvosanoihin. Kaikki muut taulut voit jättää harjoitustyössäsi huomioimatta.

### Tietokannan muut aineistot

* UML-kaavio [(Chinook-tietokannan Wiki)](https://github.com/lerocha/chinook-database/wiki/Chinook-Schema)
* Valmis tietokanta: [Chinook_Sqlite.sqlite](https://github.com/lerocha/chinook-database/raw/master/ChinookDatabase/DataSources/Chinook_Sqlite.sqlite)
* Dokumentaatio: https://github.com/lerocha/chinook-database
* SQL-luontikäskyt: [Chinook_Sqlite.sql](https://raw.githubusercontent.com/lerocha/chinook-database/master/ChinookDatabase/DataSources/Chinook_Sqlite.sql)
* [Tietokannan lisenssi (MIT)](https://github.com/lerocha/chinook-database/blob/master/LICENSE.md)
* SQLite tools -Video

    Chinook-tietokantaa käytettiin tällä kurssilla aikaisemmin linkitetyssä [SQLite tools -videossa](https://video.haaga-helia.fi/media/SQLite+tools/0_pez4r54j). Tästä videosta voi olla sinulle hyötyä myös tämän tehtävän tekemisessä. 
* [SQLite tools -komentorivityökalut](https://sqlite.org/download.html)

    Tietokannan käyttäminen komentoriviltä ei ole välttämättä tarpeellista harjoitustyön tekemiseksi, mutta voit halutessasi ladata SQLite tools -ohjelman Windows-, Linux- tai macOS -version yllä olevasta linkistä.

### Esimerkkikyselyjä

Harjoitustyössäsi saatat tarvita esimerkiksi seuraavia kyselyjä:

```sql
-- kaikkien artistien hakeminen aakkosjärjestyksessä:
SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;

-- yksittäisen artistin kaikkien albumien hakeminen:
SELECT AlbumId, Title FROM Album WHERE ArtistId = ?;

-- yksittäisen albumin kaikkien kappaleiden hakeminen (bonus):
SELECT TrackId, Name FROM Track WHERE AlbumId = ?;

-- artistin lisääminen:
INSERT INTO Artist (Name) VALUES (?);

-- albumin lisääminen tietylle artistille (bonus):
INSERT INTO Album (Title, ArtistId) VALUES (?, ?);

-- kaikkien artistien hakeminen yhdistettynä tietoon albumien määrästä (bonus):
SELECT Artist.ArtistId, Name, COUNT(AlbumId) AS AlbumCount 
    FROM Artist 
    LEFT JOIN Album ON Album.ArtistId = Artist.ArtistId 
    GROUP BY Artist.ArtistId 
    ORDER BY Name ASC;
```


## Harjoitustyön toiminnalliset vaatimukset

Harjoitustyön arviointi perustuu sekä toteutettuihin toiminnallisuuksiin että saavutettuun laatuun. Voit toteuttaa palveluun alla esitettyjen ominaisuuksien lisäksi vapaavalintaisia lisäominaisuuksia, jotka huomioidaan tapauskohtaisesti myös arvioinnissa.

### Tavoitearvosana 1

Toteutat verkkosovelluksen, jossa on etusivu, jolla näytetään lista tietokannassa olevien artistien nimistä. Tietokantalogiikka on eritetynä DAO-luokkaan ja HTML-koodi on toteutettuna JSP-sivun avulla. Koodin laatu noudattaa kurssilla käsiteltyjä hyviä käytäntöjä välttävästi.

**Huom!** Hyväksyttyyn arvosanaan riittää siis, että ymmärrät ja saat toistettua harjoitustyötunnilla esitetyt esimerkit.


### Tavoitearvosana 3

Kuten edellä, eli toteutat etusivun, jolla näytetään tietokannassa olevien artistien nimet. Lisäksi toteutat lomakkeen ja `doPost`-metodin artistien lisäämiseksi tietokantaan. Lomake artistin lisäämiseksi voidaan toteuttaa samalle sivulle kuin lista artisteista tai omalle sivulleen. Lisätyn artistin tulee tulla näkyville artistilistaan.

Sovelluksen tulee hyödyntää kurssin sisällön mukaisesti DAO-mallia, hyviä koodauskäytäntöjä, JSP-sivuja sekä JSTL-kirjastoa.


### Tavoitearvosana 4

Toteutat edellisten ominaisuuksien lisäksi sivun, joka näyttää yksittäisen valitun artistin kaikki albumit. Etusivulla listattujen artistien nimien tulee toimia linkkeinä tälle uudelle sivulle. Tarvitset sivua varten uuden servletin, jolle välitetään artistin id parametrina, esimerkiksi näin: `http://localhost:8080/albums?ArtistId=50`.

Albumeita varten tarvitset tietokannan valmista `Album`-taulua sekä uutta `Album`-luokkaa. Tietokantakyselyn voit toteuttaa esimerkiksi seuraavasti:

```sql
SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?;
```

Artistin id voidään välittää etusivulta seuraavalle sivulle esimerkiksi `GET`-parametrina seuraavasti:

```html
<a href="/albums?ArtistId=50">Metallica</a>
```

Toteutuksessa tietokantaoperaatiot suositellaan jaettavaksi kahteen erilliseen DAO-luokkaan:

* **ArtistDao**

    `Artist`-tauluun liittyvät operaatiot 

* **AlbumDao**

    `Album`-tauluun liittyvät operaatiot

Lisäksi tietokantayhteyden muodostaminen ja yhteyksien sulkeminen suositellaan tehtävän omassa luokassaan.

### Tavoitearvosana 5

Toteutat edellisten ominaisuuksien lisäksi ominaisuuden, jolla käyttäjä pystyy hakemaan artisteja ja albumeita niiden nimien perusteella. Hakutulokset tulee esittää JSP-sivulla, jolla artistit ja albumit toimivat linkkeinä artistin sivulle.

Esimerkkikyselyitä hakujen tekemiseksi:

```sql
-- artistien hakeminen osittaisen nimen perusteella:
SELECT ArtistId, Name FROM Artist 
    WHERE Name LIKE ? 
    ORDER BY Name ASC;

-- albumien ja niiden artistien hakeminen osittaisen title:n perusteella:
SELECT AlbumId, Album.ArtistId, Album.Title, Artist.Name FROM Album 
    LEFT JOIN Artist ON Artist.ArtistId = Album.ArtistId 
    WHERE Title LIKE ? ORDER BY Title ASC;
```

**Huom!** Muista lisätä `LIKE`-kyselyyn hakusanan alkuun ja loppuun prosenttimerkit, jotta löydät myös osittaiset osumat: 

```java
ps.setString(1, "%" + searchTerm + "%");
```


### Versionhallinta, yksikkötestaus ja Ajax

Versionhallinnan, yksikkötestauksen ja Ajax-kutsujen soveltaminen katsotaan eduksi, mutta ne eivät ole ehdottomina vaatimuksina millekään tavoitearvosanalle.


## Harjoitustyön laatuvaatimukset

Vaikka edellä esitetyt tavoitearvosanat liittyvät palvelun toiminnallisuuteen, harjoitystyön arvioinnissa huomioidaan myös toteutuksen laatu. Laadukas ja toimiva toteutus katsotaan arvosanaa nostavaksi, kun taas laatuongelmat heikentävät arvosanaa.

Palvelun tulee selvitä normaaleista käyttötapauksista ilman poikkeuksia. Normaalit käyttötapaukset tarkoittavat mm. linkkien klikkaamista ja lomakkeiden lähettämistä **millä tahansa syötteillä**. Normaaliin käyttöön ei lasketa sitä, jos käyttäjä syöttää esimerkiksi suoraan selaimen osoiteriville virheellisen id:n.

Suorituskyvyllä tai tietokantakyselyiden optimoinnilla ei ole painoarvoa. Käyttöliittymän visuaalisuutta ei arvioida, kunhan tarvittavat elementit löytyvät (tekstit, linkit, lomakkeet).


## Tietoturva

**Palveluun ei toteuteta kirjautumista tai käyttäjienhallintaa**. Mahdolliset datan lisäykset, muuttamiset ja poistot eivät edellytä käyttäjän tunnistamista. Palvelun tulee kuitenkin olla teknisesti turvallinen, eli ei altis esim. SQL- tai XSS-injektioille (muista `PreparedStatement` ja `c:out`).


## Harjoitustyön referenssitoteutus

Harjoitustyöstä on tehty referenssitoteutus nimeltä "Music catalog". Referenssitoteutus on **laajuudeltaan suurempi, kuin mitä edellytetään tällä kurssilla**. Emme ole käsitelleet mm. istuntoja, joita tarvittaisiin käyttäjäkohtaisen hakuhistorian tai suosikkilistan toteuttamiseksi.

Voit katsoa harjoitustyön referenssitoteutuksen esittelyn tästä videosta: 

[![https://video.haaga-helia.fi/media/t/0_x0ojb3pq](https://api.kaltura.nordu.net/p/288/sp/28800/thumbnail/entry_id/0_x0ojb3pq/version/100022/width/435/height/260)](https://video.haaga-helia.fi/media/t/0_x0ojb3pq)

https://video.haaga-helia.fi/media/t/0_x0ojb3pq


## Harjoitustyön palauttaminen (viim. su 24.5. klo 22)

Harjoitustyön lähdekoodit palautetaan kokonaisuudessaan Teamsiin zip-pakettina. 

Lähdekoodin lisäksi palauta erillisenä tiedostona kuvaus toteuttamasi web-sovelluksen ominaisuuksista ja niiden jakautumisesta eri luokkiin.

Jos käytit harjoitustyössäsi versionhallintaa (Git), aja projektisi juurihakemistossa komento:

    git log --oneline --decorate > git-log.txt

Edellä mainittu komento luo projektiisi tiedoston `git-log.txt`, joka sisältää listan tehdyistä commiteista. Jos käytit jotain graafista Git-työkalua, voit `git-log.txt`:n sijasta liittää projektiisi kuvankaappauksen työkalusi näkymästä. Jos koodisi on GitHubissa tai vastaavassa versionhallintapalvelussa, lisää myös tieto tästä `git-log.txt`-tiedostoosi.

Gitin käyttö huomioidaan positiivisesti harjoitustyön arvostelussa, mutta se ei ole vaatimuksena erinomaiseen arvosanaan. **Varmista myös seuraavassa vaiheessa, että myös luotu tiedosto git-log.txt tulee mukaan tekemääsi zip-pakettiin.**


**Projektin lähettäminen Teamsiin**

[Tee projektistasi zip-tiedosto](https://stackoverflow.com/a/5386448) valitsemalla Eclipsessä harjoitustyöprojektin nimen päällä *Export – Export.. – General – Archive file*. Tallenna tiedosto .zip-muotossa säilyttäen hakemistorakenne. Varmista, että zip-paketti sisältää kaikki ratkaisusi *.java*- ja *.jsp*-tiedosto ja palauta zip-paketti Teamsin palautuskansioon.


---

Chinook-tietokannan on luonut [Luis Rocha](https://github.com/lerocha) ja se on lisensoitu avoimena lähdekoodina [MIT-lisenssillä](https://github.com/lerocha/chinook-database/blob/master/LICENSE.md).
