package com.lostad.app.base.view;

import android.content.Intent;
import android.os.Bundle;

import com.lostad.app.demo.view.LoginActivity;
import com.lostad.app.demo.view.PagerChildActivity;
import com.lostad.applib.entity.ILoginConfig;


public class BaseAppLoginActivity extends BaseActivity{
    protected  ILoginConfig mLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mLogin = getLoginConfig();
		if(mLogin==null){
			showToast("请登陆！");
            toLoginActivity();
			finish();
		}
	}

	public void toLoginActivity(){
		Intent intent = new Intent(this, LoginActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);//
		startActivity(intent);
		startActivity(intent);
		finish();
	}

	protected Class getCallbackActivityClass() {
		String target = getIntent().getStringExtra("target");
		Class targetAct;
		try {
			targetAct = Class.forName(target);
		} catch (Exception e) {
			e.printStackTrace();
			targetAct = PagerChildActivity.class ;//MainActivity.class;
		}
		return targetAct;
	}


}
