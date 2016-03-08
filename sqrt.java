import java.util.Scanner;
public class sqrt{
static double sqroot;
static int length=0;
public static void square(double x)
{
	int n = 0, m = 0, done = 0, k = 1;		
	float term = 1, term1 = 0;
	double VALUE;
	double temp_sqrt = 1;
	double temp = 0;
	double factorial = 1;
	double num=x;
	if (x >= 0.4)
	{	
		//Division by 4 to get closer to 1
		while (x > 1.6)
		{
			x = x/ 4;
			n++;
		}
	}
	else
	{
		//Multiplication by 4 to get closer to 1
		while (x < 0.4)
		{
			x = x * 4;
			m++;
		}
	}
	System.out.print("x= "+x);
	//Square root calculation
	while (done != 1)
	{
		term1 = term;
		factorial = factorial * k;
		//Power series used: Taylor Series for square root : sqrt(x) = 1 + 1 / 2(x?-1)? 1 / 4(x?-1) ^ 2 / 2!+ 3 / 8(x?-1) ^ 3 / 3!? 15 / 16(x?-1) ^ 4 / 4!+ ..
		term = (float) ((-term1)*(x - 1.0)*(2*k - 3.0) / 2.0);
		temp = term / factorial;
		temp_sqrt = temp_sqrt + temp;
		VALUE = Math.abs(temp);
		if (VALUE < 0.0000000001)
		{
			sqroot = temp_sqrt;
			length = k;
			done = 1;		
		}
		k++;
	}
	//Multiplication
	for (int i = 1; i <= n; i++)
	{
		sqroot = sqroot + sqroot;
	}
	//Division
	for (int i = 1; i <= m; i++)
	{
		sqroot = sqroot / 2;
	}
	System.out.print(",\tn= "+length+"\nMy square root of ["+num+"] is "+sqroot);
}
public static void main(String args[])
{
    Scanner sc;
    while(true)
    {
    	System.out.print("Enter the number for square root (0 for exit) :");
    	sc=new Scanner(System.in);
    	double x=sc.nextDouble();
    	if(x==0)
    	{
    		break;
    	}
    	else
    	{
    		square(x);
    		System.out.println("\nLibrary Square root of ["+x+"] is "+Math.sqrt(x));
    	}
    }
    sc.close();
}
}
