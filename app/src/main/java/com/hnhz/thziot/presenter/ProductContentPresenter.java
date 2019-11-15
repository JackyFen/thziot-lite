package com.hnhz.thziot.presenter;

import com.hnhz.thziot.bean.MenuBean;
import com.hnhz.thziot.bean.MenuRightBean;
import com.hnhz.thziot.model.ProductModel;
import com.hnhz.thziot.model.impl.ProductModelImpl;
import com.hnhz.thziot.presenter.view.IProductContentView;
import com.kq.platform.kq_common.bean.HttpResult;
import com.kq.platform.kq_common.http.HttpResultObserver;
import com.kq.platform.kq_common.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by Zhou jiaqi on 2019/8/29.
 */
public class ProductContentPresenter extends BasePresenter {

    private IProductContentView iProductContentView;
    private ProductModel productModel;

    public ProductContentPresenter(IProductContentView iProductContentView) {
        this.iProductContentView = iProductContentView;
        productModel = new ProductModelImpl();
    }

    public void getMenuList(){
        //iProductContentView.showWait();

        MenuRightBean menuRightBean = new MenuRightBean();
        List<MenuBean> menuList = new ArrayList<>();

        MenuBean menuBean1 = new MenuBean();
        menuBean1.setHref("http://www.baidu.com");
        menuBean1.setName("菜单1");

        MenuBean menuBean2 = new MenuBean();
        menuBean2.setHref("http://github.com");
        menuBean2.setName("菜单2");

        menuList.add(menuBean1);
        menuList.add(menuBean2);
        menuRightBean.setListProductAccess(menuList);

        iProductContentView.getMenu(menuRightBean);
//        productModel.getMenuInfo(subItemId,productId)
//                .subscribe(new HttpResultObserver<MenuRightBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addDisposable(d);
//                    }
//
//                    @Override
//                    public void onSuccess(HttpResult<MenuRightBean> t) {
//                        iProductContentView.cancelWait();
//                        iProductContentView.getMenu(t.getResultVo());
//                    }
//
//                    @Override
//                    public void _onError(String errorCode, String msg) {
//                        iProductContentView.cancelWait();
//                        iProductContentView.onFailure(errorCode,msg);
//                    }
//                });
    }
}
