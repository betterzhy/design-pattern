package com.zhy;

import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    public void test() {
        VideoPublisher videoPublisher = new VideoPublisher();

        YoutubeListener youtubeListener = new YoutubeListener();
        YoukuListener youkuListener = new YoukuListener();

        videoPublisher.addListener(youtubeListener);
        videoPublisher.addListener(youkuListener);

        videoPublisher.notifyListeners(
                new Message("新增", "发布新视频: 看房VLOG", "www.xxx.com")
        );

        // 无法继续上传Youtube了
        System.out.println("由于政策原因, Youtube账号不再维护");
        videoPublisher.removeListener(youtubeListener);

        videoPublisher.notifyListeners(
                new Message("删除", "发布新视频: 旅游VLOG", "www.xxx.com")
        );
    }
}
