package nikitagordia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class qReader {

    private static Scanner in;
    private static boolean fileFound;

    public qReader(String path) {
        try {
            in = new Scanner(new File(path));
            fileFound = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileFound = false;
        }
    }

    public static ArrayList<ArrayList<Pair> > getLessons() {
        if (!fileFound) return null;
        ArrayList<ArrayList<Pair> > res = new ArrayList<>();
        ArrayList<Pair> now = new ArrayList<>();
        while (in.hasNextLine()) {
            String curr = in.nextLine();
            if (isGap(curr)) {
                if (!now.isEmpty()) {
                    res.add(now);
                    now = new ArrayList<>();
                }
                continue;
            }
            now.add(createPair(curr));
        }
        if (!now.isEmpty()) res.add(now);
        in.close();
        return res;
    }

    private static Pair createPair(String str) {
        int first, last;
        first = last = -1;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '\t') {
                last = i;
                if (first == -1) first = i;
            }
        return new Pair(str.substring(0, first), str.substring(last + 1, str.length()));
    }

    private static boolean isGap(String str) {
        for (int i = 0; i < str.length(); i++)
            if (isLetter(str.charAt(i))) return false;
        return true;
    }

    private static boolean isLetter(char ch) {
        return isEngLetter(ch) || isRusLetter(ch);
    }

    private static boolean isEngLetter(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private static boolean isRusLetter(char ch) {
        return (ch >= 'а' && ch <= 'я');
    }
}
