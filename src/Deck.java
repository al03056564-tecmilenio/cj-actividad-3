import java.nio.ByteBuffer;
import java.util.*;

public class Deck {
    private List<Card> cards;
    private String ID;
    public Deck() {
        cards = new ArrayList<>();
        ID = shortUUID();
        initializeDeck();
    }
    private static String shortUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }
    private void initializeDeck() {
        String treboles = "\u2663";
        String corazones = "\u2661";
        String picas = "\u2660";
        String diamantes = "\u2662";
        List<String> palos = Arrays.asList(treboles, corazones, picas, diamantes);
        List<String> valores = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

        for (String palo : palos) {
            String color;
            if (palo.equals(treboles) || palo.equals(picas)) {
                color = Colores.BLACK_BACKGROUND;
            } else {
                color = Colores.RED_BACKGROUND_BRIGHT;
            }
            for (String valor : valores) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck #" + Colores.BLUE + ID);
    }

    public void head() {
        System.out.println("Head:");
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            printCard(card);

            System.out.println("Quedan " + cards.size() + " cartas en el deck #" + Colores.BLUE + ID);
        } else {
            System.out.println("No hay cartas en el deck #" + Colores.BLUE + ID);
        }
    }

    public void pick() {
        System.out.println("Pick:");
        if (!cards.isEmpty()) {
            int index = (int) (Math.random() * cards.size());
            Card card = cards.remove(index);
            printCard(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck #" + Colores.BLUE + ID);
        } else {
            System.out.println("No hay cartas en el deck #" + Colores.BLUE + ID);
        }
    }

    public void hand() {
        List<Card> handCards = new ArrayList<>();
        if (cards.size() >= 5) {
            System.out.println("Hand:");
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                handCards.add(card);
                // System.out.println(card.toString());
            }
            printCards(handCards);
            System.out.println("Quedan " + cards.size() + " cartas en el deck #" + Colores.BLUE + ID);
        } else {
            System.out.println("No hay suficientes cartas en el deck #" + Colores.BLUE + ID + "para repartir una mano.");
        }
    }
    public void showDeck() {
        System.out.println("Showing Deck: #" + Colores.BLUE + ID);
        printCards(cards);
    }
    private void printCard(Card card) {
        System.out.println(Colores.WHITE + card.getColor() + card.getValor() + (card.getValor().equals("10") ? " " : "  ")  + Colores.RESET);
        System.out.println(Colores.WHITE + card.getColor() + " " + card.getPalo() + " " + Colores.RESET);
        System.out.println(Colores.WHITE + card.getColor() + (card.getValor().equals("10") ? " " : "  ") + card.getValor() + Colores.RESET);
    }
    private void printCards(List<Card> cards) {
        for (Card card: cards) {
            System.out.print(Colores.BLUE + card.getColor() + card.getValor() + (card.getValor().equals("10") ? " " : "  ") + Colores.RESET + " ");
        }
        System.out.println("");
        for (Card card: cards) {
            System.out.print(Colores.BLUE + card.getColor() + " " + card.getPalo() + " " + Colores.RESET + " ");
        }
        System.out.println("");
        for (Card card: cards) {
            System.out.print(Colores.BLUE_BOLD + card.getColor() + (card.getValor().equals("10") ? " " : "  ") + card.getValor() + Colores.RESET + " ");
        }
        System.out.println("");
    }
}

class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }
    public String getPalo() {
        return palo;
    }
    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return palo + "," + color + "," + valor;
    }
}
