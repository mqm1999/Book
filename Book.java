/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson007;

import com.sun.management.VMOption;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class Book {

    Scanner sc = new Scanner(System.in);
    String name;
    long price;
    String origin;
    String category;
    int numOfPage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    public Book() {

    }

    public Book(String name, long price, String origin, String category, int numOfPage) {
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.category = category;
        this.numOfPage = numOfPage;
    }

    public void show() {
        System.out.println(name + "," + price + "," + origin + "," + numOfPage);
    }

    public void input() {
        System.out.println("Name: ");
        setName(sc.next());
        System.out.println("Price: ");
        setPrice(sc.nextLong());
        System.out.println("Origin: ");
        setOrigin(sc.next());
        System.out.println("Category: ");
        setCategory(sc.next());
        System.out.println("Number Of Page: ");
        setNumOfPage(sc.nextInt());
    }

    public String output() {
        return "Book{"
                + "name='" + name + '\''
                + ", origin='" + origin + '\''
                + ", category='" + category + '\''
                + ", price=" + price
                + ", numberOfPage=" + numOfPage
                + '}';
    }
}
