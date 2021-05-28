public class Main {
    public static void main(String[] args){
        int counter = 0;
        Board myBoard = new Board();
        myBoard.printBoard();
        while(!myBoard.isSolved()) {
            myBoard.update3d();
            myBoard.change1s();
            myBoard.printPossBoard();
            myBoard.printBoard();
            counter++;
            System.out.println(counter + " iterations");
            if (myBoard.stuck()){
                System.out.println("I GIVE UP");
                break;
            }
        }



    }
}
