// State.java
/*
 * to describe the state
 */

package jiugong2;

/**
 *
 * @author yuankui
 */
public class State {
    private int dimension;
    private State father = null;

    public int [][] cell;
    private int steps;


    // getter of the father
    public State getFather() {
        return father;
    }
    // setter of the father
    public void setFather(State father) {
        this.father = father;
    }

    // check whether the state has a father state
    public Boolean hasFather() {
        if (this.father == null) {
            return false;
        }
        return true;
    }
    // get the dimension of the State
    public int getDimension() {
        return dimension;
    }
    
    // the setter of steps
    public int getSteps() {
        return steps;
    }

    // the getter of steps
    public void setSteps(int steps) {
        this.steps = steps;
    }

    // constructor
    public State(int dimension,int steps) {
        this.dimension = dimension;
        cell = new int[dimension][];
        for (int i=0;i<dimension;i++)
            cell[i] = new int[dimension];
    }

    // return the position of the one
    public Position onePosition () {
        for (int i=0;i<dimension;i++)
            for (int j=0;j<dimension;j++)
                if (cell[i][j] == 1)
                    return new Position(i,j);
        return null;
    }

    // get the copy of the state
    public State copy() {
        int [][] tmp = new int[dimension][];
        for (int i=0;i<dimension;i++)
            tmp[i] = new int[dimension];

        // copy
        for (int i=0;i<dimension;i++)
            for (int j=0;j<dimension;j++)
                tmp[i][j] = cell[i][j];

        // set the new copied state
        State tmpState = new State(dimension,0);
        tmpState.cell = tmp;
        tmpState.steps = this.steps;
        return tmpState;
    }

    // move the one's position in the dircection 'p'
    public void move(Position p) {
        Position one = this.onePosition();
        cell[one.x][one.y] = cell[one.x+p.x][one.y+p.y];
        cell[one.x+p.x][one.y+p.y] = 1;
    }

    // check whether the two state is the same
    public Boolean equals(State s) {
        for (int i=0;i<dimension;i++)
            for (int j=0;j<dimension;j++)
                if (this.cell[i][j] != s.cell[i][j])
                    return false;
        return true;
    }

    // add the steps of state
    public void addSteps() {
        this.steps ++;
    }

    // print the state in the console
    public void print() {
        for (int i=0;i<this.getDimension();i++) {
            for (int j=0;j<this.getDimension();j++)
                System.out.print(this.cell[i][j] + " ");
            System.out.println();
        }
    }

    // get the hashcode of the state
    public int hashCode() {
        int stage,code,step;
        code = 0;
        stage = 1;
        step = 1;
        for (int i=0;i<this.getDimension();i++) {
            for (int j=0;j<this.getDimension();j++) {
                step ++;
                code += this.cell[i][j] * stage;
                stage *= step;
            }
        }
        return code;
    }

    // compare the similarity of the two state
    public int getCost(State end) {
        int cost;
        cost = 0;
        for (int i=0;i<this.getDimension();i++) {
            for (int j=0;j<this.getDimension();j++) {
                if (this.cell[i][j] != end.cell[i][j])
                    cost ++;
            }
        }
        
        int g = this.getSteps();
        int h = cost;
        int f = g + h;
        return f;
    }
}