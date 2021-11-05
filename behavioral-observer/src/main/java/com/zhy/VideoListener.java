package com.zhy;

// 模板方法类
public abstract class VideoListener implements Listener {
    @Override
    public void update(Message message) {
        if ("新增".equals(message.getAction())) {
            doAdd(message);
        } else if ("删除".equals(message.getAction())) {
            doRemove(message);
        } else if ("替换".equals(message.getAction())) {
            doReplace(message);
        } else {
            throw new RuntimeException("错误的操作");
        }
    }

    abstract void doAdd(Message message);

    abstract void doRemove(Message message);

    abstract void doReplace(Message message);
}
