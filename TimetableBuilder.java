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

                if (line.equals("#")) {
                    Course tempCourse = new Course(); 
                    // read course number
                    line = scanner.nextLine(); 
                    tempCourse.setCourseNumber(line);
                    // read course name                    
                    line = scanner.nextLine(); 
                    tempCourse.setCourseNumber(line);
                    // read course inst
                    line = scanner.nextLine();
                    tempCourse.setCourseInstructor(line);
                    // read num of lecs
                    line = scanner.nextLine(); 
                    String[] lectures = line.trim().split("\\s+");
                    int numberOfLectures = Integer.parseInt(lectures[0]);
                    int numberOfTutorials = Integer.parseInt(lectures[1]);
                    int numberOfLabs = Integer.parseInt(lectures[2]);
                    tempCourse.setNumberOfLectures(numberOfLectures, numberOfLabs, numberOfTutorials);
                    // read lecture hours
                    
                    for(int i = 0; i < numberOfLectures; i++)
                    {
                        lectures = scanner.nextLine().trim().split("\\s+");
                        Hour tempHour = new Hour(lectures[0].toCharArray(), Integer.parseInt(lectures[1]));
                        tempCourse.addLectureHour(tempHour); 
                    }
                    //read lab hours
                    for(int i = 0; i < numberOfLabs; i++)
                    {
                        lectures = scanner.nextLine().trim().split("\\s+");
                        Hour tempHour = new Hour(lectures[0].toCharArray(), Integer.parseInt(lectures[1]));
                        tempCourse.addLabHour(tempHour); 
                    }
                    //read tutorial hours
                    for(int i = 0; i < numberOfTutorials; i++)
                    {
                        lectures = scanner.nextLine().trim().split("\\s+");
                        Hour tempHour = new Hour(lectures[0].toCharArray(), Integer.parseInt(lectures[1]));
                        tempCourse.addTutorialHour(tempHour); 
                    }
                } else {
                    String[] splitString = line.trim().split("\\s+");
                    timetableBuilder.setSemester(Integer.parseInt(splitString[0]));
                    timetableBuilder.setYear(Integer.parseInt(splitString[1]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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