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