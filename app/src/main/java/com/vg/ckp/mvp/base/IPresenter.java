package com.vg.ckp.mvp.base;

import java.lang.ref.WeakReference;

public class IPresenter<IView> {

    protected WeakReference<IView> mReference;

    public IPresenter(IView view){
        attachView(view);
    }

    /**
     * 连接上View模型，类型于Activity与Fragment的连接onAttachActivity()
     * @param view
     */
    public void attachView(IView view){

        mReference = new WeakReference<IView>(view);

    }

    /**
     * 断开与View模型的连接，类型于Activity与Fragment的断开onDetachActivity()
     */
    public void detachView(){
        if (mReference != null){
            mReference.clear();
        }
    }
    public IView getView(){

        return mReference.get();
    }


}
