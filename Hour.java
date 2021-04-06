public class Hour {
    char[] day = new char[2]; 
    int period; 

    Hour(char[] day, int period){
        for (int i = 0; i < 2; i++) {
            this.day[i] = day[i];
        }
        this.period = period; 
    }

    Hour()
    {
        String temp = "  ";
        this.day = temp.toCharArray(); 
        period = 0; 
    }

    public void printHour()
    {
        String dayString = day.toString();
        System.out.println("Day: " + dayString + "Hour: " + period);
    }
}
