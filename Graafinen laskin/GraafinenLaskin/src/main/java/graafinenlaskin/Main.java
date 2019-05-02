
package graafinenlaskin;

import javax.swing.SwingUtilities;
/**
 * Main-luokka
 * Tehdään uusi käyttöliittymä.
 * @author mikaelpa
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma());
    }
    
}