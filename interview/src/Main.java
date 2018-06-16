import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Integer> a = new HashMap<>();

        Integer b = 1;
        Integer c = 2;
        a.put(b, 1);
        a.put(c, 2);

        c = new Integer(1);

    /*    InputStream is = new FileInputStream("zhopa");
        Writer writer;
        writer.write(new char[10]);
        OutputStream os;
        os.write(new byte[10]);
        System.out.println(a.entrySet());*/

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher("12");
        System.out.println(matcher.matches());
    }
}
