package sim.ssn.com.servicealarmclockapp.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sim.ssn.com.servicealarmclockapp.R;


public class FragmentStandard extends Fragment {

    public static String TAG = FragmentStandard.class.getSimpleName();

    private static int FRAGMENT_LAYOUT = R.layout.fragment_standard;
    private static int RECYCLERVIEW = R.id.fragment_standard_recycler_view;
    private static int CARDVIEW = R.layout.fragment_standard_cardview;

    private static String OBJECTONE = "OBJECTONE";
    private static String OBJECTTWO = "OBJECTTWO";

    private View rootView;

    public static FragmentStandard newInstance() {
        FragmentStandard fragment = new FragmentStandard();
        Bundle bundle = new Bundle();
        bundle.putString(OBJECTONE, "TESTONE");
        bundle.putString(OBJECTTWO, "TESTTWO");
        fragment.setArguments(bundle);
        return fragment;
    }

    private Object loadArguments() {
        String objectOne = getArguments().getString(OBJECTONE);
        String objectTwo = getArguments().getString(OBJECTTWO);
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(FRAGMENT_LAYOUT, container, false);
            Log.d(TAG, "Fragment inflated [" + getActivity().getResources().getResourceName(FRAGMENT_LAYOUT) + "].");

            RecyclerView.Adapter mAdapter = new FragmentStandardAdapter(CARDVIEW, this);
            Log.d(TAG, "Adapter [" + mAdapter.getClass().getSimpleName() + "] with CardView [" + getActivity().getResources().getResourceName(CARDVIEW) + "] initialized.");

            RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(RECYCLERVIEW);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(mAdapter);
            Log.d(TAG, "RecyclerView [" + getActivity().getResources().getResourceName(RECYCLERVIEW) + "] initialized.");

            /*
            Space for Custom Views
            */
        }
        return rootView;
    }
}
