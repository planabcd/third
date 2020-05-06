package array;

/**
 * @author think
 * @version v 1.0 2019/11/9 15:11
 */
public class PlusOne66 {
    public static void main(String[] args) {
        int[] nums = {9,9};
        final int[] numsResult = new PlusOne66().plusOne(nums);
        int[] nums2= {2,9,3};
        final int[] nums2Result = new PlusOne66().plusOne(nums2);
        int[] nums3 = {2,7,9};
        final int[] nums3Result = new PlusOne66().plusOne(nums3);

        int[] nums4 = {5,6,2,0,0,4,6,2,4,9};
        final int[] numsResult4 = new PlusOne66().plusOne2(nums4);
    }

    public int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if(digits[lastIndex]<9){
            digits[lastIndex]++;
            return digits;
        }
        for(int i = lastIndex; i>=0; i--){
            if(digits[i]+1!=10){
                digits[i]+=1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        int[] newArray = new int[lastIndex + 2];
        newArray[0] = 1;
        System.arraycopy(digits,0,newArray,1,digits.length);
        return newArray;

    }

    public int[] plusOne2(int[] digits) {
        int lastIndex = digits.length-1;
        if(digits[lastIndex]<9){
            digits[lastIndex]++;
            return digits;
        }
        int num = concat(digits);
        num++;
        return splitNum2Array(num);
    }

    public int concat(int[] digits){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i!=digits.length; i++){
            sb.append(""+digits[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public int[] splitNum2Array(int num){
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int[] nums = new int[chars.length];
        for(int i=0; i!=chars.length; i++){
            nums[i] = chars[i]-'0';
        }
        return nums;
    }

}
