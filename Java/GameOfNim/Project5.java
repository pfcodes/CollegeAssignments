import java.util.Scanner;
/**
 * Driver module for Game of Nim.
 * 
 * @author CS140 Instructors 
 * @version 2/27/2017
 */
public class Project5
{
    public static void main(String args[]) 
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the minimum number of marbles in your pile: ");
        int min = console.nextInt();
        
        System.out.print("Enter the maximum number of marbles in your pile: ");
        int max = console.nextInt();
        GameOfNim game = new GameOfNim(min, max);
        
        game.play();
    }
}
