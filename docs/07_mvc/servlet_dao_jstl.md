[⇦ takaisin kurssin etusivulle](../)

# Verkkosovellus kolmikerrosarkkitehtuurilla

Tällä viikolla tavoitteinamme on rakentaa kolmikerrosarkkitehtuuria noudattava web-sovellus, joka yhdistää tähän mennessä opettelemamme erilliset tietokanta- ja web-teknologiat yhdeksi loogiseksi kokonaisuudeksi.

Jatkat siis tällä viikolla edellisellä viikolla aloittamasi web-projektin kehittämistä ja tarvitset myös shopping list -tietokantaluokkiasi. Mikäli aikaisemmat aiheet ovat jääneet sinulta kesken, voit hyödyntää tällä viikolla myös kurssin malliratkaisuja, jotka julkaistaan edellisten tehtävien määräajan päätyttyä.

<!-- ## Malliratkaisu

Tämän tehtävän palautusaika on umpeutunut. Voit katsoa malliratkaisun täältä:

* [Video](https://web.microsoftstream.com/video/eae36e47-8f40-4d46-b010-ddea09587de7)
* [Servletit](https://github.com/haagahelia/embedded-tomcat-template/tree/kevat2020/src/main/java/servlet)
* [JSP-sivut](https://github.com/haagahelia/embedded-tomcat-template/tree/kevat2020/src/main/webapp/WEB-INF)
-->




## Sovelluksemme arkkitehtuuri

Sovellusten kehitettävyyden ja ylläpidettävyyden kannalta on tärkeää, että ne noudattavat jotain tiettyä arkkitehtuuria ja että niissä erilliset loogiset kokonaisuudet on toteutettu toisistaan irrallaan. Meidän ostoslistasovelluksessamme noudatamme kolmikerrosarkkitehtuuria ja MVC-mallia:

> *"Three-tier architecture is a client-server software architecture pattern in which the user interface (presentation), functional process logic ("business rules"), computer data storage and data access are developed and maintained as independent modules, most often on separate platforms."*
>
> [Multitier architecture, Wikipedia](https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture)

Model-View-Controller -suunnittelumallissa (MVC) sovelluksen eri vastuualueet eriytetään toisistaan sovelluksen sisällä kolmikerrosarkkitehtuurin mukaisesti malleihin, näkymiin, ja ohjauslogiikkaan. Tämä suunnittelumalli on tyypillinen erityisesti olio-ohjelmointiparadigmaa noudattavissa web-sovelluksissa ja suosittelen lukemaan aiheesta blogikirjoituksen ["MVC for dummies: malli, näkymä ja ohjain -arkkitehtuuri web-sovelluksissa " (Hurja, 2020)](https://www.hurja.fi/blogi/mvc-for-dummies-malli-nakyma-ja-ohjain-arkkitehtuuri-web-sovelluksissa/).

Näiden arkkitehtuurimallien mukaisesti sovelluksemme kolme osakokonaisuutta ovat siis:

1. datan tallennuskerros (model: dao, jdbc ja SQLite)
2. käyttöliittymäkerros (view: jsp ja jstl)
3. looginen kerros (controller: servlet)

Seuraavissa kappaleissa ja videoissa käsittelemme jo aikaisemmin toteuttamamme datan tallennuskerroksen tuomisen osaksi web-sovellustamme.


## DAO- ja Model-luokkien lisääminen projektiin

Olet aikaisemmassa tehtävässä luonut `ShoppingListITem`-luokan, joka mallintaa yksittäisiä tietokannassa olevia rivejä. Olet lisäksi luonut DAO-luokan, jonka avulla pystyt tekemään CRUD-operaatioita tietokantaasi. Tulet tällä viikolla tarvitsemaan näitä luokkia osana isompaa sovellusta. 

Saat valmiit luokat helpoiten käyttöön web-projektissasi kopioimalla luokkien pakettirakenteen `src/main/java`-hakemiston alle. Mahdollisesti toteuttamasi JUnit-testiluokat puolestaan kuuluvat `src/test/java`-hakemiston alle.

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

**HUOM!** Mikäli käytit `JDBCShoppingListItemDao`-luokkasi kanssa ympäristömuuttujaa tietokannan osoitteen säilyttämisessä, määrittele sama ympäristömuuttuja myös `launch.Main`-luokan ympäristömuuttujiin.


## Video 1: [Tietokantaluokkien tuominen web-sovellukseen](https://web.microsoftstream.com/video/3998be63-0576-44e2-8e05-fb3da6008789) <small>10:33</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/3998be63-0576-44e2-8e05-fb3da6008789?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tässä videossa lisäämme verkkopalveluumme aikaisemmalla viikolla toteuttamamme tietokantaluokat. Lisäämme `Main`-luokallemme `JDBC_DATABASE_URL`-ympäristömuuttujan, jonka avulla verkkosovellus hyödyntää samaa tietokantaa kuin aikaisempi tekstikäyttöliittymämme.

Tällä videolla esiintyvät lähdekoodit löydät JDBC ja DAO -tehtävien malliratkaisuista Teamsissa.

&nbsp;



## Riippuvuuksien asentaminen

Omien lähdekooditiedostojemme lisäksi tarvitsemme web-projektiimme sen ulkoiset riippuvuudet, eli SQLite-ajurin ja JUnit-testikirjaston. Projektipohjassa on valmiiksi käytössä Maven-automaatiotyökalu riippuvuuksien hallitsemiseksi. Aikaisempien riippuvuuksien ja uuden JSTL-tagikirjaston (JSP Standard Tag Library) asennus sujuu helpoiten lisäämällä se riippuvuutena Mavenin hyödyntämään `pom.xml`-tiedostoon. 

<!--Toinen vaihtoehto olisi tallentaa riippuvuudet .jar-paketteina (Java Archive), kuten aikaisemmin tällä kurssilla teimme SQLite-kirjaston kanssa.-->


### Riippuvuuksien määrittely pom.xml:ään

Tomcat-projektipohjan juurihakemistossa sijaitseva `pom.xml`-projektitiedosto on normaali XML-tiedosto, jota voit muokata esimerkiksi Eclipsen tekstieditorilla. Avatessasi tiedostoa Eclipse saattaa avata sen "Overview"-näkymässä, jolloin voit vaihtaa näkymän klikkaamalla sen alalaidan `pom.xml`-välilehteä [tämän videon mukaisesti](https://javavids.com/video/open-xml-in-pomxml-by-default-in-eclipse).

Tehdessäsi muutoksia ja tallentaessasi tiedoston Eclipsen Maven-lisäosa asentaa automaattisesti uudet riippuvuudet projektiisi.

### Versionumeroiden määritteleminen

Riippuvuuksien versionumerot on tapana määritellä projektitiedostoon `<properties>`-tagin sisään ja itse riippuvuudet `<dependencies>`-tagin sisään. Lisää plus-merkillä merkityt rivit pom.xml-tiedostoosi properties-tagin sisään (huom, jätä `+`-merkit pois rivien alusta):

```diff
 <properties>
     <!-- Tomcatin versionumero -->
     <tomcat.version>9.0.31</tomcat.version>

    <!-- lisää nämä rivit: -->
+    <sqlite.driver.version>3.30.1</sqlite.driver.version>
+    <junit.jupiter.version>5.6.0</junit.jupiter.version>
+    <jstl.api.version>1.2</jstl.api.version>
```

Yllä käytetty tapa esittää tiedoston uudet rivit vihreällä sekä `+`-merkillä on myös gitin tapa esittää tiedostojen muutoksia. Lisätyt tagit määrittelevät seuraavat kolme uutta muuttujaa versionumeroita varten:

Muuttuja                | Versionumero  | Tarkoitus
------------------------|---------------|----------
sqlite.driver.version   | 3.30.1        | SQLite-ajuri JDBC-kirjastolle
junit.jupiter.version   | 5.6.0         | JUnit-yksikkötestikirjasto
jstl.api.version        | 1.2           | JSTL-tagikirjasto

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


## JSTL (JSP Standard Tag Library)

Dynaamisten ominaisuuksien, kuten ehto- ja toistorakenteiden toteuttaminen JSP-sivuilla onnistuu kätevimmin hyödyntäen edellä projektiimme lisättyä JSTL-kirjastoa. JSTL-kirjaston avulla esimerkiksi ehto- ja toistorakenteet voidaan toteuttaa JSP-sivuille XML-muotoisten tagien avulla (`c:if`- ja `c:forEach`-tagit). JSTL-kirjaston avulla voimme myös turvallisesti näyttää sivulla syötteinä saatuja merkkijonoja, jotka saattavat sisältää haitallista HTML-koodia (`c:out`-tagi).

Katso seuraava video, jossa esitellään tagikirjaston käyttöönotto sekä sen keskeisiä tageja:

**YouTube: [JSTL Tutorial part 2 Core Tags](https://youtu.be/R0EnI9_ZMA0)**

<!--[![JSTL Tutorial part 2 Core Tags](https://img.youtube.com/vi/R0EnI9_ZMA0/hq1.jpg)](https://youtu.be/R0EnI9_ZMA0)-->

> *Tämä video esittelee, miten JSTL tagikirjasto lisätään JSP-sivulle `taglib`-direktiivin avulla. Opit myös käyttämään `c:out` ja `c:forEach` tageja. Video näyttää myös konkreettisesti, miten lista olioita voidaan välittää servletiltä JSP-sivulle ja miten sillä olevat Java-oliot saadaan esitettyä sivulla HTML-muodossa. Video on jatkoa viime viikon videolle [JSTL tutorial part 1](https://youtu.be/KmREMEhj5eE).*


## Video 2: [Tietokantapohjaisen servletin toteuttaminen ja tulosten näyttäminen JSP-sivulla](https://web.microsoftstream.com/video/515b523d-bc9b-4892-a2cf-78e75206e9a9) <small>58:31</small>

Seuraavalla videolla lisäämme verkkopalvelumme tarvitsemat riippuvuudet ohjeen mukaisesti Maven-työkalun avulla. Tietokantaluokat kopioidaan aikaisemmista harjoituksistamme ja kopioinnin onnistuminen varmistetaan yksikkötesteillä. Lopulta näytämme tietokannasta löytyvät ostoslistan rivit HTML-muodossa JSP-sivulla:

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/515b523d-bc9b-4892-a2cf-78e75206e9a9?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Videolla esitellään lisäksi tyypillinen ongelma Tomcatin käynnistämisessä, joka johtuu siitä, että vanha Tomcat-suoritus on edelleen käynnissä taustalla (kohta 15:30).

Tärkeä aihe web-palvelun suojaamiseksi haitallisilta JavaScript-koodeilta (Cross Site Scripting, XSS) esitellään videolla kohdassa 44:13.

&nbsp;

<!--Videolla muokattavan [pom.xml-tiedoston, ShoppingListServlet-luokan ja list.jsp-tiedoston lähdekoodit löydät täältä](https://gist.github.com/swd1tn002/c2adb55f198846d6f44bf6d96275dead).-->


## Video 3: [JSP-sivujen ehtorakenteet ja "fail silently"-ominaisuus](https://web.microsoftstream.com/video/d4adda6c-9b93-4a0a-a92a-57067f3493fb) <small>31:21</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/d4adda6c-9b93-4a0a-a92a-57067f3493fb?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla toteutamme servletin, joka välittää JSP-sivulle useita attribuutteja. Tutustumme myös `c:if`-ehtorakenteisiin ja JSP-sivujen virheenkäsittelyyn. 

<!--Videolla käsiteltävän [SummerCountdownServlet.java-luokan ja countdown.jsp-sivun löydät täältä](https://gist.github.com/swd1tn002/1a9eac1b32179a8411e6f611ef0f731a).-->

&nbsp;


## Tehtävät

Näissä tehtävissä tarvitset aikaisempina viikkoina toteutettuja tietokantaluokkia. Mikäli tehtävät jäivät sinulta kesken tai et ole tyytyväinen koodisi toimintaan, voit käyttää tehtävän pohjana malliratkaisun lähdekoodeja, jotka julkaistaan kurssin Teams-kanavalla tehtävien määräajan päätyttyä.

Tehtävät liittyvät vahvasti edellä esitettyihin videoihin, joten videoiden katsominen on suositeltavaa.


### Osa 1: Toteuta ostoslistan sisällön hakeva servletti ja sen `doGet`-metodi

Tarvitset ostoslistan esittämistä varten uuden servletin, joka voi löytyä palvelimeltasi esimerkiksi juuresta (`/`) tai polusta (`/list`). Voit vapaasti valita haluamasi polun, joka määritellään kuten edellisessä tehtävässä, eli `@WebServlet("/")`-annotaation avulla. Ylempänä esitetyssä esimerkkihakemistorakenteessa tämän servletin tiedostonimi on `ShoppingListServlet.java`, mutta voit nimetä tiedoston haluamallasi tavalla.

Tarvitset servletissä aikaisemmin toteuttamaasi DAO-luokkaa tuotteiden hakemista ja lisäämistä varten. Lisää servlet-luokkaan tarvittavat `import`-komennot DAO-luokkaa sekä model-luokkaa varten.

`doGet`-metodin on tarkoitus hakea kaikki ostoslistan tuoterivit listana. Sen jälkeen servletin tulee välittää kyseinen lista seuraavassa osassa toteutettavalle JSP-sivulle `setAttribute`-metodin avulla. [Tämä YouTube-video](https://youtu.be/R0EnI9_ZMA0) havainnollistaa listan välittämisen JSP-sivulle sekä listan käyttämisen tagikirjaston avulla.


### Osa 2: Toteuta JSP-sivu ostoslistan sisällön esittämistä varten

Toteuta tietokannasta haettujen ostoslistan tuoterivien näyttämiseksi uusi JSP-sivu. Yllä esimerkkihakemistorakenteessa tämän sivun tiedostonimi on `list.jsp`, mutta voit nimetä tiedoston myös muulla tavalla. Tällä JSP-sivulla tarvitset aikaisemmin asentamaasi **JSTL-kirjastoa**, joka otetaan käyttöön sivulla `taglib`-direktiivin avulla:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
```

Ylempänä sivulta löytyvä video 2 näyttää, miten ostoslista voidaan käydä läpi `c:forEach`-tagin avulla ja miten tuoterivit tulostetaan turvallisesti `c:out`-tagin avulla.

Sivun HTML-rakenteella ei ole tämän tehtävän kannalta suurta merkitystä, kunhan ratkaisusi on järkevää HTML-koodia. Voit näyttää ostoslistan sisällön valintasi mukaan esimerkiksi `<ul>`- ja `<li>`-listaelementeillä ([ohje](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li)):

```html
<!-- lista -->
<ul>
    <!-- TODO: Nämä rivit tulee generoida c:forEach-tagin avulla -->
    <li>Milk</li>
    <li>Eggs</li>
</ul>
```

Vaihtoehtoisesti voit luoda `<table>`-taulukkorakenteen esimerkiksi seuraavasti ([ohje](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table)):

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

SQL-aiheen yhteydessä käytimme `PreparedStatement`-luokkaa välttääksemme tekstidatan tulkitsemisen SQL-lausekkeina (SQL-injektio). Koska **ostoslistan tuotteet ovat käyttäjien syöttämää dataa, myös ne saattavat sisältää mitä tahansa merkkijonoja**. On siis mahdollista, että käyttäjä kirjoittaa tuotteen nimeen **esimerkiksi HTML- tai JavaScript-koodia**, joka muuttaa sivun sisältöä haitallisesti toisen käyttäjän avatessa sivua. Tästä haavoittuvuudesta käytetään termiä Cross Site Scripting (XSS). Voit lukea aiheesta lisää [Open Web Application Security Project -projektin sivuilla (OWASP)](https://owasp.org/www-community/attacks/xss/).

HTML-koodin yhteydessä onkin erittäin tärkeää huolehtia siitä, että kaikki dynaaminen teksti enkoodataan siten, että esimerkiksi kulmasulkeita `<` ja `>` ei tulkita osaksi HTML-tageja, vaan pelkiksi kirjainmerkeiksi. `c:out`-tagi huolehtii juuri tästä ja muuttaa esimerkiksi `<`-merkin ns. HTML-entiteetiksi `&lt;`, jonka selain tulkitsee aina kirjainmerkiksi.

> *"An HTML entity is a piece of text ("string") that begins with an ampersand (&) and ends with a semicolon (;) . Entities are frequently used to display reserved characters (which would otherwise be interpreted as HTML code), and invisible characters (like non-breaking spaces)."*
>
> *MDN web docs. Entity. [https://developer.mozilla.org/en-US/docs/Glossary/Entity](https://developer.mozilla.org/en-US/docs/Glossary/Entity)*

Esimerkiksi käyttäjän syöttämä tuotenimi `"Milk <script>alert('attack!');</script>"` ei siis saa tuottaa HTML-sivulle sisältöä:

```html
<li>Milk <script>alert('attack!');</script></li>
```

`c:out`-tagin avulla käyttäjän syöte voidaan muuttaa turvalliseksi:

```html
<li>Milk &lt;script&gt;alert(&#039;attack!&#039;);&lt;/script&gt;</li>
```

Lue myös tarvittaessa keskustelu aiheesta ["what exactly does the &lt;c:out&gt; do?"](https://stackoverflow.com/q/291031)


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

Pyynnön mukana välitetään käyttäjän kirjoittama tuotenimi, joka on palvelimella käsiteltävissä sillä nimellä, joka on määritetty kyseisen tekstikentän `name`-attribuutin arvoksi:

```html
<input name="title" />
```

Tässä tapauksessa attribuutin arvona on `title`, joten se saadaan servletissä luettua esimerkiksi seuraavasti:

```
String itemTitle = req.getParameter("title");
```

### Lomaketietojen käsitteleminen palvelimella

Lomakkeen lähetyksen jälkeen se käsitellään palvelimella joko `doGet` tai `doPost`-käsittelijämetodilla. Käytettävä metodi riippuu siitä, mikä HTTP-metodi on määritetty sivun lomakkeelle. Tässä tehtävässä lomake lähetetään post-metodilla:

```html
<form method="post">
```

Jos et määritellyt lomakkeelle erillistä `action`-attribuuttia, lähetetään pyyntö samaan osoitteeseen josta HTML-sivu ladattiin. Meidän tapauksessamme pyyntö päätyy siis samalle servletille, tällä kertaa `doPost`-metodille.

Lisää omaan servlettiisi uusi `doPost`-metodi, joka lukee parametrina lähetetyn tuotenimen ja lisää tietokantaan uuden tuoterivin kyseisellä nimellä. Huom! Noudata MVC-mallia ja hyödynnä DAO-luokkaa, äläkä tee tietokantaoperaatiota servlet-luokassasi:

```java
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // todo: get the product title from request parameters
    // todo: use the title to create a new product object
    // todo: use the DAO to store the product object into the database
}
```

### Bonus: uudelleenohjaus POST-pyynnön jälkeen (Post/Redirect/Get)

> "*The post / redirect / get pattern or PRG pattern is a development approach that prevents duplicate content when submitting forms and provides a more intuitive user interface. The post-redirect-get pattern allows you to set bookmarks, share URLs, and reload a website that queries and sends form data - without creating duplicate content or near duplicate content.*"
>
> *Ryte Wiki. Post-Redirect-Get. [https://en.ryte.com/wiki/Post-Redirect-Get](https://en.ryte.com/wiki/Post-Redirect-Get)*

Onnistuneen POST-tyyppisen lomakkeen lähetyksen jälkeen on aina hyvä tehdä uudelleenohjaus, eli pyytää selainta lataamaan sivu GET-pyynnöllä. Tällä tavoin käyttäjä ei voi esimerkiksi vahingossa käyttää selaimensa päivitä-toimintoa tai sivuhistoriaa ja toistaa POST-tyyppistä kutsua, joka saattaisi luoda esimerkiksi tietokantaan saman rivin uudelleen.

POST-pyyntöihin vastaamista uudelleenohjauksilla kutsutaan osuvasti nimellä ["Post/Redirect/Get"](https://en.wikipedia.org/wiki/Post/Redirect/Get)". Selaimen uudelleenohjauksen voi käytännössä toteuttaa servletissä `HttpServletResponse`-olion `sendRedirect`-metodilla seuraavasti:

```java
resp.sendRedirect("/polku/johon/ohjataan");
```

Käytännössä `"/polku/johon/ohjataan"` on tyypillisesti sama polku, joka on määritetty servletin osoitteeksi `@WebServlet`-annotaatiolla.

---

### Loppusanat

Olemme nyt jatkokehittäneet aikaisemmin toteuttamamme komentorivikäyttöliittymällä toimivan logiikan web-sovellukseksi. Ohjelmiston tarkoituksenmukainen rakenne on mahdollistanut koodin hyödyntämisen erilaisissa käyttötarkoituksissa.

Jotta ohjelma olisi lopulta hyödyllinen ostoslistasovellus, siihen tulisi vielä lisätä lukuisia ominaisuuksia, kuten tuoterivin poistaminen. Tutustumme hieman myöhemmin myös `doDelete`-metodiin, jonka avulla toteutamme rivien poistamisen ostoslistalta.