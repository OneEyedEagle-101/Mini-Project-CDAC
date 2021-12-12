import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateTime {
    String date()
    {
    Date t1 =new Date();
        SimpleDateFormat dt1 =new SimpleDateFormat("dd:MM:yyyy    HH:mm");
       return dt1.format(t1);
    }
}
