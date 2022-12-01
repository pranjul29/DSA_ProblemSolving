import java.util.*;
public class RandomizedSet {
    HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(set.contains(val))
        {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Integer[] arrayNumbers = set.toArray(new Integer[set.size()]);
        Random rndm = new Random();
        int rndmNumber = rndm.nextInt(set.size());
        return arrayNumbers[rndmNumber];
    }
}