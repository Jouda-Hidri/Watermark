package bean;

public class WatermarkJournal extends Watermark{
	String content;
	String title;
	String author;
	public WatermarkJournal(String content, String title, String author) {
		this.content = content;
		this.title=title;
		this.author=author;
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
}
