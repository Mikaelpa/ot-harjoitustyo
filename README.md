# Graafinen Laskin

Sovellus ei suoranaisesti ole laskin, vaikka nimessä niin sanotaan. Sovelluksella voi sen sijaan piirtää funktioiden kuvaajia.

[Arkkitehtuurikuvaus](/Graafinen%20laskin/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](/Graafinen%20laskin/dokumentaatio/testausdokumentti.md)

[Tuntikirjanpito](/Graafinen%20laskin/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](/Graafinen%20laskin/dokumentaatio/vaatimusmaarittely.md)

[Käyttöohje](/Graafinen%20laskin/dokumentaatio/kayttoohje.md)

## Releaset

[Viikko 5](https://github.com/Mikaelpa/ot-harjoitustyo/releases/tag/Viikko5Beta)

[Loppupalautus](https://github.com/Mikaelpa/ot-harjoitustyo/releases/tag/Viikko7)

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

tekee kansioon target suorituskelpoisen jar-tiedoston _GraafinenLaskin-1.0-SNAPSHOT.jar_


### Checkstyle

Tiedostoon [checkstyle.xml](/Graafinen%20laskin/GraafinenLaskin/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocin voi avata tiedostosijainnista _target/site/apidocs/index.html_

