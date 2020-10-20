[⇦ takaisin kurssin etusivulle](../)


# Tietokannan eriyttäminen ja DAO-pattern 

Tähän mennessä kurssia olemme tutustuneet ymmärrettävän ja ylläpidettävän koodin kirjoittamiseen, koodin testaamiseen ja tietokantaohjelmointiin. Seuraavaksi rakennamme pienen tietokantaa hyödyntävän komentorivisovelluksen, jonka logiikkaa on mahdollista uudelleenkäyttää ja testata.

Lopulta tavoitteenamme on sovellus, joka on ensinnäkin toimiva, mutta sen lisäksi ylläpidettävissä ja laajennettavissa elinkaarensa aikana. Seuraavissa vaiheissa jatkammekin saman sovelluksen kehittämistä web-pohjaiseksi palveluksi. Voit tutustua tavoittelemaamme lopputulokseen jo etukäteen osoitteessa [http://shoppinglist-example.herokuapp.com/](http://shoppinglist-example.herokuapp.com/)!

<!--## Malliratkaisu

Tämän tehtävän palautusaika on umpeutunut. Voit katsoa malliratkaisun [tältä videolta](https://web.microsoftstream.com/video/61360881-77bb-4610-b22c-4a6ef3b298a6).-->


## DAO (Data Access Object)

Ohjelman rakenteen ja arkkitehtuurin suunnittelemiseksi on hyviä tunnettuja ja laajasti käytettyjä suunnittelumalleja (pattern), joita noudattamalla tulet soveltaneeksi hyviä käytäntöjä ja koodistasi tulee toivottavasti laadukasta. Ohjelmistokehittäjät noudattavat usein samoja suunnittelumalleja, mikä helpottaa muiden kirjoittamien ohjelmien ymmärtämistä ja koodauskäytäntöjen yhtenäistämistä.

Tietokantalogiikan eriyttämiseksi muusta koodista käytetään usein ns. **DAO**-mallia:

> "DAO stands for **Data Access Object**. DAO Design Pattern is used to separate the data persistence logic in a separate layer. This way, the service remains completely in dark about how the low-level operations to access the database is done. This is known as the principle of **Separation of Logic**."
>
> [*DAO Design Pattern*](https://www.journaldev.com/16813/dao-design-pattern)

## Videot


**[JDBC-aiheen kertaus](https://web.microsoftstream.com/video/aea9daea-9811-4ba2-bd14-943658e381a1)** 13:03

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/aea9daea-9811-4ba2-bd14-943658e381a1?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>


&nbsp;


**[Intro DAO-patterniin](https://web.microsoftstream.com/video/ec6e052c-ba95-4c59-975f-6322c81097e6?st=33)** 3:53

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/ec6e052c-ba95-4c59-975f-6322c81097e6?st=33&amp;autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>


&nbsp;


**[ShoppingListApp-sovelluksen ensimmäinen vaihe](https://web.microsoftstream.com/video/8efb239a-4700-444a-a4a8-f6ef9bac10e9)** 41:41

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/8efb239a-4700-444a-a4a8-f6ef9bac10e9?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>


&nbsp;


**[DAO-käsitteen esittely ja ostoslistan DAO-luokat](https://web.microsoftstream.com/video/0c7e026d-5064-4ceb-8afc-58940bfeced7)** 27:48

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/0c7e026d-5064-4ceb-8afc-58940bfeced7?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

[ShoppingListItem.java](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/java/model/ShoppingListItem.java)

[ShoppingListItemDao.java](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/java/database/ShoppingListItemDao.java)


&nbsp;


### Itseopiskelumateriaali

Lue DAO-suunnittelumallin esittely esimerkkikoodeineen osoittessa [https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm). Kyseisen tutoriaalin koodiesimerkit eivät hyödynnä oikeaa tietokantaa, vaan tavallista `ArrayList`-listaa. Vastaavalla tavalla toteutettu listapohjainen DAO-luokka ostoslistasta on nähtävissä esimerkkisovelluksen lähdekoodeissa: [`FakeShoppingListItemDao.java`](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/java/database/FakeShoppingListItemDao.java).


## Palautettava tehtävä

### `JDBCShoppingListItemDao`-luokka

Toteuta oppitunnilla esitellyn `ShoppingListItem`-tietokantataulun CRUD-operaatiot uuteen DAO-luokkaan nimeltä `JDBCShoppingListItemDao`. 

Voit käyttää DAO-luokkasi pohjana alla esitettyä keskeneräistä luokkaa. Muuta tarvittaessa yksityiskohdat, kuten package, vastaamaan omaa projektiasi:

```java
// tiedosto JDBCShoppingListItemDao.java
package database;

import java.util.List;

import model.ShoppingListItem;

/**
 * TODO: Complete the implementation of this DAO-class 
 * by implementing database operations for each of the 
 * CRUD methods.
 */
public class JDBCShoppingListItemDao implements ShoppingListItemDao {

    @Override
    public List<ShoppingListItem> getAllItems() {
        return null;
    }

    @Override
    public ShoppingListItem getItem(long id) {
        return null;
    }

    @Override
    public boolean addItem(ShoppingListItem newItem) {
        return false;
    }

    @Override
    public boolean removeItem(ShoppingListItem item) {
        return false;
    }

}
```

Huomaa, että `JDBCShoppingListItemDao` on JDBC-teknologiaa hyödyntävä luokka, joka toteuttaa `ShoppingListItemDao`-rajapinnan:

```java
public class JDBCShoppingListItemDao implements ShoppingListItemDao {
                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
```

Itse rajapinnan määrittelyssä tai nimeämisessä ei ole otettu kantaa siihen, ladataanko tieto tietokannasta, tiedostosta tai vaikka verkosta. Kaikkien metodien edessä esiintyy `@Override`-annotaatio, joka tarkoittaa, että kyseinen metodi on määritetty kyseisessä rajapinnassa. 

Tallenna itsellesi myös luokan tarvitsema rajapinta:

```java
// tiedosto ShoppingListItemDao.java
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

Muuta tarvittaessa yksityiskohdat, kuten `package`, vastaamaan omaa projektiasi. Mikäli rajapinnat eivät ole sinulle täysin tuttuja, riittää että tiedät, että rajapinta määrittelee metodit, jotka sen toteuttavien luokkien on toteutettava samoilla parametriarvoilla  ja paluuarvoilla.


### ShoppingListItem-luokka

Kaikki tietokannasta luetut tiedot mallinnetaan DAO-mallissa olio-ohjelmointiparadigman mukaisesti olioina, joten tarvitset myös uutta `ShoppingListItem`-luokkaa. Tämän luokan oliot mallintavat yksittäisiä tietokannan tuoterivejä, eli ohjelman dataa. Vastaavista luokista käytetään usein termejä [bean, business object tai entity](https://en.wikipedia.org/wiki/Business_object).

Jokaisella ostoslistan rivillä on sekä `id` että tuotteen nimi `title`, joten lisää nämä tietueet myös omaan `ShoppingListItem`-luokkaasi. 


### DAO-metodien toteuttaminen

Toteuta DAO-luokkaasi `ShoppingListItem`-olioita käsittelevät metodit seuraavien kuvausten mukaisesti.


#### getAllItems()

Toteuta tämä metodi siten, että metodin sisällä luetaan tietokantataulun kaikki rivit, ja niistä luodaan rivejä vastaavat `ShoppingListItem`-oliot. Laita oliot metodin sisällä listalle, ja palauta lista lopuksi metodista. Jos tietokannassa ei ole lainkaan rivejä, palauta tyhjä lista.

#### getItem(long id)

Toteuta tämä metodi siten, että metodin sisällä etsit riviä, jonka `id`-sarakkeen arvona on annettu arvo. Jos vastaava rivi löytyy, luo uusi `ShoppingListItem`-olio ja palauta se. Muussa tapauksessa palauta `null`.

#### addItem(ShoppingListItem lisattava)

Toteuta tämä metodi siten, että metodin sisällä lisäät tietokantaan uuden rivin. Lisättävän rivin `title`-sarakkeen arvoksi laitetaan metodille annetun olion `title`.

#### removeItem(ShoppingListItem poistettava)

Toteuta tämä metodi siten, että metodin sisällä poistat tietokannasta metodille annettua `ShoppingListItem`-oliota vastaavan rivin. Poistettavan tietokantarivin id:n saat selville olion `id`-attribuutista. Mikäli poistaminen onnistuu, palauta tästä metodista `true`. Muussa tapauksessa palauta `false`.


#### Extra: lisätyn rivin automaattisen id:n selvittäminen

`addItem`-metodin on tarkoitus lisätä uusi rivi tietokantaan. Tällöin voi olla tarpeellista, että päivität `ShoppingListItem`-oliolle `id`-arvoksi tietokantaan lisätyn uuden rivin id:n.

Voit lisäyksen jälkeen selvittää lisätyn rivin id:n `Statement.RETURN_GENERATED_KEYS`-arvon ja `.getGeneratedKeys()`-metodin avulla seuraavasti:

```java
// By Yishai & Lukas Eder, cc by-sa 4.0. https://stackoverflow.com/a/1376241/12748248
String sql = "INSERT INTO table (column1, column2) values(?, ?)";

PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
stmt.executeUpdate();

ResultSet rs = stmt.getGeneratedKeys();
rs.next();

int automaticallyGeneratedId = rs.getInt(1);
```

Tutustu aiheeseen tarkemmin [StackOverflow-keskustelussa](https://stackoverflow.com/questions/1376218/is-there-a-way-to-retrieve-the-autoincrement-id-from-a-prepared-statement).


### Ostoslistasovelluksen liittäminen DAO-luokkaan

Muuta tunnilla esiteltyä ja edellisessä tehtävässä kehittämääsi `ShoppingListApp`-ostoslistasovellusta siten, että **tietokantakyselyitä ei suoriteta enää samassa luokassa käyttöliittymän kanssa**. 

Sen sijaan käyttöliittymäluokkasi tulee hyödyntää DAO-luokkaa tietokannan käsittelyyn ja toimia olio-ohjelmointikäytäntöjen mukaisesti hyödyntäen listoja ja `ShoppingListItem`-olioiden metodeja.


### Extra 1: kovakoodatut ympäristökohtaiset asetukset ympäristömuuttujiin

*Tämä osa on valinnainen, mutta sitä suositellaan, mikäli olet saanut kaikki tähänastiset harjoitukset tehtyä.*

Usein samaa koodia suoritetaan lukuisissa erilaisissa ympäristöissä, kuten useiden eri kehittäjien omilla Windows-, Mac- ja Linux- koneilla. Kehittäjien henkilökohtaisten koneiden lisäksi sama koodi toimii tuotantoympäristössä, joka saattaa sijaita pilvipalvelussa tai konesalissa. Eri ympäristöissä tarvitaankin eri yhteysosoitteet, käyttäjätunnukset ja muita muuttuvia tietoja esimerkiksi tietokantojen käyttämiseksi.

Ympäristökohtaisia asetuksia ei haluta kirjoittaa suoraan ohjelmakoodiin, jotta koodia ei jouduta muuttamaan jokaista suoritusympäristöä varten. Toisaalta arkaluontoisia tietoja, kuten tietokantojen salasanoja, ei koskaan haluta tallentaa selkokielisinä ohjelmakoodiin tai versionhallintaan.

Yleinen tapa ratkaista edellä esitetty ongelma on asettaa ympäristökohtaisesti vaihtuvat arvot käyttöjärjestelmän **ympäristömuuttujiin**. Sovellus voi ympäristömuuttujien avulla käyttää esimerkiksi kehitys-, testi- tai tuotantokantaa ilman, että ohjelmakoodia muutetaan. Salaiset tiedot, kuten salasanat, jäävät myös pois ohjelmakoodista.


#### Ympäristömuuttujien hyödyntäminen

Ympäristömuuttujien arvoja voidaan Javassa lukea `System.getenv`-metodilla. Alla olevassa esimerkissä dao-luokkaan on luotu `connect`-niminen metodi yhteyden luomiseksi, jota muut saman luokan metodit kutsuvat. `connect`-metodi käyttää yhteysosoitteena ympäristömuuttujasta haettua yhteysosoitetta, eikä kovakoodattua merkkijonoa:

```java
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCShoppingListItemDao implements ShoppingListItemDao {

    // read the database connection String from an environment variable:
    private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");

    private Connection connect throws SQLException () {
        return DriverManager.getConnection(JDBC_URL);
    }
}
``` 

*Tämä esimerkki noudattaa [Heroku-sovellusalustan ympäristömuuttujakäytäntöä](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java#using-the-database_url-in-plain-jdbc).*

#### Ympäristömuuttujien asettaminen Eclipsessä

Voit soveltaa edellä esitettyä esimerkkiä omassa koodissasi tai kopioida sen itsellesi suoraan. Muutos edellyttää lähdekoodin muuttamisen lisäksi sitä, että siirrät aikaisemmin koodissa olleen kovakoodatun yhteysosoitteen Eclipsen suoritusasetuksiin. Voit Eclipsessä muokata ohjelmasi suoritusympäristöä seuraavan ohjeen mukaan: https://examples.javacodegeeks.com/desktop-java/ide/eclipse/eclipse-environment-variable-setup-example/.

Määrittele siis edellä mainitun ohjeen mukaisesti itsellesi Eclipseen ympäristömuuttuja `JDBC_DATABASE_URL`, joka sisältää JDBC-yhteysrivin esimerkiksi muodossa `jdbc:sqlite:c:\polku\tiedosto.sqlite`.

### Extra 2: DAO-luokan testaaminen JUnit-testillä

*Tämä osa on valinnainen, mutta sitä suositellaan, mikäli olet saanut kaikki tähänastiset harjoitukset tehtyä.*

Nyt kun tietokannan sijainti on konfiguroitavissa ympäristömuuttujilla, voit toteuttaa DAO-luokkasi metodeille yksikkötestit, jotka käyttävät eri tietokantaa kuin varsinainen `ShoppingListApp`-ohjelmaluokka. 

Luo itsellesi testejä varten kopio SQLite-tietokannasta (tiedostosta `shoppingList.sqlite`). Näin voit poistaa ja lisätä rivejä testeissä ilman, että se vaikuttaa ohjelman normaaliin käyttöön.

Aseta Eclipseen testiluokan suoritusasetuksista ympäristömuuttujaan testitietokannan sijainti edellisen vaiheen ohjeen mukaisesti, esim. `jdbc:sqlite:c:\polku\testit\tiedosto.sqlite`.

#### Tietokannan alustaminen testeissä

Tietokantaa hyödyntävän koodin testaaminen voi olla vaikeaa, mikäli tietokantaan jää edellisten testikertojen jäljiltä dataa, joka vaikuttaa testien suoritukseen seuraavalla kerralla. Tämän vuoksi [testitietokanta tyypillisesti tyhjennetään ja alustetaan aina samalla datalla](https://www.google.com/search?q=reset+database+between+junit+tests) ennen jokaista testitapausta. 

Voit kirjoittaa testiluokkaasi testien alustuksen erilliseen metodiin [`@BeforeEach`](https://howtodoinjava.com/junit5/before-each-annotation-example/)-annotaation avulla. JUnit suorittaa `@BeforeEach`-metodisi automaattisesti ennen jokaista `@Test`-metodia, joten tietokannassa on ennen jokaista testiä aina ennalta tiedossa oleva sisältö.

Voit lainata omaan testiisi alla esitettyä `@BeforeEach`-metodia, joka tyhjentää ensin `ShoppingListItem`-taulun ja lisää tauluun kaksi riviä ennen jokaista testiä:

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

## Tehtävän palauttaminen

Palauta kaikki tehtävässä kirjoittamasi lähdekoodit Teamsiin määräaikaan mennessä. Palauta tiedostot yksittäin, eli ei pakattuna.

Muistakaa kysyä kaikissa tehtäviin liittyvissä aiheissa Teamsissa!
