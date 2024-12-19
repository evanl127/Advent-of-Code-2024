import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day14Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day14Input");
        System.out.println(fileData);
        ArrayList<String> position = new ArrayList<>();
        ArrayList<String> coordMove = new ArrayList<>();
        for (String i : fileData){
            String[] a = i.split(" ");
            position.add(a[0].substring(2));
            coordMove.add(a[1].substring(2));
        }
        System.out.println(partOne(position,coordMove));

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
    public static long partOne(ArrayList<String> a, ArrayList<String> b){
        int quad1 = 0;
        int quad2 = 0;
        int quad3 = 0;
        int quad4 = 0;
        int xLength = 100;
        int yLength = 102;
        int xMid = 50;
        int yMid = 51;
        for(int i = 0; i < a.size(); i++){
            String[] coord = a.get(i).split(",");
            int x = Integer.parseInt(coord[0]);
            int y = Integer.parseInt(coord[1]);
            String[] moveset = b.get(i).split(",");
            int dX = Integer.parseInt(moveset[0]) * 100;
            int dY = Integer.parseInt(moveset[1]) * 100;
            x = (dX % xLength) + x;
            y = (dY % yLength) + y;
            x = x % xLength;
            y = y % yLength;
            if(x < 0)
                x += xLength;
            if(y < 0)
                y += yLength;
            if(x < xMid && y < yMid)
                quad1++;
            if(x > xMid && y < yMid)
                quad2++;
            if(x < xMid && y > yMid)
                quad3++;
            if(x > xMid && y > yMid)
                quad4++;
        }

        return ((long) quad1 * (long)quad2 * (long)quad3 * (long)quad4);
    }
}