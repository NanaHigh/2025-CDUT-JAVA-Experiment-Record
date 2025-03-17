package Ex8.Depends;

// 乌龟线程
public class Turtle implements Runnable {
    private int position;
    private final RaceStatus status;
    private final Thread rabbitThread;
    // 赛道总长度
    private static final int TRACK_LENGTH = 1000;
    // 单位时间（毫秒）
    private static final int TIME_UNIT = 1000;

    public Turtle(RaceStatus status, Thread rabbitThread) {
        // 乌龟作弊先跑400米
        this.position = 400;
        this.status = status;
        this.rabbitThread = rabbitThread;
    }

    public void run() {
        try {
            while (!status.raceOver && position < TRACK_LENGTH) {
                Thread.sleep(TIME_UNIT);
                position += 1;
                
                synchronized (status) {
                    System.out.println("[乌龟] 当前位置：" + position + "米");
                    if (position >= TRACK_LENGTH) {
                        System.out.println("============= 乌龟到达终点 =============");
                        status.raceOver = true;
                        rabbitThread.interrupt();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
