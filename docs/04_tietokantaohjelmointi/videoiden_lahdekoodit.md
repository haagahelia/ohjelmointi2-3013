## src/main/java/tietokanta/TietokantaanYhdistaminen.java

```java
package tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TietokantaanYhdistaminen {
    private static final String URL = "jdbc:sqlite:C:\\sqlite\\shoppingList.sqlite";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection yhteys = DriverManager.getConnection(URL);

        PreparedStatement kysely = yhteys.prepareStatement("SELECT * FROM ShoppingListItem");

        ResultSet tulokset = kysely.executeQuery();

        while (tulokset.next()) {
            long id = tulokset.getLong("id");
            String tuotenimi = tulokset.getString("title");

            System.out.println(id + " " + tuotenimi);
        }

        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna lisättävän tuotteen nimi: ");
        String syote = lukija.nextLine();

        PreparedStatement insertKysely = yhteys.prepareStatement("INSERT INTO ShoppingListItem (title) VALUES (?)");
        insertKysely.setString(1, syote);

        int rivit = insertKysely.executeUpdate();
        System.out.println("Lisättiin " + rivit + " riviä");

        // suljetaan kaikki resurssit
        tulokset.close();
        kysely.close();
        insertKysely.close();
        yhteys.close();
        lukija.close();
    }
}
```