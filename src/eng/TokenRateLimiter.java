package eng;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author think
 * @version v 1.0 2020/1/18 18:01
 * 令牌桶限流
 */
public class TokenRateLimiter {

    static class TokenBucket {
        /**
         * 当前令牌数量
         */
        private int curPermits;
        /**
         * 令牌放入速率
         */
        private int secondRate;
        /**
         * 最大令牌数量
         */
        private int maxPermits;
        /**
         * 上一次获取令牌时间
         */
        private long lastTokenMs;

        TokenBucket(int curPermits, int secondRate, int maxPermits,long lastTokenMs){
            this.curPermits = curPermits;
            this.secondRate = secondRate;
            this.maxPermits = maxPermits;
            this.lastTokenMs = lastTokenMs;
        }

        public boolean tryAcquire(int permits){
            long curMs = System.currentTimeMillis();
            long newPermits = ((curMs - lastTokenMs)/1000) * secondRate;
            if(newPermits<=0){
                //时间间隔太长溢出了
                return false;
            }else{
                lastTokenMs = System.currentTimeMillis();
            }
            int expectPermits = (int) Math.min(maxPermits,curPermits+newPermits);
            if(expectPermits-permits>=0){
                curPermits = expectPermits-permits;
                return true;
            }else{
                curPermits = expectPermits;
                return false;
            }
        }
    }


    public static void main(String[] args) throws Exception{
        TokenBucket tokenBucket = new TokenBucket(0, 1, 10,System.currentTimeMillis());
        while(true){
            if(tokenBucket.tryAcquire(3)){
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                System.out.println("tryAcquire success,times="+format);
            }
        }
    }


}
