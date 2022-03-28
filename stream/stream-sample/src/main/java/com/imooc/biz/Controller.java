package com.imooc.biz;

import com.imooc.topic.DelayedTopic;
import com.imooc.topic.ErrorTopic;
import com.imooc.topic.GroupTopic;
import com.imooc.topic.MyTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

  @Autowired private MyTopic producer;
  @Autowired private GroupTopic groupTopicProducer;
  @Autowired private DelayedTopic delayedTopicProducer;
  @Autowired private ErrorTopic errorTopicProducer;
  // 简单广播消息
  @PostMapping("send")
  public void sendMessage(@RequestParam(value = "body") String body) {
    producer.output().send(MessageBuilder.withPayload(body).build());
  }
  // 消息分组和消息分区
  @PostMapping("sendToGroup")
  public void sendMessageToGroup(@RequestParam(value = "body") String body) {
    groupTopicProducer.output().send(MessageBuilder.withPayload(body).build());
  }

  // 延迟消息
  @PostMapping("sendDM")
  public void sendDelayedMessage(
      @RequestParam(value = "body") String body, @RequestParam(value = "seconds") Integer seconds) {

    MessageBean msg = new MessageBean();
    msg.setPayload(body);

    log.info("ready to send delayed message");
    delayedTopicProducer
        .output()
        .send(MessageBuilder.withPayload(msg).setHeader("x-delay", seconds * 1000).build());
  }

  // 异常重试（单机版）
  @PostMapping("sendError")
  public void sendErrorMessage(@RequestParam(value = "body") String body) {
    MessageBean msg = new MessageBean();
    msg.setPayload(body);
    errorTopicProducer.output().send(MessageBuilder.withPayload(msg).build());
  }
}
