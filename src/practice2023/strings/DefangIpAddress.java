package practice2023.strings;

public class DefangIpAddress {

    public static void main(String[] args) {
        System.out.println("Defanged IP Adress: " + defangIPaddr("1.1.1.1"));
        System.out.println("Defanged IP Adress: " + defangIPaddr("255.100.50.0"));
        System.out.println("Defanged IP Adress: " + defangIPaddr("127.0.0.1"));
    }

    public static String defangIPaddr(String address) {
        if(address == null || address.length() == 0) {
            return address;
        }
        return address.replace(".", "[.]");
    }
}
