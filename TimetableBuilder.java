import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class TimetableBuilder {

    ArrayList<Course> courses = new ArrayList<Course>();
    int semester;
    int year;

    public static void main(String[] args) {

        TimetableBuilder timetableBuilder = new TimetableBuilder(); 

        // read file
        try {
            File file = new File("SuhaTimetable.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line == "#") {
                    // read course number
                    // read course name
                    // read course inst
                    // read num of lecs
                    // read hours
                } else {
                    line = scanner.nextLine(); 
                    String[] splitString = line.trim().split("\\s+");
                    timetableBuilder.setSemester(Integer.parseInt(splitString[0]));
                    timetableBuilder.setYear(Integer.parseInt(splitString[1]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // extract year and sem
        // extract courses
        // create a 2D timetable like array
        // fill array with course number
        // attempt to randomly find a free hour
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}