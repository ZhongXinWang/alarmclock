package wzx.app.com.wzxalarmclock.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import wzx.app.com.wzxalarmclock.R;
import wzx.app.com.wzxalarmclock.adapter.ClockListAdapter;
import wzx.app.com.wzxalarmclock.entity.Clock;

/**
 * Created by 王钟鑫 on 2017/4/12.
 */

public class ClockFragment extends Fragment {

    private View mView;
    private ListView mListView;
    private FloatingActionButton mFloatingActionButton;
    private ClockListAdapter mAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.getDatabase();
    }
    @Nullable //该注释表示可以传入空值 @NotNull表示不许传入空值，否则系统会提出警告
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_clock,container,false);
        mListView = (ListView) mView.findViewById(R.id.clock_list);
        //通过litepal查找数据库
       List<Clock> list = DataSupport.findAll(Clock.class);

        if(list != null){

            mAdapter = new ClockListAdapter(getActivity(),R.layout.list_view_item,list);
            mListView.setAdapter(mAdapter);
        }
        mFloatingActionButton = (FloatingActionButton) mView.findViewById(R.id.add_btn);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"提示",Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //添加数据
                        Clock clock = new Clock();
                        clock.setBibtare(1);
                        clock.setContent("hello");
                        clock.setIsStart(1);
                        clock.setSetTime("12:12");
                        clock.save();
                        mAdapter.notifyDataSetChanged();

                    }
                }).show();

            }
        });
        return mView;
    }

}
