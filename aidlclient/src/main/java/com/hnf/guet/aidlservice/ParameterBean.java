package aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

public class ParameterBean implements Parcelable {

    private int param;

    public ParameterBean(int param){
        this.param = param;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    /**
     * 反序列化
     * @param in
     */
    protected ParameterBean(Parcel in) {
        this.param = in.readInt();
    }

    public static final Creator<ParameterBean> CREATOR = new Creator<ParameterBean>() {
        @Override
        public ParameterBean createFromParcel(Parcel in) {
            return new ParameterBean(in);
        }

        @Override
        public ParameterBean[] newArray(int size) {
            return new ParameterBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 序列化
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.param);
    }
}
