package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.entity.UserToken;
import com.example.util.PwdEncoder;


@Service(LoginService.BEAN_NAME)
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static final long TOKEN_EXPIRE_INTERVAL = 5 * 60 * 1000;//30 minutes
    
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private CacheService cacheService;
    
    @Override
    public UserToken authentication(String userName, String password){
        
        if(StringUtils.isEmpty(userName)){
            return null;
        }
        if(StringUtils.isEmpty(password)){
            return null;
        }
        List<User> userList = userDao.findByUserName(userName);
        if(userList.size()== 0){
            return null;
        }
        
        User user = userList.get(0);
        
        //encrypt password and compare
        String comparedPassword = "";//input pwd to be compare
        
        //userName are correct, so have same first param
        try {
        	logger.info("db password:"+user.getPassword());
			comparedPassword = PwdEncoder.encryptSHA2MAC(userName, password);
			logger.info("comparedPassword:"+comparedPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        if(!comparedPassword.equals(user.getPassword())){
            logger.error("user ["+ user.getUserName() + "] authentication fail!");
            return null;
        }
        
        if("N".equals(user.getStatus())){
            logger.error("Status ["+ user.getStatus() + "] authentication fail! user not Active");
            return null;
        }
        
        logger.info("user ["+ user.getUserName() + "] authentication success!");
        logger.info(user.toString());
        
        UserToken token = new UserToken(user, TOKEN_EXPIRE_INTERVAL);
        cacheService.put(CacheService.CACHE_TOKEN, token.getId(), token);
        return token;
    }
    
    @Override
    public void logoff(String tokenId){
        if(!StringUtils.isEmpty(tokenId)){
            cacheService.evict(CacheService.CACHE_TOKEN, tokenId);
        }
    }
}
