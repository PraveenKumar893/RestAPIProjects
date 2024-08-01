package com.libraryManagementSystem.libraryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagementSystem.libraryManagementSystem.Service.libraryService;
import com.libraryManagementSystem.libraryManagementSystem.pojo.Books;

	@RestController
	@RequestMapping("/api/books")
	public class libraryManagementController {
		
		@Autowired
		private libraryService libaryservice;
		
	    @PostMapping("/addBook")
	    public ResponseEntity<String> addBook(@RequestBody Books book) {
	    	libaryservice.addBook(book);
	        return ResponseEntity.ok("Book added successfully");
	    }

	    @GetMapping("/books")
	    public ResponseEntity<List<Books>> getBooks() {
	        return ResponseEntity.ok(libaryservice.getAllBooks());
	    }

	    @GetMapping("/search")
	    public ResponseEntity<String> searchBooksByTitle(@RequestParam String value, @RequestParam String type) {
	        return ResponseEntity.ok(libaryservice.searchBooksByTitle(value,type));
	    }


	    @PostMapping("/checkout")
	    public ResponseEntity<String> checkOutBook(@RequestParam long isbnId) {
	        if (libaryservice.checkOutBook(isbnId)) {
	            return ResponseEntity.ok("Book checked out successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not available");
	        }
	    }

	    @PostMapping("/return")
	    public ResponseEntity<String> returnBook(@RequestParam long isbnId) {
	        if (libaryservice.returnBook(isbnId)) {
	            return ResponseEntity.ok("Book returned successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
	        }
	    }

	    @GetMapping("/fine")
	    public ResponseEntity<Double> calculateFine(@RequestParam int overdueDays, @RequestParam double fineRate) {
	        return ResponseEntity.ok(libaryservice.calculateFine(overdueDays, fineRate));
	    }
	    
	    @GetMapping("/placeOrder")
	    public ResponseEntity<String> placeOrder(@RequestParam String title) {
	    	System.out.println("dsdsd");
	    	libaryservice.placeorderBysearchBook(title,"BOOKS");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Ordered Successfully");	    	
	    }
	}
