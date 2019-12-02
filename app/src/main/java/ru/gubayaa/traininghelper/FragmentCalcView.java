package ru.gubayaa.traininghelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class FragmentCalcView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_calc, null);

        FragmentCalcPresenter Presenter = new FragmentCalcPresenter();
        Presenter.createTabs(this.getContext(), currentView);

        return currentView;
    }

}
