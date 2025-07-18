import java.awt.*;
import java.awt.event.*;

class Book {
    int id;
    String title;
    boolean available;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        available = true;
    }
}

class Student {
    int id;
    String name;
    java.util.List<Book> borrowedBooks;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new java.util.ArrayList<>();
    }

    void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.available = false;
    }

    void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.available = true;
    }
}

public class LibraryManagementSystemAwt extends Frame implements ActionListener {
    java.util.List<Book> books = new java.util.ArrayList<>();
    java.util.List<Student> students = new java.util.ArrayList<>();

    TextField bookIdField, bookTitleField, studentIdField, studentNameField, borrowBookIdField, borrowStudentIdField, returnBookIdField, returnStudentIdField;
    Button addBookButton, addStudentButton, displayBooksButton, displayStudentsButton, borrowBookButton, returnBookButton;
    Label bookIdLabel, bookTitleLabel, studentIdLabel, studentNameLabel, borrowBookIdLabel, borrowStudentIdLabel, returnBookIdLabel, returnStudentIdLabel;
    TextArea textArea;

    public LibraryManagementSystemAwt() {
        setLayout(null);
        setBackground(new Color(240, 248, 255));

        Label headline = new Label("Library Management System", Label.CENTER);
        headline.setBounds(100, 40, 300, 30);
        headline.setFont(new Font("Arial", Font.BOLD, 18));
        headline.setForeground(Color.DARK_GRAY);
        add(headline);

        bookIdLabel = new Label("Book ID:");
        bookIdLabel.setBounds(120, 90, 100, 20);
        bookIdLabel.setForeground(Color.BLUE);
        add(bookIdLabel);

        bookIdField = new TextField();
        bookIdField.setBounds(220, 90, 150, 20);
        add(bookIdField);

        bookTitleLabel = new Label("Book Title:");
        bookTitleLabel.setBounds(120, 120, 100, 20);
        bookTitleLabel.setForeground(Color.BLUE);
        add(bookTitleLabel);

        bookTitleField = new TextField();
        bookTitleField.setBounds(220, 120, 150, 20);
        add(bookTitleField);

        addBookButton = new Button("Add Book");
        addBookButton.setBounds(200, 150, 100, 20);
        addBookButton.addActionListener(this);
        add(addBookButton);

        studentIdLabel = new Label("Student ID:");
        studentIdLabel.setBounds(120, 190, 100, 20);
        studentIdLabel.setForeground(Color.BLUE);
        add(studentIdLabel);

        studentIdField = new TextField();
        studentIdField.setBounds(220, 190, 150, 20);
        add(studentIdField);

        studentNameLabel = new Label("Student Name:");
        studentNameLabel.setBounds(120, 220, 100, 20);
        studentNameLabel.setForeground(Color.BLUE);
        add(studentNameLabel);

        studentNameField = new TextField();
        studentNameField.setBounds(220, 220, 150, 20);
        add(studentNameField);

        addStudentButton = new Button("Add Student");
        addStudentButton.setBounds(200, 250, 100, 20);
        addStudentButton.addActionListener(this);
        add(addStudentButton);

        displayBooksButton = new Button("Display Books");
        displayBooksButton.setBounds(120, 290, 100, 20);
        displayBooksButton.addActionListener(this);
        add(displayBooksButton);

        displayStudentsButton = new Button("Display Students");
        displayStudentsButton.setBounds(270, 290, 100, 20);
        displayStudentsButton.addActionListener(this);
        add(displayStudentsButton);

        borrowBookIdLabel = new Label("Book ID:");
        borrowBookIdLabel.setBounds(120, 330, 100, 20);
        borrowBookIdLabel.setForeground(Color.BLUE);
        add(borrowBookIdLabel);

        borrowBookIdField = new TextField();
        borrowBookIdField.setBounds(220, 330, 150, 20);
        add(borrowBookIdField);

        borrowStudentIdLabel = new Label("Student ID:");
        borrowStudentIdLabel.setBounds(120, 360, 100, 20);
        borrowStudentIdLabel.setForeground(Color.BLUE);
        add(borrowStudentIdLabel);

        borrowStudentIdField = new TextField();
        borrowStudentIdField.setBounds(220, 360, 150, 20);
        add(borrowStudentIdField);

        borrowBookButton = new Button("Borrow Book");
        borrowBookButton.setBounds(200, 390, 100, 20);
        borrowBookButton.addActionListener(this);
        add(borrowBookButton);

        returnBookIdLabel = new Label("Book ID:");
        returnBookIdLabel.setBounds(120, 430, 100, 20);
        returnBookIdLabel.setForeground(Color.BLUE);
        add(returnBookIdLabel);

        returnBookIdField = new TextField();
        returnBookIdField.setBounds(220, 430, 150, 20);
        add(returnBookIdField);

        returnStudentIdLabel = new Label("Student ID:");
        returnStudentIdLabel.setBounds(120, 460, 100, 20);
        returnStudentIdLabel.setForeground(Color.BLUE);
        add(returnStudentIdLabel);

        returnStudentIdField = new TextField();
        returnStudentIdField.setBounds(220, 460, 150, 20);
        add(returnStudentIdField);

        returnBookButton = new Button("Return Book");
        returnBookButton.setBounds(200, 490, 100, 20);
        returnBookButton.addActionListener(this);
        add(returnBookButton);

        textArea = new TextArea();
        textArea.setBounds(50, 530, 400, 150); 
        textArea.setBackground(new Color(245, 245, 220));
        textArea.setForeground(Color.DARK_GRAY);
        add(textArea);

        setSize(500, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookButton) {
            int id = Integer.parseInt(bookIdField.getText());
            String title = bookTitleField.getText();
            books.add(new Book(id, title));
            textArea.setText("Book Added Successfully!\n\nBook ID: " + id + "\nBook Title: " + title);
        } else if (e.getSource() == addStudentButton) {
            int id = Integer.parseInt(studentIdField.getText());
            String name = studentNameField.getText();
            students.add(new Student(id, name));
            textArea.setText("Student Added Successfully!\n\nStudent ID: " + id + "\nStudent Name: " + name);
        } else if (e.getSource() == displayBooksButton) {
            String output = "Book List:\n\n";
            for (Book book : books) {
                output += "Book ID: " + book.id + "\tBook Title: " + book.title + "\tAvailable: " + book.available + "\n";
            }
            textArea.setText(output);
        } else if (e.getSource() == displayStudentsButton) {
            String output = "Student List:\n\n";
            for (Student student : students) {
                output += "Student ID: " + student.id + "\tStudent Name: " + student.name + "\n";
            }
            textArea.setText(output);
        } else if (e.getSource() == borrowBookButton) {
            int bookId = Integer.parseInt(borrowBookIdField.getText());
            int studentId = Integer.parseInt(borrowStudentIdField.getText());
            Book book = getBook(bookId);
            Student student = getStudent(studentId);
            if (book != null && student != null && book.available) {
                student.borrowBook(book);
                textArea.setText("Book Borrowed Successfully!\n\nBook ID: " + bookId + "\nStudent ID: " + studentId);
            } else {
                textArea.setText("Book or Student not found, or book is not available.");
            }
        } else if (e.getSource() == returnBookButton) {
            int bookId = Integer.parseInt(returnBookIdField.getText());
            int studentId = Integer.parseInt(returnStudentIdField.getText());
            Book book = getBook(bookId);
            Student student = getStudent(studentId);
            if (book != null && student != null && !book.available) {
                student.returnBook(book);
                textArea.setText("Book Returned Successfully!\n\nBook ID: " + bookId + "\nStudent ID: " + studentId);
            } else {
                textArea.setText("Book or Student not found, or book is not borrowed.");
            }
        }
    }

    private Book getBook(int id) {
        for (Book book : books) {
            if (book.id == id) {
                return book;
            }
        }
        return null;
    }

    private Student getStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new LibraryManagementSystemAwt();
    }
}

