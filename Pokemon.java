public class Pokemon {
    private int level;
    private double baseCatchRate;

    public Pokemon(){
        level = 0;
        baseCatchRate = 0;
    }

    public Pokemon (int l, double bCR){
        level = l;
        baseCatchRate = bCR;
    }

    public int getLevel(){
        return level;
    }

    public double getBaseCatchRate() {
        return baseCatchRate;
    }
}
