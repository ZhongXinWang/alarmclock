package wzx.app.com.wzxalarmclock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import wzx.app.com.wzxalarmclock.R;
import wzx.app.com.wzxalarmclock.entity.Clock;
import wzx.app.com.wzxalarmclock.util.ViewHolder;

/**
 * Created by 王钟鑫 on 2017/4/12.
 */

public class ClockListAdapter extends BaseAdapter {
    private Context mContext;
    private int mLayoutId;
    private List<Clock> mList;
    public ClockListAdapter(Context context,int layoutId,List<Clock> list){

        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mList = list;

    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {

        return mList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(mContext).inflate(mLayoutId,parent,false);

        }
        //使用ViewHolder来优化
        TextView setTime =  ViewHolder.get(convertView,R.id.set_time);
        TextView showRepeat = ViewHolder.get(convertView,R.id.show_repeat);
        TextView whenStart =  ViewHolder.get(convertView,R.id.when_start);
        Switch status =  ViewHolder.get(convertView,R.id.status);

        Clock clock = mList.get(position);
        setTime.setText(clock.getSetTime());
        whenStart.setText(clock.getContent());
        if(clock.getIsStart() == 1){

            status.setChecked(true);
        }
        return convertView;
    }
}
