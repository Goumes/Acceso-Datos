package practicasax_xml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agomez
 */
public class Book 
{
    private String category;
    private String title;
    private String author;
    private int year;
    private double price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Book ()
    {
        this.category = "";
        this.title = "";
        this.author = "";
        this.year = 0;
        this.price = 0.0;
    }
    
    public Book (String category, String title, String author, int year, double price)
    {
        this.category = category;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    
    
}
