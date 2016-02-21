package com.everSeeker.action;

import com.everSeeker.SpringContextUtils;
import com.everSeeker.entity.User;
import com.everSeeker.service.UserService;
import com.everSeeker.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("/user")
public class UserAction {

    /**
     * 如果userService不采用getBean方式获得的话，即直接写成private UserService userService，会报空指针错误。
     * 通过debug方式查看会发现，userService=null，没有注入成功，原因暂时还不知道，请高手告知。
     */
    @Resource
    private UserService userService = SpringContextUtils.getApplicationContext().getBean(UserServiceImpl.class);

    /**
     * @GET : get请求
     * @Path : 路径,由于类的路径为/user,所以该方法的路径为/user/{username}
     * @Produces : 返回类型。该方法为文本。
     * @Consumes : 可以接受的类型。
     */
    @GET
    @Path("{username}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getByUsername(@PathParam("username") String username) throws Exception {
        return userService.getUserByUsername(username).toString();
    }

    /**
     * 返回的类型为json。需要将类User转换为json格式。本案例采用的转换方式为jackson, 在pom.xml中有说明。
     */
    @GET
    @Path("json/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByUsername(@PathParam("username") String username) throws Exception {
        return userService.getUserByUsername(username);
    }
}

