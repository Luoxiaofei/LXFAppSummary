package com.appsummary.luoxf.myappsummary.recyclerView.fastscroll;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.recyclerView.fastscroll.Views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerFastScrollFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview_fast_scroll, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FastScrollRecyclerView recyclerView = (FastScrollRecyclerView) getView().findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapter());
    }

    private static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
            implements FastScrollRecyclerView.SectionedAdapter {
        private List<String> allItems = new ArrayList<>();
        private Map<Integer, String> indexMap = new HashMap<>();

        private RecyclerAdapter() {
            for (int i = 0; i < 20; i++) {
                allItems.add("aaaaaa" + i);
                indexMap.put(i, "a");
            }
            int size = indexMap.size();
            for (int i = 0; i < 20; i++) {
                allItems.add("bbbbb" + i);
                indexMap.put(i + size, "b");
            }
            int size1 = indexMap.size();
            for (int i = 0; i < 20; i++) {
                allItems.add("cccc" + i);
                indexMap.put(i + size1, "c");
            }
            int size2 = indexMap.size();
            for (int i = 0; i < 20; i++) {
                allItems.add("eeeee" + i);
                indexMap.put(i + size2, "e");
            }
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_fast_scroll_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(String.format(allItems.get(position)));
        }

        @Override
        public int getItemCount() {
            return allItems.size();
        }

        @NonNull
        @Override
        public String getSectionName(int position) {
            return indexMap.get(position);
        }


        static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView text;

            public ViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text);
            }
        }
    }
}
