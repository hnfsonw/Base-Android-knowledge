package com.hnf.guet.moreknowleagemoremoney.Android.GreenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by SNOW on 2020/8/10.
 */
@Entity  //加上此注解表明是数据库对象
public class UserBean {

    private String name;

    private String sex;

    @Id(autoincrement = true)
    private Long deliverId;






    @Generated(hash = 1660727367)
    public UserBean(String name, String sex, Long deliverId) {
        this.name = name;
        this.sex = sex;
        this.deliverId = deliverId;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }






    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getDeliverId() {
        return this.deliverId;
    }

    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }



}
