import java.util.HashMap;
import java.util.Queue;

public class GameBoard {
    private Dice dice;
    private Queue<Person> nextTurn;
    private HashMap<Integer,Integer> Snakes;
    private HashMap<Integer,Integer> Ladders;
    private int BoardSize;

    GameBoard(Dice dice,Queue<Person> nextTurn,HashMap<Integer,Integer> Snakes,HashMap<Integer,Integer> Ladders,int BoardSize){
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.Snakes = Snakes;
        this.Ladders = Ladders;
        this.BoardSize = BoardSize;
    }

    public void StartGame(){
        while(nextTurn.size() > 1){
            Person person = nextTurn.poll();
            int currLocation = person.getLocation(); 
            int nextLocation = currLocation + dice.DiceNumber();
            if (nextLocation > BoardSize){
                nextTurn.add(person);
            }
            else if (nextLocation < BoardSize ){
                if (Snakes.containsKey(nextLocation)){
                    nextLocation = Snakes.get(nextLocation);
                    System.out.println(person.getName() + " moved to " + nextLocation + " after snake dinner...");
                }
                else if(Ladders.containsKey(nextLocation)){
                    nextLocation = Ladders.get(nextLocation);
                    System.out.println(person.getName() + " moved to " + nextLocation + " after climbing the ladder...");
                }
                else{
                    System.out.println(person.getName() + " moved to " + nextLocation + ".");
                }
                nextTurn.add(person);
                person.setLocation(nextLocation);
            }
            else if(nextLocation == BoardSize){
                System.out.println(person.getName() + " moved to " + BoardSize + " and won the game!");
            }
            
        }
    }
    
}
