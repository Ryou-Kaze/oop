import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateConverter {
    public static LocalDate convertToDate(String dateStr){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(dateStr,formatter);
        }
        catch (DateTimeParseException e){
            System.out.println("Invalid date! Pls input in dd-MM-yyyy format");
            return null;
        }
    }
    public static String getDateNow(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter);
        return formattedDate;
    }
    public static boolean checkExpiry(String expDateStr){
        LocalDate today = LocalDate.now();
        return today.isAfter(convertToDate(expDateStr));
    }


}
