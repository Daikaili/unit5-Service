package com.example.service;

import android.app.Service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="MyService";
    private boolean quit=false;
    private int count=0;
    private MyBinder myBinder=new MyBinder();
    public class MyBinder extends Binder{
    	public MyBinder(){
    		Log.i(TAG,"MyBinder Constructure invoked");
    	}
    	public int getCount(){
    		return count;
    	}
    }
	@Override
	public IBinder onBind(Intent arg0) {        //重写onBind方法




		// TODO Auto-generated method stub
		Log.i(TAG,"MyService onBind invoked");
		return  myBinder;
	}
	@Override
	public void onCreate() {              //重写OnCreate方法




		// TODO Auto-generated method stub
		Log.i(TAG,"MyService onCreate invoked");
		super.onCreate();
		new Thread(){
			public void run(){
				while(!quit){
					try{
						Thread.sleep(50);
						count++;
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	@Override
	public void onDestroy() {            //重写onDestroy方法




		// TODO Auto-generated method stub
		Log.i(TAG,"MyService onDestroy invoked");
		super.onDestroy();
		 this.quit = true;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {




		// TODO Auto-generated method stub
		Log.i(TAG,"MyService  onStartCommand invoked");   //重写onStartCommand方法
		return super.onStartCommand(intent, flags, startId);
	}
  
}