package leap_year;

/**
 * Solution to kata: http://codingdojo.org/kata/LeapYears/
 *
 * A leap year is defined as one that is divisible by 4, but is not otherwise
 * divisible by 100 unless it is also divisible by 400.
 *
 * For example, 2001 is a typical common year and 1996 is a typical leap year,
 * whereas 1900 is an atypical common year and 2000 is an atypical leap year.
 *
 * The Gregorian calendar was a reform of the Julian calendar. It was instituted
 * in 1582 by Pope Gregory XIII, before 1582 a leap year is only divisible by 4.
 *
 * A Julian year is any year before 1582 and a Gregorian year is any year from
 * and included 1582.
 *
 * @author tobias urhaug
 *
 */
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
