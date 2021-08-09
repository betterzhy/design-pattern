import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        VideoPublisher videoPublisher = new VideoPublisher();

        YoutubeUploader youtubeUploader = new YoutubeUploader();
        BilibiliUploader bilibiliUploader = new BilibiliUploader();

        videoPublisher.addObserver(youtubeUploader);
        videoPublisher.addObserver(bilibiliUploader);

        videoPublisher.statusChanged(new Message("新增", "发布新视频: 看房VLOG", "www.xxx.com"));

        // 无法继续上传Youtube了
        System.out.println("由于政策原因, Youtube账号不再维护");
        videoPublisher.removeObserver(youtubeUploader);
        videoPublisher.statusChanged(new Message("删除", "发布新视频: 旅游VLOG", "www.xxx.com"));

    }
}

// 被订阅对象的抽象
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}

// 订阅对象的抽象
interface Observer {
    void update(Message message);
}

// 被订阅对象发送给订阅对象消息载体
class Message {
    String action;
    String description;
    String link;

    public Message(String action, String description, String link) {
        this.action = action;
        this.description = description;
        this.link = link;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

class VideoPublisher implements Subject {
    private final List<Observer> observers;

    public VideoPublisher() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // 触发通知
    public void statusChanged(Message message) {
        notifyObservers(message);
    }
}

// 模板方法类
abstract class AbstractVideoUploader implements Observer {
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

class BilibiliUploader extends AbstractVideoUploader {
    @Override
    public void doAdd(Message message) {
        System.out.println("新增视频, 同步至: Bilibili");
    }

    @Override
    public void doRemove(Message message) {
        System.out.println("删除视频, 同步至: Bilibili");
    }

    @Override
    public void doReplace(Message message) {
        System.out.println("替换视频, 同步至: Bilibili");
    }
}

class YoutubeUploader extends AbstractVideoUploader {
    @Override
    public void doAdd(Message message) {
        System.out.println("新增视频, 同步至: Youtube");
    }

    @Override
    public void doRemove(Message message) {
        System.out.println("删除视频, 同步至: Youtube");
    }

    @Override
    public void doReplace(Message message) {
        System.out.println("替换视频, 同步至: Youtube");
    }
}

