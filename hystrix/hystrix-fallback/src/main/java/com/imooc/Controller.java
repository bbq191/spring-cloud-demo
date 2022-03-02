package com.imooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author afu
 */
@RestController
public class Controller {

  @Qualifier("fallback")
  @Autowired
  private MyService myService;

  @GetMapping("/fallback")
  public String fallback() {
    return myService.error();
  }

  @GetMapping("/timeout")
  public String timeout(Integer timeout) {
    return myService.retry(timeout);
  }
}
