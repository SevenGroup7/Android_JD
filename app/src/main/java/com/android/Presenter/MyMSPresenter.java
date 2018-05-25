package com.android.Presenter;

import com.android.Module.MyMSModule;
import com.android.View.MyMSInterface;

public class MyMSPresenter implements MyMSInterface {

    private MyMSModule myMSModule;
    private MyMSInterface myMSInterface;

    public MyMSPresenter(MyMSInterface myMSInterface){
        this.myMSModule = new MyMSModule();
        this.myMSInterface = myMSInterface;
    }

    public void getDate(String str){
        myMSModule.getDate(str,this);
    }

    public void detachView(){
        if(myMSInterface!=null){
            myMSInterface=null;
        }
    }

    @Override
    public void onMiaoShu(Object obj) {
myMSInterface.onMiaoShu(obj);
    }
}
