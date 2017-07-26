import java.util.Queue;

/**
 * Created by Narcissus on 2017/7/21.
 */
public class DownloadThread extends Thread{
    SynQueue synQueue;
    public  DownloadThread(SynQueue synQueue){
        this.synQueue = synQueue;
    }

    @Override
    public void run(){
        String url;
        url = synQueue.pull();
    }
}
