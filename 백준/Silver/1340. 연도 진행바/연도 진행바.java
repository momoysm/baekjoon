import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input = br.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "MMMM d, yyyy HH:mm"
                , Locale.ENGLISH);

            LocalDateTime day = LocalDateTime.parse(input, formatter);
            LocalDateTime start = LocalDateTime.of(day.getYear(), 1, 1, 0, 0);
            LocalDateTime end = LocalDateTime.of(day.getYear()+1, 1, 1, 0, 0);

            long totalMinute = ChronoUnit.MINUTES.between(start, end);
            long passedMinute = ChronoUnit.MINUTES.between(start, day);

            double result = (double) passedMinute / totalMinute * 100;

            bw.write(result + "");
            bw.flush();
        }
    }

}