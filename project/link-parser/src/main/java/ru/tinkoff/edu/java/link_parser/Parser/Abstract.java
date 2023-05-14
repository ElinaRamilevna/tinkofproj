package ru.tinkoff.edu.java.link_parser.Parser;

import ru.tinkoff.edu.java.link_parser.Link.ParserLink;
import java.net.URL;

public abstract class Abstract {

    Abstract nextParser;

    public Abstract(Abstract nextParser) {
        this.nextParser = nextParser;
    }

    public abstract ParserLink parser_Link(URL url);
}

