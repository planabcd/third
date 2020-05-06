package num;

/**
 * @author think
 * @version v 1.0 2020/2/28 12:00
 */
public class Num2Zh {
    //    给出一个五位阿拉伯数字，请写出它的中文读法，如：
    //            12345 —> 一万两千三百四十五
    //10000 —> 一万

    static char[] numArr = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    static String[] unitArr = {"万", "千", "百", "十", ""};

    public static String numToChinese(int num) {
        char[] newNum = String.valueOf(num).toCharArray();
        int len = newNum.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(String.valueOf(newNum[i]));
            boolean zeroFlag = temp == 0 ? true : false;
            if (zeroFlag) {
                while (i < len - 1 && newNum[i + 1] == '0') {
                    i++;
                }
                if (i != len - 1) {
                    res.append(numArr[0]);
                }
            } else {
                res.append(numArr[temp]);
                res.append(unitArr[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //System.out.print(numToChinese(12345));
        //System.out.print("\n");
        //System.out.print(numToChinese(10000));
        //System.out.print("\n");
        //System.out.print(numToChinese(10001));
        //System.out.print("\n");
        //System.out.print(numToChinese(10100));
        //System.out.print("\n");
        //System.out.print(numToChinese(10101));
        //System.out.print("\n");
        //System.out.print(numToChinese(20890));
        System.out.println(num2zhWithYi(12050057));
    }

    static String num2zhWithYi(int number) {
        //结果
        String resule = "";
        //用作替换数字的字符数组
        String[] rep = new String[]
                {"零", "一", "二", "三", "四",
                        "五", "六", "七", "八", "九",};
        //用于添加单位的数组
        String[] unit = new String[]
                {"", "十", "百", "千", "万", "十"
                        , "百", "千", "亿", "十", "百", "千"};
        //取数字位数
        int l = String.valueOf(number).length();
        //循环取最后以为数字处理字符转换
        for (int i = 0; i < l; i++) {
            //取最后位数值
            int temp = number % 10;
            //取剩余位
            number = number / 10;
            //判断当前最后位为0
            if (temp == 0) {
                //判断万位添加单位 万
                if (i == 4)
                    resule += unit[4];
                //判断亿位添加单位 亿
                if (i == 8) {
                    resule += unit[8];
                }
                //判断当前最后位是否需要加 零
                if (resule != "" && resule.charAt(resule.length() - 1) != '零' && resule.charAt(resule.length() - 1) != '万' && resule.charAt(resule.length() - 1) != '亿') {
                    resule += rep[temp];
                }

            } else {
                //当前位不是0 添加单位 添加数值
                resule += unit[i];
                resule += rep[temp];
            }
        }
        //定义中间变量 倒叙结果
        String str = resule;
        resule = "";
        for (int i = 0; i < str.length(); i++) {
            resule += str.charAt(str.length() - 1 - i);
        }
        return resule;
    }
}
