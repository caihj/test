package com.fighter.fruit;

import com.fighter.annotation.Fruit;

/**
 * Created by chj on 2015/12/22.
 */
@Fruit(name="香蕉" , color = "黄色")
public class Banana extends  FruitBase{
    public Banana()
    {
        this.desc = "我是香蕉";
    }

}
