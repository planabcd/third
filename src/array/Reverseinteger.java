package array;

/**
 * @author think
 * @version v 1.0 2019/9/16 23:52
 */
public class Reverseinteger {
    public static void main(String[] args) {
        int reverse = new Reverseinteger().reverse(-512);
    }

    public int reverse(int x) {
        int result = 0;
        while(x!=0){
            int pop = x%10;
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && pop>Integer.MAX_VALUE%10) ){
                return 0;
            }
            if(result<Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE%10)){
                return 0;
            }
            result = result*10 + pop;
            x = x/10;
        }
        return result;
    }
}
