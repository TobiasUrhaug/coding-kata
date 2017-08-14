package leap_year;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LeapYearTest
{

    @Test
    public void a_julian_year_divisible_by_four_is_a_leap_year()
    {
	assertThat(LeapYear.test(4)).isTrue();
	assertThat(LeapYear.test(1500)).isTrue();
	assertThat(LeapYear.test(1580)).isTrue();
    }

    @Test
    public void a_julian_year_not_divisible_by_four_is_a_common_year()
    {
	assertThat(LeapYear.test(1577)).isFalse();
	assertThat(LeapYear.test(1578)).isFalse();
	assertThat(LeapYear.test(1579)).isFalse();
    }

    @Test
    public void a_gregorian_year_divisible_by_four_and_not_hundred_is_a_leap_year()
    {
	assertThat(LeapYear.test(2004)).isTrue();
	assertThat(LeapYear.test(2008)).isTrue();
    }

    @Test
    public void a_gregorian_year_not_divisible_by_four_is_a_common_year()
    {
	assertThat(LeapYear.test(2001)).isFalse();
	assertThat(LeapYear.test(2002)).isFalse();
	assertThat(LeapYear.test(2003)).isFalse();
    }

    @Test
    public void a_gregorian_year_divisible_by_hundred_and_not_four_hundred_is_a_common_year()
    {
	assertThat(LeapYear.test(1700)).isFalse();
	assertThat(LeapYear.test(1800)).isFalse();
	assertThat(LeapYear.test(1900)).isFalse();
    }

    @Test
    public void a_gregorian_year_divisible_by_four_hundred_is_a_leap_year()
    {
	assertThat(LeapYear.test(1600)).isTrue();
	assertThat(LeapYear.test(2000)).isTrue();
    }
}
