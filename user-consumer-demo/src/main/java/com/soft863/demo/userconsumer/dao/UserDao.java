package com.soft863.demo.userconsumer.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.soft863.demo.userconsumer.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    @HystrixCommand(fallbackMethod="queryUserByIdFallback")
    public User queryUserById(Long id){
        List<User> users = new ArrayList<>();
        // String baseUrl = "http://localhost:8081/user/";
        // 根据服务名称，获取服务实例
        /*List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";

            User user=this.restTemplate.getForObject(baseUrl + id, User.class);
            // 每次间隔500毫秒*/
        // 地址直接写服务名称即可
        long begin = System.currentTimeMillis();
        String baseUrl = "http://user-service/user/";
            User user=this.restTemplate.getForObject(baseUrl + id, User.class);
            // 每次间隔500毫秒
        long end = System.currentTimeMillis();

        logger.info("访问用时：{}", end - begin);
        return user;

    }
    public User queryUserByIdFallback(Long id){
        User user = new User();
        int i = id.intValue();
        user.setUid(i);
        user.setUname("用户信息查询出现异常！");
        return user;
    }
}