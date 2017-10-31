package nikitagordia;

import java.util.ArrayList;

public class Test {

    private long start;
    private int n, ok;
    private ArrayList<Pair> wrong;

    public Test(ArrayList<Pair> arr, int lim) {
        if (lim == -1) n = arr.size(); else n = lim;
        ok = 0;
        wrong = new ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            checkPair(arr.get(i % arr.size()), i);
        statistics();
    }

    private void statistics() {
        Main.lgn("------------------------------\\(*_*)/--------------------------------------");
        Main.lgn("--------| Time : " + ((int)(System.currentTimeMillis() - start) / 1000) + "s");
        Main.lgn("--------| Correct : " + ok);
        Main.lgn("--------| Incorrect : " + (n - ok));
        Main.lgn("--------| Statisctics : " + (((double)ok / n) * 100) + "%");
        Main.lgn("");
        for (Pair p : wrong) {
            Main.lgn("----! " + p.eng + "  ->   " + p.rus);
        }
        Main.lgn("");
    }

    private void checkPair(Pair p, int id) {
        Main.lgn("----------------| " + (id + 1) + " / " + n + " |(" + ((int)(System.currentTimeMillis() - start) / 1000) + "s)----------------");
        Main.lgn("--------| " + p.eng + " ?");
        Main.lg("--------| [Enter]");
        Main.in.getLine();
        Main.lg("--------| " + p.rus + "   [Answer] : ");
        String s = Main.in.getLine();
        if (s.indexOf("+") != -1) ok++; else wrong.add(p);
        Main.lgn("\n");
    }
}
