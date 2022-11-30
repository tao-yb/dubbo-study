package com.dubbo.consume.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Method;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.dubbo.*;
import com.dubbo.consume.anno.DubboConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DubboConfig.class)
@Slf4j(topic = "test")
public class ConsumerTest {

    @Reference(check = true,loadbalance = "random",url = "dubbo://localhost:20880")
    private UserService userService;

//    @Reference(check = false,group = "*",parameters = {"merger","true"})
    @Reference(check = false,group = "g2")
    private GroupService groupService;

    @Reference(check =false,version = "20")
    private VersionService versionService;

    @Reference(check = false,validation = "true")
    private ValidationService validationService;

    @Reference(check = false,interfaceClass = GenericService.class)
    private GenericService genericService;

    @Reference(check = false,timeout = 5000,methods = {@Method(name ="query",async
            = true)})
    private AsyncService asyncService;

    @Test
    public void useQuery(){
        final String tao = userService.queryUser("tao");
        log.warn("=================="+tao);
    }

    @Test
    public void group(){
        log.info(groupService.getGroupName());
    }

    @Test
    public void api(){
        ApplicationConfig config = new ApplicationConfig("dubbo-consume-00A1");
        config.setQosEnable(false);

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");

        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(config);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(UserService.class);

        final UserService userService = referenceConfig.get();
        log.error("========"+userService.queryUser("api-tao"));
    }

    @Test
    public void version(){
        log.info("version:{}",        versionService.version());
    }

    @Test
    public void valid(){
        User user = new User();
        user.setAge(20);
        user.setName("test");
        user.setLoginDate(new Date(System.currentTimeMillis()-100000));
        validationService.save(user);
    }

    @Test
    public void gerneric(){
        ApplicationConfig config = new ApplicationConfig("dubbo-consume-00A1");
        config.setQosEnable(false);

        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(config);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface("com.dubbo.UserService");
        referenceConfig.setGeneric(true);

        final GenericService genericService = referenceConfig.get();
        final Object user = genericService.$invoke("queryUser", new String[]{"java.lang.String"}, new Object[]{
                "tao"});
        log.info("result:{}",user);
    }

    @Test
    public void genericImpl(){
        genericService.$invoke("test",new String[]{"java.lang.String"},new Object[]{
                "aaa"});
    }

    @Test
    public void async(){
        try {
            User user = asyncService.query("01");
            log.info("user name :{}",user);
            final Future<Object> future = RpcContext.getContext().getFuture();
            user = (User)future.get();
            log.info("===user name :{}",user.getName());

            User user2 = asyncService.querySync("02");
            log.info("user22222 name :{}",user);
            final Future<Object> future2 = RpcContext.getContext().getFuture();
            user = (User)future2.get();
            log.info("===user name :{}",user.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
