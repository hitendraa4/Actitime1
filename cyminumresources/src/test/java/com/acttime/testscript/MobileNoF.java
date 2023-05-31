package com.acttime.testscript;

public class MobileNoF {
	
	
	public static void main(String [] args)
	{
		
		
		long a=9079835978l;
		
		int [] x=new int[10];
		
		while(a>0)
		{
long d=a%10;
			
			x[(int)d]++;
			
			 a=a/10;
			
		}
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Frequency of:"+i+"->"+x[i]);
		}
		
		
		
		
	}

}
