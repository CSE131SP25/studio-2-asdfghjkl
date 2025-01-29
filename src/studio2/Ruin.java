package studio2;
import java.util.Scanner;

public class Ruin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start Ammount: ");
        double startAmount = scanner.nextDouble();
        System.out.print("Win Chance: ");
        double winChance = scanner.nextDouble();
        System.out.print("Win Limit: ");
        double winLimit = scanner.nextDouble();
        System.out.print("Total Simulations: ");
        double totalSimulations = scanner.nextDouble();

        boolean win;
        int run = 0;
        int wins = 0;
        
        double expectedRuin = (1 - (startAmount / winLimit)) / (1 - Math.pow((startAmount / winLimit), totalSimulations));
        
        for (int i = 0; i < totalSimulations; i++) {
            run++;
            if (Math.random() < winChance) {
                win = true;
            } else {
                win = false;
            }
            if (win) {
                startAmount++;
                wins++;
                System.out.println("Simulation " + i + ": Win");
            } else {
                startAmount--;
                System.out.println("Simulation " + i + ": Loss");
            }
            if (startAmount == 0 || startAmount == winLimit || run == totalSimulations) {
                System.out.println("Losses: " + (totalSimulations - wins) + " Simulations: " + (run));
                System.out.println("Ruin Rate from Simulation: " + (totalSimulations - wins) / totalSimulations + " Expected Ruin Rate: " + expectedRuin);
                i = (int) totalSimulations;
            }
        }
    }
}