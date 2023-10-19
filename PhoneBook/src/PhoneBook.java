import java.util.ArrayList;
import java.util.HashMap;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();


    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {phoneBook.get(name).add(phoneNum);}
        else {
            ArrayList<Integer> mmm = new ArrayList<>();
            mmm.add(phoneNum);
            phoneBook.put(name, mmm);
        }
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {return phoneBook.get(name);}
        else return new ArrayList<>();
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}