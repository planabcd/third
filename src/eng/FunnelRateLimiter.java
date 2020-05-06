package eng;

/**
 * @author think
 * @version v 1.0 2020/1/18 18:01
 * 漏斗限流
 */
public class FunnelRateLimiter {

    static class Funnel{
        /**
         * 剩余空间
         */
        private int remainSpace;
        /**
         * 漏水速率
         */
        private int milSecondRate;
        /**
         * 漏斗容量
         */
        private int capacity;
        /**
         * 上一次漏水时间
         */
        private long lastWaterTimeMs;

        public boolean water(int space){
            makeSpace();
            if(remainSpace>space){
                remainSpace-=space;
                return true;
            }
            return false;
        }

        public void makeSpace(){
            long nowMs = System.currentTimeMillis();
            lastWaterTimeMs = nowMs;
            //已经释放的空间
            long lostSpace = (nowMs - lastWaterTimeMs) * milSecondRate;
            if(lostSpace==0){
                //释放空间太小
            }
            if(lostSpace<0){
                //时间太长,溢出
                remainSpace = capacity;
                return;
            }

            if(remainSpace+lostSpace>capacity){
                remainSpace = capacity;
            }else{
                remainSpace = (int) (remainSpace+lostSpace);
            }
        }

    }



}
