
### SQLite-komentorivityökalun käyttö

SQLite-komentorivityökalulla voit antaa kahdenlaisia komentoja:
1. SQL-kyselyitä (normaali SQL-kysely, joka päättyy puolipisteeseen)
2. Komentorivityökalun omia komentoja (rivi aloitetaan pisteellä, loppuun ei puolipistettä)

Seuraavassa komentorivi-istunnossa lyhyt esimerkki [Chinook-tietokannan](https://github.com/lerocha/chinook-database/raw/master/ChinookDatabase/DataSources/Chinook_Sqlite.sqlite) avaamisesta (`.open Chinook_Sqlite.sqlite`), tulosteiden muotoilusta (`.headers on` ja `.mode column`),rakenteen tutkimisesta (`.tables`, `.schema Artist`) sekä kyselyiden tekemisestä (`SELECT * FROM Artist LIMIT 3;`). 

[Katso myös video!](https://video.haaga-helia.fi/media/SQLite+tools/0_pez4r54j).

```sql
PS C:\sqlite> .\sqlite3.exe

SQLite version 3.20.1 2017-08-24 16:21:36
Enter ".help" for usage hints.

sqlite> .open Chinook_Sqlite.sqlite
sqlite> .tables

Album          Employee       InvoiceLine    PlaylistTrack
Artist         Genre          MediaType      Track
Customer       Invoice        Playlist

sqlite> SELECT * FROM Artist LIMIT 3;

1|AC/DC
2|Accept
3|Aerosmith

sqlite> .headers on
sqlite> .mode column
sqlite> SELECT * FROM Artist LIMIT 3;

ArtistId    Name
----------  ----------
1           AC/DC
2           Accept
3           Aerosmith

sqlite> .schema Artist

CREATE TABLE [Artist]
(
    [ArtistId] INTEGER  NOT NULL,
    [Name] NVARCHAR(120),
    CONSTRAINT [PK_Artist] PRIMARY KEY  ([ArtistId])
);
CREATE UNIQUE INDEX [IPK_Artist] ON [Artist]([ArtistId]);

sqlite> .schema Album

CREATE TABLE [Album]
(
    [AlbumId] INTEGER  NOT NULL,
    [Title] NVARCHAR(160)  NOT NULL,
    [ArtistId] INTEGER  NOT NULL,
    CONSTRAINT [PK_Album] PRIMARY KEY  ([AlbumId]),
    FOREIGN KEY ([ArtistId]) REFERENCES [Artist] ([ArtistId])
                ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE UNIQUE INDEX [IPK_Album] ON [Album]([AlbumId]);
CREATE INDEX [IFK_AlbumArtistId] ON [Album] ([ArtistId]);
```


---

Chinook-tietokannan on luonut [Luis Rocha](https://github.com/lerocha) ja se on lisensoitu avoimena lähdekoodina [MIT-lisenssillä](https://github.com/lerocha/chinook-database/blob/master/LICENSE.md).


Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä.