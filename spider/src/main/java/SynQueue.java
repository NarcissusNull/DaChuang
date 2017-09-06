import java.util.LinkedList;
import java.util.Queue;

/**
 * 多线程队列,也就是仓库
 * Created by Narcissus on 2017/7/21.
 */
public class SynQueue {
    private Queue<String> queue;

    public SynQueue(){
        queue = new LinkedList<String>();
    }

    public synchronized String pull(){
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        String string = queue.poll();
        return string;
    }

    public synchronized void offer(String string){
        this.notify();
        queue.offer(string);
    }
}
