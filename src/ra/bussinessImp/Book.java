package ra.bussinessImp;

import ra.bussiness.IBook;
import ra.util.InputMethods;

import java.util.List;

public class Book implements IBook, Comparable<Book> {
    @Override
    public int compareTo(Book o) {
        return (int) (o.getInterest() - this.interest);
    }

    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;
    static int idMax = 0;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }



    @Override
    public void inputData() {
        //Book ID
        this.bookId = idMax + 1;
        System.out.println("Mã sách: " + this.bookId);
        idMax = this.bookId;

        //Book Name
        System.out.print("Nhập tên sách: ");
        this.bookName = InputMethods.getString();

        //Title
        System.out.print("Nhập tiêu đề: ");
        this.title = InputMethods.getString();

        //Number Of Pages
        System.out.print("Nhập số trang sách: ");
        this.numberOfPages = InputMethods.getInteger();

        //Import Price
        while (true) {
            System.out.print("Nhập giá thu: ");
            this.importPrice = InputMethods.getFloat();
            if (this.importPrice > 0) {
                break;
            } else {
                System.err.println("Giá thu phải lớn hơn 0");
            }
        }

        //Export Price
        while (true) {
            System.out.print("Nhập giá bán: ");
            this.exportPrice = InputMethods.getFloat();
            if (this.exportPrice > this.importPrice * 1.2) {
                break;
            } else {
                System.err.println("Giá bán phải lớn hơn 20% giá trị giá thu");
            }
        }

        //Interest
        this.interest = this.exportPrice - this.importPrice;
        System.out.println("Lợi nhuận: " + this.interest);

        //Book Status
        boolean isExist = true;
        System.out.println("Chọn trạng thái: ");
        System.out.println("1. Còn hàng");
        System.out.println("2. Hết hàng");
        System.out.print("Trạng thái: ");
        do {
            int choise = InputMethods.getInteger();
            switch (choise) {
                case 1:
                    this.bookStatus = true;
                    isExist = false;
                    break;
                case 2:
                    this.bookStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Số trang sách: " + numberOfPages);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái: " + (bookStatus ? "Còn hàng" : "Hết hàng"));
    }
}
