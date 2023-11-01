import java.util.ArrayList;

public class Personenverwaltung {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPv() {
        return pv;
    }

    private String name;
    private ArrayList <Person> pv = new ArrayList<>();

    public Personenverwaltung(String name) {
        this.name = name;
    }

// methode string to string zum ausdrucken listeninhalt



    public void createSimplePerson (String firstName, String lastName) {

        //Person person1 = new Person(firstName, lastName);
        pv.add(new Person(firstName,lastName));

    }

    public void createHigherPerson (String firstName, String lastName, Gender gender, String birthDay) {

        pv.add(new Person(firstName,lastName,gender,birthDay));

    }

    public void createFullPerson (String firstName, String lastName, Gender gender, String birthDay,String street, String nr, String plz, String city ) {

        Adress adress = new Adress(street,nr,plz,city);

        pv.add(new Person(firstName, lastName, gender, birthDay,adress));
    }

    public String toString() {
        //System.out.println(Person);

        String result = "";

        for (Person p : pv){
            result += p.toString();
        }
        return result;
    }

}



