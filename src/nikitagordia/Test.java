package nikitagordia;

import java.util.ArrayList;

public class Test {

    private long start;
    private int n, ok;
    private ArrayList<Pair> wrong;

    public Test(ArrayList<Pair> arr) {
        n = arr.size();
        ok = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < arr.size(); i++)
            checkPair(arr.get(i), i);
        for (int i = 0; i < arr.size(); i++)
            System.out.println("!" + arr.get(i).eng + " " + arr.get(i).rus);
    }

    private void checkPair(Pair p, int id) {
        Main.lgn("----------------| " + (id + 1) + " / " + n + " |(" + ((int)(System.currentTimeMillis() - start) / 1000) + "s)----------------");
        Main.lgn("--------| " + p.eng + " ?");
        Main.lg("--------| [Enter]");
        Main.in.getLine();
        Main.lg("--------| " + p.rus + "   [Answer] : ");
        String s = Main.in.getLine();
        if (s.equals("exit")) System.exit(0);
        if (s.indexOf(s) != -1) ok++; else wrong.add(p);
        Main.lgn("");
    }
}
