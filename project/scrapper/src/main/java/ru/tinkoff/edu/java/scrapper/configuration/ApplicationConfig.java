package ru.tinkoff.edu.java.scrapper.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import ru.tinkoff.edu.java.scrapper.schedule.Scheduler;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig(@NotNull String test, Scheduler scheduler, AccessType dataBaseAccessType) {
	 @Bean
	    public long schedulerIntervalMs(ApplicationConfig config) {
	        return config.scheduler().interval().toMillis();
	    }
	 public enum AccessType {
	        JDBC, JPA, JOOQ
	    }

}