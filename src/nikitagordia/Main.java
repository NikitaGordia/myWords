package nikitagordia;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static qReader file;
    public static conReader in;
    private static ArrayList<ArrayList<Pair> > list;
    private static int allWords;

    public static void main(String[] args) {
        /*if (args.length != 1) {
            lg("Wong quantity of arguments...");
            return;
        }*/
        file = new qReader("/home/nikita-gordia/Space/Workspace/Eng/Word");
        in = new conReader();
        list = qReader.getLessons();
        countAllWords();
        working();
    }

    private static void working() {
        lgn("myWords.1.0");
        lgn("Type 'exit' to return from program. Quantity of lessons : " + list.size() + ". Quantity of words : " + allWords);
        while (true) {
            lgn("\tPlease type the mode : ");
            lgn("\t\t'1' -> Check all words");
            lgn("\t\t'2' -> Check last n recording");
            lg("\t\t\tYou: ");
            String ln = in.getLine();
            switch (ln) {
                case "exit":
                    System.exit(0);
                    break;
                case "1": readyTest(list.size());
                    break;
                case "2": checkNRecording();
                    break;
            }
        }
    }

    private static void checkNRecording() {
        String ans;
        int x;
        while (true) {
            lg("Number of recording : ");
            ans = in.getLine();
            if (ans.equals("exit")) System.exit(0);
            try {
                x = Integer.parseInt(ans);
                if (x < 1 || x > list.size()) throw new NumberFormatException("");
                break;
            } catch (NumberFormatException e) {
                lgn("Wrong number!");
            }
        }
        readyTest(x);
    }

    private static void readyTest(int n) {
        ArrayList<Pair> res = new ArrayList<>();
        for (int i = list.size() - n; i < list.size(); i++)
            for (Pair x : list.get(i))
                res.add(x.getClone());
        Random r = new Random();
        for (int i = 0; i < res.size() * 100; i++) {
            int x = r.nextInt(res.size()), y = r.nextInt(res.size());
            Pair temp = res.get(x);
            res.set(x, res.get(y));
            res.set(y, temp);
        }
        for (Pair p : res)
            if (r.nextBoolean()) p.swap();
        new Test(res);
    }

    private static void countAllWords() {
        for (int i = 0; i < list.size(); i++)
            allWords += list.get(i).size();
    }

    public static void crash(String mess) {
        System.out.println(mess);
        System.exit(0);
    }

    public static void lgn(Object o) {
        System.out.println(o);
    }

    public static void lg(Object o) {
        System.out.print(o);
    }
}
