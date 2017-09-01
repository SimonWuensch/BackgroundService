package sim.ssn.com.servicealarmclockapp;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TestIntentService.stop(MainActivity.this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        TestIntentService.start(this);
    }
}
