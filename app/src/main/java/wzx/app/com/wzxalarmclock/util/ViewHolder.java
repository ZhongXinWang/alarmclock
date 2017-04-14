package wzx.app.com.wzxalarmclock.util;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by 王钟鑫 on 2017/4/12.
 */

public class ViewHolder {

    @SuppressWarnings("unchecked")
    public static  <T extends  View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        //SparseArray 是android用来优化内存存储的map结构，（key,value）,读取数据的时候使用的是二分查找
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);//保存没有加载过的标签
        }
        View childView =  viewHolder.get(id);//根据id作为key来获取存储的value
        if (childView == null) {
            //如果没有加载过，就重新查找该id
            childView = view.findViewById(id);
            //保存下来
            viewHolder.put(id,childView);
        }
        return  (T)childView;
    }
}
