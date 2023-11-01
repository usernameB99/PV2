import java.util.ArrayList;
import java.util.Scanner;

public class Verwaltung {

    //personenverwaltung erstellen und zu liste hinzufügen
    //listen pv linz, pv cb usw hinzufügen

    //string to string methode zum ausdrucken der liste


    public ArrayList<Personenverwaltung> directorsList = new ArrayList<>();

    public static void main(String[] args) {

        Personenverwaltung cb = new Personenverwaltung("CB");
        Personenverwaltung linz = new Personenverwaltung("Linz");
        Personenverwaltung avengers = new Personenverwaltung("Avengers");

        Personenverwaltung current = null;

        Scanner sc = new Scanner(System.in);
        int select;
        boolean cont = true;

        System.out.println("Herzlich willkommen zur Personenverwaltung");

        do {


            System.out.println("Wöhlen Sie eine Personenverwaltung aus: \n1.) Coders Bay \n2.) Linz \n3.) Avengers");
            System.out.println(":q! Programm beenden");
            //select = sc.nextInt();

    /*
            String input = sc.nextLine(); // Lies die Eingabe als Zeichenkette

            if (":q!".equals(input)) {
                // Wirf die Ausnahme, um das Programm zu beenden
                throw new RuntimeException("Programm wird beendet.");
            }
*/
            //select = Integer.parseInt(input); // Konvertiere die Eingabe in eine Zahl

            select = Integer.parseInt(checkForProgramTermination());


            if (select == 1) {
                current = cb;
            } else if (select == 2) {
                current = linz;
            } else if (select == 3)  {
                current = avengers;
            } else  {
                System.out.println("Tschüss.");
                System.exit(0);
            }



            System.out.println("1.) Person anlegen \n2.) Person löschen\n3.) Person suchen");
            select = Integer.parseInt(checkForProgramTermination());

            if (select == 1) {
                System.out.println("Welches Informationspaket wollen Sie für die Person anlegen?");
                System.out.println("1.) Simple - Vorname / Nachname");
                System.out.println("2.) Advanced - Vorname / Nachname / Geschlecht / Geburtstag");
                System.out.println("3.) Premium - Vorname / Nachname / Geschlecht / Geburtstag / Straße / Nr / Plz / Stadt");
                select = Integer.parseInt(checkForProgramTermination());
                //sc.nextLine();

                if (select == 1) {
                    System.out.println("Vorname");
                    //checkForProgramTermination(input);   //neu zuweisen scanner
                    String FirstName = checkForValidPersonName();
                    System.out.println("Nachname");
                    //checkForProgramTermination(input);
                    String LastName = checkForValidPersonName();

                    current.createSimplePerson(FirstName, LastName);
                } else if (select == 2) {
                    System.out.println("Vorname");
                    String FirstName = checkForValidPersonName();
                    System.out.println("Nachname");
                    String LastName = checkForValidPersonName();
                    System.out.println("Geschlecht (männlich/weiblich/divers)");
                    Gender gender = Gender.valueOf(checkForProgramTermination());
                    System.out.println("Geburtstag");
                    String BirthDay = checkForProgramTermination();

                    current.createHigherPerson(FirstName, LastName, gender, BirthDay);
                } else if (select == 3) {
                    System.out.println("Vorname");
                    String FirstName = checkForValidPersonName();
                    System.out.println("Nachname");
                    String LastName = checkForValidPersonName();
                    System.out.println("Geschlecht (männlich/weiblich/divers)");
                    Gender gender = Gender.valueOf(checkForProgramTermination());
                    System.out.println("Geburtstag");
                    String BirthDay = checkForProgramTermination();
                    System.out.println("Straße");
                    String Street = checkForProgramTermination();
                    System.out.println("Nr");
                    String Nr = checkForProgramTermination();
                    System.out.println("Plz");
                    String Plz = checkForProgramTermination();
                    System.out.println("Stadt");
                    String City = checkForProgramTermination();

                    current.createFullPerson(FirstName, LastName, gender, BirthDay, Street, Nr, Plz, City);

                }

                //ArrayList<Person> list = current.getPv();
                //for (Person person : list) {
                //    System.out.println(person.getFirstName());
                //}

                for (Person person : current.getPv()) {
                    System.out.println(person.getFirstName());
                }

            } // Auswahl anlegen

            else if (select == 2){
                System.out.println("Sie haben löschen ausgewählt");

                for (int i = 0; i < current.getPv().size(); i++) {
                    System.out.println(i + ".) " + current.getPv().get(i).getFirstName());
                }

                System.out.println("Welche Person möchten Sie löschen?");
                select = sc.nextInt();

                current.getPv().remove(select);

            }

            else if (select == 3){
                System.out.println("Welche Person möchten Sie suchen?");
                containsPerson(current);

            }

        } while (cont); //main total

    }

    public void createPersonenverwaltung(String name) {

        directorsList.add(new Personenverwaltung(name));
    }

    public String toString() {


        String result = "";

        for (Personenverwaltung pv : directorsList) {
            result += pv.toString();
        }
        return result;
    }

    public static void containsPerson(Personenverwaltung toSearch){

        String searchName = checkForValidPersonName();
        boolean nameFound = false;
        String firstName;
        String lastName;

        try {

            for (int i = 0; i < toSearch.getPv().size(); i++) {
                firstName = toSearch.getPv().get(i).getFirstName();
                lastName = toSearch.getPv().get(i).getLastName();

                 if ((searchName.equals(firstName)) || (searchName.equals(lastName)))
                 {
                     nameFound = true;
                 }
            }
            if (nameFound){
                System.out.println("Name wurde gefunden");
            } else {

                    throw new NullPointerException();

            }
        } catch (NullPointerException e){
            System.out.println("NullPointException - Person wurde nicht gefunden.");
        }


    }

    public static String checkForProgramTermination() {
      Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            if (":q!".equals(input)) {
                throw new RuntimeException("Programm wird beendet.");
            }
        } catch (RuntimeException e) {
            System.exit(0);
        }


        System.out.println("---------checkForProgramTermination passed---------");
        return input;
    }


    public static String checkForValidPersonName() {
       Boolean stay = true;
       String name = "";
       // Scanner nameScanner = new Scanner(System.in);

        while (stay) {
            try {
                name = checkForProgramTermination();

                if (name.matches(".*\\d.*")) {
                    System.out.println("----- input has number ----- exit false");
                    //name= nameScanner.nextLine();
                    throw new RuntimeException("Ungültiger Name: Der Name darf keine Zahlen enthalten.");
                } else {
                    System.out.println("----- returninger bei void person shit passed----- ");
                    stay = false;
                    return name;

                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Bitte erneut eingeben:");
            }
        }
        return name;
    }



}
