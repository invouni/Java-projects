import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
/*
Tasks Designing a Library Management System
Tasks:
1)Can add and get book;
2)Can add and remove member;
3)Can allot a book to a member;
4)Can remove a book from a member.
*/

public class Library {
    // main class
    public static void main(String[] args) {
        System.out.println("Library Management System");
        // initializing library
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        // making library work
        while (true) {
            System.out.print("To add a book type AB, To add a member type AM, To allot a book to member type ABM, To remove Member type RM, to remove contained book from member type RBFM:- ");
            String input = sc.nextLine();
            input = lib.updateString(input);
            if (input.equals("ab")) {
                System.out.print("Type name of Book :- ");
                String book = sc.nextLine();
                book = lib.updateString(book);
                System.out.print("Type name of author :- ");
                String author = sc.nextLine();
                author = lib.updateString(author);
                lib.addBook(book, author);
                System.out.println("Book Added");
            } else if (input.equals("am")) {
                System.out.print("Enter the name of member to be added :- ");
                String mem = sc.nextLine();
                mem = lib.updateString(mem);
                lib.addMember(mem);
                System.out.println("Member added");
            } else if (input.equals("rm")) {
                System.out.print("Enter the name of member to be removed :- ");
                String mem = sc.nextLine();
                mem = lib.updateString(mem);
                lib.removeMember(mem);
                System.out.println("Member removed");
            } else if (input.equals("abm")) {
                System.out.print("Enter the name of member :- ");
                String mem = sc.nextLine();
                mem = lib.updateString(mem);
                System.out.print("Enter the name of book :- ");
                String book = sc.nextLine();
                book = lib.updateString(book);
                lib.allotBookToMember(mem, book);
            } else if (input.equals("rbfm")) {
                System.out.print("Enter the name of member :- ");
                String mem = sc.nextLine();
                mem = lib.updateString(mem);
                System.out.print("Enter the name of book :- ");
                String book = sc.nextLine();
                book = lib.updateString(book);
                lib.removeBookFromMember(mem, book);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    // make string according to database
    private String updateString(String str) {
        return str.trim().replaceAll(" ", "-").toLowerCase();
    }

    // library members and books and authors with their books info
    HashMap<String, Book> books;
    HashMap<String, Member> members;
    HashMap<String, ArrayList<Book>> authors;

    // making a constructor for Library
    Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.authors = new HashMap<>();
    }

    // add a book
    private void addBook(String name, String author) {
        // create a book and add it to library also add author to library and its book
        Book newBook = new Book(name, author);
        books.put(name, newBook);
        authors.computeIfAbsent(author, k -> new ArrayList<>()).add(newBook);
    }

    // get books availability
    private Book getBook(String name) {
        return books.get(name);
    }

    // remove book by member
    private void removeBookFromMember(String memberName, String bookName) {
        Book book = books.get(bookName);
        Member member = members.get(memberName);
        if (member != null && book != null && member.bookSet.contains(book)) {
            member.bookSet.remove(book);
            book.isAvailable = true;
            System.out.println("Book removed from member");
        } else {
            System.out.println("Book or member not found");
        }
    }

    // add member
    private void addMember(String name) {
        // create a member and add it to library
        Member newMember = new Member(name);
        members.put(name, newMember);
    }

    // remove member
    private void removeMember(String name) {
        // if member exists remove them
        if (members.containsKey(name)) {
            HashSet<Book> memberBooks = members.get(name).bookSet;
            for (Book book : memberBooks) {
                book.isAvailable = true;
            }
            members.remove(name);
        }
    }

    // allot book to member
    private void allotBookToMember(String memberName, String bookName) {
        Book book = books.get(bookName);
        Member member = members.get(memberName);
        if (book != null && member != null && book.isAvailable) {
            member.bookSet.add(book);
            book.isAvailable = false;
            System.out.println("Book allotted to member");
        } else {
            System.out.println("Book or member not found, or book not available");
        }
    }

    // book class contains book info
    private class Book {
        // attributes of book
        String name, author;
        boolean isAvailable;

        // constructor to make a book
        Book(String name, String author) {
            this.name = name;
            this.author = author;
            this.isAvailable = true;
        }
    }

    // member class contains member info
    private class Member {
        // member properties
        String name;
        HashSet<Book> bookSet;

        // constructor to make a member
        Member(String name) {
            this.name = name;
            this.bookSet = new HashSet<>();
        }
    }
                  
}
