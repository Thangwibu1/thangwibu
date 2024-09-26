package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Function {
    public String id;
    public String name;
    public int yob;
    public double gpa;
    private List<Student> sList;
    Scanner sc = new Scanner(System.in);
    public Function() {
        sList = new ArrayList<>();
    }
    public void addStudent() {
        clearScreen();
        System.out.print("Enter your student ID: ");
        id = sc.nextLine();
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your year of birth: ");
        yob = sc.nextInt();
        System.out.print("Enter your gpa: ");
        gpa = sc.nextDouble();

        sList.add(new Student(id, name, yob, gpa));
        
        System.out.println("Add student information sucessfull");
    }
    //Read file
    public void readFromFile() throws IOException {
        File f = new File("data.txt");
        if (!f.exists()) {
            System.out.println("New file already created");
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            } 
            String info[] = line.split("[|]");
            String id = info[0].trim();
            String name = info[1];
            int yob = Integer.parseInt(info[2].trim());
            double gpa = Double.parseDouble(info[3].trim());

            sList.add(new Student(id, name, yob, gpa));
        }

        br.close();
        fr.close();
    }

    public void display() {
        clearScreen();
        if (!sList.isEmpty()) {
            System.out.println("Don't have student! PLease add something!");
            return;
        }
        for (Student student : sList) {
            System.out.println(student);
        }
    }
    //Write document to file
    public void saveToFile() throws IOException {
        File f = new File("data.txt");
        FileWriter fr = new FileWriter(f);
        BufferedWriter br = new BufferedWriter(fr);
        for (Student student : sList) {
            br.write(student.toString());
        }
        br.close();
        fr.close();
    } 

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
