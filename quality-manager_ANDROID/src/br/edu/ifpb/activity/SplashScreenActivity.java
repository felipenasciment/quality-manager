package br.edu.ifpb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import br.edu.ifpb.R;
import br.edu.ifpb.alertdialog.SemConexaoAlertDialog;
import br.edu.ifpb.conection.HttpUtil;
import br.edu.ifpb.conection.VerificarConexaoAsyncTask;

public class SplashScreenActivity extends Activity implements Runnable {

	private static int SPLASH_TIME_OUT = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		Handler handler = new Handler();
		handler.postDelayed(this, SPLASH_TIME_OUT);
	}

	@Override
	public void run() {
		if (HttpUtil.isConnect(getApplicationContext())) {

			VerificarConexaoAsyncTask verificaConexao = new VerificarConexaoAsyncTask(
					this);
			verificaConexao.execute();
		} else {

			SemConexaoAlertDialog semConexaoAlertDialog = new SemConexaoAlertDialog(
					this);
			semConexaoAlertDialog.showAlertDialog();
		}
	}
}