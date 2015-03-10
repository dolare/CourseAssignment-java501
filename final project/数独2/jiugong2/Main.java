/*
 * the original algorithm,with no acceleration
 */

package jiugong2;
import java.util.*;
/**
 *
 * @author xqg
 */
public class Main {
    static int [][] a =
        {{3,9,4},
         {2,1,5},
         {8,7,6}};

    static int [][] b ={
        {2,3,4},
        {9,1,5},
        {8,7,6}};
    public static void main(String[] args) throws Exception {

        // input the params
        input();
        //use to calculate the time is cost to complete the searth.
        Timer timer = new Timer();
        timer.begin();

        // initial the first state
        State first = new State(3,0);
        first.cell = a;

        // set the last state
        State last = new State(3,0);
        last.cell = b;

        first.print();
        first.print();
        // add the first state into the queue
       Queue queue = new Queue();
       queue.addLast(first);
       
       // begin the calc
       while(queue.hasElement()) {
           // if the queue is empty, then the search failed.
           if (!queue.hasElement()) {
               System.out.println("search failed.");
               return;
           }
           // get the current state
           State nowState = queue.popFirstObject();
           Position nowPos = nowState.onePosition();

           // check the four directions
           for (int i=0;i<4;i++) {
               if (nowPos.check(Directions.d[i])) {
                   // get the new state
                   State newState = nowState.copy();
                   // add the steps
                   newState.addSteps();
                   
                   newState.move(Directions.d[i]);
                   newState.setFather(nowState);
                   
                   // insert the new state into the queue
                   queue.addLast(newState);
                   
                   // check whether the new state is the finnal state
                   if (newState.equals(last)) {
                       // the timer stops
                       timer.end();
                       System.out.println("total time cost : " + timer.getCost() + " milliseconds");

                       System.out.println("total steps is : " + newState.getSteps());
                       System.out.println("this is the finnal state.");
                       System.out.println("total state in the queue: " + queue.getLast());
                       System.out.println("the route is as follows:");
                       print_route(newState);
                       return ;
                   }
               }
           }
       } 
    }

    public static void print_route(State s) {
        if (s.hasFather())
            print_route(s.getFather());
        System.out.println("step " + s.getSteps() + ": ");
        s.print();
    }

    public static void input() throws Exception {
        System.out.println("input the first state:");
        Scanner s = new Scanner(System.in);
        for (int i=0;i<9;i++) {
            int c = s.nextInt();
            a[i/3][i%3] = c;   
        }


        System.out.println("input the last state:");
        for (int i=0;i<9;i++) {
            int c = s.nextInt();
            b[i/3][i%3] = c;
        }
    }
}
