package com.zhy;

import java.util.ArrayList;
import java.util.List;

// 主题对象
public class VideoPublisher implements Publisher {
    private final List<Listener> observers;

    public VideoPublisher() {
        observers = new ArrayList<>();
    }

    @Override
    public void addListener(Listener listener) {
        observers.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        observers.remove(listener);
    }

    @Override
    public void notifyListeners(Message message) {
        for (Listener observer : observers) {
            observer.update(message);
        }
    }
}
