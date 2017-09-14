package com.chinaums.timelogout;

/**
 * EventBus
 */

public class MessageEvent {

    private int code ;

    public MessageEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
