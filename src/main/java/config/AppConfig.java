package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bean.Book;
import bean.Document;
import bean.Journal;

@Configuration
public class AppConfig {
	@Bean
	public Book getBook() {
		return new Book(0, "TitleMock", "authorMock", "topicMock");
	}
	@Bean
	public Journal getJournal() {
		return new Journal(0, "TitleMock", "authorMock");
	}
}
