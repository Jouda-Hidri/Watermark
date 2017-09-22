package bean;

import org.springframework.stereotype.Component;


@Component
public class Book extends Document{
	
	String content;
	String title;
	String author;
	String topic; // business, science and media.
	

	public Book(int i, String title, String author, String topic) {
		super(i, title, author);
		this.content = "Book";
		this.title = title;
		this.author=author;
		this.topic=topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Override
	public Watermark make() {
		return new WatermarkBook(content, title, author, topic);
	}
}
