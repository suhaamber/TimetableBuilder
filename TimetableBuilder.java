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

                    for (int i = 0; i < numberOfLectures; i++) {
                        lectures = scanner.nextLine().trim().split("\\s+");
                        Hour tempHour = new Hour(lectures[0].toCharArray(), Integer.parseInt(lectures[1]));
                        tempCourse.addLectureHour(tempHour);
                    }
                    // read lab hours
                    for (int i = 0; i < numberOfLabs; i++) {
                        lectures = scanner.nextLine().trim().split("\\s+");
                        Hour tempHour = new Hour(lectures[0].toCharArray(), Integer.parseInt(lectures[1]));
                        tempCourse.addLabHour(tempHour);
                    }
                    // read tutorial hours
                    for (int i = 0; i < numberOfTutorials; i++) {
                        lectures = scanner.nextLine().trim().split("\\s+");
                        Hour tempHour = new Hour(lectures[0].toCharArray(), Integer.parseInt(lectures[1]));
                        tempCourse.addTutorialHour(tempHour);
                    }
                    timetableBuilder.addCourse(tempCourse);

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

        Hour freeHour = timetableBuilder.returnFreeHour();
        freeHour.printHour();

    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Hour returnFreeHour()
    {
        Hour tempHour = new Hour(); 
        int tempDay, tempPeriod; 
        //create a 2D array that represents a timetable
        boolean[][] timetable = new boolean[5][9]; 
        
        for (Course course : this.courses) {
            for (Hour hour : course.lectureHours) {
                if(hour.day.equals("Su".toCharArray()))
                    tempDay = 0; 
                else if(hour.day.equals("Mo".toCharArray()))
                    tempDay = 1;
                else if(hour.day.equals("Tu".toCharArray())) 
                    tempDay = 2; 
                else if(hour.day.equals("We".toCharArray()))
                    tempDay = 3; 
                else
                    tempDay = 4; 
                tempPeriod = hour.period - 1;
                timetable[tempDay][tempPeriod] = true; 
            }
            for(Hour hour: course.labHours){
                if(hour.day.equals("Su".toCharArray()))
                    tempDay = 0; 
                else if(hour.day.equals("Mo".toCharArray()))
                    tempDay = 1;
                else if(hour.day.equals("Tu".toCharArray())) 
                    tempDay = 2; 
                else if(hour.day.equals("We".toCharArray()))
                    tempDay = 3; 
                else
                    tempDay = 4; 
                tempPeriod = hour.period - 1; 
                timetable[tempDay][tempPeriod] = true; 
            }
            for(Hour hour: course.tutorialHours){
                if(hour.day.equals("Su".toCharArray()))
                    tempDay = 0; 
                else if(hour.day.equals("Mo".toCharArray()))
                    tempDay = 1;
                else if(hour.day.equals("Tu".toCharArray())) 
                    tempDay = 2; 
                else if(hour.day.equals("We".toCharArray()))
                    tempDay = 3; 
                else
                    tempDay = 4; 
                tempPeriod = hour.period - 1; 
                timetable[tempDay][tempPeriod] = true; 
            }
        }
        int randomDay = -1, randomPeriod = -1; 
        do{
        //use a randomizer to select a day and period
        
        //randomDay = ?; 
        //randomPeriod = ?; 
        
        //check if that hour is free

        //if yes, return that hour 
        //otherwise, run the randomizer again 
        
        }while(!timetable[randomDay][randomPeriod]); 

        switch(randomDay){
            case 0: tempHour.day = "Su".toCharArray();
                    break; 
            case 1: tempHour.day = "Mo".toCharArray();
                    break; 
            case 2: tempHour.day = "Tu".toCharArray();
                    break; 
            case 3: tempHour.day = "We".toCharArray();
                    break; 
            case 4: tempHour.day = "Th".toCharArray();
                    break; 
        }
        tempHour.period = randomPeriod + 1; 
        return tempHour; 
    }

    public static int getRandomDay(){
        //int randomDay = Min + (int)(Math.random() * ((Max - Min) + 1));
        return 0; 
    }

    public static int getRandomPeriod(){
        //int randomPeriod = Min + (int)(Math.random() * ((Max - Min) + 1));
        return 0; 
    }
}