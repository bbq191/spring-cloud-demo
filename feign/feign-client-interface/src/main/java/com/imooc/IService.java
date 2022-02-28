package com.imooc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author afu
 */
@FeignClient("feign-client")
public interface IService {
  @GetMapping("/sayHi")
  String sayHi();

  @PostMapping("/sayHi")
  Friend sayHiPost(@RequestBody Friend friend);
}
