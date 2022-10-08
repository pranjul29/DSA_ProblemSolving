class Node{
    char ch;
    Node[] child = new Node[26];
    boolean isEnd = false;
    int value = -1;
    Node(char ch)
    {
        this.ch = ch;
    }
}
public class MapSumPairs {
    public static void insert(String A,Node root,int value)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                curr.child[index] = new Node(char_array[i]);
            }
            curr = curr.child[index];
        }
        curr.value = value;
        curr.isEnd = true;
    }
    public static int sumOfValues(Node curr)
    {
        if(curr == null)
            return 0;
        int sum = 0;
        if(curr.isEnd == true)
            sum+= curr.value;
        for(int i = 0;i<26;i++)
        {
            if(curr.child[i]!=null)
            {
                sum += sumOfValues(curr.child[i]);
            }
        }
        if(sum == 0)
            return curr.value;
        return sum;
    }
    public static int search(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                return 0;
            }
            curr = curr.child[index];
        }
        return sumOfValues(curr);
    }
    public static int[] solve(String[] A, int[] B) {
        Node root = new Node('#');
        int count = 0;
        for(int i = 0;i<B.length;i++)
        {
            if(B[i] == -1)
                count++;
        }
        int[] result = new int[count];
        int counter = 0;
        for(int i = 0;i<A.length;i++)
        {
            if(B[i]!= -1)
                insert(A[i],root,B[i]);
            else
            {
                result[counter] = search(A[i],root);
                counter++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] A = {new String("apple"),new String("ap"),new String("app"),new String( "ap")};
        int[] B = {3,-1,2,-1};
        System.out.println(solve(A, B));
    }
}
