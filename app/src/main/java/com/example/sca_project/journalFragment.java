package com.example.sca_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link journalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class journalFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<DataItem> data = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public journalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment journalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static journalFragment newInstance(String param1, String param2) {
        journalFragment fragment = new journalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup =(ViewGroup)inflater.inflate(R.layout.fragment_journal, container, false);

        recyclerView=viewGroup.findViewById(R.id.recyclerview_journal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(getContext(),data);
        recyclerView.setAdapter(recyclerAdapter);


        DataItem item = new DataItem();
        item.setJournal_title("일지젬;ㅗㄱ");
        item.setJournal_day("2020/11/25");
        item.setViewnum("170");
        item.setMain("ㅁ니라ㅓㄴ매ㅓㄻㄴㄹㅇ");
        data.add(item);
        recyclerAdapter.setData(data);


        return viewGroup;
    }
}