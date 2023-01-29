/* 
Source: https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan&id=graph-i
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
 
Constraints:

0 <= bank.length <= 10
startGene.length == endGene.length == bank[i].length == 8
startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
*/
import java.util.*;
public class MinimumGeneticMutation {
    public static int minMutation(String start, String end, String[] bank) {
        
        if(start.equals(end))
            return 0;

        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start + "" + 0);
        HashSet<String> visited = new HashSet<>();

        for(String i : bank)
            set.add(i);
        
        while(!queue.isEmpty())
        {
            String curr = queue.peek();
            queue.remove();
            String gene = curr.substring(0,8);
            if(visited.contains(gene))
                continue;
            int count = Integer.parseInt(curr.substring(8));
            if(gene.equals(end))
                return count;
            visited.add(gene);
            char[] possible = {'A','C','G','T'};
            for(int i = 0;i<8;i++)
            {
                int index = i;
                char[] char_array = gene.toCharArray();
                for(char c : possible)
                {
                    if(gene.charAt(index) == c)
                        continue;
                    char_array[index] = c;
                    String temp = new String(char_array);
                    if(set.contains(temp))
                        queue.add(temp + "" + (count+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String startGene = new String("AACCGGTT");
        String endGene = new String("AAACGGTA");
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(startGene,endGene,bank));
    }
}
