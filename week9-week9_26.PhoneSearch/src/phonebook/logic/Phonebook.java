package phonebook.logic;

import java.util.*;

public class Phonebook {

    Map<String, Person> people = new HashMap<String, Person>();


    public String findPhoneByName(String name){
        Person person = people.get(name);
        if(person == null) return "  not found";
        StringBuilder sb = new StringBuilder();
        for (String s : person.getPhoneNumbers())
        {
            sb.append(" ");
            sb.append(s);
            sb.append("\n");
        }
        return "\n" + sb;
    }

    public void removeByName(String name){
        people.remove(name);
    }

    private Person findPersonByPhone(String phone){
        for (String name : this.people.keySet()){
            Person tempPerson = this.people.get(name);
            for (String phoneNumber : tempPerson.getPhoneNumbers()) {
                if (phoneNumber.equals(phone)) return tempPerson;
            }
        }
        return null;
    }

    public String findNameByPhone(String number){
        Person person = findPersonByPhone(number);
        if (person == null)return " not found";
        return " " + person.getName();
    }

    public Person findInfoByName(String name){
        return people.get(name);
    }

    public Person findByName(String name){
        Person person = findPerson(name);
        return person;
    }

    private List<Person> findPeopleByKeyword(String keyword){
        List<Person> matches = new ArrayList<Person>();
        for (String name : this.people.keySet()){
            Person tempPerson = this.people.get(name);
            if (keyword.isEmpty()) {
                matches.add(tempPerson);
            } else if (tempPerson.getName().contains(keyword)){
                matches.add(tempPerson);
            }  else if (tempPerson.getAddress() != null){
                if(tempPerson.getAddress().contains(keyword) || tempPerson.getCity().contains(keyword)) {
                    matches.add(tempPerson);
                }
            }
        }
        Collections.sort(matches);
        return matches;
    }

    public String filterByKeyword(String keyword){
        List<Person> matches = findPeopleByKeyword(keyword);
        if (matches.isEmpty()) return " keyword not found";
        StringBuilder sb = new StringBuilder();
        for (Person person : matches)
        {
            sb.append(" ");
            sb.append(person.getName());
            sb.append(person.toString());
        }
        return "\n" + sb;
    }


    private Person findPerson(String name){
        Person person = people.get(name);
        if (person == null){
            person = new Person();
            people.put(name, person);
            person.setName(name);
        }
        return person;
    }

    public void addPerson(String name, String address, String city){
        Person person = findPerson(name);
        person.setAddress(address);
        person.setCity(city);
    }

    public void addPerson(String name, String phoneNumber){
        Person person = findPerson(name);
        person.addNumber(phoneNumber);
    }


}
