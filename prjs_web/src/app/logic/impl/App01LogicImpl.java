package app.logic.impl;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import manager.common.bean.ConstantBean;
import manager.common.bean.RedisConstant;
import manager.common.bean.UserBean;
import app.action.APP01Action;
import app.dao.APP01Dao;
import app.logic.App01LogicIF;

@Service
public class App01LogicImpl implements App01LogicIF{
}
