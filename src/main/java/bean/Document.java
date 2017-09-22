package bean;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public abstract class Document implements IDocument{	
	int id;
	Watermark watermark;	
	public Document(int i, String title, String author) {
		super();
		this.id = i;
		this.watermark = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Watermark getWatermark() {
		return watermark;
	}	
	public void setWatermark(Watermark watermark) {
		this.watermark = watermark;
	}	
	
	@Async
	public Future<String> setWatermark() {
	    System.out.println("Watermarketing ... ");
	    	this.watermark = make();        
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				System.out.println("Error : "+e.getMessage());
			}     
	        AsyncResult<String> ticket = new AsyncResult<String>("Watermarketing done!");	        
	        return ticket;
	}
	
}