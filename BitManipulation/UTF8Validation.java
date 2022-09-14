public class UTF8Validation {
    public static int getLeftMostSetBits(int data)
    {
        int count = 0;
        if(((data&(1<<7)) > 1) && ((data&(1<<6)) > 1) && ((data&(1<<5)) > 1) && ((data&(1<<4)) > 1) && ((data&(1<<3)) > 1))
            return -1;
        if(((data&(1<<7)) > 1) && ((data&(1<<6)) > 1) && ((data&(1<<5)) > 1) && ((data&(1<<4)) > 1))
            return 3;
        else if (((data&(1<<7)) > 1) && ((data&(1<<6)) > 1) && ((data&(1<<5)) > 1))
            return 2;
        else if (((data&(1<<7)) > 1) && ((data&(1<<6)) > 1))
            return 1;
        else if ((data&(1<<7)) == 0)
            return 0;
        else
            return -1;
    }
    public static boolean validUtf8(int[] data) {
        int N = data.length;
        for(int i = 0;i<data.length;i++)
        {
            int count_set_bits = getLeftMostSetBits(data[i]);
            if(count_set_bits == -1)
                return false;
            else if(count_set_bits == 3)
            {
                i++;
                if(i == N)
                    return false;
                if(!(((data[i]&(1<<7)) > 1) && (data[i]&(1<<6)) == 0))
                    return false;
                i++;
                if(i == N)
                    return false;
                if(!(((data[i]&(1<<7)) > 1) && (data[i]&(1<<6)) == 0))
                    return false;
                i++;
                if(i == N)
                    return false;
                if(!(((data[i]&(1<<7)) > 1) && (data[i]&(1<<6)) == 0))
                    return false;
            }
            else if(count_set_bits == 2)
            {
                i++;
                if(i == N)
                    return false;
                if(!(((data[i]&(1<<7)) > 1) && (data[i]&(1<<6)) == 0))
                    return false;
                i++;
                if(i == N)
                    return false;
                if(!(((data[i]&(1<<7)) > 1) && (data[i]&(1<<6)) == 0))
                    return false;
            }
            else if(count_set_bits == 1)
            {
                i++;
                if(i == N)
                    return false;
                if(!(((data[i]&(1<<7)) > 1) && (data[i]&(1<<6)) == 0))
                    return false;
            }
        }
        return true;
    }    
    public static void main(String[] args) {
        int[] arr = {248,130,130,130};
        System.out.println(validUtf8(arr));
    }
}
