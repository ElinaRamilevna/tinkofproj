package ru.tinkoff.edu.java.link_parser.Parser;

import ru.tinkoff.edu.java.link_parser.Link.ParserLink;
import ru.tinkoff.edu.java.link_parser.Link.StackOverflowLink;
import java.net.URL;

public class StackOverflow extends Abstract {
	public StackOverflow(Abstract nextParser) {
		super(nextParser);
	}

	@Override
	public ParserLink parser_Link(String url) {

		URL toParse = tweakUrl(url);
        if (toParse == null) return null;


        if (toParse.getHost().equals("stackoverflow.com")) {
            String[] tokens = toParse.getFile().substring(1).split("/");
            if (tokens.length >= 2 && tokens[0].equals("questions")) {
                try {
                    return new StackOverflowLink(Long.parseLong(tokens[1]));
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect question ID");
                    return null;
                }
            } else return null;
        }

        if (nextParser != null) return nextParser.parser_Link(url);

        return null;
    }
}