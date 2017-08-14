package leap_year;

public class LeapYear
{

    public static boolean test(int year)
    {
	return inJulianCalendar(year) ? isJulianLeapYear(year) : isGregorianLeapYear(year);
    }

    private static boolean inJulianCalendar(int year)
    {
	return year < 1582;
    }

    private static boolean isJulianLeapYear(int year)
    {
	return divisibleBy(year, 4);
    }

    private static boolean isGregorianLeapYear(int year)
    {
	return divisibleBy(year, 4) && !isExceptionGregorianCommonYear(year);
    }

    private static boolean isExceptionGregorianCommonYear(int year)
    {
	return divisibleBy(year, 100) && !divisibleBy(year, 400);
    }

    private static boolean divisibleBy(int year, int factor)
    {
	return year % factor == 0;
    }

}
