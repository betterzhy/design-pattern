package com.zhy;

// 订阅对象Observer，的抽象
interface Listener {
    void update(Message message);
}
