package genericUtility.Practice;

public class JavaRunTimeParameterTest
{
	public static void main(String[] args)
	{
		System.out.println(args.length);
		
		for(String var : args) {
			System.out.println(var);
		}
	}
}
