// HashTable.java
/*
 * hash table 
 */

package jiugong2;

/**
 *
 * @author xqg
 */
public class HashTable {
    private Boolean [] table;
    private int size;
    public HashTable(int size) {
        table = new Boolean[size];
        this.size = size;
        for (int i=0;i<size;i++) {
            table[i] = false;
        }
    }

    public void put(int n) {
       table[n] = true;
    }

    public Boolean contains(int n) {
        return table[n];
    }
}
