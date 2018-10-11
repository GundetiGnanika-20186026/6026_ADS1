import java.util.Scanner;
class Book{
	String name;
	String author;
	double price;
	Book(String name1, String author1, double price1) {
		this.name = name1;
		this.author = author1;
		this.price = price1;
	}
}

class BinaryST<Key extends Comparable<Key>,Value> {
	BinaryST(){

	}
	private Node root;
	class Node {
		private Book key;
		private Value val;
		private Node left, right;
		private int size;

		Node(Book key1, Value val1, int size1){
			this.key = key1;
			this.val = val1;
			this.size = size1;
		}

	}

	public void put(Book key, Value val) {
		root = put(root, key, val);
	}

	public Node put(Node x, Book key, Value val) {
		if (x == null) return new Node(key, val, 1);
        int cmp = key.name.compareTo(x.key.name);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        //x.size = 1 + size(x.left) + size(x.right);
        return x;
	}

	 public Value get(Book key) {
        return get(root, key);
    }


	private Value get(Node x, Book key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.name.compareTo(x.key.name);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
 }

    class Solution{
    	Solution(){

    	}
    	public static void main(String[] args) {
    		Scanner scan = new Scanner(System.in);
    		BinaryST object = new BinaryST();

    		while(scan.hasNext()){
    			String[] line = scan.nextLine().split(",");
    			//BinaryST<String,Integer> object = new BinaryST<String,Integer>();
    			Book obj = new Book(line[1],line[2],Double.parseDouble(line[3]));
    			switch(line[0]){
    				case "put" :

    				      object.put(obj,line[4]);
    				      break;
    				case "get" :
    				      System.out.println(object.get(obj));
    				      break;


    			}
    		}
    	}
    }



