package com.angel.vlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.angel.vlayout.R;

/**
 * Created by Angel on 2017/3/24.
 */
public class ScrollFixAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private LayoutHelper helper;
    private LayoutInflater inflater;
    private RecyclerView recyclerView;

    public ScrollFixAdapter(Context context, LayoutHelper helper, RecyclerView recyclerView) {
        this.context = context;
        this.helper = helper;
        this.inflater = LayoutInflater.from(context);
        this.recyclerView = recyclerView;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return helper;
    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(inflater.inflate(R.layout.image, parent, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    public int getItemCount() {
        return 1;
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        private ImageView img;

        public MyViewholder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerView.scrollToPosition(0);
                }
            });
        }
    }
}
