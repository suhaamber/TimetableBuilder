import java.util.*;

public class Course {
    String courseNumber; 
    String courseName; 
    String courseInstructor; 
    int lecture, lab, tutorial; //number of lectures, labs and tutorials 

    ArrayList<Hour> lectureHours = new ArrayList<Hour>(); 
    ArrayList<Hour> labHours = new ArrayList<Hour>(); 
    ArrayList<Hour> tutorialHours = new ArrayList<Hour>(); 

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public void setNumberOfLectures(int lecture, int lab, int tutorial) {
        this.lecture = lecture;
        this.lab = lab; 
        this.tutorial = tutorial; 
    }

    public void addLectureHour(Hour hour){
        lectureHours.add(hour);
    }

    public void addLabHour(Hour hour){
        labHours.add(hour);
    }

    public void addTutorialHour(Hour hour){
        tutorialHours.add(hour); 
    }
}
