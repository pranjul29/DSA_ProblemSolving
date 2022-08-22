public class LpsOfString {
    public static void GenerateLPS(String S)
    {
        int[] lps = new int[S.length()];
        lps[0] = 0;
        for(int i = 1;i<S.length();i++)
        {
            int X = lps[i-1];
            while(S.charAt(X)!=S.charAt(i))
            {
                if(X == 0)
                {
                    X = -1;
                    break;
                }
                X = lps[X-1];
            }
            lps[i] = X + 1;
        }
        for(int i = 0;i<lps.length;i++)
        {
            System.out.print(lps[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String string = new String("abbcba#abcbba");
        GenerateLPS(string);
    }
}
