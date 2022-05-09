import java.util.*;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Board Size:");
        int boardsize = scan.nextInt();
        System.out.println("Enter Number of Dices:");
        int noofdice = scan.nextInt();
        System.out.println("Enter Number of Snakes:");
        int noofsnakes = scan.nextInt();

        Dice dice = new Dice(noofdice);
        HashMap<Integer,Integer> snakes = new HashMap<Integer,Integer>();
        scan.nextLine();
        while(noofsnakes-- > 0){
            String[] req = scan.nextLine().split(" ");
            int x = Integer.parseInt(req[0]);
            int y = Integer.parseInt(req[1]);
            snakes.put(x, y);
        }

        HashMap<Integer,Integer> ladders = new HashMap<Integer,Integer>();
        System.out.println("Enter Number of Ladders:");
        int noofladders = scan.nextInt();
        scan.nextLine();
        while(noofladders-- > 0){
            String[] req = scan.nextLine().split(" ");
            int x = Integer.parseInt(req[0]);
            int y = Integer.parseInt(req[1]);
            ladders.put(x, y);
        }

        Queue<Person> players = new LinkedList<Person>();
        System.out.println("Enter Number of Players:");
        int noofplayers = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<noofplayers;i++){
            String name = scan.nextLine();
            Person p = new Person(name);
            players.add(p);
        }
        scan.close();

        GameBoard Board = new GameBoard(dice, players, snakes, ladders, boardsize);
        Board.StartGame();
    }


}

