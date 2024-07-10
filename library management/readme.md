# Library Management System

This Java-based Library Management System allows for basic operations such as adding and getting books, adding and removing members, allotting books to members, and removing books from members.

## Features
1. **Add and Get Books**: Add books to the library and retrieve their information.
2. **Add and Remove Members**: Manage library members by adding or removing them.
3. **Allot Book to Member**: Assign a book to a member.
4. **Remove Book from Member**: Remove a book from a member's possession.

## Code Structure

### Main Class: Library
The main class contains the primary functionality of the library management system.

#### `main` Method
The main method serves as the entry point of the application. It interacts with the user to perform various library operations.

```java
public static void main(String[] args) {
    System.out.println("Library Management System");
    Library lib = new Library();
    Scanner sc = new Scanner(System.in);
    // user interaction loop
}
```

### Supporting Methods
- **`updateString`**: Normalizes the input string to a specific format.
- **`addBook`**: Adds a new book to the library.
- **`getBook`**: Retrieves a book's information from the library.
- **`removeBookFromMember`**: Removes a book from a member's possession.
- **`addMember`**: Adds a new member to the library.
- **`removeMember`**: Removes a member from the library.
- **`allotBookToMember`**: Allots a book to a member.

### Data Structures
- **`HashMap<String, Book> books`**: Stores the books in the library.
- **`HashMap<String, Member> members`**: Stores the members of the library.
- **`HashMap<String, ArrayList<Book>> authors`**: Stores the authors and their respective books.

### Inner Classes
#### `Book`
Represents a book in the library.

```java
private class Book {
    String name, author;
    boolean isAvailable;
    // constructor
}
```

#### `Member`
Represents a library member.

```java
private class Member {
    String name;
    HashSet<Book> bookSet;
    // constructor
}
```

## Usage

### Add a Book
To add a book, type `AB` followed by the book's name and author.

### Add a Member
To add a member, type `AM` followed by the member's name.

### Remove a Member
To remove a member, type `RM` followed by the member's name.

### Allot a Book to a Member
To allot a book to a member, type `ABM` followed by the member's name and the book's name.

### Remove Book from a Member
To remove a book from a member, type `RBFM` followed by the member's name and the book's name.

## Example Interaction
```
Library Management System
To add a book type AB, To add a member type AM, To allot a book to member type ABM, To remove Member type RM, to remove contained book from member type RBFM:- AB
Type name of Book :- Harry Potter
Type name of author :- J.K. Rowling
Book Added
```

## Conclusion
This basic library management system provides fundamental operations to manage books and members effectively. Further enhancements can be added to extend its functionality.
