package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author merlin
 * Project 1 Code - Daniel Breitigan & Jake Moore
 * Problem 11.6.2 from Programming Challenges. Using memoization
 */
public class Project1
{
    static String input1, input2;

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
    	BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    	String inputString = new String(inputReader.readLine());
        for (int i = 0; i < Integer.parseInt(inputString); i++)
        {
        	input2 = new String(inputReader.readLine());
        	input1 = new String(inputReader.readLine());
        	System.out.println(answer());
        }
    }

    static int memoTable[][];
    /**Creates memoization table and calls memoUpdater to start recursion */
    public static int answer()
    {
    	int stringOneIndex = input1.length() - 1;
        int stringTwoIndex = input2.length() - 1;
        memoTable = new int[stringOneIndex+1][stringTwoIndex+1];
        for (int k=0;k<stringOneIndex+1;k++)
        	for (int j=0;j<stringTwoIndex+1;j++)
        		memoTable[k][j] = -1;
        return memoUpdater(stringOneIndex, stringTwoIndex);
    }

    /** Updates the Memo. Used in conjuction with cMeat to do
     * mutual recursion with memoization to optimistringTwoIndex speed.
     * USED TO BE CALLED cShell*/
    private static int memoUpdater(int stringOneIndex, int stringTwoIndex)
    {
        if (stringOneIndex == -1)
        	return 1;
        if (memoTable[stringOneIndex][stringTwoIndex] == -1)
        	memoTable[stringOneIndex][stringTwoIndex] = stringSubsequences(stringOneIndex, stringTwoIndex);
        return memoTable[stringOneIndex][stringTwoIndex];
    }

    /**
     * Uses mutual recursion with memoUpdater to find compare stringTwoIndex
     * with distinct subsequences of stringOneIndex
     * USED TO BE CALLED cMeat
     */
    private static int stringSubsequences(int stringOneIndex, int stringTwoIndex)
    {
        if (stringOneIndex == -1)
        	return 1;
        if (stringOneIndex > stringTwoIndex)
        	return 0;
        if (stringOneIndex == stringTwoIndex)
        {
        	if (sameString(stringOneIndex))
        		return 1;
        	return 0;
        }
        if (input1.charAt(stringOneIndex) == input2.charAt(stringTwoIndex))
        {
        	return (memoUpdater(stringOneIndex - 1, stringTwoIndex - 1))
        			+ memoUpdater(stringOneIndex, stringTwoIndex - 1);
        }
        return (memoUpdater(stringOneIndex, stringTwoIndex - 1));
    }

    /** Checks if two strings are equivalent
     * * USED TO BE CALLED sameish*/
    private static boolean sameString(int end)
    {
        for (int i = 0; i <= end; i++)
        	if (input1.charAt(i) != input2.charAt(i))
        		return false;
        return true;
    }

}
