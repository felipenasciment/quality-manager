package br.edu.ifpb.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.edu.ifpb.R;
import br.edu.ifpb.conection.ParserAsyncTask;
import br.edu.ifpb.conection.PreencherSpinnerProgramaInstitucionalAsyncTask;
import br.edu.ifpb.qmanager.entidade.Edital;
import br.edu.ifpb.qmanager.entidade.Gestor;
import br.edu.ifpb.qmanager.entidade.ProgramaInstitucional;
import br.edu.ifpb.util.Constantes;
import br.edu.ifpb.util.Mascara;
import br.edu.ifpb.util.Valida��o;

public class CadastrarEditalActivity extends Activity implements
		OnClickListener {

	private Intent intent;
	private Bundle params;
	private Gestor gestor;
	private Edital edital = new Edital();
	private List<ProgramaInstitucional> programasInstitucionais = new ArrayList<ProgramaInstitucional>();
	private List<String> siglaProgramasInstitucionais;
	private List<String> tipoEdital;
	private Spinner spinnerProgramaInstitucional;
	private EditText editTextNumeroEdital;
	private EditText editTextAno;
	private EditText editTextInicioInscricoes;
	private EditText editTextFimInscricoes;
	private EditText editTextPrazoRelatorioParcial;
	private EditText editTextPrazoRelatorioFinal;
	private EditText editTextNumeroVagas;
	private EditText editTextBolsaOrientador;
	private EditText editTextBolsaDiscente;
	private Spinner spinnerTipoEdital;
	private Button buttonCadastrarEdital;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_edital);

		PreencherSpinnerProgramaInstitucionalAsyncTask preencherSpinner = new PreencherSpinnerProgramaInstitucionalAsyncTask();

		try {
			programasInstitucionais = preencherSpinner.execute().get();

			if (programasInstitucionais != null) {
				findViews();
				addMascaras();
				createListSigla();
				ativarSpinner(spinnerProgramaInstitucional,
						siglaProgramasInstitucionais);
				ativarSpinner(spinnerTipoEdital, tipoEdital);
				buttonCadastrarEdital.setOnClickListener(this);
			} else {
				Toast toast = Toast.makeText(getApplicationContext(),
						Constantes.ERROR_PROGRAMA_INSTITUCIONAL_NULL,
						Toast.LENGTH_LONG);
				toast.show();
				intent = new Intent(getApplicationContext(),
						GestorActivity.class);
				startActivity(intent);
				finish();
			}
		} catch (InterruptedException e) {
			Toast toast = Toast.makeText(this, "ERRO: Conex�o Encerrada",
					Toast.LENGTH_LONG);
			toast.show();
			intent = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(intent);
			finish();
		} catch (ExecutionException e) {
			Toast toast = Toast.makeText(this, "ERRO: Conex�o Encerrada",
					Toast.LENGTH_LONG);
			toast.show();
			intent = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(intent);
			finish();
		}
	}

	@Override
	public void onClick(View v) {
		if (validateAll()) {
			edital.setNumero(Integer.parseInt((editTextNumeroEdital).getText()
					.toString()));
			edital.setAno(Integer.parseInt((editTextAno).getText().toString()));
			edital.setInicioInscricoes((editTextInicioInscricoes).getText()
					.toString());
			edital.setFimInscricoes((editTextFimInscricoes).getText()
					.toString());
			edital.setRelatorioParcial((editTextPrazoRelatorioParcial)
					.getText().toString());
			edital.setRelatorioFinal((editTextPrazoRelatorioFinal).getText()
					.toString());
			edital.setNumero(Integer.parseInt((editTextNumeroVagas).getText()
					.toString()));
			edital.setBolsaDocente(Double.parseDouble(Mascara
					.unmask((editTextBolsaOrientador).getText().toString())));
			edital.setBolsaDiscente(Double.parseDouble(Mascara
					.unmask((editTextBolsaDiscente).getText().toString())));
			edital.setProgramaInstitucional(itemSelectSpinner());
			edital.setTipoEdital((spinnerTipoEdital.getSelectedItem())
					.toString().charAt(0));
			edital.setGestor(gestor);

			ParserAsyncTask<Edital> parser = new ParserAsyncTask<Edital>(
					edital, this, Constantes.CADASTRAR_EDITAL,
					params.getInt("Gestor"));
			parser.execute();
		}
	}

	public void ativarSpinner(Spinner generic, List<String> genericItems) {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, genericItems);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
		generic.setAdapter(adapter);
		generic.setSelection(0);

		generic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	public void findViews() {
		intent = getIntent();
		params = intent.getExtras();
		gestor = new Gestor();
		gestor.setPessoaId(params.getInt("Gestor"));
		editTextInicioInscricoes = (EditText) findViewById(R.id.editTextInicioInscricoes);
		editTextFimInscricoes = (EditText) findViewById(R.id.editTextFimInscricoes);
		editTextPrazoRelatorioParcial = (EditText) findViewById(R.id.editTextPrazoRelatorioParcial);
		editTextPrazoRelatorioFinal = (EditText) findViewById(R.id.editTextPrazoRelatorioFinal);
		editTextNumeroEdital = (EditText) findViewById(R.id.editTextNumeroEdital);
		editTextAno = (EditText) findViewById(R.id.editTextAno);
		editTextNumeroVagas = (EditText) findViewById(R.id.editTextNumeroVagas);
		editTextBolsaOrientador = (EditText) findViewById(R.id.editTextBolsaOrientador);
		editTextBolsaDiscente = (EditText) findViewById(R.id.editTextBolsaDiscente);
		spinnerProgramaInstitucional = (Spinner) findViewById(R.id.spinnerProgramaInstitucional);
		spinnerTipoEdital = (Spinner) findViewById(R.id.spinnerTipoEdital);
		buttonCadastrarEdital = (Button) findViewById(R.id.buttonCadastrarEdital);
	}

	public void addMascaras() {
		// Adicionar Mascara aos campos Inicio Inscri��es
		editTextInicioInscricoes.addTextChangedListener(Mascara.insert(
				"####-##-##", editTextInicioInscricoes));

		// Adicionar Mascara aos campos Fim Inscri��es
		editTextFimInscricoes.addTextChangedListener(Mascara.insert(
				"####-##-##", editTextFimInscricoes));

		// Adicionar Mascara aos campos Prazo Relatorio Parcial
		editTextPrazoRelatorioParcial.addTextChangedListener(Mascara.insert(
				"####-##-##", editTextPrazoRelatorioParcial));

		// Adicionar Mascara aos campos Prazo Relatorio Final
		editTextPrazoRelatorioFinal.addTextChangedListener(Mascara.insert(
				"####-##-##", editTextPrazoRelatorioFinal));

		// Adicionar Mascara aos campos Bolsa Orientador
		editTextBolsaOrientador.addTextChangedListener(Mascara
				.money(editTextBolsaOrientador));

		// Adicionar Mascara aos campos Bolsa Discente
		editTextBolsaDiscente.addTextChangedListener(Mascara
				.money(editTextBolsaDiscente));
	}

	public void createListSigla() {
		siglaProgramasInstitucionais = new ArrayList<String>();
		siglaProgramasInstitucionais.add(Constantes.MSG_INICIO_SPINNER);

		for (int i = 0; i < programasInstitucionais.size(); i++) {
			siglaProgramasInstitucionais.add(programasInstitucionais.get(i)
					.getSigla());
		}

		tipoEdital = new ArrayList<String>();
		tipoEdital.add(Constantes.MSG_INICIO_SPINNER);
		tipoEdital.add("Pesquisa");
		tipoEdital.add("Extens�o");
	}

	public boolean validateAll() {
		if (Valida��o.validarCampo(editTextNumeroEdital))
			if (Valida��o.validarCampo(editTextAno))
				if (Valida��o.validarCampo(editTextInicioInscricoes))
					if (Valida��o.validarCampo(editTextFimInscricoes))
						if (Valida��o
								.validarCampo(editTextPrazoRelatorioParcial))
							if (Valida��o
									.validarCampo(editTextPrazoRelatorioFinal))
								if (Valida��o.validarCampo(editTextNumeroVagas))
									if (Valida��o
											.validarCampo(editTextBolsaOrientador))
										if (Valida��o
												.validarCampo(editTextBolsaDiscente))
											if (Valida��o.validarSpinner(
													spinnerProgramaInstitucional
															.getSelectedItem()
															.toString(),
													getApplicationContext()))
												if (Valida��o
														.validarSpinner(
																spinnerTipoEdital
																		.getSelectedItem()
																		.toString(),
																getApplicationContext())) {
													return true;
												}
		return false;
	}

	public ProgramaInstitucional itemSelectSpinner() {
		ProgramaInstitucional programaInstitucional = new ProgramaInstitucional();
		for (int i = 0; i < programasInstitucionais.size(); i++) {
			if (programasInstitucionais.get(i).getSigla()
					.equals(spinnerProgramaInstitucional.getSelectedItem())) {
				programaInstitucional = programasInstitucionais.get(i);
			}
		}
		return programaInstitucional;
	}
}
