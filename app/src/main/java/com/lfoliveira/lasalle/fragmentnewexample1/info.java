package com.lfoliveira.lasalle.fragmentnewexample1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link info#newInstance} factory method to
 * create an instance of this fragment.
 */
public class info extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "index";

    String [] INFOS = new String[] {"Brazil...","Germany...","Italy..."};


    // TODO: Rename and change types of parameters
    private static int index;


    public info() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static info newInstance(int index) {
        info fragment = new info();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView text = getView().findViewById(R.id.infoTextView);
        text.setText(INFOS[index]);
    }

    public int getIndex() {
        return index;
    }
}
