package com.angel.vlayout.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.angel.vlayout.R;
import com.angel.vlayout.adapter.DelegateRecyclerAdapter;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Administrator on 2017/3/27.
 */
@EActivity(R.layout.recycler)
public class StickyLayoutActivity extends Activity {


    @ViewById
    RecyclerView recycler;

    @AfterViews
    void afterviews() {
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recycler.setLayoutManager(manager);
        DelegateAdapter adapter = new DelegateAdapter(manager, true);
        //在顶部时需先添加sticklayout，在底部时最后添加sticklayout
        StickyLayoutHelper helper = new StickyLayoutHelper(true);
//        adapter.addAdapter(new StickRecyclerAdapter(this, helper, recycler));
//        adapter.addAdapter(new DelegateRecyclerAdapter(this, new LinearLayoutHelper()));
          //顶部和实体合二为一
        adapter.addAdapter(new DelegateRecyclerAdapter(this, helper));
        adapter.addAdapter(new DelegateRecyclerAdapter(this, new LinearLayoutHelper()));
          //底部
//        StickyLayoutHelper helper = new StickyLayoutHelper(false);
//        adapter.addAdapter(new DelegateRecyclerAdapter(this, new LinearLayoutHelper()));
//        adapter.addAdapter(new StickRecyclerAdapter(this, helper));
        recycler.setAdapter(adapter);
    }
}
