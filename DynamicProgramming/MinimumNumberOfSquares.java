public class MinimumNumberOfSquares {
    public static int countMinSquares(int A) {
        // smallerResults = new HashMap<>();
        // smallerResults.put(1,1);
        int count = 0;
        while(A > 1)
        {
            int value = (int)(Math.log(A)/Math.log(2));
            int count_of_value = A/(value*value);
            
            count += count_of_value;
            A = A - value*value*count_of_value;
            System.out.println("Value: "+value+ " Count_Of_Value: "+count_of_value+" Count:" + count+ " A:"+A);
        }
        if(A == 1)
            count++;
        return count;
    }
    public static void main(String[] args) {
        int A = 12;
        System.out.println(countMinSquares(A));
    }
}
