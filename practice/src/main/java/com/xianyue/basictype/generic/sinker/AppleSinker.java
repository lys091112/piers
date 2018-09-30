package com.xianyue.basictype.generic.sinker;

import com.xianyue.basictype.generic.Apple;

/**
 * @since 下午1:39 18-8-31
 */
public class AppleSinker extends Sinker<Apple> {

    @Override
    public void sink(Apple fruit) {
        System.out.println("i am a apple");
    }
}
