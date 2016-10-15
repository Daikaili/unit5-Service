package com.example.service;
import com.example.service.MyService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;


import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.ServiceConnection;

public class MainActivity extends Activity {
    
    private MyBinder myBinder;
    private static final String TAG="MyService";
	@Override
	protected void onCreate(Bundle savedInstanceState) {






		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnStart=(Button)findViewById(R.id.btnstart);
		Button btnStop=(Button)findViewById(R.id.btnStop);
		Button btnBind=(Button)findViewById(R.id.btnBind);
		Button btnUnbind=(Button)findViewById(R.id.btnUnbind);
		Button btnGet=(Button)findViewById(R.id.btnGet);
		
		
		final Intent intent=new Intent();
		intent.setAction(TAG);
		
		btnStart.setOnClickListener(new OnClickListener() {



			
			@Override
			public void onClick(View v) {


				// TODO Auto-generated method stub
				startService(intent);
			}
		});
		
		btnStop.setOnClickListener(new OnClickListener() {


			
			@Override
			public void onClick(View v) {


				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
		btnBind.setOnClickListener(new OnClickListener() {		
			
			public void onClick(View v) {

				bindService(intent, conn,Service.BIND_AUTO_CREATE);	
			}
		}); 
        btnUnbind.setOnClickListener(new OnClickListener() {		
	
			public void onClick(View v) {

				unbindService(conn);				
			}
		});
        btnGet.setOnClickListener(new OnClickListener() 
{
			public void onClick(View v) {		
	
				Toast.makeText(MainActivity.this, "Count="+myBinder.getCount(), Toast.LENGTH_LONG).show();				
			}
		});
    }
    
    private ServiceConnection conn=new ServiceConnection() {	
	
		public void onServiceDisconnected(ComponentName name) {		
	
			Log.i(TAG, "MainActivity onServiceDisconnected invoked");
		}		
		public void onServiceConnected(ComponentName name, IBinder service) {
	
			Log.i(TAG,"MainActivity onServiceConnected invoked");
			myBinder=(MyBinder)service;
		}
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {





		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
