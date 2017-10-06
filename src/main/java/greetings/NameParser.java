package greetings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A name parser that parses an array of names.
 *
 * In case null is given as input, a replacement name which is defined in the
 * constructor is used as replacement. A single entry in the input can contain
 * several names separated by a separator. Sometimes the input deliberately
 * contains this separator and the separation needs to be escaped. This can be
 * achieved by surrounding the input by the escape characters. Both the escape
 * characters and the separator are defined at construction of the parser.
 *
 * @author tobias urhaug
 *
 */

public class NameParser
{

    public final String nullReplacement;
    public final String escapeCharacter;
    public final String separator;
    public static final String empty = "";

    public NameParser(String nullReplacement, String escapeCharacter, String separator)
    {
	this.nullReplacement = nullReplacement;
	this.escapeCharacter = escapeCharacter;
	this.separator = separator;
    }

    /**
     * Parses an array of names where nulls are replaced by a stand in name. If a
     * name in the @param names contains a separator, the names contained in this
     * input will be split into its respective names. This behavior can be escaped
     * by surrounding the input with escape characters
     *
     * @return the parsed and split names in the input as a List
     */
    public List<String> parse(String... names)
    {
	return Arrays.stream(names).map(this::replaceNull).flatMap(name -> split(name).stream()).collect(Collectors.toList());
    }

    private String replaceNull(String name)
    {
	return name == null ? nullReplacement : name;
    }

    private List<String> split(String name)
    {
	if (name.startsWith(escapeCharacter) && name.endsWith(escapeCharacter))
	{
	    return Arrays.asList(name.replace(escapeCharacter, empty));
	} else
	{
	    return Arrays.asList(name.split(separator));
	}
    }
}