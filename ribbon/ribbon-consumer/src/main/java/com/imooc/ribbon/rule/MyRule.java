package com.imooc.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author afu
 */
@NoArgsConstructor
public class MyRule extends AbstractLoadBalancerRule implements IRule {

  @Override
  public void initWithNiwsConfig(IClientConfig iClientConfig) {}

  @Override
  public Server choose(Object o) {
    HttpServletRequest request =
        ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
            .getRequest();

    String uri = request.getServletPath() + "?" + request.getQueryString();
    return router(uri.hashCode(), getLoadBalancer().getAllServers());
  }

  public Server router(int hashId, List<Server> addressList) {
    if (CollectionUtils.isEmpty(addressList)) {
      return null;
    }
    TreeMap<Long, Server> address = new TreeMap<>();
    addressList.forEach(
        // 虚化若干节点到哈希环
        e -> {
          for (int i = 0; i < 15; i++) {
            long hash = hash(e.getId() + i);
            address.put(hash, e);
          }
        });
    long hash = hash(String.valueOf(hashId));
    SortedMap<Long, Server> last = address.tailMap(hash);
    // 当哈希环首尾相接的时候取第一个节点
    if (last.isEmpty()) {
      address.firstEntry().getValue();
    }
    return last.get(last.firstKey());
  }

  public long hash(String key) {
    MessageDigest md5;
    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    byte[] keyByte = null;
    keyByte = key.getBytes(StandardCharsets.UTF_8);
    md5.update(keyByte);
    byte[] digest = md5.digest();
    long hashCode =
        ((long) (digest[2] & 0xFF << 16) | (digest[1] & 0xFF << 8) | (digest[1] & 0xFF));
    return hashCode & 0xffffffffL;
  }
}
