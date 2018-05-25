package com.android.Presenter;

import com.android.Module.MyModule;
import com.android.Module.MyNineModule;
import com.android.View.MyNineInterface;

public class MyNinePresenter implements MyNineInterface {
    private MyNineModule myNineModule;
    private MyNineInterface myNineInterface;

    public MyNinePresenter(MyNineInterface myNineInterface){
        this.myNineModule = new MyNineModule();
        this.myNineInterface = myNineInterface;
    }

    public void getDate(String str){
        myNineModule.getDate(str,this);
    }

    public void detachView(){
        if(myNineInterface!=null){
            myNineInterface=null;
        }
    }

    @Override
    public void nineSuccess(Object obj) {
        myNineInterface.nineSuccess(obj);
    }
}
