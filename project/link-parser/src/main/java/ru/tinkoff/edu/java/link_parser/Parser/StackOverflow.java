package ru.tinkoff.edu.java.link_parser.Parser;

import ru.tinkoff.edu.java.link_parser.Link.ParserLink;
import ru.tinkoff.edu.java.link_parser.Link.StackOverflowLink;

public class StackOverflow extends Abstract {
	public StackOverflow(Abstract nextParser) {
		super(nextParser);
	}

	@Override
	public ParserLink parser_Link(String url) {

		if (url == null) return null;
		String toParse = tweakUrl(url);
		String[] tokens = toParse.split("/");

		if (tokens.length >= 1 && tokens[0].equals("stackoverflow.com")) {
			if (tokens.length >= 2 && tokens[1].equals("questions")) {
				if (tokens.length >= 3) {
					try {
						return new StackOverflowLink(Long.parseLong(tokens[2]));
					} catch (NumberFormatException e) {
						return null;
					}
				}
			} else return null;
		}

		if (nextParser != null) return nextParser.parser_Link(url);

		return null;
	}
}