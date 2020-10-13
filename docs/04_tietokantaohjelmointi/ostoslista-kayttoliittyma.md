# Ostoslistasovelluksen käyttöliittymän luonti Scanner-luokan avulla

Tämän tehtävän kannalta ei ole oleellista, minkälaisen käyttöliittymän rakennat, kunhan sen kautta pystyy käyttämään tietokantaa ja näkemään tehtyjen muutosten vaikutukset.

Voit toteuttaa ohjelmasi omien mieltymystesi mukaan tai noudattaa seuraavan esimerkkisovelluksen toiminnallisuuksia:

```
Welcome to the shopping list app!
Available commands:
 list
 add [product name]
 remove [product name]
 help
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

> remove Eggs

Succesfully removed Eggs

> remove Cookies

Could not remove Cookies

> quit

Bye!
```

Esimerkkisovelluksessa käyttäjän syötettä pyydettäessä ruudulle tulostetaan `>` merkki syötteen odottamisen merkiksi: 

```java
System.out.print("> ");
```
Tulostaa:
```
>
```

Koska `>`-merkki tulostettiin `print` eikä `println`-metodilla, syöttää käyttäjä komentonsa samalle riville. Komennon jälkeen saattaa myös tulla komennosta riippuen muita arvoja:

```
> add Pepperoni pizza
```

Kokonaisuudessaan käyttäjä syötti siis merkkijonon `"add Pepperoni pizza"`, jossa `add` on komento ja `Pepperoni pizza` komentoon liittyvä lisättävä asia. Koodin tasolla tämä syöte voidaan lukea `Scanner`-olion avulla yhdessä tai kahdessa osassa:

```java
// näissä esimerkeissä input-muuttujassa on Scanner-olio!

String command = input.next(); // ensimmäinen sana riviltä: "add"
String parameter = input.nextLine(); // loppurivi: "Pepperoni pizza"
```

Jos merkkijono on luettu yhdessä osassa, voidaan se pilkkoa kahteen osaan esim. seuraavalla tavalla:

```java
String line = input.nextLine();

if (line.contains(" ")) {
    int firstWhitespace = line.indexOf(" ");
    command = line.substring(0, firstWhitespace);
    parameter = line.substring(firstWhitespace + 1);
} else {
    command = line;
}
```

Komennon ja siihen mahdollisesti liittyvän parametrin lukemisen jälkeen voidaan koodi haarauttaa joko Javan perusteista tutulla `if-else if-else`-ketjulla tai `switch case`-rakenteella:

```java
switch (command) {
case "quit":
    // quit the program
case "add":
    // store the given product in DB
    break;
case "remove":
    // try removing the product from the DB
    break;
case "list":
    // list all lines in DB
    break;
case "help":
    // print the help text
    break;
default:
    // print instructions on how to use this shopping list application
    break;
}
```

Koska ohjelman halutaan toimivan toistaiseksi ja kysyvän käyttäjän syötettä aina uudelleen, on edellä esitetyt syötteen kyselyt ja ehtorakenteet toteutettava jonkin toistorakenteen sisään.