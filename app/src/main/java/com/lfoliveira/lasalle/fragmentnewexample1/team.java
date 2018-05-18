package com.lfoliveira.lasalle.fragmentnewexample1;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class team extends ListFragment {

 String [] TEAMS = new String[] {"Brazil", "Germany","Italy"};
 boolean isInfoActive;
 int currenctIndex;

    public team() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, TEAMS));

        View infoFrame = getActivity().findViewById(R.id.info);

        isInfoActive = infoFrame != null && infoFrame.getVisibility() == View.VISIBLE;

        if (isInfoActive) {
            showInfo(currenctIndex);
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showInfo(position);
    }

    private void showInfo(int index) {
        currenctIndex = index;

        if (isInfoActive){
            info infoFragment = (info) getFragmentManager().findFragmentById(R.id.info);
            if (infoFragment == null || infoFragment.getIndex() != index){
                infoFragment = info.newInstance(index);
                getFragmentManager().beginTransaction().replace(R.id.info,infoFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();

            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), InfoActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }

    }
}
