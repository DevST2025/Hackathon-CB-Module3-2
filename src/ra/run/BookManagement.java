package ra.run;

import ra.bussinessImp.Book;
import ra.util.InputMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookManagement {
    static List<Book> listBooks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        byte choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách\n" +
                    "2. Hiển thị thông tin các sách\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần\n" +
                    "4. Xóa sách theo mã sách\n" +
                    "5. Tìm kiếm sách theo tên sách\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách\n" +
                    "7. Thoát \n " + "Hãy nhập  lưa chọn : ");

            choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    inputDataBook();
                    break;
                case 2:
                    displayDataBook();
                    break;
                case 3:
                    sortByProfit();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    updateStatus();
                    break;
                case 7:
                    scanner.close();
                    System.out.println("Thoát khỏi chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn  không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 7);
    }

    //1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách
    public static void inputDataBook() {
        System.out.print("Nhập số sách mà bạn muốn điền thông tin: ");
        int bookSize = InputMethods.getInteger();

        for (int i = 0; i < bookSize; i++) {
            System.out.printf("Nhập thông tin sách thứ %d: \n", i + 1);
            Book book = new Book();
            book.inputData();
            listBooks.add(book);
            System.out.println("--------------------");
        }
    }

    //2. Hiển thị thông tin tất cả sách trong thư viện
    public static void displayDataBook() {
        System.out.println("-----Thông tin tất cả sách trong thư viện-----");
        if (listBooks.size() == 0) {
            System.out.println("Hiện tại không có sách trong thư viện");
            return;
        }
        for (int i = 0; i < listBooks.size(); i++) {
            System.out.printf("Thông tin sách thứ %d: \n", i + 1);
            listBooks.get(i).displayData();
            System.out.println("--------------------");
        }
    }

    //3. Sắp xếp sách theo lợi nhuận giảm dần
    public static void sortByProfit() {
        listBooks.sort(Book::compareTo);
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần");
    }

    //4. Xóa sách theo mã sách
    public static void removeBook() {
        boolean isCheck = true;
        int inputId;
        int index = 0;
        System.out.print("Nhập mã sách mà bạn muốn xoá: ");
        inputId = InputMethods.getInteger();

        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).getBookId() != inputId) {
                System.out.print("Không tìm thấy mã sách mà bạn muốn xoá");
                isCheck = false;
            } else {
                index = i;
            }
        }
        if (isCheck) {
            listBooks.remove(index);
            System.out.printf("Đã xoá sách có mã %d\n", inputId);
        }
    }
    //5. Tìm kiếm tương đối sách theo tên sách
    public static void searchBook() {
        boolean check =  false;
        System.out.print("Nhập vào tên sách cần tìm: ");
        String inputName = InputMethods.getString();
        for (Book b: listBooks) {
            if(b.getBookName().toLowerCase().contains(inputName.toLowerCase())){
                b.displayData();
                check= true;
            }
        }
        if (!check){
            System.err.println("Không tìm thấy sách!");
        }
    }

    //6. Thay đổi trạng thái của sách theo mã sách
    public static void updateStatus() {
        boolean isCheck = true;
        int inputId;
        int index = 0;
        System.out.print("Nhập mã sách mà bạn muốn xoá: ");
        inputId = InputMethods.getInteger();
        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).getBookId() != inputId) {
                System.out.print("Không tìm thấy mã sách mà bạn muốn xoá");
                return;
            } else {
                index = i;
            }
        }
        if (isCheck) {
            listBooks.get(index).setBookStatus(!listBooks.get(index).isBookStatus());
            System.out.printf("Đã thay đổi trạng thái sách có mã %d\n", inputId);

        }
    }


}
