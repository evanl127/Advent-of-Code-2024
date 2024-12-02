import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Day1Advent {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> listOne = parseStringAL(fileData, 0);
        ArrayList<Integer> listTwo = parseStringAL(fileData, 1);
        listOne.sort(Comparator.naturalOrder());
        listTwo.sort(Comparator.naturalOrder());
        System.out.println(compareIAL(listTwo, listOne));
        System.out.println(similarityScore(listOne, listTwo));
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
    public static ArrayList<Integer> parseStringAL(ArrayList<String> fileData, int i){
        ArrayList<Integer> numList = new ArrayList<>();
        for(String a : fileData){
            String[] b = a.split(" ");
            if(i == 0){
                int c = Integer.parseInt(b[0]);
                numList.add(c);
            }
            else{
                int c = Integer.parseInt(b[3]);
                numList.add(c);
            }
        }
        return numList;
    }
    public static int compareIAL(ArrayList<Integer> a, ArrayList<Integer> b){
        int sumDistance = 0;
        for(int i = 0; i < a.size(); i++){
            sumDistance += Math.abs(a.get(i) - b.get(i));
        }
        return sumDistance;
    }
    public static int similarityScore(ArrayList<Integer> a, ArrayList<Integer> b){
        int similar = 0;
        for(int i = 0; i < a.size(); i++){
            int counter = 0;
            int c = a.get(i);
            for(int j = 0; j < b.size(); j++){
                if(c == b.get(j)){
                    counter++;
                }
            }
            similar += c * counter;
        }
        return similar;
    }
}