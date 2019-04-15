# Graafinen Laskin

Sovellus ei suoranaisesti ole laskin, vaikka nimessä niin sanotaan. Sovelluksella voi sen sijaan piirtää funktioiden kuvaajia.

[Tuntikirjanpito](/Graafinen%20laskin/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](/Graafinen%20laskin/dokumentaatio/vaatimusmaarittely.md)

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_


### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _GraafinenLaskin-1.0-SNAPSHOT.jar_


### Checkstyle

Tiedostoon [checkstyle.xml](/Graafinen%20laskin/GraafinenLaskin/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_



