package scripts;

import org.testng.annotations.Test;

public class JavaRunTimeScenarioMavenParameter_Test
{
	@Test
	public void runTimeParameter_Test()
	{
		String property = System.getProperty("browser");
		System.out.println(property);
		
		System.out.println("test ng test");
	}
	
}
