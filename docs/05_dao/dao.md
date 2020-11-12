[⇦ takaisin kurssin etusivulle](../)


# Tietokannan eriyttäminen ja DAO-pattern 

Tähän mennessä kurssia olemme tutustuneet ymmärrettävän ja ylläpidettävän koodin kirjoittamiseen, koodin testaamiseen ja tietokantaohjelmointiin. Seuraavaksi rakennamme pienen tietokantaa hyödyntävän komentorivisovelluksen, jonka logiikkaa on mahdollista uudelleenkäyttää ja testata.

Lopulta tavoitteenamme on sovellus, joka on ensinnäkin toimiva, mutta sen lisäksi ylläpidettävissä ja laajennettavissa elinkaarensa aikana. Seuraavissa vaiheissa jatkammekin saman sovelluksen kehittämistä web-pohjaiseksi palveluksi. Voit tutustua tavoittelemaamme lopputulokseen jo etukäteen osoitteessa [https://shoppinglist-example.herokuapp.com/](https://shoppinglist-example.herokuapp.com/)!

**Huom!** Videoiden katsomiseksi sinun täytyy kirjautua sisään Microsoft Stream -palveluun Haaga-Helian käyttäjätunnuksellasi.

<!--## Malliratkaisu

Tämän tehtävän palautusaika on umpeutunut. Voit katsoa malliratkaisun [tältä videolta](https://web.microsoftstream.com/video/61360881-77bb-4610-b22c-4a6ef3b298a6).-->


## Video 1: [JDBC-aiheen kertaus](https://web.microsoftstream.com/video/aea9daea-9811-4ba2-bd14-943658e381a1) <small>13:03</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/aea9daea-9811-4ba2-bd14-943658e381a1?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla kerrataan edellisessä aiheessa käsitellyt JDBC-aiheeseen liittyvät käsitteet ja työkalut kuten ajuri, tietokantatiedosto, build path, SQLite tools, yhteysosoite ja prepared statement. Mikäli edellisen JDBC-aiheen sisältö ehti jo unohtua, sinun kannattaa aloittaa tästä videosta.

&nbsp;


## DAO (Data Access Object)

Ohjelman rakenteen ja arkkitehtuurin suunnittelemiseksi on hyviä tunnettuja ja laajasti käytettyjä suunnittelumalleja (pattern), joita noudattamalla tulet soveltaneeksi hyviä käytäntöjä ja koodistasi tulee toivottavasti laadukasta. Ohjelmistokehittäjät noudattavat usein samoja suunnittelumalleja, mikä helpottaa muiden kirjoittamien ohjelmien ymmärtämistä ja koodauskäytäntöjen yhtenäistämistä.

Tietokantalogiikan eriyttämiseksi muusta koodista käytetään usein ns. **DAO**-mallia:

> *"DAO stands for **Data Access Object**. DAO Design Pattern is used to separate the data persistence logic in a separate layer. This way, the service remains completely in dark about how the low-level operations to access the database is done. This is known as the principle of **Separation of Logic**."*
>
> JournalDEV. DAO Design Pattern. [https://www.journaldev.com/16813/dao-design-pattern](https://www.journaldev.com/16813/dao-design-pattern)


## Video 2: [Intro DAO-patterniin](https://web.microsoftstream.com/video/ec6e052c-ba95-4c59-975f-6322c81097e6?st=33) <small>3:53</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/ec6e052c-ba95-4c59-975f-6322c81097e6?st=33&amp;autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla esitellään motivaatio tietokantapohjaisen Java-ohjelman rakenteen parantamiseksi DAO-kehitysmallin avulla. Videolla käsiteltävän luokan `TietokantaanYhdistaminen.java` löydät [täältä](../04_tietokantaohjelmointi/videoiden_lahdekoodit).

&nbsp;


## Video 3: [ShoppingListApp-sovelluksen ensimmäinen vaihe](https://web.microsoftstream.com/video/8efb239a-4700-444a-a4a8-f6ef9bac10e9) <small>41:41</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/8efb239a-4700-444a-a4a8-f6ef9bac10e9?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla toteutamme ShoppingListApp-sovelluksen käyttöliittymän ensimmäisiä komentoja [switch-case-rakenteella](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html). Videoilla esiintyvä PowerPoint-esitys on ladattavissa [tästä](../04_tietokantaohjelmointi/jdbc.pdf). Käyttöliittymän erillinen ohje löytyy [täältä](../04_tietokantaohjelmointi/ostoslista-kayttoliittyma).

Videon lopussa käsitellään `finally`-lohkon käyttämistä JDBC-resurssien sulkemiseen kyselyn tekemisen jälkeen. Vaikka videon alkuosa olisi sinulle jo tuttua, katso yhteyksien sulkemista koskeva osuus kohdasta 29:50 alkaen.

&nbsp;


## Video 4: [DAO-käsitteen esittely ja ostoslistan DAO-luokat](https://web.microsoftstream.com/video/0c7e026d-5064-4ceb-8afc-58940bfeced7) <small>27:48</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/0c7e026d-5064-4ceb-8afc-58940bfeced7?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla parannamme ShoppingListApp-sovelluksemme rakennetta hyödyntämällä DAO-luokkaa. Videolla hyödynnämme seuraavaa model-luokkaa ja rajapintaa:

* [ShoppingListItem](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/java/model/ShoppingListItem.java)-luokka

* [ShoppingListItemDao](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/java/database/ShoppingListItemDao.java)-rajapinta


&nbsp;


### Lisämateriaali

Lue DAO-suunnittelumallin esittely esimerkkikoodeineen osoittessa [https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm). Kyseisen tutoriaalin koodiesimerkit eivät hyödynnä oikeaa tietokantaa, vaan tavallista `ArrayList`-listaa. Vastaavalla tavalla toteutettu listapohjainen DAO-luokka ostoslistasta on nähtävissä esimerkkisovelluksen lähdekoodeissa: [FakeShoppingListItemDao.java](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/java/database/FakeShoppingListItemDao.java).



## Palautettava tehtävä

Tällä kertaa jatkamme edellisessä JDBC-aiheessa aloittamaamme ostoslistasovellusta, joka hyödyntää `shoppingList.sqlite`-tietokantaa ja siinä olevaa `ShoppingListItem`-tietokantataulua. Aikaisemman toteutuksen sijaan ohjelman logiikka halutaan nyt jäsennellä uudelleen siten, että ohjelman käyttöliittymä on erillään ohjelman tietokantalogiikasta. Käyttöliittymä ja tietokantakerros (DAO) kommunikoivat keskenään tavallisten Java-olioiden, kuten listojen ja ShoppingListItem-olioiden avulla. Ratkaisusi ei tarvitse olla laajuudeltaan tai toimivuudeltaan täydellinen, vaan myös osittain toimivat ratkaisut arvostellaan.

Varsinaisen DAO-osuuden lisäksi tehtävänannossa on kaksi vapaaehtoista bonustehtävää: ympäristömuuttujien hyödyntäminen sekä tietokantalogiikan yksikkötestaus. Nämä syventävät tehtävät eivät ole kurssin oppimistavoitteiden kannalta pakollisia, mutta ne syventävät kurssin aiheita ammatillisesti hyödyllisillä tavoilla.

💡 Tehtävänannossa ei ole kuvailtu tarkemmin mahdollisia yksityisia apumetodeja tai apuluokkia, jotka voivat tehdä koodistasi helpommin ymmärrettävää tai ylläpidettävää. Voit tehtävänannossa mainittujen luokkien ja metodien lisäksi luoda esimerkiksi `Database`-luokan, jonne sijoitat tietokannan yhteyksien avaamiseen ja sulkemiseen liittyvän logiikan. Vaihtoehtoisesti voit toteuttaa halutessasi DAO-luokkaasi erilliset metodit yhteyksien avaamiseksi ja resurssien sulkemiseksi, jotta tätä samaa logiikkaa ei tarvitse toistaa kaikissa tietokantaa käsittelevissä metodeissa.


### Model-luokka

Kaikki tietokannasta luetut tiedot mallinnetaan DAO-mallissa olio-ohjelmointiparadigman mukaisesti olioina, joten tarvitset myös uutta `ShoppingListItem`-luokkaa. Tämän luokan oliot mallintavat yksittäisiä tietokannan tuoterivejä, eli ohjelman dataa. Vastaavista luokista käytetään usein termejä [bean, business object tai entity](https://en.wikipedia.org/wiki/Business_object).

Jokaisella ostoslistan rivillä on sekä `id` että tuotteen nimi `title`, joten lisää nämä tietueet myös omaan `ShoppingListItem`-luokkaasi. Lisäksi tarvitset konstruktoreja, gettereitä ja settereitä, jotka voit toteuttaa oman ohjelmasi tarpeiden mukaisesti.


### DAO-luokka

DAO-mallissa tietokantaoperaatiot kirjoitetaan omaan luokkaansa, joka palauttaa metodeistaan tavallisia Java-olioita. Tämän ohjelman tapauksessa DAO-luokkasi palauttaa edellä esiteltyjä ShoppingListItem-olioita sekä yksitellen että listoina. Toteuta ShoppingListItemDao-luokka ja sen tarvitsemat tietokantaa käsittelevät metodit alla esitetyn keskeneräisen rungon mukaisesti. Muuta tarvittaessa yksityiskohdat vastaamaan omaa projektiasi:

```java
// tiedosto JDBCShoppingListItemDao.java

package database; // muuta tämä tarvittaessa

import java.util.List;

import model.ShoppingListItem;

public class JDBCShoppingListItemDao implements ShoppingListItemDao {

    @Override
    public List<ShoppingListItem> getAllItems() {
        // TODO: Toteuta tämä metodi
        return null;
    }

    @Override
    public ShoppingListItem getItem(long id) {
        // TODO: Toteuta tämä metodi
        return null;
    }

    @Override
    public boolean addItem(ShoppingListItem newItem) {
        // TODO: Toteuta tämä metodi
        return false;
    }

    @Override
    public boolean removeItem(ShoppingListItem item) {
        // TODO: Toteuta tämä metodi
        return false;
    }

}
```

Tutustu tarvittaessa vielä videoon 4, jossa käsitellään tämän luokan toimintaa ja sen yhteyttä `ShoppingListApp`-ohjelmaluokkaan.

### DAO-luokan rajapinta

Edellä esitetty `JDBCShoppingListItemDao` on JDBC-teknologiaa hyödyntävä luokka, joka toteuttaa `ShoppingListItemDao`-rajapinnan:

```java
public class JDBCShoppingListItemDao implements ShoppingListItemDao 
                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
```

Kaikissa luokan metodeissa esiintyy `@Override`-annotaatio, joka tarkoittaa sitä, että kyseinen metodi on määritetty luokan toteuttamassa rajapinnassa. Tallenna itsellesi myös luokan tarvitsema rajapinta:

```java
// tiedosto ShoppingListItemDao.java

package database; // muuta tämä tarvittaessa

import java.util.List;

import model.ShoppingListItem;

public interface ShoppingListItemDao {

    public List<ShoppingListItem> getAllItems();

    public ShoppingListItem getItem(long id);

    public boolean addItem(ShoppingListItem newItem);

    public boolean removeItem(ShoppingListItem item);
}
```

Muuta jälleen yksityiskohdat, kuten package, vastaamaan omaa projektiasi. Mikäli rajapinnat eivät ole sinulle tässä vaiheessa täysin tuttuja, riittää että tiedät, että rajapinta määrittelee metodit, jotka sen toteuttavien luokkien on toteutettava samoilla parametriarvoilla ja paluuarvoilla.


### DAO-luokan metodien toteuttaminen

Toteuta DAO-luokkaasi `ShoppingListItem`-olioita käsittelevät metodit seuraavien kuvausten mukaisesti.


#### getAllItems()

Toteuta tämä metodi siten, että metodin sisällä luetaan tietokantataulun kaikki rivit, ja niistä luodaan rivejä vastaavat `ShoppingListItem`-oliot. Laita oliot metodin sisällä listalle, ja palauta lista lopuksi metodista. Jos tietokannassa ei ole lainkaan rivejä, palauta tyhjä lista. Katso tarvittaessa vinkkejä yllä esitetyltä videolta "DAO-käsitteen esittely ja ostoslistan DAO-luokat".


#### getItem(long id)

Toteuta tämä metodi siten, että metodin sisällä etsit riviä, jonka `id`-sarakkeen arvona on annettu arvo. Jos vastaava rivi löytyy, luo uusi `ShoppingListItem`-olio ja palauta se. Muussa tapauksessa palauta `null`.


#### addItem(ShoppingListItem lisattava)

Toteuta tämä metodi siten, että metodin sisällä lisäät tietokantaan uuden rivin. Lisättävän rivin `title`-sarakkeen arvoksi laitetaan metodille annetun olion `title`.


#### removeItem(ShoppingListItem poistettava)

Toteuta tämä metodi siten, että metodin sisällä poistat tietokannasta metodille annettua `ShoppingListItem`-oliota vastaavan rivin. Poistettavan tietokantarivin id:n saat selville olion `id`-attribuutista. Mikäli poistaminen onnistuu, palauta tästä metodista `true`. Muussa tapauksessa palauta `false`.


#### Extra: lisätyn rivin automaattisen id:n selvittäminen

SQLite-tietokantamme huolehtii automaattisesti sinne lisättyjen rivien `id`-arvojen generoinnista kasvavassa järjestyksessä. `addItem`-metodia kutsuttaessa voi olla tarpeellista, että päivität lisättävälle `ShoppingListItem`-oliolle `id`-arvoksi sitä vastaavan automaattisesti generoidun id-arvon.

Voit selvittää insert-komennon jälkeen lisätyn rivin id:n `Statement.RETURN_GENERATED_KEYS`-arvon ja `.getGeneratedKeys()`-metodin avulla seuraavasti:

```java
// By Yishai & Lukas Eder, cc by-sa 4.0. https://stackoverflow.com/a/1376241/12748248
String sql = "INSERT INTO table (column1, column2) values(?, ?)";

PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
stmt.executeUpdate();

// haetaan generoidut pääavaimet
ResultSet rs = stmt.getGeneratedKeys();
rs.next();

// lisäämämme rivin id saadaan kutsumalla getInt(1)
int automaticallyGeneratedId = rs.getInt(1);
```

Voit tutustua aiheeseen tarkemmin tässä [StackOverflow-keskustelussa](https://stackoverflow.com/questions/1376218/is-there-a-way-to-retrieve-the-autoincrement-id-from-a-prepared-statement).


### Ostoslistasovelluksen liittäminen DAO-luokkaan

Muuta tunnilla esiteltyä ja edellisessä tehtävässä kehittämääsi `ShoppingListApp`-ostoslistasovellusta siten, että **tietokantakyselyitä ei suoriteta enää samassa luokassa käyttöliittymän kanssa**. 

Sen sijaan käyttöliittymäluokkasi tulee hyödyntää uutta DAO-luokkaa tietokannan käsittelyyn ja toimia olio-ohjelmointikäytäntöjen mukaisesti hyödyntäen listoja ja `ShoppingListItem`-olioita.

----

### ⭐ Vapaahetoinen tehtävä 1: ympäristömuuttujat

*Tämä osa on valinnainen, mutta sitä suositellaan, mikäli olet saanut kaikki tähänastiset harjoitukset tehtyä.*

Usein samaa koodia suoritetaan lukuisissa erilaisissa ympäristöissä, kuten useiden eri kehittäjien omilla Windows-, Mac- ja Linux- koneilla. Kehittäjien henkilökohtaisten koneiden lisäksi sama koodi toimii tuotantoympäristössä, joka saattaa sijaita pilvipalvelussa tai konesalissa. Eri ympäristöissä tarvitaankin eri yhteysosoitteet, käyttäjätunnukset ja muita muuttuvia tietoja esimerkiksi tietokantojen käyttämiseksi.

Ympäristökohtaisia asetuksia ei haluta kirjoittaa suoraan ohjelmakoodiin, jotta koodia ei jouduta muuttamaan jokaista suoritusympäristöä varten. Toisaalta arkaluontoisia tietoja, kuten tietokantojen salasanoja, ei koskaan haluta tallentaa selkokielisinä ohjelmakoodiin tai versionhallintaan.

Yleinen tapa ratkaista edellä esitetty ongelma on asettaa ympäristökohtaisesti vaihtuvat arvot käyttöjärjestelmän **ympäristömuuttujiin**. Sovellus voi ympäristömuuttujien avulla käyttää esimerkiksi kehitys-, testi- tai tuotantokantaa ilman, että ohjelmakoodia muutetaan. Salaiset tiedot, kuten salasanat, jäävät myös pois ohjelmakoodista.


#### Ympäristömuuttujien hyödyntäminen

Ympäristömuuttujat ovat eräänlainen käyttöjärjestelmäkohtainen Map-tietorakenne, jossa eri arvoja voidaan käsitellä avainten, eli ympäristömuuttujien nimien, avulla. Ympäristömuuttujien arvoja voidaan Javassa lukea `System.getenv`-metodilla esimerkiksi seuraavasti. 

```diff

+ // merkkijono luetaan ympäristömuuttujasta:
+ private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");

- // kovakoodattu merkkijono:
- private static final String JDBC_URL = "jdbc:sqlite:c:\\sqlite\\shoppingList.sqlite";
```

Alemmalla rivillä merkkijono ei siis ole enää "kovakoodattuna", vaan se määritellään ympäristömuuttujiin avaimella **JDBC_DATABASE_URL**. Avaimena voitaisiin käyttää periaatteessa mitä vain merkkijonoa, mutta tässä käyttämämme **JDBC_DATABASE_URL** noudattaa mm. [Heroku-sovellusalustan ympäristömuuttujakäytäntöä](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-database_url-in-plain-jdbc).

Alla olevassa esimerkissä dao-luokkaan on luotu uusi yksityinen `connect`-niminen metodi yhteyden luomiseksi, jota muut saman luokan metodit kutsuvat. Tällainen metodi voi olla hyödyllinen myös omassa koodissasi. `connect`-metodi käyttää yhteysosoitteena ympäristömuuttujasta haettua yhteysosoitetta, eikä kovakoodattua merkkijonoa:


```java
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCShoppingListItemDao implements ShoppingListItemDao {

    // read the database connection String from an environment variable:
    private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
}
``` 

Kun koodi on asetettu lukemaan tietokannan sijainti ympäristömuuttujasta, täytyy tämä sijainti lisätä seuraavaksi `JDBC_DATABASE_URL`-nimiseen ympäristömuuttujaan.


#### Ympäristömuuttujien asettaminen Eclipsessä

Voit Eclipsessä lisätä ohjelmallesi ympäristömuuttujia tämän [Stack Overflow -ketjun](https://stackoverflow.com/a/12810433) ohjeiden mukaisesti. Pidempi ohje löytyy tarvittaessa esimerkiksi [javacodegeeks.com:ista](https://examples.javacodegeeks.com/desktop-java/ide/eclipse/eclipse-environment-variable-setup-example/).

Määrittele siis edellä mainitun ohjeen mukaisesti itsellesi Eclipseen ympäristömuuttuja `JDBC_DATABASE_URL`, joka sisältää JDBC-yhteysrivin esimerkiksi muodossa `jdbc:sqlite:c:\polku\tiedosto.sqlite`. Huomaa, että koska ympäristömuuttuja ei ole Javan merkkijono, ei sen ympärille kirjoiteta lainausmerkkejä eikä kenoviivaa `\` kirjoiteta tuplana ~~`\\`~~.

Vaihtoehtoisesti ympäristömuuttujia voidaan määritellä koko järjestelmän tasolla [Windowsissa](https://docs.oracle.com/en/database/oracle/r-enterprise/1.5.1/oread/creating-and-modifying-environment-variables-on-windows.html#GUID-DD6F9982-60D5-48F6-8270-A27EC53807D0), [Linuxissa](https://www.google.com/search?q=linux+set+environment+variable) ja [MacOS:ssa](https://www.google.com/search?q=macos+set+environment+variable). Tätä tapaa ei kuitenkaan suositella tällä kurssilla.

----

### ⭐ Vapaaehtoinen tehtävä 2: DAO-luokan testaaminen JUnit-testillä

*Tämä osa on valinnainen, mutta sitä suositellaan, mikäli olet saanut kaikki tähänastiset harjoitukset tehtyä.*

Nyt kun tietokannan sijainti on konfiguroitavissa ympäristömuuttujilla, voit toteuttaa DAO-luokkasi metodeille yksikkötestit, jotka käyttävät eri tietokantaa kuin varsinainen `ShoppingListApp`-ohjelmaluokka. 

Luo itsellesi testejä varten kopio SQLite-tietokannasta (tiedostosta `shoppingList.sqlite`). Näin voit poistaa ja lisätä rivejä testeissäsi ilman, että se vaikuttaa ohjelman normaaliin käyttöön.

Aseta Eclipseen testiluokan suoritusasetuksista ympäristömuuttujaan testitietokannan sijainti edellisen vaiheen ohjeen mukaisesti, esim. `jdbc:sqlite:c:\sqlite\testit\shoppingListTest.sqlite`.

#### Tietokannan alustaminen testeissä

Tietokantaa hyödyntävän koodin testaaminen voi olla vaikeaa, mikäli tietokantaan jää edellisten testikertojen jäljiltä dataa, joka vaikuttaa testien suoritukseen seuraavalla kerralla. Tämän vuoksi [testitietokanta tyypillisesti tyhjennetään ja alustetaan aina samalla datalla](https://www.google.com/search?q=reset+database+between+junit+tests) ennen jokaista testitapausta. 

Voit kirjoittaa testiluokkaasi testien alustuksen erilliseen metodiin [`@BeforeEach`](https://howtodoinjava.com/junit5/before-each-annotation-example/)-annotaation avulla. JUnit suorittaa `@BeforeEach`-metodisi automaattisesti ennen jokaista `@Test`-metodia, joten tietokannassa on ennen jokaista testiä aina ennalta tiedossa oleva sisältö.

Voit lainata omaan testiisi alla esitettyä `@BeforeEach`-metodia, joka tyhjentää ensin `ShoppingListItem`-taulun ja sen jälkeen lisää tauluun kaksi riviä ennen jokaista testiä:

```java
class JDBCShoppingListItemDaoTest {

    private JDBCShoppingListItemDao dao = new JDBCShoppingListItemDao();

    /**
     * This method clears the test database and inserts two rows directly in the
     * database before each test with a delete statement.
     * 
     * This way every time the tests are executed they have exactly the same data to
     * work with.
     * 
     * !! Make sure to always use a different database environment variable for each
     * execution environment to prevent data loss or corruption !!
     */
    @BeforeEach
    public void setUp() throws Exception {
        Connection connection = dao.connect();
        connection.prepareStatement("delete from ShoppingListItem").executeUpdate();
        connection.prepareStatement("insert into ShoppingListItem (id, title) values (1, 'Milk'), (2, 'Eggs')").executeUpdate();
        connection.close();
    }

    // Write the actual tests methods here. You can use Milk (1) and Eggs (2) in all of your tests!
}
```


----

## Tehtävän palauttaminen

Palauta kaikki tehtävissä kirjoittamasi lähdekoodit Teamsiin määräaikaan mennessä. Palauta tiedostot yksittäin, eli ei pakattuna. Muista myös, että voit kysyä kaikissa tehtäviin liittyvissä aiheissa Teamsissa!

Ratkaisusi ei tarvitse olla laajuudeltaan tai toimivuudeltaan täydellinen, vaan myös osittain toimivat ratkaisut arvostellaan. Osittain ratkaistut palautukset arvostellaan suhteessa niiden toimivuuteen ja valmiusasteeseen.

