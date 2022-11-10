import java.util.*;
class StockSpanner {
    ArrayList<Integer> stock;
    public StockSpanner() {
        stock = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        int count = 0;
        for(int i = stock.size()-1;i>=0;i--)
        {
            if(stock.get(i) <= price)
                count++;
            else
                break;
        }
        stock.add(price);
        return count+1;
    }
}
public class OnlineStockPlan {
    public static void main(String[] args) {
        StockSpanner st = new StockSpanner();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        for(int i = 0;i<arr.length;i++)
            System.out.print(st.next(arr[i]) + " ");
    }
}
