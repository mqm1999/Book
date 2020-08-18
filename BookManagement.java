/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson007;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class BookManagement {

    Scanner sc = new Scanner(System.in);
    ArrayList<Book> book = new ArrayList<>();
    ArrayList<String> category = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();

    public boolean add(Book A) {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getName().equals(A.getName())) {
                return false;
            }
        }
        book.add(A);
        return true;
    }

    public void show() {
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i).output());
        }
    }

    public void update(String name) {
        int flag = -1;
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getName().equals(name)) {
                flag = i;
            }
        }
        if (flag >= 0) {
            while (true) {
                System.out.println("Select information you want to change: ");
                System.out.println("1. Name \t 2. Price \t 3. Origin \t 4. Category \t 5. Number Of Page");
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Input new name: ");
                        book.get(flag).setName(sc.next());
                    case 2:
                        System.out.println("Input new price: ");
                        book.get(flag).setPrice(sc.nextLong());
                    case 3:
                        System.out.println("Input new origin: ");
                        book.get(flag).setOrigin(sc.next());
                    case 4:
                        System.out.println("Input new category: ");
                        book.get(flag).setCategory(sc.next());
                    case 5:
                        System.out.println("Input new number of page: ");
                        book.get(flag).setNumOfPage(sc.nextInt());
                    default:
                        return;
                }
            }
        } else {
            System.out.println("Book not found");
        }
    }

    public boolean delete(String name) {
        int flag = -1;
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getName().equals(name)) {
                flag = i;
            }
        }
        if (flag >= 0) {
            book.remove(flag);
            return true;
        }
        return false;
    }

    public ArrayList<String> filterBook() {
        for (int i = 0; i < book.size(); i++) {
            String currentBookCategory = book.get(i).getCategory();
            boolean isNewCategory = true;
            for (int j = 0; j < book.size(); j++) {
                if (currentBookCategory.equals(category.get(j))) {
                    isNewCategory = false;
                }
            }
            if (isNewCategory) {
                category.add(currentBookCategory);
            }
        }
        return category;
    }

    public ArrayList<String> showFilterBook(String category) {
        for (int i = 0; i < book.size(); i++) {
            if (category.equals(book.get(i).getCategory())) {
                name.add(book.get(i).getName());
            } else {
                System.out.println("Category not found");
            }
        }
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i));
        }
        return name;
    }

    public ArrayList<Book> orderByPrice() {
        Book temp = new Book();
        temp.setPrice(0);
        for (int i = 0; i < book.size() - 1; i++) {
            if(book.get(i).getPrice() > book.get(i+1).getPrice()){
                temp.setName(book.get(i).getName());
                temp.setPrice(book.get(i).getPrice());
                temp.setOrigin(book.get(i).getOrigin());
                temp.setCategory(book.get(i).getCategory());
                temp.setNumOfPage(book.get(i).getNumOfPage());
                
                book.get(i).setName(book.get(i+1).getName());
                book.get(i).setPrice(book.get(i+1).getPrice());
                book.get(i).setOrigin(book.get(i+1).getOrigin());
                book.get(i).setCategory(book.get(i+1).getCategory());
                book.get(i).setNumOfPage(book.get(i+1).getNumOfPage());
                
                book.get(i+1).setName(temp.getName());
                book.get(i+1).setPrice(temp.getPrice());
                book.get(i+1).setOrigin(temp.getOrigin());
                book.get(i+1).setCategory(temp.getCategory());
                book.get(i+1).setNumOfPage(temp.getNumOfPage());
            }
        }
        return book;
    }
}
