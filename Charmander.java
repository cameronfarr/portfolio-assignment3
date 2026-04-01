public class Charmander extends Pokemon{
    public int x;
    public Charmander(int level, double baseCatchRate){
        x = level;
        baseCatchRate = 0.2;
    }

    @Override
    public String toString(){
        return "A level " + x + " charmander";
    }
}
