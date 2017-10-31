package nikitagordia;

import java.io.BufferedInputStream;
import java.io.IOException;

public class conReader {

    private static BufferedInputStream in;

    public conReader() {
        in = new BufferedInputStream(System.in);
    }

    public String getLine() {
        String str = "";
        int ch;
        try {
            while ((ch = in.read()) != '\n') str += (char)ch;
        } catch (IOException e) {
            Main.crash("Input error!");
        }
        if (str.equals("exit")) System.exit(0);
        return str;
    }
}
