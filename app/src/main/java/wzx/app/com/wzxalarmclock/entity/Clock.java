package wzx.app.com.wzxalarmclock.entity;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by 王钟鑫 on 2017/4/12.
 */

public class Clock extends DataSupport {

    //编号
    @Column(ignore = true)
    private int mId;
    //设定的时间
    private String mSetTime;
    //备注的内容
    private String mContent;
    //铃声
    private int mVoice;
    //是否振动
    private int mBibtare;
    //重复次数
    private String  mReptime;
    //是否开启
    private int mIsStart;

    public int getId() {
        return mId;
    }

    public String getSetTime() {
        return mSetTime;
    }

    public void setSetTime(String setTime) {
        mSetTime = setTime;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getVoice() {
        return mVoice;
    }

    public void setVoice(int voice) {
        mVoice = voice;
    }

    public int getBibtare() {
        return mBibtare;
    }

    public void setBibtare(int bibtare) {
        mBibtare = bibtare;
    }

    public String  getReptime() {
        return mReptime;
    }

    public void setReptime(String reptime) {
        mReptime = reptime;
    }

    public int getIsStart() {
        return mIsStart;
    }

    public void setIsStart(int isStart) {
        mIsStart = isStart;
    }
}
