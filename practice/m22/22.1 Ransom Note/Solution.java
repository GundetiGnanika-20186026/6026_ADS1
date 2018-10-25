import java.util.Scanner;


class HashST<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int n;

    private int m;

    private SequentialSearchST<Key, Value>[] st;

    public HashST() {
        this(INIT_CAPACITY);
    }

    public HashST(final int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean contains(final Key key) {
        return get(key) != null;
    }

    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(final Key key, final Value val) {
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }
}

class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;


    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    public int size() {
        return n;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Key key) {

        return get(key) != null;
    }

     public void put(Key key, Value val) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public Value get(Key key) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }



}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        int m = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        HashST<String, Integer> mag = new HashST<String, Integer>();
        HashST<String, Integer> notes = new HashST<String, Integer>();
        for (int i = 0; i < m; i++) {
            mag.put(magazine[i], 0);
        }
        for (int j = 0; j < n; j++) {
            notes.put(note[j], 0);
        }
        for (int i = 0; i < m; i++) {
            int count = mag.get(magazine[i]);
            if (mag.contains(magazine[i])) {
                mag.put(magazine[i], count + 1);
            } else {
                mag.put(magazine[i], 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!mag.contains(note[j])) {
                System.out.println("No");
                return;
            } else if (mag.contains(note[j])) {
                int num = notes.get(note[j]);
                if (notes.contains(note[j])) {
                    notes.put(note[j], num + 1);
                } else {
                    notes.put(note[j], 1);
                }
                if (notes.get(note[j]) > mag.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}



