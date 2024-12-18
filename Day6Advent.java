import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input");
        System.out.println(fileData);

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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
class FreeSpace {
    boolean visited = false;
    public void setVisited(){
        visited = true;
    }
}
class Guard{
    private int direction;
    Guard(){
        direction = 1;
    }
    void turn() {
        direction += 1;
        if(direction == 5)
            direction = 1;
    }
    int getDirection(){
        return direction;
    }
}
class Obstacle{
}
class Row{
    ArrayList<Object> b;
}