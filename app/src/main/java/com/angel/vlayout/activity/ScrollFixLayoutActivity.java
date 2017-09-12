package com.angel.vlayout.activity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.angel.vlayout.R;
import com.angel.vlayout.adapter.DelegateRecyclerAdapter;
import com.angel.vlayout.adapter.ScrollFixAdapter;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Angel on 2017/3/24.
 */
@EActivity(R.layout.recycler)
public class ScrollFixLayoutActivity extends Activity {
    @ViewById
    RecyclerView recycler;

    @AfterViews
    void afterviews() {
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recycler.setLayoutManager(manager);
        DelegateAdapter adapter = new DelegateAdapter(manager, true);
        ScrollFixLayoutHelper helper = new ScrollFixLayoutHelper(20, 20);
        //show_always:总是显示
        //show_on_enter:当页面滚动到这个视图的位置的时候，才显示
        //show_on_leave:当页面滚出这个视图的位置的时候显示
        helper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        adapter.addAdapter(new DelegateRecyclerAdapter(this, new LinearLayoutHelper()));
        adapter.addAdapter(new ScrollFixAdapter(this, helper, recycler));
        recycler.setAdapter(adapter);
    }
}