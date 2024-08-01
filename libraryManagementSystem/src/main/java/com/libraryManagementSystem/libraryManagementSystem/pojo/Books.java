package com.libraryManagementSystem.libraryManagementSystem.pojo;


public class Books {
	
	private long isbnId;
	private String bookName;
	private String author;
	private String genre ;
	private boolean isAvailable;

	
	public Books(long isbnId, String bookName, String author, String genre, boolean isAvailable) {
		this.isbnId = isbnId;
		this.bookName = bookName;
		this.author = author;
		this.genre = genre;
		this.isAvailable = isAvailable;
	}

	public long getIsbnId() {
		return isbnId;
	}

	public void setIsbnId(long isbnId) {
		this.isbnId = isbnId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
    public String toString() {
        return "Book{" +
                "isbnId='" + isbnId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
