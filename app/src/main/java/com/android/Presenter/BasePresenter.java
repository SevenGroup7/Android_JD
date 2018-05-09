package com.android.Presenter;

import com.android.Interfaces.IBaseView;

public class BasePresenter<V extends IBaseView> {

    private V mIBaseView;


    public void attachView(V IBaseView){
        this.mIBaseView = IBaseView;
    }

    public V getView(){
        return mIBaseView;
    }

    public void detachView(){
        if(mIBaseView != null){
            mIBaseView = null;
        }
    }


}
