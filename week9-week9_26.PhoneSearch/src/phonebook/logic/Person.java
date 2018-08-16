package phonebook.logic;

import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable<Person> {

    private String city, address, name;
    private Set<String> phoneNumbers = new HashSet<String>();

    public Person(String name, String city, String address, String phoneNumber) {
        this.city = city;
        this.address = address;
        this.name = name;
        this.phoneNumbers.add(phoneNumber);
    }

    public Person() {
    }

    public Person(String name, String city, String address) {
        this(name, city, address, null);
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, String phoneNumber) {
        this(name, null, null, phoneNumber);
    }

    public void addNumber(String phoneNumber){
        this.phoneNumbers.add(phoneNumber);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "  " + addressToString() + "\n" + "  " + phoneNumbersToString();
    }

    private String addressToString(){
        if (this.address == null){
            return "address unknown";
        } else {
            return "address: " + this.address + " " + this.city;
        }
    }

    private String phoneNumbersToString(){
        if (this.phoneNumbers.isEmpty()){
            return "phone number not found";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : phoneNumbers)
            {
                sb.append("   ");
                sb.append(s);
                sb.append("\n");
            }
            return "phone numbers:" + sb;
        }
    }
}
