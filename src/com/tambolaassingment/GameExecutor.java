package com.tambolaassingment;

public class GameExecutor implements  Runnable{
    static int randomNumberGenerated=0;

    @Override
    public void run() {

        while(!Player.housieStatus) {
            randomNumberGenerated = RandomNumberGenerator.numberGenerator();
            TambolaBoard.board.replace(randomNumberGenerated,true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args)  {
        System.out.println("Let's Begin the Tambola game \n");
        new TambolaBoard();
        GameExecutor gameExecutor = new GameExecutor();
        Thread gameExecutorThread = new Thread(gameExecutor);
        Player player1 = new Player("Priyanshu",new TicketChecker());
        Player player2 = new Player("Yansh",new TicketChecker());
        Thread player1thread = new Thread(player1);
        Thread player2thread = new Thread(player2);
        gameExecutorThread.start();
        player1thread.start();
        player2thread.start();
        }
}

