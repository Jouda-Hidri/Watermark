package bean;




public class WatermarkBook extends Watermark{
	String content;
	String title;
	String author;
	String topic;
	public WatermarkBook(String content, String title, String author, String topic) {
		this.content=content;
		this.title=title;
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
}
