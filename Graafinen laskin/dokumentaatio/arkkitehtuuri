# Arkkitehtuurikuvaus

## Rakenne

Ohjelma on rakennettu pakkaukseen _graafinenlaskin_ joka sisältää sovelluksen käyttöliittymän sekä erillisen piirtoalustan.

## Käyttöliittymä

Käyttöliittymä sisältää 4 tekstikenttää sekä kaksi nappia _tyhjennä_ sekä _piirrä_

Jokainen tekstikenttä on oma [JTextField](https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html)-olionsa. Napit on taas toteutettu [JButton](https://docs.oracle.com/javase/7/docs/api/javax/swing/JButton.html)-olioina.

## Sovelluslogiikka

Sovelluksen muodostavat luokat [Piirtoalusta](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/GraafinenLaskin/src/main/java/graafinenlaskin/Piirtoalusta.java) sekä [Kayttoliittyma](https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/GraafinenLaskin/src/main/java/graafinenlaskin/Kayttoliittyma.java).
 Sovelluksen käynnistyttyä käyttöliittymä tekee uuden [JFramen](https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html) ja _piirrä_ nappi taas tekee uuden piirtoalustan. Piirtoalusta huolehtii nimensä mukaisesti funktioiden piirtämisestä.
 
Sovelluksen luokkakaavio onkin hyvin yksinkertainen, sillä sovelluksella on main-luokan lisäksi vain kaksi muuta luokkaa:
 
 <img src="https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/dokumentaatio/kuvat/luokkakaavio.png?raw=true" width="750">

### Päätoiminnallisuudet

Sovelluksella on vain kaksi toiminnallisuutta: funktioiden kuvaajien piirtäminen ja piirtoalustan tyhjennys.

#### Piirtäminen

Piirtoalusta on [JPanel](https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html)-olion jatke ja sille on kirjoitettu oma paintComponent(Graphics g)-metodi, jota kutsutaan kun kyseistä oliota päivitetään tai kutsutaan olion metodia repaint(). 

#### Tyhjennys

Piirtoalustan tyhjennys on toteutettu maalaamalla JPanelin päälle samalla värillä kun sen tausta ja maalamalla xy ristikko takaisin metodissa init().

 <img src="https://github.com/Mikaelpa/ot-harjoitustyo/blob/master/Graafinen%20laskin/dokumentaatio/kuvat/sekvenssikaavio.png?raw=true" width="750">

