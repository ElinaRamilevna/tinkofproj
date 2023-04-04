package ru.tinkoff.edu.java.link_parser.Link;


public record GitHubLink(String username, String repository) implements ParserLink {

}