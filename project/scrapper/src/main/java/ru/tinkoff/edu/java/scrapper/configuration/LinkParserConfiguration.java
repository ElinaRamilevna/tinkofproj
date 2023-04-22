package ru.tinkoff.edu.java.scrapper.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Parser.LinkParser;

@Configuration

public class LinkParserConfiguration {
	 @Bean
	    public LinkParser linkParser(){
	        return new LinkParser();
	    }

}
