package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Notes {
    public int id;
    public String surname;
    public int work_number;
    public int home_number;
    public String address;

    public Notes(int Id, String Surname, int Work_Number ,int Home_Number, String Address){
        this.id = Id;
        this.surname = Surname;
        this.work_number = Work_Number;
        this.home_number = Home_Number;
        this.address = Address;
    }

    public Notes(ArrayList<Notes> notes){

    }

    public void AddContact() throws IOException {
        ArrayList<Notes> notes = new ArrayList<>();
        notes.add(new Notes(this.id, this.surname, this.home_number, this.work_number, this.address));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter("contact.json")){
            gson.toJson(notes, writer);
        }
    }

    public void EditContact(int id) throws IOException{
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileReader reader = new FileReader("contact.json")){
            Notes[] notes = gson.fromJson(reader, Notes[].class);
            for (Notes note: notes) {
                if (note.id == id){
                    note.surname = scanner.nextLine();
                    note.work_number = scanner.nextInt();
                    note.home_number = scanner.nextInt();
                    note.address = scanner.nextLine();
                    try (FileWriter writer = new FileWriter("contact.json")){
                        gson.toJson(notes, writer);
                    }
                    break;
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void DeleteContact(int id) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileReader reader = new FileReader("contact.json")){
            Notes[] notes = gson.fromJson(reader, Notes[].class);
            ArrayList<Notes> notes_arr = new ArrayList<>();
            for (Notes note: notes) {
                if (note.id != id){
                    notes_arr.add(note);
                    try (FileWriter writer = new FileWriter("contact.json")){
                        gson.toJson(notes_arr, writer);
                    }
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void SelectContact() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileReader reader = new FileReader("contact.json")){
            Notes[] notes = gson.fromJson(reader, Notes[].class);
            for (Notes notes1: notes) {
                System.out.println("ID: " + notes1.id);
                System.out.println("Name: " + notes1.surname);
                System.out.println("Work number: " + notes1.work_number);
                System.out.println("Home number: " + notes1.home_number);
                System.out.println("Address: " + notes1.address);
            }
        }
    }

    public String FindContact(String findName) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileReader reader = new FileReader("contact.json")){
            Notes[] notes = gson.fromJson(reader, Notes[].class);
            for (Notes note: notes) {
                if(findName.equals(note.surname)){
                    System.out.println("ID: " + note.id);
                    System.out.println("Name: " + note.surname);
                    System.out.println("Work number: " + note.work_number);
                    System.out.println("Home number: " + note.home_number);
                    System.out.println("Address: " + note.address);
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
