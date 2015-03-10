// Queue.java
/*
 * to store the states
 */

package jiugong2;

/**
 *
 * @author yuankui
 */
public class Queue {
    private State [] states = new State[1000000];

    private int first;
    private int last;

    // check how many states have been generated.
    public int getLast() {
        return last;
    }

    // constructor
    public Queue() {
        this.first = 0;
        this.last = -1;
    }

    // add a state into the queue
    public void addLast(State s) throws Exception {
        last ++;
        if (last > 999999)
            throw new Exception("Queue out of range.");
        
        states[last] = s;
    }

    // just get the first state in the queue
    public State getFirstObject() {
        return states[first];
    }

    // get and delete the first state in the queue
    public State popFirstObject() {
        return states[first++];
    }

    // get and delete the best state
    public State popBestObject(State last) {
        int best = Integer.MAX_VALUE;
        int bestP = 0;
        for (int i=0;i<=this.last;i++)
            if (this.states[i] != null) {
                int tmp = this.states[i].getCost(last);
                if (tmp < best) {
                    best = tmp;
                    bestP = i;
                }
            }

        State tmpState = this.states[bestP];
        this.states[bestP] = null;
        return tmpState;
    }

    // get and delete the best state
    public Boolean hasElement() {
        if (last >= first)
            return true;
        else
            return false;
    }

}
