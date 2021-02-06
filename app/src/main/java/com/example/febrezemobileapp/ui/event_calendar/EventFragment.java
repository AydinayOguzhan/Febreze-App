package com.example.febrezemobileapp.ui.event_calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.example.febrezemobileapp.R;
import com.example.febrezemobileapp.ui.apply.ApplyFragment;
import com.example.febrezemobileapp.ui.home.HomeViewModel;

public class EventFragment extends Fragment {

    Button _btnApply;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_event_calendar,container,false);

        _btnApply = (Button) root.findViewById(R.id.btnApply);
        _btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(((ViewGroup)getView().getParent()).getId(), ApplyFragment.class,null)
                        .setReorderingAllowed(true).addToBackStack("").commit();
            }
        });

        return root;
    }
}
