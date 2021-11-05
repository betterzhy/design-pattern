package com.zhy;

// Observer对象
public class YoukuListener extends VideoListener {
    @Override
    public void doAdd(Message message) {
        System.out.println("新增视频, 同步至: Youku");
    }

    @Override
    public void doRemove(Message message) {
        System.out.println("删除视频, 同步至: Youku");
    }

    @Override
    public void doReplace(Message message) {
        System.out.println("替换视频, 同步至: Youku");
    }
}
