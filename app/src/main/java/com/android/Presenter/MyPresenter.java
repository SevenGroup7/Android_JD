package com.android.Presenter;

import com.android.Module.MyModule;
import com.android.View.MyViewInterface;

public class MyPresenter implements MyPresenterInterface {

    private MyModule myModule;
    private MyViewInterface myViewInterface;

    public MyPresenter(MyViewInterface myViewInterface){
        this.myModule = new MyModule();
        this.myViewInterface = myViewInterface;
    }

    public void getDate(String str){
        myModule.getDate(str,this);
    }

    public void detachView(){
        if(myViewInterface!=null){
            myViewInterface=null;
        }
    }

    @Override
    public void onSuccess(Object obj) {
        myViewInterface.onSuccess(obj);
    }
}
