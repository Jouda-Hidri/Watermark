package bean;




public class Journal extends Document{
	String content;
	String title;
	String author;
	public Journal(int i, String title, String author) {
		super(i, title, author);
		this.content = "Journal";
		this.title = title;
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
	@Override
	public Watermark make() {
		return new WatermarkJournal(content, title, author);
	}
}
