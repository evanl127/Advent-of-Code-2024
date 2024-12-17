import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13Advent {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day13Input");
        ArrayList<Game> games = parseGame(fileData);
        System.out.println(partOne(games));
        System.out.println(partTwo(games));
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static ArrayList<Game> parseGame(ArrayList<String> fileData) {
        ArrayList<Game> games = new ArrayList<Game>();
        for (int i = 0; i < fileData.size(); i += 3) {
            String buttonAInfo = fileData.get(i);
            String buttonBInfo = fileData.get(i + 1);
            String prizeInfo = fileData.get(i + 2);
            long buttonAxChange = Long.parseLong(buttonAInfo.split(":")[1].split(",")[0].trim().split("\\+")[1]);
            long buttonAyChange = Long.parseLong(buttonAInfo.split(":")[1].split(",")[1].trim().split("\\+")[1]);
            long buttonBxChange = Long.parseLong(buttonBInfo.split(":")[1].split(",")[0].trim().split("\\+")[1]);
            long buttonByChange = Long.parseLong(buttonBInfo.split(":")[1].split(",")[1].trim().split("\\+")[1]);
            long prizeX = Long.parseLong(prizeInfo.split(":")[1].split(",")[0].trim().split("=")[1]);
            long prizeY = Long.parseLong(prizeInfo.split(":")[1].split(",")[1].trim().split("=")[1]);
            Button a = new Button(buttonAxChange, buttonAyChange);
            Button b = new Button(buttonBxChange, buttonByChange);
            Game g = new Game(a, b, prizeX, prizeY);
            games.add(g);
        }
        return games;
    }
    public static int partOne(ArrayList<Game> game){
        int tokens = 0;
        for(int i = 0; i < game.size(); i ++){
            Game temp = game.get(i);
            long aChangeX = temp.getA().getxChange();
            long aChangeY = temp.getA().getyChange();
            long bChangeX = temp.getB().getxChange();
            long bChangeY = temp.getB().getyChange();
            long xCoord = temp.getxGoal();
            long yCoord = temp.getyGoal();
            long differenceB = xCoord * aChangeY - yCoord * aChangeX;
            differenceB = Math.abs(differenceB);
            long changeDiffB = bChangeX * aChangeY - bChangeY * aChangeX;
            changeDiffB = Math.abs(changeDiffB);
            long differenceA = xCoord * bChangeY - yCoord * bChangeX;
            differenceA = Math.abs(differenceA);
            long changeDiffA = aChangeX * bChangeY - aChangeY * bChangeX;
            changeDiffA = Math.abs(changeDiffA);
            if(differenceB % changeDiffB == 0 && (differenceB / changeDiffB <= 100)) {
                long bTimes1 = differenceB / changeDiffB;
                long aTimes1 = xCoord - (bTimes1 * bChangeX);
                aTimes1 = aTimes1 / aChangeX;
                tokens += (int) (aTimes1 * 3 + bTimes1);
            }
            else if(differenceA % changeDiffA == 0 && (differenceA / changeDiffA <= 100)){
                long aTimes2 = differenceA % changeDiffA;
                long bTimes2 = xCoord - (aTimes2 * aChangeX);
                bTimes2 = bTimes2 / bChangeX;
                tokens += (int) (aTimes2 * 3 + bTimes2);
                }


        }
        return tokens;
    }
    public static long partTwo(ArrayList<Game> game){
        long tokens = 0;
        for(int i = 0; i < game.size(); i ++){
            Game temp = game.get(i);
            long aChangeX = temp.getA().getxChange();
            long aChangeY = temp.getA().getyChange();
            long bChangeX = temp.getB().getxChange();
            long bChangeY = temp.getB().getyChange();
            long xCoord = temp.getxGoal() + 10000000000000L;
            long yCoord = temp.getyGoal() + 10000000000000L;
            long bTimes = (xCoord*aChangeY-yCoord*aChangeX)/(aChangeY*bChangeX-bChangeY*aChangeX);
            long aTimes = (xCoord*bChangeY-yCoord*bChangeX)/(bChangeY*aChangeX-bChangeX*aChangeY);
            if(aTimes * aChangeX + bChangeX * bTimes == xCoord && aTimes * aChangeY + bChangeY * bTimes == yCoord) {
                tokens += (aTimes * 3 + bTimes);
                System.out.println(i);
            }


        }
        return tokens;
    }

}
class Game {
    private Button a;
    private Button b;
    private long xGoal;
    private long yGoal;

    public Game(Button a, Button b, long xGoal, long yGoal) {
        this.a = a;
        this.b = b;
        this.xGoal = xGoal;
        this.yGoal = yGoal;
    }

    public Button getA() {
        return a;
    }

    public Button getB() {
        return b;
    }

    public long getxGoal() {
        return xGoal;
    }

    public long getyGoal() {
        return yGoal;
    }

    public void setxGoal(long xGoal) {
        this.xGoal = xGoal;
    }

    public void setyGoal(long yGoal) {
        this.yGoal = yGoal;
    }

    public String toString() {
        return a + "\n" + b + "\n" + "Prize: " + "X=" + xGoal + ", Y=" + yGoal;
    }
}

class Button {
    private long xChange;
    private long yChange;

    public Button(long xChange, long yChange) {
        this.xChange = xChange;
        this.yChange = yChange;
    }

    public long getxChange() {
        return xChange;
    }

    public long getyChange() {
        return yChange;
    }

    public String toString() {
        return "Button: " + "X+" + xChange + ", Y+" + yChange;
    }
}
