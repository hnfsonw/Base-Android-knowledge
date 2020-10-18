package com.hnf.guet.moreknowleagemoremoney.Serializable;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Android 序列化方式
 * 主要用于内存序列化上
 */
public class pacelableTest implements Parcelable {
    private String name;
    private int age;

    public pacelableTest() {
    }

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
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    protected pacelableTest(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }


    /**
     * 反序列化
     */
    public static final Parcelable.Creator<pacelableTest> CREATOR = new Parcelable.Creator<pacelableTest>() {
        @Override
        public pacelableTest createFromParcel(Parcel source) {
            return new pacelableTest(source);
        }

        @Override
        public pacelableTest[] newArray(int size) {
            return new pacelableTest[size];
        }
    };
}
