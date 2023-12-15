import java.sql.SQLOutput;
import java.util.Scanner;

//Guesser class for guess the number
class Guesser
{
    int guessNum;
    public int guessNumber()
    {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Guesser kindly guess the number ranging from 0 to 10 : ");
            guessNum = sc.nextInt();
            if (guessNum<0 || guessNum>10){
                System.out.println("Enter valid number!");
            }
        }while (guessNum<0 || guessNum>10);
        return guessNum;
    }
}

class Player
{
    int pguessNum;
    public int getPguessNum()
    {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Player kindly guess the number: ");
        do{
            pguessNum = sc.nextInt();
            if(pguessNum<0 || pguessNum>10){
                System.out.println("The number should be from 0 to 10!");
            }
        }while (pguessNum<0 || pguessNum>10);
        return pguessNum;

    }
}

class Umpire
{
    int flag = 1;
    int p1pnt=0;
    int p2pnt=0;
    int p3pnt=0;
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    public void collectNumFromGusser()
    {
        Guesser g = new Guesser();
        numFromGuesser = g.guessNumber();
    }
    public void collectNumFromPlayer()
    {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.print("Player1 Guess the number: ");
        numFromPlayer1 = p1.getPguessNum();
        System.out.print("Player2 Guess the number: ");
        numFromPlayer2 = p2.getPguessNum();
        System.out.print("Player3 Guess the number: ");
        numFromPlayer3 = p3.getPguessNum();
    }

    public void compare()
    {
        if(numFromGuesser==numFromPlayer1)
        {
            flag++;
            if (numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
            {
                System.out.println("All the players won this Round");
                p1pnt++;
                p2pnt++;
                p3pnt++;
            }
            else if (numFromGuesser==numFromPlayer2)
            {
                System.out.println("Player1 and Player2 won this Round");
                p1pnt++;
                p2pnt++;
            }
            else if (numFromGuesser==numFromPlayer3)
            {
                System.out.println("Player1 and Player3 won this Round");
                p1pnt++;
                p3pnt++;
            }
            else
            {
                System.out.println("Player1 won this Round");
                p1pnt++;
            }
        }
        else if(numFromGuesser==numFromPlayer2)
        {
            flag++;
            if (numFromGuesser==numFromPlayer3)
            {
                System.out.println("Player2 and Player3 won this Round");
                p2pnt++;
                p3pnt++;
            }
            else
            {
                System.out.println("player2 won this Round");
                p2pnt++;
            }
        }
        else if(numFromGuesser==numFromPlayer3)
        {
            flag++;
            System.out.println("Player3 won this Round");
            p3pnt++;
        }
        else
        {
            System.out.println("NO RESULT FOUND!");
            flag = 0;
        }
    }

    public void result()
    {
        System.out.println("Player1 got "+p1pnt+" Points");
        System.out.println("Player2 got "+p2pnt+" Points");
        System.out.println("Player3 got "+p3pnt+" Points");
    }
    public void displayWinner()
    {
        if(p1pnt>p2pnt && p1pnt>p3pnt)
        {
            System.out.println("PLAYER-1 IS WINNER");
        }
        else if(p2pnt>p1pnt && p2pnt>p3pnt)
        {
            System.out.println("PLAYER-2 IS WINNER");
        }
        else if(p3pnt>p1pnt && p3pnt>p2pnt)
        {
            System.out.println("PLAYER-3 IS WINNER");
        }
        else if(p1pnt==p2pnt && p1pnt>p3pnt)
        {
            System.out.println("PLAYER-1 AND PLAYER-2 ARE WINNERS");
        }
        else if(p1pnt==p3pnt && p1pnt>p2pnt)
        {
            System.out.println("PLAYER-1 AND PLAYER-3 ARE WINNERS");
        }
        else if(p2pnt==p3pnt && p2pnt>p1pnt)
        {
            System.out.println("PLAYER-2 AND PLAYER-3 ARE WINNERS");
        }
        else
        {
            System.out.println("GAME TIE");
        }

    }

}


public class Main {
    public static void main(String[] args) {
        System.out.println("*************************************GUESSER GAME******************************************");
        Umpire u = new Umpire();
        for (int i=0;i<4;i++)
        {
            if (i==0)
            {
                System.out.println("******************************* ROUND-1 ************************************");
            }
            else if (i==1) {
                System.out.println("******************************* ROUND-2 ************************************");
            }
            else if (i==2) {
                System.out.println("******************************* ROUND-3 ************************************");
            }
            else{
                System.out.println("******************************* ROUND-4 ************************************");
            }
            do{
                u.collectNumFromGusser();
                u.collectNumFromPlayer();
                u.compare();
            }  while (u.flag==0);
        }
        System.out.println("********************************************************************************************");
        u.result();
        System.out.println("********************************************************************************************");
        System.out.println("\n");
        System.out.println("*******************************THE FINAL WINNER*********************************************");
        u.displayWinner();

        System.out.println("**************************************FINISH***********************************************");

    }
}