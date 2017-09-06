package sim.ssn.com.servicealarmclockapp.fragment;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sim.ssn.com.servicealarmclockapp.model.TestDB;

public class FragmentStandardAdapter extends  RecyclerView.Adapter<FragmentStandardViewHolder>{

    private static String TAG = FragmentStandardAdapter.class.getSimpleName();

    private final int layoutCardView;
    private final FragmentStandard fragment;
    private CardView cardView;

    private List<String> defaultInputs;
    private Activity activity;

    public FragmentStandardAdapter(int layoutCardView, final FragmentStandard fragment){
        this.layoutCardView = layoutCardView;
        this.fragment = fragment;
        initDefaultInputs();
    }

    private void initDefaultInputs(){
        TestDB testDB = new TestDB(fragment.getActivity());
        defaultInputs = testDB.getALL();
    }

    @Override
    public FragmentStandardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(layoutCardView, parent, false);
//        Log.d(TAG, "CardView inflated [" + activity.getResources().getResourceName(layoutCardView) + "].");
        FragmentStandardViewHolder viewHolder = new FragmentStandardViewHolder(fragment.getActivity(), cardView);
        Log.d(TAG, viewHolder.getClass().getSimpleName() + " initialized.");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FragmentStandardViewHolder viewHolder, int position) {
        viewHolder.assignData(position, defaultInputs.get(position));
        Log.d(TAG, viewHolder.getClass().getSimpleName() + " assigned Data. Position [" + position + "].");
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return defaultInputs.size();
    }

}