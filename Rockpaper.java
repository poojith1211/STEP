import java.util.*;

public class Rockpaper {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove))
            return "Draw";

 if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }
    public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock", "Paper", "Scissors"};
int wins = 0, losses = 0, draws = 0;
        int n = 5;

        System.out.println("Rock Paper Scissors Game");

 for (int i = 1; i <= n; i++) {
   System.out.print("Enter your move: ");
     String playerMove = sc.next();

     playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();
            Random r = new Random();
    String computerMove = moves[r.nextInt(3)];
 String result = playRound(playerMove, computerMove);

            System.out.println("Round " + i);
     System.out.println("Player   : " + playerMove);
            System.out.println("Computer : " + computerMove);
            System.out.println("Result   : " + result);
            System.out.println();

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("----- Final Summary -----");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage);
    }
}