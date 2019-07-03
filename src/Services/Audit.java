package Services;
import java.io.*;
import java.util.List;
import java.util.Date;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Audit {
    private static Audit ourInstance = new Audit();
    private FileWriter csvWriter;


    public static Audit getInstance() {
        return ourInstance;
    }

    private Audit() {
        try{
            csvWriter = new FileWriter("audit.csv");
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void update(String nume, String data){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            csvWriter.append(nume);
            csvWriter.append(",");
            csvWriter.append(data);
            csvWriter.append("\n");
            csvWriter.flush();
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
