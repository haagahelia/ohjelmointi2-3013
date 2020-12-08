[⇦ takaisin kurssin etusivulle](../)

# Ajax, JSON ja JavaScript

Tämän viikon tehtävissä käytetään Javan lisäksi JavaScriptiä. Samalla törmäämme kokonaan uusiin käsitteisiin, kuten **asynkroniseen ohjelmointiin**, **tapahtumankuuntelijoihin** ja **promise-olioihin**. Ohjelmointikielen vaihtuminen ja uudet ohjelmointityylit kesken kurssin ovat merkittävä epäjatkuvuuskohta, jotka saattavat tehdä tästä aiheesta poikkeuksellisen haastavan. Älä kuitenkaan lannistu, mikäli aiheet ja tehtävät tuntuvat hankalilta. Ensimmäisessä tehtävässä ei ole lainkaan ohjelmointia ja seuraavatkin tehtävät ovat koodin määrässä mitattuina aikaisempia pienempiä. Voit myös aina kysyä vinkkejä Teamsissa, mikäli törmäät odottamattomaan virheilmoitukseen tai et tiedä miten edetä.


## Tämän osion tavoitteet

JavaScript-ohjelmointi, sivujen rakentaminen HTML-elementteinä ja elementtien ulkoasun määrittely CSS-tyyleillä ovat erittäin laajoja aiheita, joita käsitellään muilla kursseilla. Pyrimmekin tällä kurssilla minimoimaan sivun rakenteeseen ja ulkoasuun liittyvät aiheet, kuten HTML:n ja CSS:n. Sen sijaan tavoitteenamme on tutustua selaimen ja palvelimen väliseen tiedonsiirtoon ja siihen, miten voimme tehdä JavaScriptin avulla vaiheita sivun sisällön päivittämiseksi ja miten vastaamme näihin tarpeisiin palvelimellamme.


&nbsp;


## Video 1: [Johdanto single page app -sovelluksiin](https://web.microsoftstream.com/video/29e3d53f-0f16-4cea-8015-d3a1399ccf44) <small>26 min</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/29e3d53f-0f16-4cea-8015-d3a1399ccf44?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla teemme yleiskatsauksen viikon aiheeseen, materiaaleihin sekä tehtäviin.

Videolla esitettävää esimerkkisovellusta voi kokeilla osoitteessa [https://shoppinglist-example.herokuapp.com/](https://shoppinglist-example.herokuapp.com/). Esimerkkisovelluksen käynnistyminen saattaa kestää hetken ja siinä ei ole tukea eri käyttäjille, eli muiden käyttäjien lisäämät ja poistamat tuotteet vaikuttavat myös omaan ostoslistaasi. Esimerkkiprojektin dokumentaatio ja lähdekoodit löytyvät GitHubista osoitteesta [https://github.com/haagahelia/ShoppingListExample](https://github.com/haagahelia/ShoppingListExample).


&nbsp;



## Sovellusarkkitehtuurit: SPA ja MPA

Web-sovelluksia voidaan rakentaa hyvin erilaisilla arkkitehtuureilla. Tomcat, servletit ja JSP-sivut rakennetaan tyypillisesti [asiakas-palvelin-arkkitehtuurilla](https://www.google.com/search?q=client+server+architecture), jossa sovellus ja kaikki siihen liittyvä data sijaitsevat palvelimella, jolle asiakas tekee pyyntöjä. Palvelin suorittaa pyynnön täyttämiseksi tarvittavan logiikan ja muodostaa HTML-sivuja, jotka asiakas, eli selain, näyttää sellaisenaan käyttäjälle.

On olemassa myös muita tapoja rakentaa web-sovelluksia ja jakaa niitä osiin. Toinen tyypillinen arkkitehtuuri on Single Page Application (SPA). SPA-sovelluksissa osa sovelluslogiikasta suoritetaan käyttäjän selaimessa JavaScript-koodina, joka kommunikoi tarvittaessa taustapalvelimen kanssa. Tällöin selaimessa toimiva koodi vastaa tyypillisesti käyttöliittymästä, eli palvelin ei enää generoi HTML-sivuja, vaan tyypillisesti JSON- tai XML-muotoista dataa. Seuraavassa osiossa perehdymme JSON-tietomalliin ja REST-rajapintoihin.

Voit halutessasi perehtyä MPA- ja SPA-ohjelmistoarkkitehtuureihin syvemmin artikkelilla ["Single-page application vs. multiple-page application" (Neoteric, 2016)](https://medium.com/@NeotericEU/single-page-application-vs-multiple-page-application-2591588efe58) tai videolla ["SPAs vs MPAs/MVC - Are Single Page Apps always better?" (Academin, 2017)](https://youtu.be/F_BYg2QGsC0).

&nbsp;


## Koneluettavat rajapinnat, REST ja JSON

Sovelluslogiikan sijaitessa käyttäjän selaimessa, kohdistuu selaimen ja palvelimen väliseen tiedonsiirtoon erilaisia tarpeita. HTML-sivurakenteen sijasta JavaScript-koodissa halutaankin tyypillisesti käsitellä dataa olioina eikä HTML-elementteinä. Tätä tarkoitusta varten on kehitetty helposti koneluettava [JSON-tiedostomuoto (JavaScript Object Notation)](https://www.w3schools.com/js/js_json_intro.asp) sekä vakiintuneita tapoja JSON-vastausten hakemiseksi palvelimilta.

Katso seuraavat videot, joka käsittelevät tiedonsiirron peruskäsitteitä sekä REST-suunnitteluperiaatteet, joiden mukaisesti sovellukset vaihtavat usein tietoa koneluettavassa muodossa:

**[WebConcepts: REST API concepts and examples](https://youtu.be/7YcW25PHnAA)**

[![WebConcepts: REST API concepts and examples](https://img.youtube.com/vi/7YcW25PHnAA/hq1.jpg)](https://youtu.be/7YcW25PHnAA)

&nbsp;

**[Traversy Media: What Is A RESTful API? Explanation of REST & HTTP](https://youtu.be/Q-BpqyOT3a8)**

[![Traversy Media: What Is A RESTful API? Explanation of REST & HTTP](https://img.youtube.com/vi/Q-BpqyOT3a8/hq3.jpg)](https://youtu.be/Q-BpqyOT3a8)

&nbsp;


### JSON ja REST verkkosivujen ulkopuolella

Vaikka tällä viikolla käsittelemme tiedonsiirtoa verkkosivun näkökulmasta, REST-rajapinnat ja JSON-formaatti eivät suinkaan rajoitu pelkästään web-ohjelmointiin. JSON-tietoa voidaan käsitellä helposti käytännössä kaikilla moderneilla ohjelmointikielillä ja REST-rajapintoja hyödynnetään verkkosivujen lisäksi niin mobiilisovelluksissa, työpöytäsovelluksissa,  älykelloissa kuin muissakin sovellusympäristöissä.



## Video 2: [Single Page App -esimerkkisovellus osa 1: JavaScript- ja REST-ohjelmointi](https://web.microsoftstream.com/video/16aed7e1-55bc-4348-a0d9-876076fcb970) <small>34 min</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/16aed7e1-55bc-4348-a0d9-876076fcb970?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla tutustumme JSON-rajapinnan toteuttamiseen Java-sovelluksessa sekä rajapintaa hyödyntävän JavaScript-sovelluksen toimintalogiikkaan.

&nbsp;


### Video 3: [Single Page App -esimerkkisovellus osa 2: asynkroninen ohjelmointi, promiset ja async/await](https://web.microsoftstream.com/video/37d88eb6-d63c-4bb1-a654-dbb7e8e21687) <small>31 min</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/37d88eb6-d63c-4bb1-a654-dbb7e8e21687?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;" allowfullscreen style="border:none;"></iframe>

Tällä videolla käsittelemme tarkemmin JavaScript-koodin avulla tehtäviä palvelinkutsuja, joiden avulla voimme esimerkiksi päivittää ostoslistamme sisältöä tekemättä sivulatauksia.

&nbsp;


## Esimerkkiprojekti

Ajax-aiheen käsittelyä varten tälle kurssille on luotu oma erillinen esimerkkiprojekti. Projektin aihe on ostoslistasovellus, kuten aikaisemmissa harjoituksissamme, mutta tämä esimerkki on toteutettu hyödyntäen Ajax-teknologioita. Lue esimerkkiprojektin dokumentaatio osoitteessa [https://github.com/haagahelia/ShoppingListExample](https://github.com/haagahelia/ShoppingListExample). Samasta osoitteesta löydät myös lähdekoodit, jotka voit kloonata itsellesi ohjelman suorittamista ja muokkaamista varten. 

Jos et halua asentaa itsellesi omaa kopiota esimerkkisovelluksesta, voit käyttää sitä myös osoitteessa [https://shoppinglist-example.herokuapp.com/](https://shoppinglist-example.herokuapp.com/). Tämä versio on asennettu [Heroku](https://heroku.com/)-pilvipalveluun ilmaisena sovelluksena, joten sen käynnistyminen saattaa kestää hetken. Huomaathan myös, että ostoslistasovelluksessa ei ole tukea useille käyttäjille, eli muiden käyttäjien lisäämät ja poistamat tuotteet vaikuttavat myös omaan ostoslistaasi. Demosovelluksen ostoslistan sisältö palautetaan takaisin alkutilaan satunnaisin väliajoin.

Kun olet tutustunut esimerkkiprojektiin ja sen dokumentaatioon, etene seuraaviin kappaleisiin.


## Tehtävät

**Huom!** Kuten johdannossa jo todettiin, tämän viikon tehtävissä käytetään eri ohjelmointikieltä kuin aikaisemmilla viikoilla. Samalla törmäämme kokonaan uusiin käsitteisiin, kuten asynkroniseen ohjelmointiin, tapahtumankuuntelijoihin ja promise-olioihin. Älä lannistu, mikäli aiheet ja tehtävät osoittautuvat ylitsepääsemättömiksi. Perehdy asiaan parhaasi mukaan ja palauta ratkaisut niihin tehtäviin, jotka pystyt ratkaisemaan tälle kurssille varaamallasi työpanoksella.

Kurssin esimerkeissä ja ohjeissa hyödynnetään ainoastaan JavaScriptin standardikirjastoa, mutta voit halutessasi toteuttaa omat harjoituksesi esimerkiksi [jQuery-kirjaston](https://jquery.com/) avulla. 

### Video 4: [Ajax-tehtävien ohjeistus](https://web.microsoftstream.com/video/d25ce171-5ab8-4171-a1a9-179d8041ea45) <small>14 min</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/d25ce171-5ab8-4171-a1a9-179d8041ea45?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

&nbsp;

### Tehtävä 1: verkkoliikenteen tutkiminen

Tässä tehtävässä tutustumme esimerkkiprojektin tiedonsiirtoon sekä nettiselaimesi kehittäjätyökaluihin. Kehittäjätyökalujen tunteminen on erittäin tärkeää selainlogiikkaa kehitettäessä, koska esimerkiksi virheilmoitukset ja tiedonsiirrossa tapahtuneet virheet löytyvät ainoastaan kehittäjätyökalujen kautta.

Referenssiselaimena käytämme [Chromea](https://www.google.com/intl/fi_fi/chrome/) ja sen [DevTools](https://developers.google.com/web/tools/chrome-devtools)-työkaluja, mutta voit tehdä tehtävän millä tahansa selaimella, kunhan löydät ohjeet oman selaimesi vastaavien ominaisuuksien käyttämiseksi.

Katso video Chromen kehitystyökalujen käytöstä verkkoliikenteen tutkimiseksi:

**[Google Chrome Developer: Inspect Network Activity - Chrome DevTools 101](https://youtu.be/e1gAyQuIFQo)**

[![Google Chrome Developer: Inspect Network Activity - Chrome DevTools 101](https://img.youtube.com/vi/e1gAyQuIFQo/hq1.jpg)](https://youtu.be/e1gAyQuIFQo)

Hyödynnä videolla esitettyä työkalua ja tutki, mitä verkkoliikenteessä tapahtuu, kun lisäät [Ajax-esimerkkisovelluksessa](https://shoppinglist-example.herokuapp.com/) ostoslistalle uuden tuotteen. Selvitä, onko palvelimelle lähetettävässä POST-pyynnössä uudella tuoterivillä `id`-attribuuttia, ja jos on, mikä sen arvo on. [Ota kuvankaappaus](https://kb.iu.edu/d/afws) selaimesi kehittäjätyökalun näkymästä, jossa näkyy palvelimelta tullut vastaus JSON-muodossa. **Liitä kuvankaappaus tehtävän vastaukseesi Teamsiin.**


### Tehtävä 2: tapahtumankuuntelija

Toteuta edellisillä viikoilla aloittamaasi ostoslistasovellukseen uusi ominaisuus ostoslistan tuoterivien poistamiseksi. Mikäli ohjelmasi toimii puutteellisesti, voit hyödyntää tässä tehtävässä aikaisemman tehtävän malliratkaisua tai sen osia.

Lisää JSP-sivupohjaasi jokaisen tuoterivin kohdalle uusi painike kyseisen tuotteen poistamiseksi ostoslistalta. Lisää painikkeelle `onclick`-tapahtumankuuntelija, jonka klikkaaminen käynnistää JavaScript-funktion tuoterivin poistamiseksi. Tapahtumankuuntelija voidaan asettaa JavaScriptin avulla tai [kirjoittaa suoraan HTML-elementtiin](https://www.w3schools.com/jsref/event_onclick.asp):

```html
<!-- Painike, jota klikattaessa kutsutaan removeProduct-funktiota: -->
<button onclick="removeProduct(100)">Remove</button>
```

Jotta saat jokaiseen painikkeeseen juuri kyseistä tuotetta vastaavan poistettavan id:n, voit kirjoittaa aikaisemmilta viikoilta tutun JSP expression language -lausekkeen JavaScript-kutsun sisään:

```html
<!-- 
    product.getId() on Javaa, ja se suoritetaan palvelimella. 
    removeProduct() on JavaScriptiä, ja se suoritetaan selaimessa 
-->
<button onclick="removeProduct(${ product.getId() })">Remove</button>
```

Videosuositus: [JavaScript Tutorial For Beginners #40 - The onClick Event](https://youtu.be/XQEfWd1lh4Q)


### Tehtävä 3: tapahtumankäsittelijä

Kun olet toteuttanut painikkeen ja `onclick`-attribuutin, täytyy sinun kirjoittaa `removeProduct`-funktion varsinainen koodi. Voit kirjoittaa funktion samalle sivulle `<script>`-tagin sisään, tai [erilliseen JavaScript-tiedostoon](https://www.w3schools.com/tags/att_script_src.asp). JavaScript-koodisi voit kirjoittaa esimerkiksi hakemistoon `src/main/webapp/scripts/app.js`. Lisää tällöin JSP-sivullesi koodi:

```html
<script src="/scripts/app.js"></script>
```

Tapahtumankäsittelijän tulee saada parametriarvona poistettavan tuoterivin `id`, joka välitetään palvelimelle, jossa `id`-arvoa vastaava rivi poistetaan tietokannasta:

```javascript
async function removeProduct(id) {
    // TODO: kutsu fetch-funktiota parametrilla { method: 'DELETE' }
    // lähettääksesi poistopyynnön palvelimelle. Käytä parametrina saatua
    // id-arvoa fetch-kutsussa yksilöidäksesi poistettavan rivin.
}
```

Kutsu JavaScript-koodista palvelimelle kannattaa tehdä JavaScriptin `fetch`-funktiolla, jota käsitellään seuraavaksi.

#### DELETE-pyyntö, fetch ja promiset

Kuten ["What Is A RESTful API?"](https://youtu.be/Q-BpqyOT3a8)-videossa esitettiin, voidaan HTTP-protokollalla tuttujen `GET`- ja `POST`-pyyntöjen lisäksi lähettää myös mm. `DELETE`-tyyppisiä pyyntöjä. `DELETE`-pyyntöjä voidaan tehdä selaimella ainoastaan JavaScriptin avulla, eli niitä ei voida toteuttaa linkkien ja lomakkeiden avulla.

Käytä tuotteen poistopyynnön tekemisessä JavaScriptin `fetch`-funktiota, jolle voit määritellä vapaasti pyynnössä käytettävän HTTP-metodin. Katso seuraavat videot `fetch`-funktion ja sen palauttamien `Promise`-olioiden käyttämisestä:

**[Google Chrome Developers: Using the Fetch API](https://youtu.be/Ri7WRoRcl_U)**

[![Google Chrome Developers: Using the Fetch API](https://img.youtube.com/vi/Ri7WRoRcl_U/hqdefault.jpg)](https://youtu.be/Ri7WRoRcl_U)

> *"The Fetch API is a modern replacement for XMLHttpRequest. It includes much of the code you used to write for yourself: handling redirection and error codes, and decoding the result. This video gives you an easy introduction."*
>
> [Google Chrome Developers](https://youtu.be/Ri7WRoRcl_U)

&nbsp;

**[Google Chrome Developers: Intro to Promises (incl async/await)](https://youtu.be/7unX6hn5NA8)**

[![Google Chrome Developers: Intro to Promises (incl async/await)](https://img.youtube.com/vi/7unX6hn5NA8/hqdefault.jpg)](https://youtu.be/7unX6hn5NA8)

> *"Promises make asynchronous programming much easier than the traditional event-listener or callback approaches. This video explains promises, promise-chaining, and complex error-handling."*
>
> [Google Chrome Developers](https://youtu.be/7unX6hn5NA8)

&nbsp;

**[Google Chrome Developers: Get Started with Debugging JavaScript in Chrome DevTools](https://developers.google.com/web/tools/chrome-devtools/javascript/)**

[![Google Chrome Developers: Get Started with Debugging JavaScript in Chrome DevTools](https://img.youtube.com/vi/H0XScE08hy8/hqdefault.jpg)](https://developers.google.com/web/tools/chrome-devtools/javascript/)


> *"This tutorial teaches you the basic workflow for debugging any JavaScript issue in DevTools."*

&nbsp;

<!-- &nbsp;

**[Yhteenveto: Fetch-kutsut, Promiset ja Async/Await](https://web.microsoftstream.com/video/374c83a6-86b1-41a1-bd44-1d7a22d7ce05)** <small>15:09</small>

<iframe width="640" height="360" src="https://web.microsoftstream.com/embed/video/374c83a6-86b1-41a1-bd44-1d7a22d7ce05?autoplay=false&amp;showinfo=true" allowfullscreen style="border:none;"></iframe>

Tällä videolla esitellään fetch-kutsuja sekä niiden käsittelyä promise-olioiden ja await-avainsanan avulla konkreettisesti Shopping List App -esimerkkisovellusta käyttäen.
-->


<!--Voit lisäksi tutustua esimerkkisovelluksen `deleteItem`-funktioon [GitHubissa](https://github.com/haagahelia/ShoppingListExample/blob/master/src/main/webapp/js/app.js#L70-L81). Huomaa, että vaikka esimerkkiprojekti on toteutettu luokan ja olioiden avulla, ei sinun tarvitse tätä tehtävää varten toteuttaa muuta kuin yksittäinen funktio ilman luokkaa tai muita funktioita.-->


### Tehtävä 4: `doDelete`-metodin toteuttaminen servletissä

Edellisissä tehtävissä toteuttamasi `fetch`-palvelinkutsu tuottaa toistaiseksi HTTP-virheen 405, "Method Not Allowed". Tämä johtuu siitä, että toteuttamamme servletti pystyy toistaiseksi käsittelemään vain `POST`- ja `GET`-tyyppisiä pyyntöjä, mutta ei vielä lähettämäämme `DELETE`-pyyntöä.

Servlet-puolella `DELETE`-tyyppinen pyyntö voidaan käsitellä toteuttamalla `doDelete`-niminen metodi, jonka sisällä poistetaan rivi hyödyntäen DAO-luokkaa:

```java
@Override
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // TODO: selvitä mikä `id` annettiin pyynnön mukana
    // TODO: käytä dao-olioita id-arvoa vastaavan olion poistamiseksi kannasta
}
```

`doDelete` toimii kuten `doGet` ja `doPost`, eli voit hyödyntää parametrina saamaasi request-oliota ja sen `getParameter`-metodia selvittääksesi poistettavan rivin id:n. Id:n muuttaminen kokonaisluvuksi sekä DAO-olion kutsut tapahtuvat kuten aikaisemmilla viikoilla. Muista, että voit hyödyntää aikaisempien viikkojen malliratkaisuja, mikäli oma koodisi ei sisällä kaikkia tarvitsemiasi osia.


### Tehtävä 5: sivun sisällön päivittäminen poiston jälkeen

Kun pyyntö ostoslistan tuotteen poistamiseksi on lähetetty palvelimelle ja rivi on poistettu tietokannasta, on poistettu tuoterivi edelleen paikallaan HTML-sivulla 😕. Tämä johtuu siitä, että Ajax-pyyntö ei aiheuttanut uutta sivulatausta, eli sivun rakenne on edelleen sama kuin ennen painikkeen painamista.

Oikean rivin poistaminen HTML-sivulta on helppoa, mikäli rivillä on yksilöllinen `id`- tai `class`-attribuutti. Näin HTML-rakenteessa olevaa elementtiä pystytään käsittelemään JavaScript-koodissa suoraviivaisesti esimerkiksi `document.getElementById()`-metodin avulla. Metodi palauttaa sivulla olevan elementin JavaScript-oliona, ja sen sisältöä voidaan muuttaa tai se voidaan poistaa ohjelmallisesti. Voit lukea lisää `getElementById`-metodista [MDN web docs -palvelusta](https://developer.mozilla.org/en-US/docs/Web/API/Document/getElementById).

Seuraavassa esimerkkirakenteessa jokaiselle riville (`tr`) on lisätty yksilöllinen `id`-attribuutti:

```html
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="list-items">
        <tr id="product-1">
            <td class="title">Milk</td>
            <td><button onclick="removeProduct(1)">×</button></td>
        </tr>
        <tr id="product-2">
            <td class="title">Eggs</td>
            <td><button onclick="removeProduct(2)">×</button></td>
        </tr>
        <tr id="product-3">
            <td class="title">Bread</td>
            <td><button onclick="removeProduct(3)">×</button></td>
        </tr>
    </tbody>
</table>
```

Tällä rakenteella Milk-rivin sisältävää taulukon riviä voidaan käsitellä JavaScript-koodissa seuraavasti:

```js
let ekaRivi = document.getElementById('product-1');
```

Mikäli käytit tuotelistan rakenteessasi `<ul>`- ja `<li>`-elementtejä, sovella `id`-attribuutteja esimerkiksi näin: 

```html
<li id="product-3">Bread</li>
```

Tämän jälkeen käytä saamaasi id-arvoa `removeProduct`-funktiossa poistaaksesi yksittäisen tuoterivin taulukosta [getElementById- sekä remove-metodien avulla](https://www.w3schools.com/jsref/met_element_remove.asp):

```javascript
async function removeProduct(id) {
    // TODO: kutsu fetch-funktiota parametrilla { method: 'DELETE' }
    // lähettääksesi poistopyynnön palvelimelle. Käytä parametrina saatua
    // id-arvoa fetch-kutsussa yksilöidäksesi poistettavan rivin.

    let elementinId = "product-" + id;

    // TODO: käytä document.getElementById-metodia saadaksesi halutun elementin
    // TODO: kutsu poistettavan elementin remove()-metodia poistaaksesi 
    // sen sivulta
}
```


### Tehtävän palauttaminen

Palauta tähän tehtävään kuuluvat osat 1-5 Teams-palautuslaatikkoon erillisinä tiedostoina (ei pakettina). Muista lisätä myös tehtävässä 1 ottamasi kuvankaappaus Teamsiin. **Älä palauta koko projektia äläkä pakkaa tiedostoja.**


## Lisämateriaalit

[DWB, fetch API](https://davidwalsh.name/fetch)

[Google Developers, Introduction to fetch()](https://developers.google.com/web/updates/2015/03/introduction-to-fetch)

[Google Developers, JavaScript Promises: an Introduction](https://developers.google.com/web/fundamentals/primers/promises)

[A practical ES6 guide on how to perform HTTP requests using the Fetch API](https://www.freecodecamp.org/news/a-practical-es6-guide-on-how-to-perform-http-requests-using-the-fetch-api-594c3d91a547/)


## Loppusanat

Olemme tässä tehtävässä toteuttaneet yksittäisen ominaisuuden hyödyntäen Ajax-teknologioita. Sovelluksemme pääsääntöisesti noudattaa edelleen aikaisemmilta viikoilta tuttua arkkitehtuuria ja toimintamallia. Voit halutessasi jatkokehittää sovellukseesi lisää dynaamisia ominaisuuksia hyödyntäen esimerkkiprojektia ja löytämiäsi ohjeita.
