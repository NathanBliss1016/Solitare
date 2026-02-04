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
        
        Stack<card> Discard = new Stack<card>();
        ArrayList<Stack<card>> piles = new ArrayList<>();
        Stack<card> pile1 = new Stack<card>();
        pile1.push(deck.pop());
        piles.add((pile1));
        for (int lcv = 1;lcv < 7;lcv ++)
        {
            Stack<card> temp = new Stack<card>();
            for (int lcv2 = 0;lcv2 < lcv;lcv2++)
            {
                temp.push(deck.pop());
            }
            piles.add(temp);
        }

        // for (int lcv = 0;lcv < piles.size();lcv ++)
        // {
        //     for (card x:piles.get(lcv))
        //     {
        //         System.out.println(x.getnum() + " " +  x.gettype());
        //     }
        // }

        Stack<card> Hearts = new Stack<card>();
        Stack<card> Diamonds = new Stack<card>();
        Stack<card> Clubs = new Stack<card>();
        Stack<card> Spades = new Stack<card>();

        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter Move (Draw = D, Move = M): ");
            String ans = input.next();
            while (true)
            {
                if (ans.toUpperCase().equals("D") || ans.toUpperCase().equals("M"))
                {
                    break;
                }
                else
                {
                    System.out.println("Enter Move (Draw = D, Move = M): ");
                    ans = input.next();
                }
            }
            if (ans.toUpperCase().equals("D"))
            {
                Discard.push(pickUpCard(deck));
            }
            else
            {
                System.out.println("Enter Where Your Getting The Card From (D = Discard, 1-7 (IN WORDS!) = Piles): ");
                String pos = input.next();
                if (pos.toUpperCase().equals("D"))
                {
                    card x = Discard.pop();
                    
                }
                else
                {

                }
            }
        }
    }
    public static card pickUpCard(Stack<card> deck)
    {
        card x = deck.pop();
        System.out.println("Top card on discard pile is now a "+x.getnum()+" of "+x.gettype());
        return x;
    }
}