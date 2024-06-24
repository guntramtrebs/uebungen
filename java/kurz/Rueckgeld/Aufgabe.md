# Aufgabe

Umschulung zum Fachinformatiker Anwendungsentwicklung

Schreibe einen Algorithmus, der die zurückzugebenden Geldscheine 
und Geldstücke unter folgenden Annahmen berechnet:
- es ist immer genügend Wechselgeld von allen Arten vorhanden
- es sollen so wenig wie möglich Scheine und Münzen zurückgegeben werden


# Lösung

- Rechnung in Cent
- Geldbeträge als double/Euro einlesen und in int/cent umrechnen
- absteigend mit dem größten Rückgabestück anfangen
- möglichst viele große Stücke verwenden
- zurückzugebenden Rest berechnen
- Ausgabe

# Algorithmus
- durch die spezielle Auswahl der Münzen und Scheine beim Euro gibt es eine eindeutige Lösung
- diese Lösung lässt sich einfach berechnen, 
 indem man zuerst möglichst viele möglichst große Scheine/Münzen verwendet
- 5-Euro-Münzen etc. werden ignoriert

# Umsetzung
- Java
- IntelliJ Idea Projekt
- Ausgabe
