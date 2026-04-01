import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random pickNum = new Random();

        Pokedex myDex = new Pokedex();
        String keepPlaying = " ";

        do{
            Pokemon pokemon = spawn();

            boolean caught = false;
            do {
                float multiplier = throwBall();

                double bcr = pokemon.getBaseCatchRate();
                double cpm = 0.49985844;
                double catchProbability = 1 - Math.pow((1 - (bcr / (2 * cpm))), multiplier);

                float numPicked = pickNum.nextFloat();
                if (numPicked < catchProbability) {
                    System.out.println(pokemon.toString() + " Caught!");
                    myDex.addToDex(pokemon);
                    caught = true;
                } else {
                    System.out.println(pokemon.toString() + " jumped out, try again!");
                }
            }while(!caught);

            System.out.println("Continue Catching Pokemon? (Y or N)");
            keepPlaying = sc.nextLine();
        }while(keepPlaying.equalsIgnoreCase("N"));

        System.out.println(myDex.toString());
    }

    public static Pokemon spawn(){
        Random spawnNum = new Random();
        int pickedLevel = spawnNum.nextInt(21);
        int pokemonSpawned = spawnNum.nextInt(4);

        if(pokemonSpawned == 1){
            Pokemon bulbasaur = new Bulbasaur(pickedLevel, .2);
            System.out.println("You encounter " + bulbasaur.toString());
            return bulbasaur;
        }
        else if(pokemonSpawned == 2){
            Pokemon charmander = new Charmander(pickedLevel, .2);
            System.out.println("You encounter " + charmander.toString());
            return charmander;
        }
        else{
            Pokemon caterpie = new Caterpie(pickedLevel, .5);
            System.out.println("You encounter " + caterpie.toString());
            return caterpie;
        }

    }

    public static float throwBall(){
        Scanner sc = new Scanner(System.in);
        float ballMultiplier;
        float berryMultiplier;
        float curveMultiplier;

        System.out.println("What type of ball do you wish to use? (Poke, Great, Ultra)");
        String usedBall = sc.nextLine();

        if(usedBall.equals("Great")){
            ballMultiplier = 1.5f;
        }
        else if(usedBall.equals("Ultra")){
            ballMultiplier = 3f;
        }
        else{
            ballMultiplier = 1f;
        }

        System.out.println("What berry do you wish to use? (None, Razz, SilverPinap, GoldenRazz)");
        String usedBerry = sc.nextLine();

        if(usedBerry.equals("Razz")){
            berryMultiplier = 1.5f;
        }
        else if(usedBerry.equals("SilverPinap")){
            berryMultiplier = 1.8f;
        }
        else if(usedBerry.equals("GoldenRazz")){
            berryMultiplier = 2.5f;
        }
        else{
            berryMultiplier = 1f;
        }

        System.out.println("Is this a curveball? (Yes or No)");
        String curveQuestion = sc.nextLine();

        if(curveQuestion.equals("Yes")){
            curveMultiplier = 1.7f;
        }
        else{
            curveMultiplier = 1f;
        }

        float multipliersTogether = curveMultiplier * berryMultiplier * ballMultiplier;
        return multipliersTogether;
    }
}
