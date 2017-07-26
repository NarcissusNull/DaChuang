import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Narcissus on 2017/7/21.
 */
public class SynQueue {
    private Queue<String> queue;

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
