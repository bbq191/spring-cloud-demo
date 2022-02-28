package com.imooc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author afu
 */
@FeignClient("eureka-client")
public interface IService {
  @GetMapping("/sayHi")
  String sayHi();
}
