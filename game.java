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
        ArrayList<Stack<card>> piles = new ArrayList<Stack<card>>();
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

        //Below is the controls please be careful what you do (if any function requirements are changed make sure to change them here)

        Scanner input = new Scanner(System.in);
        while (true)
        {
            //Proper printing is needed still to display the piles (Edit the current printing as needed to make it work)
            //  for (int lcv = 0;lcv < piles.size();lcv ++)
            //  {
            //      for (card x:piles.get(lcv))
            //      {
            //          System.out.println(x.getnum() + " " +  x.gettype());
            //      }
            //  }
            System.out.println("Enter Move (Draw = D, Move = M, Quit = Q): ");
            String ans = input.next();
            if (ans.toUpperCase().equals("Q"))
            {
                break;
            }
            while (true)
            {
                if (ans.toUpperCase().equals("D") || ans.toUpperCase().equals("M") || ans.toUpperCase().equals("Q"))
                {
                    break;
                }
                else
                {
                    System.out.println("Enter Move (Draw = D, Move = M, Quit = Q): ");
                    ans = input.next();
                }
            }
            if (ans.toUpperCase().equals("D"))
            {
                Discard.push(pickUpCard(deck));
            }
            else
            {
                if (ans.toUpperCase().equals("Q"))
                {
                    System.exit(0);
                }
                System.out.println("Enter Where Your Getting The Card From (0 = Discard, 1-7 = Piles): ");
                int pos = input.nextInt();
                while (true)
                {
                    if (pos >= 0 && pos <=7)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Enter Where Your Getting The Card From (0 = Discard, 1-7 = Piles): ");
                        pos = input.nextInt();
                    }
                }
                if (pos == 0)
                {
                    card x = Discard.pop();
                    System.out.println("Enter Where Your Placing The Card (1-7 = Piles, 8 = Hearts, 9 = Diamonds, 10 = Clubs, 11 = Spades): ");
                    int pos2 = input.nextInt();
                    while (true)
                    {
                        if (pos2 >= 1 && pos2 <= 11)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Enter Where Your Placing The Card (1-7 = Piles, 8 = Hearts, 9 = Diamonds, 10 = Clubs, 11 = Spades): ");
                            pos2 = input.nextInt();
                        }
                    }
                    // for all "insert" commands, the *grabbing* stack followed by the *destination* stack is needed.
                    // Currently needed: The ability to grab any card in the stack rather than the top card.
                    if (pos2 >= 1 && pos2 <= 7)
                    {
                        piles.set(pos2 - 1, insert(x,piles.get(pos2 - 1)));
                    }
                    if (pos2 == 8)
                    {
                        Hearts = insert(x, Hearts);
                    }
                    if (pos2 == 9)
                    {
                        Diamonds = insert(x, Diamonds);
                    }
                    if (pos2 == 10)
                    {
                        Clubs = insert(x, Clubs);
                    }
                    if (pos2 == 11)
                    {
                        Spades = insert(x, Spades);
                    }
                }
                else
                {
                    card x = piles.get(pos - 1).pop();
                    System.out.println("Enter Where Your Placing The Card (1-7 = Piles, 8 = Hearts, 9 = Diamonds, 10 = Clubs, 11 = Spades): ");
                    int pos2 = input.nextInt();
                    while (true)
                    {
                        if (pos2 >= 1 && pos2 <= 11)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Enter Where Your Placing The Card (1-7 = Piles, 8 = Hearts, 9 = Diamonds, 10 = Clubs, 11 = Spades): ");
                            pos2 = input.nextInt();
                        }
                    }
                    if (pos2 >= 1 && pos2 <= 7)
                    {
                        piles.set(pos2 - 1, insert(x,piles.get(pos2 - 1)));
                    }
                    if (pos2 == 8)
                    {
                        Hearts = insert(x, Hearts);
                    }
                    if (pos2 == 9)
                    {
                        Diamonds = insert(x, Diamonds);
                    }
                    if (pos2 == 10)
                    {
                        Clubs = insert(x, Clubs);
                    }
                    if (pos2 == 11)
                    {
                        Spades = insert(x, Spades);
                    }
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
    //Use this to insert a card into the position requested (only change requirements if needed)
    public static Stack<card> insert(Stack<card> placing, Stack<card> goto)
    {
        Iterator i = placing.iterator();
        card c;
        while(i.hasNext())
        {
            c=i.next();
        }
        boolean cando = isLegal(c,goto);
        if(cando)
        {
            goto.push(placing);
        }
        return goto;
    }
    public static boolean isLegal(card x, Stack<card> place)
    {
        if(((place.peek().gettype().equals("Spades")||place.peek().gettype().equals("Clubs")) && (x.gettype().equals("Hearts")||x.gettype().equals("Diamonds")))||((place.peek().gettype().equals("Diamonds")||place.peek().gettype().equals("Hearts")) && (x.gettype().equals("Spades")||x.gettype().equals("Clubs"))))
        { // check if the card below is the opposite color ^
            if(place.peek().getnum()==x.getnum()-1) // check if card below is the placing card's number minus 1
            { 
                return true;
            }
        }
    public static Stack<card> insert(card x, Stack<card> place)
    {
        isLegal(x,place);
        return null;
    }
    //Use this in insert to make sure the move is valid (only chnage requirements if needed)
    public static boolean isLegal(card x, Stack<card> place)
    {
        return false;
    }
}