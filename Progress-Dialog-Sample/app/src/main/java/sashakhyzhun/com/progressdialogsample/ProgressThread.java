package sashakhyzhun.com.progressdialogsample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ProgressThread extends Thread {

    public static final int STATE_DONE = 0;
    public static final int STATE_RUNNING = 1;

    private Handler handler;
    private int stateRun;
    private int total;

    ProgressThread(Handler h) {
        handler = h;
    }

    public void run() {
        stateRun = STATE_RUNNING;
        total = 0;
        while (stateRun == STATE_RUNNING) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Log.e("ERROR", "Thread Interrupted");
            }
            Message msg = handler.obtainMessage();
            Bundle b = new Bundle();
            b.putInt("total" , total);
            msg.setData(b);
            handler.sendMessage(msg);
            total++;
        }
    }

    public void setState(int state) {
        stateRun = state;
    }

}
