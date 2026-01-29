import java.util.*;

public class game 
{
    public static void main(String[] args)
    {
        Stack<card> deck = new Stack<card>();
        String[] suits = new String[4];
        suits[0] = "Hearts";
        suits[1] = "Diamonds";
        suits[2] = "Spades";
        suits[3] = "Clubs";
        ArrayList<String> cardidentification = new ArrayList<>();
        for (int lcv = 0;lcv < 52;lcv ++)
        {
            int temp = (int)((Math.random() * 13) + 1);
            String temp2 = suits[(int)(Math.random() * 4)];
            card x = new card(temp2,temp);
            while(cardidentification.contains(temp2+temp))
            {
                temp = (int)((Math.random() * 13) + 1);
                temp2 = suits[(int)(Math.random() * 4)];
                x = new card(temp2,temp);
            }
            deck.push(x);
            cardidentification.add(temp2+temp);
        }
        while (!deck.empty())
        {
            card x = deck.pop();
            System.out.println(x.getnum()+" of "+x.gettype());
        }
    }
}