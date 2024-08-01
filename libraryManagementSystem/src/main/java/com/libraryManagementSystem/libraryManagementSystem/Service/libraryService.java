package com.libraryManagementSystem.libraryManagementSystem.Service;

import java.io.Closeable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.libraryManagementSystem.Bussiness.library;
import com.libraryManagementSystem.libraryManagementSystem.pojo.Books;

@Service
public class libraryService {
	
	@Autowired
	private library library ;
	
    public void addBook(Books book) {
        library.addBook(book);
    }

    public List<Books> getAllBooks() {
        return library.displayBooks();
    }

    public String searchBooksByTitle(String title, String type) {
        return library.searchBookByTitle(title,type);
    }


    public boolean checkOutBook(long isbnId) {
        return library.checkOutBook(isbnId);
    }

    public boolean returnBook(long isbnId) {
        return library.returnBook(isbnId);
    }

    public double calculateFine(int overdueDays, double fineRate) {
        return library.calculateFine(overdueDays, fineRate);
    }

	public  String placeorderBysearchBook(String title, String type) {
		 String bookList =  null;
		  try {
			  bookList = library.searchBookByTitle(title,type);
			  String bookLisss ="Title Book";
			  CloseableHttpClient httpClient = HttpClients.createDefault();
			  URI url = new URI("http://localhost:8080/api/services/placeOrder");
			  HttpPost request = new HttpPost(url);
	          request.setHeader("Content-Type", "application/json");
	          request.setEntity(new StringEntity(bookLisss));
	          CloseableHttpResponse response = httpClient.execute(request);
              System.out.println("Response Status Code: ");
		  } catch(Exception ex) {
			  ex.printStackTrace();
		  }
		 return bookList;
	}

}
