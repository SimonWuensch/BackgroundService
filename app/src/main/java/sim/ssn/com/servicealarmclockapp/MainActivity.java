package sim.ssn.com.servicealarmclockapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sim.ssn.com.servicealarmclockapp.fragment.FragmentStandard;
import sim.ssn.com.servicealarmclockapp.model.TestDB;

public class MainActivity extends Activity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TestDB testDB = new TestDB(this);


        final Button deleteAllButton = (Button) findViewById(R.id.activity_button_delete_all);
        deleteAllButton.setText("Delete All ("+ testDB.getALL().size() + ")");
        deleteAllButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                testDB.deleteALL();
                showFragmentStandard();
                deleteAllButton.setText("Delete All (0)");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        TestIntentService.stop(MainActivity.this);
        showFragmentStandard();
    }

    @Override
    protected void onStop() {
        super.onStop();
        TestIntentService.start(this);
    }

    // ** FRAGMENT ****************************************************************************** //
    public void showFragmentStandard() {
        FragmentStandard fragmentStandard = FragmentStandard.newInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_fragment_container,
                        fragmentStandard,
                        fragmentStandard.TAG)
                //.addToBackStack(FragmentListProject.TAG)
                .commit();
        Log.i(getClass().getSimpleName(), "Show Fragment [" + fragmentStandard.TAG + "].");
    }
}
