package greetings;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Solution to greeting kata:
 * https://github.com/testdouble/contributing-tests/wiki/Greeting-Kata
 *
 *
 * @author tobias urhaug
 *
 */

public class Greeting
{

    private final NameParser nameParser;
    private final Predicate<String> isUpperCase = string -> string.chars().allMatch(Character::isUpperCase);

    public Greeting(NameParser nameParser)
    {
	this.nameParser = nameParser;
    }

    public String greet(String... names)
    {
	return createGreeting(nameParser.parse(names));
    }

    private String createGreeting(List<String> names)
    {
	String greets = greet(names);
	String shouts = shout(names);
	String seperator = separate(greets, shouts);

	return greets + seperator + shouts;
    }

    private String greet(List<String> names)
    {
	return format(names, isUpperCase.negate(), "Hello, ", ".");
    }

    private String shout(List<String> names)
    {
	return format(names, isUpperCase, "HELLO, ", "!");
    }

    private String format(List<String> names, Predicate<String> namePredicate, String salutation, String punctuation)
    {
	List<String> desiredNames = names.stream().filter(namePredicate).collect(Collectors.toList());
	return desiredNames.isEmpty()
		? ""
		: salutation + joiningOxfordComma(desiredNames) + punctuation;
    }

    private String joiningOxfordComma(List<String> names)
    {
	int last = names.size() - 1;
	if (last < 1)
	{
	    return String.join("", names);
	}
	if (last == 1)
	{
	    return String.join(" and ", names);
	}
	return String.join(", and ", String.join(", ", names.subList(0, last)), names.get(last));
    }

    private String separate(String greeting, String shout)
    {
	return needsSeparator(greeting, shout) ? " AND " : "";
    }

    private boolean needsSeparator(String greeting, String shout)
    {
	return !greeting.isEmpty() && !shout.isEmpty();
    }
}