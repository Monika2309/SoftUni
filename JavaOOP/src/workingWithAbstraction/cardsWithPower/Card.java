package workingWithAbstraction.cardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;


    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    private int getCardPower(){
        return rank.getPower()+suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",rank.name(),suit.name(),getCardPower());
    }
}
