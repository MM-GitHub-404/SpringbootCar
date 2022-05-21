package com.mm.mmcar.listener;

import com.mm.mmcar.entity.CarType;
import com.mm.mmcar.entity.UserType;
import com.mm.mmcar.service.CarTypeSevice;
import com.mm.mmcar.service.UserTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author 茂茂
 * @create 2022-05-18 14:27
 */
@WebListener
public class MyLitener implements ServletContextListener {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //使用监听器在初始化时加载汽车类型和用户类型
        CarTypeSevice carTypeSevice = (CarTypeSevice) applicationContext.getBean("CarTypeSeviceImpl");
        UserTypeSevice userTypeSevice = (UserTypeSevice) applicationContext.getBean("UserTypeSeviceImpl");
        List<CarType> carTypeList = carTypeSevice.selectAllType();
        List<UserType> userTypeList = userTypeSevice.selectAllType();
        //将查询到的结果装入全局作用域中,提供前端使用
        sce.getServletContext().setAttribute("carTypeList", carTypeList);
        sce.getServletContext().setAttribute("userTypeList", userTypeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
