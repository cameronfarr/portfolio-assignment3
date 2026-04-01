public class Bulbasaur extends Pokemon {
    public int x;
    public Bulbasaur(int level, double baseCatchRate){
        x = level;
        baseCatchRate = 0.2;
    }

    @Override
    public String toString(){
        return "A level " + x + " bulbasaur";
    }
}
