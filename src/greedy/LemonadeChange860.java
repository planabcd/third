package greedy;

/**
 * @author think
 * @version v 1.0 2019/12/1 17:36
 */
public class LemonadeChange860 {
    public static void main(String[] args) {
        int[] bills = {5,5,10};
        boolean b = new LemonadeChange860().lemonadeChange(bills);
        System.out.println(b);
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i != bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean lemonadeChange2(int[] bills) {
        if (bills.length == 0) {
            return true;
        }
        if (bills[0] > 5) {
            return false;
        }

        int[] coinsNumber = {0, 0, 0};
        int[] coinsFee = {5, 10, 20};
        for (int i = 0; i != bills.length; i++) {
            if (!reduce(bills[i], coinsFee, coinsNumber)) {
                return false;
            }
            if(bills[i]==5){
                coinsNumber[0]+=1;
            }
            if(bills[i]==10){
                coinsNumber[1]+=1;
            }
            if(bills[i]==20){
                coinsNumber[2]+=1;
            }
        }
        return true;
    }

    private boolean reduce(int bill, int[] coinsFee, int[] coinsNumber) {
        if (bill == 5) {
            return true;
        }
        int coinIndex = 2;
        while (bill > 5 && coinIndex >= 0) {
            if (bill> coinsFee[coinIndex] && coinsNumber[coinIndex]>0){
                bill -= coinsFee[coinIndex];
                coinsNumber[coinIndex]--;
            }else{
                coinIndex--;
            }
        }
        return bill==5;
    }
}
