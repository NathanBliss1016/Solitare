import java.util.*;
import java.io.*;
public class game
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<card>> cards = new ArrayList<>();
        Stack<Integer> cardlist = new Stack<>();
        // Adds numbers 1 to 52 in the stack. Card types can be determined in whatever way, following suit of 13s.
        for(int x=0;x<52;x++)
        {
            int temp = (int)(Math.random()*52+1);
            if(cardlist.contains(temp))
            {
                while(cardlist.contains(temp))
                {
                    temp = (int)(Math.random()*52+1);
                }
            }
            cardlist.add(temp);
        }
    }
}
