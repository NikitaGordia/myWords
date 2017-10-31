package nikitagordia;

public class Pair {

    String eng, rus;

    public Pair(String eng, String rus) {
        this.eng = eng;
        this.rus = rus;
    }

    public Pair getClone() {
        return new Pair(eng, rus);
    }

    public void swap() {
        String temp = eng;
        eng = rus;
        rus = temp;
    }
}
