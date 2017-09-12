package com.angel.vlayout.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.angel.vlayout.R;
import com.angel.vlayout.adapter.StaggeredAdapter;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Angel on 2017/3/24.
 */
@EActivity(R.layout.recycler)
public class StaggeredGridLayoutHelperActivity extends Activity {


    @ViewById
    RecyclerView recycler;

    @AfterViews
    void afterviews() {
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recycler.setLayoutManager(manager);
        DelegateAdapter adapter = new DelegateAdapter(manager, true);
        //StaggeredGridLayoutHelper（int num,int gap)
        //num为每行显示数目，gap为两个item的边距
        adapter.addAdapter(new StaggeredAdapter(this,new StaggeredGridLayoutHelper(3,20)));
        recycler.setAdapter(adapter);
    }
}
