package com.imooc.biz;

import com.imooc.topic.GroupTopic;
import com.imooc.topic.MyTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(value = {Sink.class, MyTopic.class, GroupTopic.class})
public class StreamConsumer {

  @StreamListener(Sink.INPUT)
  public void consume(Object payload) {
    log.info("message consumed successfully, payload={}", payload);
  }

  // 自定义消息广播
  @StreamListener(MyTopic.INPUT)
  public void consumeMyMessage(Object payload) {
    log.info("My message consumed successfully, payload={}", payload);
  }

  // 消息分组 & 消费分区示例
  @StreamListener(GroupTopic.INPUT)
  public void consumeGroupMessage(Object payload) {
    log.info("Group message consumed successfully, payload={}", payload);
  }
}
