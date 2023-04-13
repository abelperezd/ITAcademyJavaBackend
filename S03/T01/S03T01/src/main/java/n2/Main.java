package n2;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();

        //set a spanish factory
        book.setAddressFactory(new SpainAddressFactory());

        //add Spanish addresses
        addSpanishAddresses(book);

        //add Spanish numbers
        addSpanishNumbers(book);

        //change the factory type
        book.setAddressFactory(new USAddressFactory());

        //add USA addresses
        addUSAAddresses(book);

        //add USA numbers
        addUSANumbers(book);

        //print the data from the book
        printBookData(book);
    }

    private static void addSpanishAddresses(Book book) {
        SpainAddress a1 = (SpainAddress) book.createAddress();
        a1.insertAddress("Carrer de Gràcia", "20", "Sabadell", "Barcelona", "08201");
        book.addAddress(1, a1);

        SpainAddress a2 = (SpainAddress) book.createAddress();
        a2.insertAddress("Carrer de Sant Cristòfol", "15", "Matadepera", "Barcelona", "08230");
        book.addAddress(2, a2);
    }

    private static void addSpanishNumbers(Book book) {
        SpainNumber n1 = (SpainNumber) book.createNumber();
        n1.insertNumber("937", "405689");
        book.addNumber(1, n1);

        SpainNumber n2 = (SpainNumber) book.createNumber();
        n2.insertNumber("937", "568925");
        book.addNumber(2, n2);
    }

    private static void addUSAAddresses(Book book) {
        USAddress a3 = (USAddress) book.createAddress();
        a3.insertAddress("123 Main St", "", "Anytown", "CA", "12345");
        book.addAddress(3, a3);

        USAddress a4 = (USAddress) book.createAddress();
        a4.insertAddress("456 Elm St", "Apt 2B", "Otherville", "NY", "67890");
        book.addAddress(4, a4);
    }

    private static void addUSANumbers(Book book) {
        USNumber n3 = (USNumber) book.createNumber();
        n3.insertNumber("415", "5551212");
        book.addNumber(3, n3);

        USNumber n4 = (USNumber) book.createNumber();
        n4.insertNumber("212", "5553434");
        book.addNumber(4, n4);
    }

    private static void printBookData(Book book){
        System.out.println("Address 1: " + book.getAddress(1).getFullAddress());
        System.out.println("Numb 1: " + book.getNumber(1).getFullNumber());
        System.out.println("Address 3: " + book.getAddress(3).getFullAddress());
        System.out.println("Numb 3: " + book.getNumber(3).getFullNumber());
    }
}
