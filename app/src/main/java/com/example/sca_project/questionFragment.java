package com.example.sca_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link questionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class questionFragment extends Fragment {

    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<DataItem> data = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public questionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment questionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static questionFragment newInstance(String param1, String param2) {
        questionFragment fragment = new questionFragment();
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

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_question, container, false);
        // Inflate the layout for this fragment
        searchView=viewGroup.findViewById(R.id.search_qna);

        recyclerView=viewGroup.findViewById(R.id.recyclerview_qna);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(getContext(),data);
        recyclerView.setAdapter(recyclerAdapter);

//        for (int i = 0; i < 10; i++) {
//            i++;
        DataItem item = new DataItem();
        item.setQna_title("질문이름");
        item.setMain("질문내용");
        item.setViewnum("180");
        data.add(item);
//        }
        recyclerAdapter.setData(data);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //입력받은 문자열 처리
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //입력란의 문자열이 바뀔때의 처리
                return false;
            }
        });
        return viewGroup;
    }
}