[⇦ takaisin kurssin etusivulle](../)

# Verkkosovellus kolmikerrosarkkitehtuurilla

Tällä viikolla tavoitteinamme on rakentaa kolmikerroksinen web-sovellus, joka yhdistää tähänasti opettelemamme erilliset teknologiat loogiseksi kokonaisuudeksi.

Jatkat tällä viikolla edellisellä viikolla aloittamasi web-projektin kehittämistä.

<!-- ## Malliratkaisu

Tämän tehtävän palautusaika on umpeutunut. Voit katsoa malliratkaisun täältä:

* [Video](https://web.microsoftstream.com/video/eae36e47-8f40-4d46-b010-ddea09587de7)
* [Servletit](https://github.com/haagahelia/embedded-tomcat-template/tree/kevat2020/src/main/java/servlet)
* [JSP-sivut](https://github.com/haagahelia/embedded-tomcat-template/tree/kevat2020/src/main/webapp/WEB-INF)
-->

## Oppitunnin videot

**[Tietokantaluokkien tuominen web-sovellukseen](https://web.microsoftstream.com/video/3998be63-0576-44e2-8e05-fb3da6008789)** <small>10:33</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/3998be63-0576-44e2-8e05-fb3da6008789?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tässä videossa lisäämme verkkopalveluumme aikaisemmalla viikolla toteuttamamme tietokantaluokat. Määrittelemme `Main`-luokallemme `JDBC_DATABASE_URL`-ympäristömuuttujan, jonka avulla verkkosovellus hyödyntää samaa tietokantaa kuin aikaisempi tekstikäyttöliittymämme.

&nbsp;


**[Tietokantapohjaisen servletin toteuttaminen ja tulosten näyttäminen JSP-sivulla](https://web.microsoftstream.com/video/515b523d-bc9b-4892-a2cf-78e75206e9a9)** <small>58:31</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/515b523d-bc9b-4892-a2cf-78e75206e9a9?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla lisäämme verkkopalvelumme tarvitsemat riippuvuudet Maven-työkalun avulla. Tietokantaluokat kopioidaan aikaisemmista harjoituksistamme, ja kopioinnin onnistuminen varmistetaan yksikkötesteillä.

Toteutamme lisäksi uuden servletin, joka näyttää JSP-sivun ja JSTL-tagien avulla tietokannassa olevat ostoslistan rivit. Käymme läpi tyypilliset ongelmatilanteet ja ratkaisut Tomcatin käynnistysongelmiin ja servletteihin liittyen. 

&nbsp;


**[JSP-sivujen ehtorakenteet ja "fail silently"-ominaisuus](https://web.microsoftstream.com/video/d4adda6c-9b93-4a0a-a92a-57067f3493fb)** <small>35:38</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/d4adda6c-9b93-4a0a-a92a-57067f3493fb?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla toteutamme servletin, joka välittää JSP-sivulle useita attribuutteja. Tutustumme myös `c:if`-ehtorakenteisiin ja JSP-sivujen virheenkäsittelyyn.

&nbsp;



## Kolmikerrosarkkitehtuuri

Sovellusten kehitettävyyden ja ylläpidettävyyden kannalta on tärkeää, että ne noudattavat jotain tiettyä arkkitehtuuria ja että niissä erilliset loogiset kokonaisuudet on toteutettu toisistaan irrallaan. Meidän ostoslistasovelluksessamme mukailemme kolmikerrosarkkitehtuuria ja MVC-mallia:

> *"Three-tier architecture is a client-server software architecture pattern in which the user interface (presentation), functional process logic ("business rules"), computer data storage and data access are developed and maintained as independent modules, most often on separate platforms."*
>
> [Multitier architecture, Wikipedia](https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture)

Meidän ostoslistasovelluksemme kolme kerrosta ovat:

* Käyttöliittymäkerros (JSP ja JSTL)
* Sovelluslogiikka (Servletit)
* Datan tallennuskerros (DAO + JDBC)


## JSTL (JSP Standard Tag Library)

Dynaamisten ominaisuuksien, kuten ehto- ja toistorakenteiden toteuttaminen JSP-sivuilla onnistuu kätevimmin hyödyntäen JSTL-kirjastoa, jonka avulla rakenteet voidaan toteuttaa XML-muotoisten tagien avulla. JSTL-kirjaston avulla voimme myös turvallisesti näyttää sivulla syötteinä saatuja merkkijonoja, jotka saattavat sisältää haitallista HTML-koodia.

Tutustu itsenäisesti seuraavaan videoon, jossa esitellään tagikirjaston käyttöönotto sekä sen keskeisiä tageja:


**[JSTL Tutorial part 2 Core Tags](https://youtu.be/R0EnI9_ZMA0)**

[![JSTL Tutorial part 2 Core Tags](https://img.youtube.com/vi/R0EnI9_ZMA0/mq1.jpg)](https://youtu.be/R0EnI9_ZMA0)

Tämä video esittelee, miten JSTL tagikirjasto lisätään JSP-sivulle `taglib`-direktiivin avulla. Opit myös käyttämään harjoituksessa tarvitsemiasi `c:out` ja `c:forEach` tageja. Video näyttää myös konkreettisesti, miten lista olioita voidaan välittää servletiltä JSP-sivulle ja miten sillä olevat Java-oliot saadaan esitettyä sivulla HTML-muodossa. Video on jatkoa viime viikon videolle [JSTL tutorial part 1](https://youtu.be/KmREMEhj5eE).


## DAO- ja Model-luokkien lisääminen projektiin

Olet aikaisemmassa tehtävässä luonut `ShoppingListITem`-luokan, joka mallintaa yksittäisiä tietokannassa olevia rivejä. Olet lisäksi luonut DAO-luokan, jonka avulla pystyt tekemään CRUD-operaatioita tietokantatauluusi. Tulet tässä tehtävässä tarvitsemaan näitä luokkia osana uutta sovellusta. Saat luokat helpoiten käyttöön web-projektissasi kopioimalla luokkien pakettirakenteen `src/main/java`-hakemiston alle. Valinnaisesti toteuttamasi JUnit-testiluokat puolestaan kuuluvat `src/test/java`-hakemiston alle.

Ohjelmasi hakemistorakenne voi olla luokkien lisäämisen jälkeen esimerkiksi seuraava:

```
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───database
│   │   │   │       JDBCShoppingListItemDao.java
│   │   │   │       ShoppingListItemDao.java
│   │   │   │
│   │   │   ├───launch
│   │   │   │       Main.java
│   │   │   │
│   │   │   ├───model
│   │   │   │       ShoppingListItem.java
│   │   │   │
│   │   │   └───servlet
│   │   │           ShoppingListServlet.java // luodaan tällä harjoituskierroksella
│   │   │
│   │   └───webapp
│   │       ├───styles
│   │       │       demo.css
│   │       │
│   │       └───WEB-INF
│   │               list.jsp // luodaan tällä harjoituskierroksella
│   │
│   └───test
│       ├───java
│       │   │
│       │   └───database
│       │           JDBCShoppingListItemDaoTest.java
```

**HUOM!** Mikäli käytit `JDBCShoppingListItemDao`-luokkasi kanssa ympäristömuuttujaa tietokannan osoitteen säilyttämisessä, joudut määrittelemään ympäristömuuttujan myös `Main`-luokan ympäristömuuttujiin.


## Riippuvuuksien asentaminen

Verkkoprojektissamme on käytössä Maven-automaatiotyökalu riippuvuuksien hallitsemiseksi. Sen avulla voimme lisätä tutut riippuvuudet, eli SQLite-ajurin ja JUnit-testikirjaston. Myös JSTL-tagikirjaston (JSP Standard Tag Library) asennus sujuu helpoiten lisäämällä se riippuvuutena `pom.xml`-tiedostoon. 

Toinen vaihtoehto olisi tallentaa riippuvuudet .jar-paketteina (Java Archive), kuten aikaisemmin tällä kurssilla teimme SQLite-kirjaston kanssa.


### pom.xml:n muokkaaminen

`pom.xml`-projektitiedosto on normaali XML-tiedosto, jota voit muokata esimerkiksi Eclipsen tekstieditorilla. Riippuvuuksien versionumerot on tapana määritellä `<properties>`-tagin sisään ja itse riippuvuudet `<dependencies>`-tagin sisään. Lisää plus-merkillä merkityt rivit pom.xml-tiedostoosi properties-tagin sisään (jätä `+`-merkit pois rivien alusta.):

```diff
 <properties>
     <!-- Tomcatin versionumero -->
     <tomcat.version>9.0.31</tomcat.version>

    <!-- lisää nämä rivit: -->
+    <sqlite.driver.version>3.30.1</sqlite.driver.version>
+    <junit.jupiter.version>5.6.0</junit.jupiter.version>
+    <jstl.api.version>1.2</jstl.api.version>
```

Tämä tapa esittää tiedoston uudet rivit vihreällä ja `+`-merkillä on myös gitin tapa esittää tiedostojen muutoksia. Lisätyt tagit määrittelevät seuraavat kolme uutta muuttujaa versionumeroita varten:

Muuttuja                | Versionumero  | Tarkoitus
------------------------|---------------|----------
sqlite.driver.version   | 3.30.1        | SQLite-ajuri JDBC-kirjastolle
junit.jupiter.version   | 5.6.0         | JUnit-yksikkötestikirjasto
jstl.api.version        | 1.2           | JSTL-tagikirjasto, jota tarvitset tässä tehtävässä

Itse riippuvuudet määritellään `<dependencies>`-tagin sisään, kukin riippuvuus omana `<dependency>`-tagina. Lisää seuraavat kolme riippuvuutta dependencies-tagin loppuun:


```diff
         <artifactId>tomcat-jsp-api</artifactId>
         <version>${tomcat.version}</version>
     </dependency>
+    <dependency>
+        <groupId>org.xerial</groupId>
+        <artifactId>sqlite-jdbc</artifactId>
+        <version>${sqlite.driver.version}</version>
+    </dependency>
+    <dependency>
+        <groupId>org.junit.jupiter</groupId>
+        <artifactId>junit-jupiter</artifactId>
+        <version>${junit.jupiter.version}</version>
+        <scope>test</scope>
+    </dependency>
+    <dependency>
+        <groupId>javax.servlet</groupId>
+        <artifactId>jstl</artifactId>
+        <version>${jstl.api.version}</version>
+    </dependency>
 </dependencies>
```

**Huom!** Esimerkkikoodien vihreiden rivien vasemmassa laidassa olevat plus-merkit (`+`) ovat osa muuttuneita rivejä korostavaa diff-syntaksia, jotka eivät kuulu mukaan pom-tiedostoon. 

Tallennettuasi muutetun `pom.xml`-tiedoston Eclipse käynnistää Maven-pluginin asentaakseen uudet riippuvuudet. Varmuuden vuoksi aina tämän tiedoston muokkaamisen jälkeen kannattaa vielä klikata projektia Eclipsen hakemistopuussa hiiren kakkospainikkeella ja valita [Maven-valikosta kohta "Update Project"](https://stackoverflow.com/a/20547404).


## Tehtävät

Näissä tehtävissä tarvitset aikaisempina viikkoina toteutettuja tietokantaluokkia. Mikäli tehtävät jäivät sinulta kesken tai et ole tyytyväinen koodisi toimintaan, voit käyttää tehtävän pohjana [malliratkaisun lähdekoodeja](/src/main/java/shoppinglist).


### Osa 1: Toteuta ostoslistan sisällön hakeva servletti ja sen `doGet`-metodi

Tarvitset ostoslistan esittämistä varten uuden servletin, joka voi löytyä palvelimeltasi esimerkiksi juuresta (`/`) tai polusta (`/list`). Voit vapaasti valita haluamasi polun, joka määritellään kuten edellisessä tehtävässä `@WebServlet("/")`-annotaation avulla. Yllä esitetyssä esimerkkihakemistorakenteessa tämän servletin tiedostonimi on `ShoppingListServlet.java`.

Tarvitset servletissä aikaisemmin toteuttamaasi DAO-luokkaa tuotteiden hakemista ja lisäämistä varten. Lisää servlet-luokkaan tarvittavat `import`-komennot DAO-luokkaa sekä sen hyödyntämää model-luokkaa varten.

`doGet`-metodin on tarkoitus hakea kaikki ostoslistan tuoterivit listana. Sen jälkeen servletin tulee välittää lista JSP-sivulle `HttpServletRequest`-olion `setAttribute`-metodin avulla. [Tämä YouTube-video](https://youtu.be/R0EnI9_ZMA0) havainnollistaa listan välittämisen JSP-sivulle sekä listan käyttämisen tagikirjaston avulla.


### Osa 2: Toteuta JSP-sivu ostoslistan sisällön esittämistä varten

Toteuta uusi JSP-sivu ostoslistan tuotteiden listaamista varten. Yllä esimerkkihakemistorakenteessa tämän sivun tiedostonimi on `list.jsp`. Tällä JSP-sivulla tarvitset aikaisemmin asentamaasi **JSTL-kirjastoa**, joka otetaan käyttöön sivulla `taglib`-direktiivin avulla:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
```

[Tehtävän videomateriaali (YouTube)](https://youtu.be/R0EnI9_ZMA0) näyttää, miten ostoslista voidaan käydä läpi `c:forEach`-tagin avulla ja miten tuoterivit tulostetaan turvallisesti `c:out`-tagin avulla.

Sivun HTML-rakenteella ei periaatteessa ole tämän tehtävän kannalta merkitystä, eli voit näyttää ostoslistan sisällön valintasi mukaan esimerkiksi listaelementeillä tai taulukolla:

```html
<!-- lista -->
<ul>
    <!-- TODO: Nämä rivit tulee generoida c:forEach-tagin avulla -->
    <li>Milk</li>
    <li>Eggs</li>
</ul>
```

```html
<!-- taulukko -->
<table>
    <thead>
        <tr><th>Product</th></tr>
    </thead>
    <tbody>
        <!-- TODO: Nämä rivit tulee generoida c:forEach-tagin avulla -->
        <tr><td>Milk</td></tr>
        <tr><td>Eggs</td></tr>
    </tbody>
</table>
```

### Injektioilta suojautuminen (Cross Site Scripting, XSS)

SQL-aiheen yhteydessä käytimme `PreparedStatement`-luokkaa välttääksemme tekstidatan tulkitsemisen SQL-lausekkeina (SQL-injektio). Koska **ostoslistan tuotteet ovat käyttäjien syöttämää dataa, myös ne saattavat sisältää mitä tahansa merkkijonoja**. On siis mahdollista, että käyttäjä kirjoittaa tuotteen nimeen **esimerkiksi HTML- tai JavaScript-koodia**, joka muuttaa sivun sisältöä haitallisesti toisen käyttäjän avatessa sivua (Cross Site Scripting, XSS). Voit lukea aiheesta lisää [täällä](https://owasp.org/www-community/attacks/xss/) (Open Web Application Security Project, OWASP).

HTML-koodin yhteydessä onkin erittäin tärkeää huolehtia siitä, että kaikki dynaaminen teksti enkoodataan siten, että esimerkiksi kulmasulkeita `<` ja `>` ei tulkita osaksi HTML-tageja, vaan pelkiksi kirjainmerkeiksi. `c:out`-tagi huolehtii juuri tästä ja muuttaa esimerkiksi `<`-merkin ns. HTML-entiteetiksi `&lt;`, jonka selain tulkitsee aina kirjainmerkiksi.

Esimerkiksi käyttähän syöttämä tuotenimi `"Milk <script>alert('attack!');</script>"` ei siis saa tuottaa HTML-sivulle sisältöä:

```html
<li>Milk <script>alert('attack!');</script></li>
```

`c:out`-tagin avulla käyttäjän syöte voidaan muuttaa turvalliseksi:

```html
<li>Milk &lt;script&gt;alert('attack!');&lt;/script&gt;</li>
```

Lue myös tarvittaessa keskustelu aiheesta ["what exactly does the &lt;c:out&gt; do?"](https://stackoverflow.com/q/291031) (StackOverflow)


### Osa 3: Toteuta lomake ja `doPost`-metodi uuden rivin lisäämiseksi ostoslistalle

Viimeiseksi tarvitsemme vielä lomakkeen uusien tuoterivien lisäämiseksi listalle, sekä käsittelijän, joka vastaanottaa lomakkeen tiedot ja kutsuu dao-luokan tallennusoperaatiota.

Voit lisätä lomakkeen samalle JSP-sivulle, jolla näytät myös tuotelistan. Lomakkeen HTML-koodiksi sopii esimerkiksi seuraava koodinpätkä:

```html
<form method="post">
    <input name="title" required type="text" placeholder="type item here..." autofocus /> 
    <input type="submit" value="Add to list" />
</form>
```

Tällä `form`-tagilla ei ole `action`-attribuuttia, joten sen lähettäminen tekee `post`-tyyppisen HTTP-pyynnön samaan osoitteeseen, josta sivu on ladattu. Voit tarvittaessa määritellä eri osoitteen lisäämällä `action`-attribuutin.

Pyynnön mukana välitetään käyttäjän kirjoittama tuotenimi, joka on palvelimella käsiteltävissä `title`-parametrin avulla. HTTP-parametrin nimi määräytyy `<input>`-elementin `name`-attribuutin mukaan.


### Lomaketietojen käsitteleminen palvelimella

Lomakkeen lähetyksen jälkeen se käsitellään palvelimella `doPost`-käsittelijämetodilla. Jos et määritellyt lomakkeelle `action`-attribuuttia, tulee pyyntö samalle servletille, jonka `doGet`-metodi palautti selaimelle lomakkeen HTML:n. 

Lisää servlettiin `doPost`-käsittelijä, joka lukee parametrina lähetetyn tuotenimen ja luo dao-luokan avulla uuden tuoterivin tietokantaan:

```java
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // todo: get the product title from request parameters
    // todo: use the title to create a new product object
    // todo: use the DAO to store the product object into the database
}
```

### Bonus: uudelleenohjaus POST-pyynnön jälkeen (Post/Redirect/Get)

Onnistuneen tuotteen lisäyksen jälkeen on hyvä tehdä uudelleenohjaus, eikä palauttaa vastaukseksi HTML-sivua. Uudelleenohjauksen johdosta selain tekee onnistuneen POST-pyynnön jälkeen uuden GET-tyyppisen pyynnön ohjaamallesi sivulle, joka käsitellään normaalisti servletin `doGet`-metodilla. Tämän seurauksena käyttäjä ei voi vahingossa käyttää selaimensa päivitä-toimintoa, ja toistaa POST-tyyppistä kutsua, joka saattaisi luoda saman rivin uudelleen.

Tätä ratkaisua kutsutaan osuvasti nimellä "[Post/Redirect/Get](https://en.wikipedia.org/wiki/Post/Redirect/Get)". Selaimen uudelleenohjauksen voi toteuttaa servletissä `HttpServletResponse`-olion `sendRedirect`-metodilla seuraavasti:

```java
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // todo: get the product title from request parameters
    // todo: use the title to create a new product object
    // todo: use the DAO to store the product object into database

    // after everything is done, send a redirect to create a GET request:
    resp.sendRedirect("/"); // redirects to server root (/), change the path if necessary
}
```

---

### Loppusanat

Olemme nyt jatkokehittäneet aikaisemmin toteuttamamme komentorivikäyttöliittymällä toimivan logiikan web-sovellukseksi. Ohjelmiston tarkoituksenmukainen rakenne on mahdollistanut koodin hyödyntämisen erilaisissa käyttötarkoituksissa.

Jotta ohjelma olisi lopulta hyödyllinen ostoslistasovellus, siihen tulisi vielä lisätä lukuisia ominaisuuksia, kuten tuoterivin poistaminen. Tutustumme hieman myöhemmin myös `doDelete`-metodiin, jonka avulla toteutamme rivien poistamisen ostoslistalta.