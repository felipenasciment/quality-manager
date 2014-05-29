package br.edu.ifpb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity implements Runnable
{

	private final int DURA�AO_SPLASH_SCREEN = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		Handler hand = new Handler();
		hand.postDelayed(this, DURA�AO_SPLASH_SCREEN);
	}
	
	@Override
	public void run() 
	{
		Intent mudan�a_tela = new Intent(this, MainActivity.class);
		startActivity(mudan�a_tela);
		finish();
	}

}
