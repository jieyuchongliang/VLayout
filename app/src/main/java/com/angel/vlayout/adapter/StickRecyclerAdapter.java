package com.angel.vlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.angel.vlayout.R;

/**
 * Created by Angel on 2017/3/24.
 */
public class StickRecyclerAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private LayoutHelper helper;
    private LayoutInflater inflater;
    private RecyclerView recyclerView;

    public StickRecyclerAdapter(Context context, LayoutHelper helper, RecyclerView recycler) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.helper = helper;
        this.recyclerView = recycler;
    }

    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(inflater.inflate(R.layout.item, parent, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewholder) holder).text.setText(position + 1 + "");
    }

    public int getItemCount() {
        return 1;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        private TextView text;

        public MyViewholder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerView.scrollToPosition(0);
                }
            });
        }
    }
}
