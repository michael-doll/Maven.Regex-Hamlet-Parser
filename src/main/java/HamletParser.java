import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public void writeFile(String toFile) {
        String current = loadFile();
        System.out.println(current);
//        Boolean appendToFile = false;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            FileWriter fileWriter = new FileWriter(classLoader.getResource("hamlet.txt").getFile());
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getHamletData(){
        return hamletData;
    }

    public Boolean findHoratio(){
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
      return matcher.find();
    }

    public Boolean findHamlet(){
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        return matcher.find();
    }

    //**
    public void changeHamletToLeon() {
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer stringBuffer = new StringBuffer();
        while(findHamlet()){
            matcher.appendReplacement(stringBuffer, "Leon");
        }
        writeFile(stringBuffer.toString());
    }

    //**
    public void changeHoratioToTariq(){
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer stringBuffer = new StringBuffer();
        while(findHoratio()){
            matcher.appendReplacement(stringBuffer, "Tariq");
        }
        writeFile(stringBuffer.toString());
    }


}
