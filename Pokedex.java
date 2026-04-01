import java.util.ArrayList;
public class Pokedex {
    private ArrayList<String> myPokedex = new ArrayList<String>();

    public void addToDex(Pokemon pokemon){
        myPokedex.add(pokemon.toString());
    }

    @Override
    public String toString(){
        String list = " ";
        for(int i = 0; i < myPokedex.size(); i++){
            list = list + myPokedex.get(i) + "\n";
        }
        return list;
    }
}
