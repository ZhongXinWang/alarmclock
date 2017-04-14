package wzx.app.com.wzxalarmclock.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import wzx.app.com.wzxalarmclock.R;
import wzx.app.com.wzxalarmclock.base.BaseActivity;
import wzx.app.com.wzxalarmclock.fragment.ClockFragment;

public class ClockActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        //管理fragment
        FragmentManager manager = getSupportFragmentManager();
        //判断fragment是否为空
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        if(fragment == null){

            fragment = new ClockFragment();
            manager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
