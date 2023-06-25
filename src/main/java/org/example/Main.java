package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Notes> notes = new ArrayList<>();
        notes.add(0,  new Notes(1, "Alexey Vasilievich", 072341212, 065523121, "Titova street"));
        notes.add(1,  new Notes(2, "Vasiliy Andreevich", 043412452, 0, "Academia Obrazcova street"));
        notes.add(2,  new Notes(3, "Maxim Aleksandrov", 052135676, 074621761, "Oleksandra Polya street"));
        notes.add(3,  new Notes(4, "Nikita Vassilena", 035463612, 0, "Slobazanskiy avenue"));
        Notes note = null;
        for(int i = 0; i < notes.size(); i++){
            note = notes.get(i);
        }
        int select;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Select in contact menu:\n1 - Add contact\n2 - Edit contact\n3 - Remove contact\n4 - Select contact\n5 - Find contact\n6 - Exit in contact");
            select = scanner.nextInt();
            scanner.nextLine();
            switch (select){
                case 1:
                    note.AddContact();
                    break;
                case 2:
                    System.out.println("Input id for edit contact: ");
                    note.EditContact(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Input id for remove contact: ");
                    note.DeleteContact(scanner.nextInt());
                    break;
                case 4:
                    note.SelectContact();
                    break;
                case 5:
                    System.out.println("Input name for select contact");
                    note.FindContact(scanner.nextLine());
                    break;
            }
        }while (select != 6);
    }
}