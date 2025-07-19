package MiscLessonPractice.src;
import java.util.Scanner;

public class MethodPrac {
    public static void main(String[] args) {
        System.out.println("Welcome to the Stats Program");
        printLogo();    
        //String batter = "Jones";
        // int hits = 183;
        // int atBats = 536;
        int er;
        int ip;
        int innings;
        float ERA;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Earned Runs: ");
        er = input.nextInt();
        System.out.println("Enter Innings Pitched: ");
        ip = input.nextInt();
        System.out.println("Enter Total Innings: ");
        innings = input.nextInt();
        // System.out.println("Batting average for " + batter + " is " +
        // battingAvg(hits, atBats));
        System.out.println("Your ERA is " + calculateERA(er, ip, innings));
        ERA = calculateERA(er,ip,innings);
        nameThatPitcher(ERA);
        input.close();
    }

    public static float calculateERA(int r, int i, int ip) {
        float earnedRuns = r;
        float innings = i;
        float inningsPitched = ip;
        float ERA = (earnedRuns * innings) / inningsPitched;
        return ERA;
    }

    public static int battingAvg(int h, int a) {
        float hits = h;
        float atBats = a;
        float avg = (hits / atBats) * 1000;
        return (int) avg;
    }

    public static void printLogo() {
        System.out.println("***********************************");
        System.out.println("******PARKER'S PITCHING STATS******");
        System.out.println("***********************************");
    }
    public static void nameThatPitcher(float e){
        float era = e;
        if(era < 2){
            System.out.println("Great ERA!");
        } else {
            System.out.println("Needs improvement. Where is Herby?");
        }
    }
}