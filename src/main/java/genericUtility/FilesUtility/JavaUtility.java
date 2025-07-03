package genericUtility.FilesUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNumber(int bound)
	{
		Random r = new Random();
		int randomNumber = r.nextInt(bound);
		return randomNumber;
	}
	
	public String getSystemDate()
	{
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String systemDate = sdf.format(d);
		return systemDate;
	}
	
	public String getRequiredDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String requiredDate = sdf.format(d);
		return requiredDate;
	}
	
}
