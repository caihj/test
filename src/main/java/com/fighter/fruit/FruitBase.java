package com.fighter.fruit;

import com.fighter.annotation.Fruit;

/**
 * Created by chj on 2015/12/22.
 */


@Fruit(name="FruitBase",color = "未定义")
public class FruitBase {

    public String desc="我是水果";

    public String getDesc() {
        return desc;
    }
}
