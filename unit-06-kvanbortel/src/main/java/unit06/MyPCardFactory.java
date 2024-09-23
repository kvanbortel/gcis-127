package unit06;

public class MyPCardFactory {
    public static void main(String[] args) {
        MyPCard card1 = new MyPCard(MyPValue.KING, MyPColor.BLACK, MyPSuit.CLUBS);
        System.out.println(card1.toString());

        MyPCard card2 = new MyPCard(MyPValue.KING, MyPColor.BLACK, MyPSuit.CLUBS);
        System.out.println(card2.equals(card1));
    }
}
