package phonebook.ui;

import phonebook.logic.Person;
import phonebook.logic.Phonebook;

import java.util.Scanner;

public class TextUserInterface {

    Scanner reader;
    Phonebook phonebook;

    public TextUserInterface(Scanner reader) {
        this.reader = reader;
        this.phonebook = new Phonebook();
    }

    public void start(){
        menu();
        System.out.println();
        while(true){
            System.out.println("command:");
            String command = reader.nextLine();
            if (command.equals("1")){
                addNumber();
            } else if(command.equals("2")){
                searchForNumber();
            } else if(command.equals("3")){
                searchByPhoneNumber();
            } else if(command.equals("4")){
                addAddress();
            } else if(command.equals("5")){
                searchForInfo();
            } else if(command.equals("6")){
                deletePerson();
            } else if(command.equals("7")){
                filter();
            } else if(command.equals("x")){
                break;
            }
        }
    }

    public void menu(){
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println("1 add a number");
        System.out.println("2 search for a number");
        System.out.println("3 search for a person by phone number");
        System.out.println("4 add an address");
        System.out.println("5 search for personal information");
        System.out.println("6 delete personal information");
        System.out.println("7 filtered listing");
        System.out.println(" x quit");
    }

    public void addNumber(){
        System.out.println("whose number:");
        String name = reader.nextLine();
        System.out.println("number:");
        String number = reader.nextLine();
        phonebook.addPerson(name, number);
    }

    public void searchForNumber(){
        System.out.println("whose number:");
        String name = reader.nextLine();
        System.out.println(phonebook.findPhoneByName(name));
    }

    public void searchByPhoneNumber(){
        System.out.println("number:");
        String number = reader.nextLine();
        System.out.println(phonebook.findNameByPhone(number));
    }

    public void addAddress(){
        System.out.println("whose address:");
        String name = reader.nextLine();
        System.out.println("street:");
        String address = reader.nextLine();
        System.out.println("city:");
        String city = reader.nextLine();
        phonebook.addPerson(name, address, city);
    }

    public void searchForInfo(){
        System.out.println("whose information:");
        String name = reader.nextLine();
        Person person = phonebook.findInfoByName(name);
        if (person == null){
            System.out.println("  not found");
        } else {
            System.out.println(person);
        }
    }

    public void deletePerson(){
        System.out.println("whose information");
        String name = reader.nextLine();
        phonebook.removeByName(name);
    }

    public void filter(){
        System.out.println("keyword (if empty, all listed):");
        String keyword = reader.nextLine();
        System.out.println(phonebook.filterByKeyword(keyword));
    }


}
