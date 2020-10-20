[⇦ takaisin kurssin etusivulle](../)

# Map-tietorakenne

Olemme ohjelmointi 1:ssä käyttäneet listoja (`ArrayList<String>`) tai taulukoita (`String[]`), kun olemme halunneet käsitellä useita saman typpisiä asioita. Javassa on myös lukuisia muita kokoelmia, joihin voimme koota dataa. Kokoelma tarkoittaa yksinkertaisesti oliota, joka kokoaa alkioita yhteen ([Oracle.com](https://docs.oracle.com/javase/tutorial/collections/intro/index.html)).

Java Collections Framework sisältää mm. seuraavat rajapinnat ja luokat:

* List (ArrayList ja LinkedList)
* Map (HashMap ja TreeMap)
* Set (HashSet ja TreeSet)
* Queue, Stack, jne (ei käsitellä tällä kurssilla)

Tällä kurssilla keskitymme Javan Map-tietorakenteeseen ja erityisesti sen HashMap-toteutukseen, eli ns. hajautustauluun.

Opiskelun tueksi erinomainen lisämateriaali hajautustauluista on Helsingin yliopiston MOOC-oppimateriaali [https://ohjelmointi-20.mooc.fi/osa-8/2-hajautustaulu](https://ohjelmointi-20.mooc.fi/osa-8/2-hajautustaulu), jonka sisältöä on lainattu myös tässä materiaalissa ja materiaaliin liittyvissä videoissa ja tehtävissä.


## Map-tietorakenne

> *Hajautustaulu eli HashMap on ArrayListin lisäksi eniten käytettyjä Javan valmiiksi tarjoamia tietorakenteita. Hajautustaulua käytetään kun tietoa käsitellään avain-arvo -pareina, missä avaimen perusteella voidaan lisätä, hakea ja poistaa arvo.*
>
> [Agile Education Research –tutkimusryhmä, mooc.fi](https://ohjelmointi-20.mooc.fi/osa-8/2-hajautustaulu)

`HashMap` voidaan ottaa käyttöön `import`-komennolla seuraavasti:

```java
import java.util.HashMap;
```

Toisin kuin listoissa, arvoja ei käsitellä pelkästään numeeristen indeksien avulla, vaan voimme määritellä avaimiksi halutessamme vaikka merkkijonoja:

```java
HashMap<String, String> postinumerot = new HashMap<String, String>();

postinumerot.put("00710", "Helsinki");
postinumerot.put("90014", "Oulu");
postinumerot.put("33720", "Tampere");
postinumerot.put("33014", "Tampere");

System.out.println(postinumerot.get("00710")); // tulostaa "Helsinki"

```

Yllä esitetty koodi muodostaa kutakuinkin seuraavanlaisen tietorakenteen, jossa jokainen avain viittaa sille asetettuun arvoon:

Avain   | Arvo
--------|-----------
"00710" | "Helsinki"
"90014" | "Oulu"
"33720" | "Tampere"
"33014" | "Tampere"

Tämän esimerkki on lainattu [Helsingin yliopiston Agile Education Research –tutkimusryhmän oppimateriaalista](https://ohjelmointi-20.mooc.fi/osa-8/2-hajautustaulu), joka on lisensoitu Creative Commons BY-NC-SA-lisenssillä. 


### [Map, osa 1](https://video.haaga-helia.fi/media/Map%2C+osa+1/0_airjor6f) <small>9:01</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_airjor6f&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_ayumj3u9" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

[PowerPoint-kalvot](./map.pdf)

&nbsp;

### [Map, osa 2](https://video.haaga-helia.fi/media/Map%2C+osa+2A+useita+arvoja+samalla+avaimella/0_diu5meln) <small>16:11</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_diu5meln&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_4a1w3y5k" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

[PowerPoint-kalvot](./map.pdf)

&nbsp;


### Syventävä video: [mapin sisällön läpikäynti](https://video.haaga-helia.fi/media/Map%2C+osa+3A+mapin+sis%C3%A4ll%C3%B6n+l%C3%A4pik%C3%A4ynti/0_7p4i6rfv) <small>4:02</small>

<iframe src="https://d38ynedpfya4s8.cloudfront.net/p/288/sp/28800/embedIframeJs/uiconf_id/23448708/partner_id/288?iframeembed=true&playerId=kaltura_player&entry_id=0_7p4i6rfv&flashvars[streamerType]=auto&amp;flashvars[localizationCode]=en&amp;flashvars[leadWithHTML5]=true&amp;flashvars[sideBarContainer.plugin]=true&amp;flashvars[sideBarContainer.position]=left&amp;flashvars[sideBarContainer.clickToClose]=true&amp;flashvars[chapters.plugin]=true&amp;flashvars[chapters.layout]=vertical&amp;flashvars[chapters.thumbnailRotator]=false&amp;flashvars[streamSelector.plugin]=true&amp;flashvars[EmbedPlayer.SpinnerTarget]=videoHolder&amp;flashvars[dualScreen.plugin]=true&amp;flashvars[hotspots.plugin]=1&amp;flashvars[Kaltura.addCrossoriginToIframe]=true&amp;&wid=0_um1myohm" width="608" height="402" allowfullscreen webkitallowfullscreen mozAllowFullScreen allow="autoplay *; fullscreen *; encrypted-media *" sandbox="allow-forms allow-same-origin allow-scripts allow-top-navigation allow-pointer-lock allow-popups allow-modals allow-orientation-lock allow-popups-to-escape-sandbox allow-presentation allow-top-navigation-by-user-activation" frameborder="0" title="Kaltura Player"></iframe>

[PowerPoint-kalvot](./map.pdf)

&nbsp;

#### Arvojen poistaminen tai tarkastaminen (`remove` ja `containsKey`)

```java
HashMap<String, String> maat = new HashMap<>();

maat.put("Suomi", "Finland");
maat.put("Ruotsi", "Sweden");
maat.put("Norja", "Norway");

boolean onRuotsi = maat.containsKey("Ruotsi"); // true

onRuotsi.remove("Ruotsi");

onRuotsi = maat.containsKey("Ruotsi"); // false

```