import java.util.*;

public class Course {
    String courseName; 
    String courseInstructor; 
    int lecture, lab, tutorial; //number of lectures, labs and tutorials 

    ArrayList<Hour> lectureHours = new ArrayList<Hour>(); 
    ArrayList<Hour> labHours = new ArrayList<Hour>(); 
    ArrayList<Hour> tutorialHours = new ArrayList<Hour>(); 

}
