package com.xianyue.basictype.generic.sinker;

import com.xianyue.basictype.generic.Orange;

/**
 * @since 下午1:39 18-8-31
 */
public class OrangeSinker extends Sinker<Orange> {

    @Override
    public void sink(Orange fruit) {

        System.out.println("i am a orange");
    }
}
