import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Karol on 12.05.2017.
 */
public class DataSaver {
    public static void writeToFile(String path, List<String> titles, List<String> links){
        String fileName = generateFileName();
        char lastPathChar = path.charAt(path.length()-1);
        if(lastPathChar != '/' && lastPathChar !='\\')
            path+="/";
        try {
            File file = new File(path + fileName);
            PrintWriter printWriter = new PrintWriter(file);
            for(int i=0; i<titles.size(); i++){
                printWriter.println(titles.get(i) + " " + links.get(i));
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String generateFileName(){
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
        return dateFormat.format(calendar.getTime()) + ".txt";
    }
}
