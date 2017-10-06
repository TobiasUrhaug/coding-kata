package greetings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NameParserTest
{

    private final String nullReplacement = "Friend";
    private final String escapeCharacter = "\"";
    private final String separator = ", ";

    private NameParser testReader()
    {
	return new NameParser(nullReplacement, escapeCharacter, separator);
    }

    @Test
    public void a_single_name_is_returned_as_a_list()
    {
	assertThat(testReader().parse("Tobias")).containsExactly("Tobias");
    }

    @Test
    public void a_null_input_is_replaced()
    {
	assertThat(testReader().parse(new String[] { null })).containsExactly(nullReplacement);
    }

    @Test
    public void an_input_containing_separated_names_is_split()
    {
	String[] names = new String[] { "Per" + separator + "Per" + separator + "Lise" };
	assertThat(testReader().parse(names)).containsExactly("Per", "Per", "Lise");
    }

    @Test
    public void a_separator_can_be_intentionally_escaped()
    {
	String[] names = new String[] { escapeCharacter + "Tove" + separator + "Mette" + escapeCharacter };
	assertThat(testReader().parse(names)).containsExactly("Tove, Mette");
    }

    @Test
    public void an_input_needs_to_start_and_end_with_escape_characters_to_escape_the_splitting()
    {
	String[] names = new String[] { escapeCharacter + "Lars, Olav", "Turid, Arne" + escapeCharacter };
	assertThat(testReader().parse(names)).containsExactly("\"Lars", "Olav", "Turid", "Arne\"");
    }
}
