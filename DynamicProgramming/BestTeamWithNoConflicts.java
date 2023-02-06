/* 
Source: https://leetcode.com/problems/best-team-with-no-conflicts/description/
You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.

Example 1:

Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
Output: 34
Explanation: You can choose all the players.
Example 2:

Input: scores = [4,5,6,5], ages = [2,1,2,1]
Output: 16
Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
Example 3:

Input: scores = [1,2,3,5], ages = [8,9,10,1]
Output: 6
Explanation: It is best to choose the first 3 players. 
 
Constraints:

1 <= scores.length, ages.length <= 1000
scores.length == ages.length
1 <= scores[i] <= 10^6
1 <= ages[i] <= 1000
*/
// TOP DOWN
import java.util.*;
public class BestTeamWithNoConflicts {
    static int[][] dp;
    public static int dp(int[][] team,int index,int prev)
    {
        if(index >= dp.length)
            return 0;
        if(prev >= dp.length)
            return 0;
        if(dp[prev+1][index] != -1)
            return dp[prev+1][index];
        if(prev == -1 || team[index][1] >= team[prev][1])
            dp[prev+1][index] = Math.max(dp(team,index+1,prev) , dp(team,index+1,index) + team[index][1]);
        else
            dp[prev+1][index] = dp(team,index+1,prev);
        return dp[prev+1][index];
    }
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        dp = new int[n][n];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<n;j++)
                dp[i][j] = -1;
        int[][] ageScore = new int[n][2];
        for(int i = 0;i<scores.length;i++)
        {
            ageScore[i][0] = ages[i];
            ageScore[i][1] = scores[i];
        }
        Arrays.sort(ageScore,(a,b) -> {
            if(a[0] == b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });
        return dp(ageScore,0,-1);
    }
    public static void main(String[] args) {
        int[] scores = {1,3,5,10,15}, ages = {1,2,3,4,5};
        System.out.println(bestTeamScore(scores,ages));
    }
}

/* 
BOTTOM UP
public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        int answer = 0;
        int[][] ageScore = new int[n][2];

        for(int i = 0;i<scores.length;i++)
        {
            ageScore[i][0] = ages[i];
            ageScore[i][1] = scores[i];
        }
        Arrays.sort(ageScore,(a,b) -> {
            if(a[0] == b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });
        for(int i = 0;i<n;i++)
        {
            dp[i] = ageScore[i][1];
            answer = Math.max(dp[i],answer);
        }
        System.out.println();
        for(int i = 0;i<n;i++)
        {
            for(int j = i-1;j>=0;j--)
            {
                if(ageScore[i][1] >= ageScore[j][1])
                    dp[i] = Math.max(dp[i],ageScore[i][1] + dp[j]);
            }
            answer = Math.max(answer,dp[i]);
        }
        return answer;
    }
*/
