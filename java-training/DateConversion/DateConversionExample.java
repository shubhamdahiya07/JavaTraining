package DateConversion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversionExample {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println("Date: " + date.toString());
        String format = "MMM dd yyyy";
        // or String format = "dd-MM-yy";

        // Creating a date format object
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        // Applying the format on the date object
        String dateFormatted = simpleDateFormat.format(date);
        System.out.println("Formatted date: " + dateFormatted);
    }
}
