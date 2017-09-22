package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.concurrent.Future;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Book;
import bean.Journal;
import bean.Watermark;
import bean.WatermarkBook;
import bean.WatermarkJournal;
import config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class JUnitSpringExample {
	

	
	
	@BeforeClass
	public static void setUp() {
		System.out.println("-----> Test begins <-----");
	}
		

	
	@Test
	public void testWatermarkBook() throws JsonProcessingException
	{		
		Book book = new Book(1, "The Dark Code", "Bruce Wayne", "Science");
		Future<String> ticket = book.setWatermark();
		
		Watermark watermark = book.getWatermark();
		Watermark watermark2 = new WatermarkBook("Book", "The Dark Code", "Bruce Wayne", "Science");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String watermark_json = mapper.writeValueAsString(watermark);
		String watermark_json2 = mapper.writeValueAsString(watermark2);
		
		assertEquals(watermark_json, watermark_json2);
			
	}

	
	@Test
	public void testWatermarkJournal() throws JsonProcessingException
	{		
		Journal journal = new Journal(3, "Journal of human flight routes", "Clark Kent");
		Future<String> ticket = journal.setWatermark();
		
		Watermark watermark = journal.getWatermark();
		Watermark watermark2 = new WatermarkJournal("Journal", "Journal of human flight routes", "Clark Kent");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String watermark_json = mapper.writeValueAsString(watermark);
		String watermark_json2 = mapper.writeValueAsString(watermark2);
		
		assertEquals(watermark_json, watermark_json2);
			
	}
	
	@AfterClass
	public static void afterTest() {
		System.out.println("-----> Test ends <-----");
	}
}
