package com.zhy;

// 主题Subject，对象的抽象
interface Publisher {
    void addListener(Listener listener);

    void removeListener(Listener listener);

    void notifyListeners(Message message);
}
