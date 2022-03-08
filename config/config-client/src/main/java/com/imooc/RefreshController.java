package com.imooc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refresh")
@RefreshScope
public class RefreshController {
  @Value("${words}")
  private String words;

  @Value("${girl}")
  private String girl;

  @GetMapping("/words")
  public String getWords() {
    return words;
  }

  @GetMapping("/marry")
  public String marry() {
    return "May I marry you, " + girl + "?";
  }
}
