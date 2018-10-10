import java.util.Scanner;
import java.util.Arrays;
class BinarySearchST<Key extends Comparable<Key>, Value> {
	Key[] keys;
	Value[] vals;
	int n = 0;
	BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public void put(Key key, Value val) {
		int i = rank(key);
		// key is already in table
		if (i < n && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		// insert new key-value pair
		for (int j = n; j > i; j--)  {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		n++;

	}


	public int rank(Key key) {
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if      (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}

	public Key max() {
        //if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n-1];
    }

    public Key floor(Key key) {
        //if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }


    public int size() {
        return n;
    }


     public boolean isEmpty() {
        return size() == 0;
    }


    public Key min() {
        //if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0];
    }




    public void delete(Key key) {
        //if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        // resize if 1/4 full
        //if (n > 0 && n == keys.length/4) resize(keys.length/2);

        //assert check();
    }



    public void deleteMin() {
        //if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }


     public Value get(Key key) {
        //if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    }


    public boolean contains(Key key) {
        //if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }


	public void print() {
		//System.out.println(Arrays.toString(keys));
		for(int i = 0;i<n;i++){
			System.out.println(keys[i]+" "+vals[i]);
		}
	}


}

class Solution {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(input.length);
		for (int i = 0; i < input.length; i++) {
			st.put(input[i], i);
		}
		//st.print();

		while(scan.hasNext()){
			String[] token = scan.nextLine().split(" ");
			switch(token[0]){
				case "max":
				      System.out.println(st.max());
				break;
				case "floor":
				      System.out.println(st.floor(token[1]));
				break;
				case "rank":
				      System.out.println(st.rank(token[1]));
				break;
				case "deleteMin":
				      st.deleteMin();
				break;
				case "contains":
				      System.out.println(st.contains(token[1]));
				break;
				case "keys" :
				      st.print();
				break;
				case "get" :
				      System.out.println(st.get(token[1]));
				break;
				default:
				break;


			}
		}

	}
}