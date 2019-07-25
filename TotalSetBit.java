/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class TotalSetBit
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int res=0;
		for(int i=1;i<=4;i++)
		{
			while(i>0)
			{
				i=(i&(i-1));
				res++;
			}
		}
		System.out.println(res);
	}
}
