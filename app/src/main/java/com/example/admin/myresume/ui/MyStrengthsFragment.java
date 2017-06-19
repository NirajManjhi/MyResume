package com.example.admin.myresume.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.myresume.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyStrengthsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyStrengthsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1
     * @return A new instance of fragment MyStrengthsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyStrengthsFragment newInstance(String param1) {
        MyStrengthsFragment fragment = new MyStrengthsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_strengths, container, false);
        ((TextView)rootView.findViewById(R.id.vp_fragment_text)).setText(mParam1);
        return rootView;
    }




}
