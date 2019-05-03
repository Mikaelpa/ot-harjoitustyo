# Testausdokumentti

Ohjelmaa on testattu sekä yksikkötesteillä JUnitilla että manuaalisesti kokeilemalla virhetilanteita.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Pakkauksen [graafinenlaskin](https://github.com/Mikaelpa/ot-harjoitustyo/tree/master/Graafinen%20laskin/GraafinenLaskin/src/main/java/graafinenlaskin) 
luokkia testaa [laskinTest](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/GraafinenLaskin/src/test/java/graafinenLaskinTest/laskinTest.java) 
jonka testitapaukset suorittavat luokkien [Kayttoliittyma](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/GraafinenLaskin/src/main/java/graafinenlaskin/Kayttoliittyma.java) 
ja [Piirtoalusta](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/GraafinenLaskin/src/main/java/graafinenlaskin/Piirtoalusta.java) 
antamia toiminnallisuuksia.

### Testauskattavuus

Sovelluksen testauksen rivikattavuus on 98% ja haarautumakattavuus 95%

<img src="https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/dokumentaatio/kuvat/testikuva.png?raw=true" width="800"> 

Testaamatta jäi käyttöliittymän kautta piirtoalustan tyhjennys, sillä en saanut testeillä sitä toimimaan. Tyhjennys on kuitenkin erikseen testattu Piirtoalusta-luokan kautta.
Myöskään main-luokkaa ei testattu, sillä se ei tee muuta kun käynnistää sovelluksen.

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti. Tekstikenttiin on yritetty syöttää reunatapauksia ja kaikissa virhetilanteissa ohjelma syöttää halutun error-viestin.

### Asennus ja konfigurointi

Sovellusta on testattu [käyttöohjeen](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/dokumentaatio/kayttoohje.md) kertomalla tavalla sekä Linux, että Windows käyttöjärjestelmissä.


### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/dokumentaatio/vaatimusmaarittely.md) listaamat perusversion toiminnallisuudet on testattu ja käyty läpi.

## Sovellukseen jääneet laatuongelmat

-Sovellus piirtää piirtoalustan vasempaan yläreunaan viimeisimmän käytetyn komponentin(en vieläkään ymmärrä mistä tämä johtuu) ja tämä on valitettavasti korjattu vähän purkkamaisella ratkaisulla piirtää kyseisen tilan päälle tyhjää.
-Funktion kuvaajien käyttämä satunnainen väri saattaa välillä mennä niin vaaleaksi, ettei sitä näy valkoista taustaa vasten
