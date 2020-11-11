[⇦ takaisin kurssin etusivulle](../)

# Tietokantaohjelmointi

Tällä viikolla opettelemme ensin muodostamaan yhteyden tietokantaan Java-ohjelmasta käsin ja tekemään yksinkertaisia CRUD-toimenpiteitä (Create, Read, Update & Delete). Tutustumme mm. käsitteisiin JDBC ja PreparedStatement.

**Huom!** Materiaalissa olevien videoiden katsomiseksi sinun täytyy kirjautua sisään Microsoft Stream -palveluun Haaga-Helian käyttäjätunnuksellasi.


## JDBC – Java Database Connectivity

Javan standardikirjastoon määritelty JDBC (Java Database Connectivity) -ohjelmointirajapinta mahdollistaa Java-sovellusten yhdistämisen eri tyyppisiin SQL-tietokantoihin ja erilaisten kyselyiden sekä päivitysten tekemisen Java-koodista käsin. 

JDBC ei rajoita sitä, minkä SQL-pohjaisten tietokantojen kanssa sitä voidaan käyttää, vaan eri tietokantoja voidaan hyödyntää käyttämällä niille toteutettuja valmiita ajureita. Sillä ei siis Java-koodisi näkökulmasta ole eroa, käytätkö esimerkiksi tietokantana esimerkiksi MySQL- vai SQLite-tyyppistä tietokantaa. Tällä kurssilla hyödynnämme SQLite-tietokantoja niiden tiedostopohjaisuuden ja helppokäyttöisyyden vuoksi.


## SQLite

SQLite-tietokanta on paikallinen muisti- tai tiedostopohjainen tietokanta, joka ei vaadi erillistä palvelinta, vaan se voidaan "sulauttaa" osaksi omaa sovellustamme:

> *"In contrast to many other database management systems, SQLite is not a client–server database engine. Rather, it is embedded into the end program."*
> 
> *"SQLite is a popular choice as embedded database software for local/client storage in application software such as web browsers. It is arguably the most widely deployed database engine, as it is used today by several widespread browsers, operating systems, and embedded systems (such as mobile phones), among others. SQLite has bindings to many programming languages.*"
>
> [https://en.wikipedia.org/wiki/SQLite](https://en.wikipedia.org/wiki/SQLite)

SQLite toimii oleellisilta osin tavoin täysin samalla tavalla kuin erilliset tietokantapalvelimet. Myös SQL-kyselyt ovat pääosin samat, esimerkiksi `SELECT id, name FROM Person`.

SQLiten kanssa emme tarvitse erillistä tietokantapalvelinta, joten meidän ei tarvitse huolehtia verkkoyhteyksistä tai salasanoista. SQLite ei myöskään edellytä asennuksia, vaan riittää, että lisäämme SQLite-ajurin Java-projektiimme. Toteutamme tietokantalogiikan Java-koodeissamme kuitenkin siten, että samat koodirivit toimisivat esim. MySQL tai MariaDB –tietokantoja hyödyntäen. Tietokannan vaihtaminen olisi myöhemmin Java-koodin kannalta suoraviivaista: sinun tulisi vain vaihtaa uusi tietokanta-ajuri ja yhteysosoitteet, joita käsitellään seuraavissa kappaleissa.

<!-- Suorituskyvyn puolesta SQLite ei olisi hyvä valinta julkisen web-järjestelmän tietokannaksi. SQLite soveltuu kuitenkin erinomaisesti moniin erilaisiin tarpeisiin ja esimerkiksi lukuisat mobiilisovellukset ja nettiselaimet käyttävät SQLite:ä paikallisena tietokantanaan. -->

## Video 1: [JDBC ja SQLite](https://web.microsoftstream.com/video/4906ef8a-22f3-4322-9673-df55481b3624) <small>8:12</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/4906ef8a-22f3-4322-9673-df55481b3624?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla esitellään JDBC-teknologian perusidea ja käsitteistöä ja valmistellaan Eclipse-projekti tietokantaohjelmointia varten.

Videolla esiintyvän ajurin latauslinkki: [https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc)

Videolla esiintyvä [PowerPoint-esitys on ladattavissa tästä](./jdbc.pdf).

&nbsp;


## JDBC:n SQLite-ajuri

Tietokannan käyttämiseksi Javasta käsin tarvitsemme erillisen JDBC-ajurin. Erilliset Java-kirjastot jaellaan tyypillisesti `.jar`-tiedostoina (Java Archive), jotka asennetaan pääsääntöisesti automaatiotyökalujen avulla. Suosituimpia automaatiotyökaluja Javalle ovat [Maven](https://maven.apache.org/) ja [Gradle](https://gradle.org/). Automaatiotyökalujen avulla monimutkaistenkin riippuvuuksien hallinta on kohtuullisen yksinkertaista ja myös Eclipsessä on hyvät integraatiota automaatiotyökalujen hyödyntämiseksi.

Jotta kurssilla ei tulisi kerralla liikaa uusia työkaluja, haemme tarvittavan ajurin manuaalisesti Mavenin tietovarastosta. Web-ohjelmoinnin yhteydessä opettelemme lisäämään saman ajurin Mavenin avulla. Siirry Maven-repositorioon osoitteeseen [https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc). Siirry sieltä uusimpaan versioon (esim. 3.32.3.2) ja tallenna ajuri itsellesi linkistä "Jar (6.9 MB)". 

Kirjoitushetkellä viimeisimmän *.jar*-paketin lataus tapahtuu suoraan [tästä linkistä](https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.32.3.2/sqlite-jdbc-3.32.3.2.jar).

Ajurin käyttöönotto projektissasi edellyttää sen lisäämistä projektin "build path":iin. Build path on lista hakemistoista, joissa ohjelmasi käyttämät Java-luokat sijaitsevat. Helpoiten tämä onnistuu seuraavasti:

1. luo projektiisi uusi `lib`-hakemisto
2. siirrä edellä tallentamasi `.jar`-tiedosto lib-hakemistoon
3. lisää lib-hakemisto projektisi "build path":iin [tämän Stack Overflow -viestin mukaisesti](https://stackoverflow.com/a/23420543).

*Huom! Jar-tiedostot sisältävät suoritettavaa ohjelmakoodia, joten niiden kanssa tulee huomioida tietoturva, aivan kuten muidenkin suoritettavien ohjelmien kanssa. Jar-paketteja ei kannata ladata tuntemattomista lähteistä. Tunnettujen ja laajasti käytettyjen pakettien käyttäminen voi myös olla turvallisempaa kuin heikommin tunnettujen tai vähäisessä käytössä olevien. [Google-haku "Is Maven Safe?"](https://www.google.com/search?q=is+maven+safe)*


## Video 2: [SQLite tools ja uuden tietokannan luominen](https://web.microsoftstream.com/video/9735fb55-5e0c-4d7d-bc03-bb72bd1097a1) <small>8:38</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/9735fb55-5e0c-4d7d-bc03-bb72bd1097a1?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla valmistellaan tietokanta, jota käytetään seuraavaksi Java-ohjelmasta käsin.

Videolla käytettävän työkalun latauslinkki: [https://sqlite.org/download.html](https://sqlite.org/download.html)

[SQLite tools -komentorivityökalun "käyttöohje"](./komentorivityokalu)


&nbsp;


### SQLite-tietokannan käyttäminen Javan ulkopuolelta (valinnainen)

Tietokannan käyttäminen Java-ohjelmasi ulkopuolella ei ole tällä kurssilla välttämätöntä, mutta kyselyitä on helpompi suunnitella ja kokeilla ennen niiden koodaamista osaksi ohjelmaa. Tietokannan luonti on myös luonnollista tehdä erillisellä työkalulla, eikä itse Java-ohjelmassa.

[Erilaisten graafisten käyttöliittymien](https://www.google.com/search?q=sqlite+gui) (gui, Graphical User Interface) lisäksi SQLite:lle on saatavissa SQLite:n oma komentorivityökalu.

Voit ladata itsellesi kyseisen `sqlite3.exe`-komentorivityökalun osoitteesta: [https://sqlite.org/download.html](https://sqlite.org/download.html). Työkalut löytyvät esimerkiksi Windowsille otsikon "Precompiled Binaries for Windows" alta (sqlite-tools-win32-x86-VERSIO.zip). Pura `sqlite3.exe`-tiedosto zip-paketista esimerkiksi samaan kansioon tietokantasi kanssa. Jos käytät eri käyttöjärjestelmää, sovella ohjeita oman käyttöjärjestelmäsi työkaluversion mukaisesti.

[Tällä sivulla](./komentorivityokalu) on esimerkki SQLite-komentorivityökalun käyttämisestä tämän kurssin harjoitustyötietokannan kanssa. Lisää ohjeita löydät SQLiten omilta sivuilta osoitteesta [https://sqlite.org/cli.html](https://sqlite.org/cli.html) ja alla olevista videoista.

<!--[![SQLite tools](https://api.kaltura.nordu.net/p/288/sp/28800/thumbnail/entry_id/0_pez4r54j/version/100012/width/435/height/260)](https://video.haaga-helia.fi/media/SQLite+tools/0_pez4r54j)

[SQLite tools -komentorivityökalun käyttöohje](https://video.haaga-helia.fi/media/SQLite+tools/0_pez4r54j)-->



## Video 3: [Tietokantaan yhdistäminen ja kyselyn tekeminen](https://web.microsoftstream.com/video/581f69fe-9594-4488-b841-e44954f303f2) <small>27:52</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/581f69fe-9594-4488-b841-e44954f303f2?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla esitellään Javan luokat, joita tarvitset tietokantayhteyksien ja -kyselyiden muodostamiseksi. 

Videolla esiintyvän `shoppingList.sqlite`-tietokantatiedoston voit ladata itsellesi [kurssin GitHub-repositoriosta](https://github.com/haagahelia/ohjelmointi2-3013/blob/master/sql/shoppingList.sqlite?raw=true). Videolla valmistuvan lähdekooditiedoston `TietokantaanYhdistaminen.java` löydät [täältä](./videoiden_lahdekoodit). Videolla esiintyvä [PowerPoint-esitys on ladattavissa tästä](./jdbc.pdf).

&nbsp;


## SQLite-tietokannan yhteysosoite

Muodostaessasi yhteyden tietokantaan `DriverManager.getConnection(url)`-metodin avulla, tulee sinun antaa parametrina merkkijono, joka on tietokanta-ajurikohtainen "connection url". Yhteysosoitteet alkavat aina tekstillä `jdbc:` ja ajurin nimellä. Ajurin nimen jälkeen kirjoitetaan kaksoispiste, ja sen jälkeen esimerkiksi tietokannan sijainti levyllä (esim. SQLite) tai verkossa (esim. MySQL).

SQLite-tietokannalle yhteysosoite on käyttöjärjestelmästä riippuen joko muodossa `jdbc:sqlite:C:\polku\tietokanta.sqlite` tai `jdbc:sqlite:/users/me/database.sqlite`. Kun kirjoitat SQLite-osoitteen Java-merkkijonoksi, huomaa, että kenoviivat (`\`) ovat Javassa varattu erikoismerkeille. Tavallisen kenoviivan tuottamiseksi merkkijonoon kirjoitetaan siksi kaksi kenoviivaa (`"\\"`). 

Java-koodissasi yhteys tietokantaan `C:\sqlite\shoppingList.sqlite` määritellään siis näin:

```java
private static final String JDBC_URL = "jdbc:sqlite:C:\\sqlite\\shoppingList.sqlite";
```

MySQL-tietokantaan yhdistettäisiin vastaavasti esim. osoitteella `"jdbc:mysql://127.0.0.1:3306/shoppinglist"`. Tällöin sinun tulee myös [lisätä projektiisi MySQL-ajuri](https://www.mysql.com/products/connector/), aivan kuten lisäsimme aikaisemmin SQLite-ajurin.

Seuraavalla viikolla opettelemme siirtämään ns. kovakoodatun tietokannan osoitteen lähdekoodista ympäristömuuttujaan:

```java
// tästä lisää seuraavassa aiheessa:
private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");
```


## Video 4: [Turvalliset parametrisoidut tietokantakyselyt: prepared statement](https://web.microsoftstream.com/video/ddf1432d-fc3e-4d34-9feb-9ec68701d57d) <small>15:37</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/ddf1432d-fc3e-4d34-9feb-9ec68701d57d?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla käsittelemme SQL injektioita, jotka aiheuttavat merkittäviä tietoturvauhkia tietokantapohjaisille järjestelmille. Opimme valmistelemaan kyselyt siten, että haitallista syötettä ei käsitellä SQL-komentoina vaan normaalina tekstinä.

Videolla esiintyvän lähdekooditiedoston `TietokantaanYhdistaminen.java` löydät [täältä](./videoiden_lahdekoodit).

&nbsp;



## Lisämateriaali

[Jenkov.com](http://tutorials.jenkov.com/jdbc/index.html) -palvelussa on laaja tutoriaali JDBC-teknologioista ja se käsittelee kattavasti tietokantojen Javasta käyttämiseksi tarvittavat toimenpiteet. Tutoriaali itsessään käyttää H2-tietokantaa, mutta ei tietokanta-ajurin luokan nimeä ja yhteysosoitetta lukuun ottamatta poikkea SQLite:n käytöstä:

[http://tutorials.jenkov.com/jdbc/index.html](http://tutorials.jenkov.com/jdbc/index.html)

Jenkov.com:in tutoriaalin lisäksi myös Oraclella on [kattava oppimateriaali](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html) JDBC:n opetteluun. 

[https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)

Hyviä ohjeita löytyy myös YouTubesta sekä Googlettamalla tarkemmin yksittäisiä JDBC-aiheita.

Jenkov.com:in tutoriaalissa H2-tietokannan ajuri ladataan kirjoittamalla koodirivi `Class.forName("org.h2.Driver");`. Ajurin lataus manuualisesti ei usein ole erikseen tarpeellista, mutta vastaava rivi SQLite-tietokannan ajurin lataamiseksi on:

```java
Class.forName("org.sqlite.JDBC");
```



## Tehtävä: tietokantapohjainen ostoslistasovellus 1/2

Tämä on kaksiosaisen tehtävän ensimmäinen vaihe, joka palautetaan Teamsiin yhdessä seuraavan DAO-tehtävän kanssa. Tehtävän ratkaisemiseksi sinulle voi olla hyödyllistä tutustua myös videoon ["ShoppingListApp-sovelluksen ensimmäinen vaihe"](https://web.microsoftstream.com/video/8efb239a-4700-444a-a4a8-f6ef9bac10e9).

Tarkemmat palautusohjeet löydät seuraavan aiheen lopusta. Muista, että voit kysyä Teamsissa neuvoja tehtävään.


### Ostoslista ja CRUD-operaatiot

Tällä viikolla sinun tulee toteuttaa Java-ohjelma, joka toimii käyttöliittymänä ostoslistan tuotteita sisältävälle tietokannalle. Tietokannassa on vain yksi taulu eikä sinun tarvitse huolehtia esimerkiksi siitä, voisiko ohjelmassa olla samanaikaisesti useita eri käyttäjien ostoslistoja. 

Käyttöliittymän kautta tulee voida tehdä CRUD-operaatiot tietojen päivittämistä lukuun ottamatta (Create, Read, ~~Update~~ & Delete).

Ostoslistan sisällöksi riittää kutakin tuoteriviä kohden yksilöllinen `id` sekä ostettavan tuotteen nimi (`title`). Voit hyödyntää tässä tehtävässä valmista [SQLite-tietokantatiedostoa](https://github.com/haagahelia/ohjelmointi2-3013/blob/master/sql/shoppingList.sqlite?raw=true), johon on ajettu seuraava luontikäsky ja muutama esimerkkirivi:

```sql
CREATE TABLE ShoppingListItem (
   id INTEGER PRIMARY KEY,
   title TEXT NOT NULL
);
```

Valmiin tietokantatiedoston voit ladata itsellesi [tästä](https://github.com/haagahelia/ohjelmointi2-3013/blob/master/sql/shoppingList.sqlite?raw=true). Tallenna tiedosto johonkin hakemistoon, jonka osoite on helposti kopioitavissa Java-koodiisi (esim. `C:\sqlite\shpopingList.sqlite` tai `/home/omanimi/sqlite/shoppingList.sqlite`).

Varmista myös, että olet varmasti ladannut edellä [olevan ohjeistuksen mukaisesti](#jdbcn-sqlite-ajuri) SQLite-ajurin ja olet sijoittanut sen lib-kansioon, joka on projektisi build pathissa. 


### SQL-kyselyiden tietoturva

Huomaa, että SQL-kyselyjen muodostaminen merkkijonoja yhdistelemällä aiheuttaa mm. tietoturvaongelmia, kuten alla oleva esimerkki havainnollistaa:

[![Exploits of a Mom](https://imgs.xkcd.com/comics/exploits_of_a_mom.png)](https://xkcd.com/327/)

Kuva: Randall Munroe. Exploits of a Mom. [https://xkcd.com/327/](https://xkcd.com/327/). [CC BY-NC 2.5](https://creativecommons.org/licenses/by-nc/2.5/)

Muista siis käyttää oppimateriaaleissa esiteltyä `PreparedStatement`-luokkaa aina muodostaessasi kyselyitä, joihin syötetään dynaamisesti parametreja!


### Esimerkkikäyttöliittymä

Tämän tehtävän kannalta ei ole oleellista, minkälaisen käyttöliittymän rakennat, kunhan sen kautta pystyy käyttämään tietokantaa ja näkemään tehtyjen muutosten vaikutukset.

Ohjelman esimerkkikäyttöliittymästä on [erillinen ohjedokumentti](./ostoslista-kayttoliittyma). Voit toteuttaa ohjelmasi omien mieltymystesi mukaan tai noudattaa seuraavan esimerkkisovelluksen toiminnallisuuksia:

```
Welcome to the shopping list app!
Available commands:
 list
 add [product name]
 remove [product name]
 quit

> list

Shopping list contents:
(1) Milk

> add Eggs

Successfully added Eggs

> list

Shopping list contents:
(1) Milk
(2) Eggs

> add Bread

Successfully added Bread

> remove Eggs

Succesfully removed Eggs

> list

Shopping list contents:
(1) Milk
(3) Bread

> remove Cookies

Could not remove Cookies

> foobar

Unknown command "foobar".

> quit

Bye!

```

[Tutustu käyttöliittymän dokumentaatioon](./ostoslista-kayttoliittyma)

### Tehtävän palauttaminen

Tämä on kaksiosaisen tehtävän ensimmäinen vaihe, joka palautetaan Teamsiin yhdessä seuraavan tehtävän kanssa. Tarkemmat palautusohjeet löydät seuraavan aiheen lopusta. Muista, että voit kysyä Teamsissa neuvoja tehtävään.
