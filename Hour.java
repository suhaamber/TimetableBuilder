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
        //do nothing
    }

    public void printHour()
    {
        //String dayString = day.toString();
        System.out.println("Day: " + day[0] + day[1] + " Hour: " + period);
    }
}
