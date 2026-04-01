public class Caterpie extends Pokemon {
    public int x;
    public Caterpie(int level, double baseCatchRate){
        x = level;
        baseCatchRate = 0.5;
    }

    @Override
    public String toString(){
        return "A level " + x + " caterpie";
    }
}
