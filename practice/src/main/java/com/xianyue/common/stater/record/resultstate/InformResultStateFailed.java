package com.xianyue.common.stater.record.resultstate;

import com.xianyue.common.stater.inform.InformResultEvent;

/**
 * @author liuhongjun
 * @note
 * @since 2019-06-13
 */
public class InformResultStateFailed extends InformResultState {

    public InformResultStateFailed() {
        super(InformResultEvent.FAILED);
    }
}
