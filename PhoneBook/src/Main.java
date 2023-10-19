
public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        pb.add("Катя", 123456);
        pb.add("Катя", 456789);
        pb.add("Женя", 741852);

        System.out.println(pb.find("Катя"));
        System.out.println(PhoneBook.getPhoneBook());
        System.out.println(pb.find("Me"));

    }
}