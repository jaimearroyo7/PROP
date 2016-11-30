package dominio;

import java.util.LinkedHashMap;

/******************************************************************************
 *  Compilation:  javac dominio.SparseArray.java
 *  Execution:    java dominio.SparseArray
 *
 *  A sparse vector, implementing using a symbol table.
 *
 *  [Not clear we need the instance variable n except for error checking.]
 *
 ******************************************************************************/

public class SparseArray<T> {
    private final int n;             // length
    private LinkedHashMap<Integer, T> st;  // the vector, represented by index-value pairs

    // initialize the all 0s vector of length n
    public SparseArray(int n) {
        this.n  = n;
        this.st = new LinkedHashMap<Integer, T>();
    }

    // put st[i] = value
    public void put(int i, T value) {
        if (i < 0 || i >= n) throw new RuntimeException("Illegal index");
        else st.put(i, value);
    }

    // return st[i]
    public T get(int i) {
        if (i < 0 || i >= n) throw new RuntimeException("Illegal index");
        if (st.containsKey(i)) return st.get(i);
        else return null;
    }

    // return the number of nonzero entries
    public int nnz() {
        return st.size();
    }

    // return the size of the vector
    public int size() {
        return n;
    }

}