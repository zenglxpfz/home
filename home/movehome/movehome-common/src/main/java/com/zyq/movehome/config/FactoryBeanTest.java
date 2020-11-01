package com.zyq.movehome.config;

import com.zyq.movehome.dto.RoleDTO;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @program:
 * @description:这是spring默认这个类为工厂类，会自动调用工厂方法
 * @author: ZengYunQi
 * @time: 2020/9/6 - 23:06
 */
public class FactoryBeanTest implements FactoryBean<RoleDTO> {
    //spring会自动调用该工厂方法去创建你要创建的类实例，返回创建的对象
    @Override
    public RoleDTO getObject() throws Exception {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRole("nh");
        return roleDTO;
    }

    @Override
    public Class<?> getObjectType() {
        return RoleDTO.class;
    }

    //是否创建单实例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
