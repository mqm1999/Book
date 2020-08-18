/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson007;

import java.util.Scanner;

/**
 *
 * @author HP Pavilion
 */
public class Lesson007 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //class: Book: name, price, where, category, numOfPage
        //method: showInfo, 
        //class: BookManagement:
        //method: create, update, delete, show according to filter: price from lowest, category
        //ArrayList<Book>
        Scanner sc = new Scanner(System.in);
        BookManagement BM = new BookManagement();
        while (true) {
            System.out.println("Select option: 1. Add \n 2. Show \n 3. Update \n 4. Delete \n 5. Show based on filter \n 6. Order by price from lowest to highest");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    Book book = new Book();
                    book.input();
                    if (BM.add(book)) {
                        System.out.println("Added");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 2:
                    BM.show();
                    break;
                case 3:
                    System.out.println("Input book you want to change: ");
                    String name = new String();
                    name = sc.next();
                    BM.update(name);
                    break;
                case 4:
                    System.out.println("Input book you want to delete: ");
                    String name1 = new String();
                    name1 = sc.next();
                    if (BM.delete(name1)) {
                        System.out.println("Deleted");
                    } else {
                        System.out.println("Failed");
                    }
                    break;
                case 5: 
                    System.out.println("Input a category: ");
                    String categoryInput = sc.next();
                    BM.showFilterBook(categoryInput);
                    break;
                case 6:
                    BM.orderByPrice();
                    break;
            }
        }
    }

}
