package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @version v 1.0 2020/8/9 0:36
 */
public class RestoreIpAddresses93 {
    //93. 复原IP地址
    //给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
    //
    //有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
    //
    //
    //
    //示例:
    //
    //输入: "25525511135"
    //输出: ["255.255.11.135", "255.255.111.35"]
    //https://leetcode-cn.com/problems/restore-ip-addresses/
    public static void main(String[] args) {
        List<String> res = new RestoreIpAddresses93().restoreIpAddresses("010010");
        for (String re : res) {
            System.out.println(re);
        }
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        //边界
        if (length<4 || length>12){
            return res;
        }
        //s,index,split,length,path,res
        List<String> path = new ArrayList<>();
        dfs(s,0,0,length,path,res);
        return res;
    }

    private void dfs(String s, int index, int split, int length, List<String> path, List<String> res) {
        if(index==length){
            if(split==4){
                //递归出口,切分成了4段,且s遍历完成
                res.add(String.join(".", path));
                return;
            }
        }
        //剪枝
        int remainLength = length-index;
        if(remainLength<(4-split) || remainLength>3*(4-split)){
            //剩余长度不够
            return;
        }
        for (int i = 0; i < 3; i++) {
            //s[index,index+i]转换为数字,如果=-1表示不是一个合法的ip段
            int ipNum = getIpNum(s,index,index+i);
            if(ipNum!=-1){
                path.add(ipNum+"");
                dfs(s,index+i+1,split+1,length,path,res);
                path.remove(path.size()-1);
            }
        }
    }

    private int getIpNum(String s, int left, int right) {
        if(right>=s.length()){
            return -1;
        }
        if((s.charAt(left)-'0')==0){
            if(right-left>=1){
                return -1;
            }
        }
        int x = 0;
        for (int i = 0; i <= right - left; i++) {
            x = x*10+(s.charAt(left+i)-'0');
        }
        if(x>255){
            return -1;
        }
        return x;
    }
}
