import java.util.*;
import java.io.*;

public class card 
{
    private String mytype;
    private int mynum;

    public card(String type, int num)
    {
        mytype = type;
        mynum = num;
    }

    public String gettype()
    {
        return mytype;
    }

    public int getnum()
    {
        return mynum; 
    }
}