package ru.tinkoff.edu.java.link_parser.Parser;

import ru.tinkoff.edu.java.link_parser.Parser.Abstract;
import ru.tinkoff.edu.java.link_parser.Parser.GitHub;
import ru.tinkoff.edu.java.link_parser.Parser.StackOverflow;
import ru.tinkoff.edu.java.link_parser.Link.ParserLink;

public class LinkParser {
    public ParserLink parseUrl(String url) {
        Abstract parser1 = new GitHub(null);
        Abstract parser2 = new StackOverflow(parser1);

        return parser2.parser_Link(url);
    }

}