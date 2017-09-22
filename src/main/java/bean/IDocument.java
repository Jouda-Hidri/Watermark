package bean;

import java.util.concurrent.Future;

public interface IDocument{
	
	public Watermark make();
	public Future<String> setWatermark();

}
