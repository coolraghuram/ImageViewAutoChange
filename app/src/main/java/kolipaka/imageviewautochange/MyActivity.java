package kolipaka.imageviewautochange;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class MyActivity extends Activity {
    private ImageView imgView;
    private int src[] = {R.drawable.a,R.drawable.b,R.drawable.c};
    private Timer timer;
    private MyTimerTask myTimerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setImageResource(src[0]);

        timer = new Timer();
        myTimerTask = new MyTimerTask();
        timer.schedule(myTimerTask,1000,10000);

    }

    class MyTimerTask extends TimerTask{
        int index=0;
        @Override
        public void run() {
            index++;
            if (index >= 3){
                index=0;
            }
          runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  imgView.setImageResource(src[index]);
              }
          });
        }
    }

}
