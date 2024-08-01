package com.libraryManagementSystem.libraryManagementSystem.Bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.libraryManagementSystem.libraryManagementSystem.pojo.Books;

@Service
public class library {
	
	private List<Books> book;
	
	public library() {
		book = new ArrayList<>();
	}
	
    public void addBook(Books books) {
    	book.add(books);
    }

    public List<Books> displayBooks() {
        for (Books book : book) {
            System.out.println(book);
        }
		return book;
    }
    
    public String searchBookByTitle(String val , String type) {
    	    	
    	if(type.equalsIgnoreCase("AUTHOR")) {
    		return searchBookByAuthor(val);
    	} else {
          List<Books> booksList  =  book.stream()
                .filter(book -> book.getBookName().equalsIgnoreCase(val))
                .collect(Collectors.toList());
          return booksList.isEmpty() ? "No books found with this title" : booksList.toString();
    	}
    }

    public String searchBookByAuthor(String author) {
         List<Books> authorList =   book.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
         
         return authorList.isEmpty() ? "No books found with this author" : authorList.toString();
         
    }
    
    public boolean checkOutBook(long isbnId) {
        for (Books book : book) {
            if (book.getIsbnId() == isbnId && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(long isbnId) {
        for (Books book : book) {
            if (book.getIsbnId() == isbnId && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public double calculateFine(int overdueDays, double fineRate) {
        return overdueDays * fineRate;
    }

}
