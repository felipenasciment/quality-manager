package br.edu.ifpb.conection;

import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import br.edu.ifpb.activity.LoginActivity;
import br.edu.ifpb.util.Constantes;

public class VerificarConexaoAsyncTask extends
		AsyncTask<Void, Integer, JSONObject> {

	private Activity activity;

	public VerificarConexaoAsyncTask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected JSONObject doInBackground(Void... arg0) {
		JSONObject jsonObject = null;

		// Enviar a requisi��o HTTP via GET.
		HttpService httpService = new HttpService();
		HttpResponse response = httpService
				.sendGETRequest(Constantes.SERVIDOR_ONLINE);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}

		// Convers�o do response ( resposta HTTP) para String.
		String json = HttpUtil.entityToString(response);
		Log.i("AsyncTaskKJson", "Resquest - GET: " + json);

		try {

			jsonObject = new JSONObject(json);

		} catch (JSONException e) {

			Log.e("AsyncTaskKJson", "Error parsing data " + e.toString());
		}

		return jsonObject;
	}

	@Override
	protected void onPostExecute(JSONObject result) {

		try {

			boolean online = result.getBoolean("online");

			Log.i("AsyncTaskKJson", "Servidor conectado: " + online);

			if (online) {

				Intent intent = new Intent(activity, LoginActivity.class);
				activity.startActivity(intent);
				activity.finish();
			} else {
				Toast toast = Toast.makeText(activity.getApplicationContext(),
						Constantes.ERROR_COMUNICACAO_SERVIDOR_OFF,
						Toast.LENGTH_LONG);
				toast.show();
			}

		} catch (JSONException e) {
			Log.e("AsyncTaskKJson", "Error parsing data " + e.toString());
		}

	}
}