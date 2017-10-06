package greetings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GreetingTest
{

    private final String nullReplacement = "Friend";
    private final String escapeCharacter = "\"";
    private final String separator = ", ";

    private Greeting createGreeter()
    {
	return new Greeting(new NameParser(nullReplacement, escapeCharacter, separator));
    }

    @Test
    public void the_given_name_is_greeted_with_a_hello()
    {
	assertThat(createGreeter().greet("Tobias")).isEqualTo("Hello, Tobias.");
    }

    @Test
    public void given_a_null_parameter_a_friend_is_greeted()
    {
	String[] names = { null };
	assertThat(createGreeter().greet(names)).isEqualTo("Hello, Friend.");
    }

    @Test
    public void a_name_with_only_upper_case_letters_is_greeted_with_a_shout()
    {
	assertThat(createGreeter().greet("KNUT")).isEqualTo("HELLO, KNUT!");
    }

    @Test
    public void two_names_are_greeted_with_and_separation()
    {
	assertThat(createGreeter().greet("Helle", "Moffe")).isEqualTo("Hello, Helle and Moffe.");
    }

    @Test
    public void more_than_two_names_are_greeted_with_oxford_comma()
    {
	assertThat(createGreeter().greet("Pia", "Peder", "Ask")).isEqualTo("Hello, Pia, Peder, and Ask.");
    }

    @Test
    public void names_can_be_both_spoken_and_shouted_in_a_greeting()
    {
	assertThat(createGreeter().greet("Charlotte", "BRIAN", "Heidi")).isEqualTo("Hello, Charlotte and Heidi. AND HELLO, BRIAN!");
    }

    @Test
    public void a_comma_separates_an_input_string()
    {
	assertThat(createGreeter().greet("Tom", "Dianne, Judith")).isEqualTo("Hello, Tom, Dianne, and Judith.");
    }

    @Test
    public void a_comma_separation_can_intentionally_be_escaped_by_double_quotes()
    {
	assertThat(createGreeter().greet("Karl", "\"Julie, Joe\"")).isEqualTo("Hello, Karl and Julie, Joe.");
    }
}
