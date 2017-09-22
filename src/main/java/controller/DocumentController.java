package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Book;
import bean.Document;
import bean.Journal;
import bean.Watermark;

@RestController
public class DocumentController {

	@RequestMapping(value = "/document/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Watermark makeWatermarkForDocumentId(@PathVariable int id)
	{	
		Document document = getDocumentById(id);
				try {
					makeWatermark(document);
					return document.getWatermark();
				} catch (InterruptedException | ExecutionException e) {
					return null;
				}	
	}
	public void makeWatermark(Document document)
		    throws InterruptedException, ExecutionException {
		    Future<String> ticket = document.setWatermark();
		 if(ticket != null){
			    while (true) {
			        if (ticket.isDone()) {
			            System.out.println("document can be retrieved with the ticket");
			            break;
			        }
			        Thread.sleep(1000);
			    }	
			    System.out.println("Status : " + ticket.get());
		 }
		 else{
			 System.out.println("the ticket is empty!");
		 }
		}
	
	public Document getDocumentById(int id){
		
		List<Document> listOfdocuments = new ArrayList<Document>();
		listOfdocuments=createdocumentList();
		for (Document document: listOfdocuments) {
			if(document.getId()==id)				
					return document;
		}
		return null;
	}
	

	public List<Document> createdocumentList(){
		Document documentA=new Book(1, "The Dark Code", "Bruce Wayne", "Science");
		Document documentB=new Book(2, "How to make money", "Dr. Evil", "Business");
		Document documentC=new Journal(3, "Journal of human flight routes", "Clark Kent");
		List<Document> listOfdocuments = new ArrayList<Document>();
		listOfdocuments.add(documentA);
		listOfdocuments.add(documentB);
		listOfdocuments.add(documentC);
		return listOfdocuments;
	}
}