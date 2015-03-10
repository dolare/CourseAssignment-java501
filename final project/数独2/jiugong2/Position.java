// Position.java
/*
 * to describe the Position is ok or not
 */

package jiugong2;

/**
 *
 * @author yuankui
 */
public class Position {
    public int x;
    public int y;
    public Position(int x,int y) {
        this.x = x;
        this.y = y;
    }

    // check whether can go
    public Boolean check(int x,int y) {
        int newX = this.x + x;
        int newY = this.y + y;
        if (newX>2 || newX<0)
            return false;
        if (newY>2 || newY<0)
            return false;
        return true;
    }

    public Boolean check(Position p) {
        return check(p.x,p.y);
    }
}
