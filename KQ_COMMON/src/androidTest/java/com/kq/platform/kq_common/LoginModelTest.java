package com.kq.platform.kq_common;

import com.kq.platform.kq_common.bean.HttpResult;
import com.kq.platform.kq_common.bean.UserBean;
import com.kq.platform.kq_common.model.impl.LoginModelImpl;

import org.junit.Test;

import io.reactivex.observers.TestObserver;

/**
 * Created by Zhou jiaqi on 2019/1/18.
 */
public class LoginModelTest {

    @Test
    public void login(){
        LoginModelImpl loginModelImpl = new LoginModelImpl();
        TestObserver<HttpResult<UserBean>> testObserver =  new TestObserver<>();
        loginModelImpl.login("zhangsan","123456q").subscribe(testObserver);

        testObserver.values();
    }
}
