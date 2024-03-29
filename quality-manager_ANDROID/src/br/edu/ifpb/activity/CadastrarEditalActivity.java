package br.edu.ifpb.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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
import br.edu.ifpb.listener.CadastrarEditalDataPickerOnClickListener;
import br.edu.ifpb.qmanager.entidade.Edital;
import br.edu.ifpb.qmanager.entidade.ProgramaInstitucional;
import br.edu.ifpb.qmanager.entidade.Servidor;
import br.edu.ifpb.qmanager.util.StringUtil;
import br.edu.ifpb.util.Constantes;
import br.edu.ifpb.util.DatePickerDialogAdapter;
import br.edu.ifpb.util.Mascara;
import br.edu.ifpb.util.Valida��o;

public class CadastrarEditalActivity extends Activity implements
		OnClickListener {

	private Intent intent;
	private Bundle params;
	private Servidor servidor;
	private Edital edital = new Edital();
	private List<ProgramaInstitucional> programasInstitucionais = new ArrayList<ProgramaInstitucional>();
	private List<String> siglaProgramasInstitucionais;
	private List<String> tipoEdital;
	private Spinner spinnerProgramaInstitucional;
	private EditText editTextNumeroEdital;
	private EditText editTextAno;
	private int IdPessoa;

	// Prazo inscri��es.
	private EditText editTextInicioInscricoes;
	private EditText editTextFimInscricoes;

	// Prazo relat�rio parcial e final
	private EditText editTextPrazoRelatorioParcial;
	private EditText editTextPrazoRelatorioFinal;

	private EditText editTextNumeroVagas;
	private EditText editTextBolsaOrientador;
	private EditText editTextBolsaDiscente;
	private Spinner spinnerTipoEdital;
	private Button buttonCadastrarEdital;

	private DatePickerDialog inicioInscricoesPickerDialog;
	private DatePickerDialog fimInscricoesPickerDialog;
	private DatePickerDialog prazoRelatorioParcialPickerDialog;
	private DatePickerDialog prazoRelatorioFinalPickerDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_edital);

		PreencherSpinnerProgramaInstitucionalAsyncTask preencherSpinner = new PreencherSpinnerProgramaInstitucionalAsyncTask();

		try {
			programasInstitucionais = preencherSpinner.execute().get();

			if (programasInstitucionais != null) {
				findViews();
				setDatePickerDialog();
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
						MenuGestorActivity.class);
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
			edital.setInicioInscricoes(StringUtil
					.dateSQLFormat((editTextInicioInscricoes).getText()
							.toString()));
			edital.setFimInscricoes(StringUtil
					.dateSQLFormat((editTextFimInscricoes).getText().toString()));
			edital.setRelatorioParcial(StringUtil
					.dateSQLFormat((editTextPrazoRelatorioParcial).getText()
							.toString()));
			edital.setRelatorioFinal(StringUtil
					.dateSQLFormat((editTextPrazoRelatorioFinal).getText()
							.toString()));
			edital.setNumero(Integer.parseInt((editTextNumeroVagas).getText()
					.toString()));
			edital.setBolsaDocente(Double.parseDouble(Mascara
					.unmask((editTextBolsaOrientador).getText().toString())));
			edital.setBolsaDiscente(Double.parseDouble(Mascara
					.unmask((editTextBolsaDiscente).getText().toString())));
			edital.setProgramaInstitucional(itemSelectSpinner());
			edital.setTipoEdital((spinnerTipoEdital.getSelectedItem())
					.toString().charAt(0));
			edital.setGestor(servidor);

			ParserAsyncTask<Edital> parser = new ParserAsyncTask<Edital>(
					edital, this, Constantes.CADASTRAR_EDITAL);
			parser.execute();

			intent = new Intent(this, EditalActivity.class);
			params.putInt("Gestor", IdPessoa);
			intent.putExtras(params);
			startActivity(intent);
			finish();
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
		IdPessoa = params.getInt("Gestor");
		servidor = new Servidor();
		servidor.setPessoaId(params.getInt("Gestor"));

		// Prazo inscri��es.
		editTextInicioInscricoes = (EditText) findViewById(R.id.editTextInicioInscricoes);
		editTextInicioInscricoes.setInputType(InputType.TYPE_NULL);
		editTextFimInscricoes = (EditText) findViewById(R.id.editTextFimInscricoes);
		editTextInicioInscricoes.setInputType(InputType.TYPE_NULL);

		// Prazo relat�rio parcial e final
		editTextPrazoRelatorioParcial = (EditText) findViewById(R.id.editTextPrazoRelatorioParcial);
		editTextPrazoRelatorioParcial.setInputType(InputType.TYPE_NULL);
		editTextPrazoRelatorioFinal = (EditText) findViewById(R.id.editTextPrazoRelatorioFinal);
		editTextPrazoRelatorioFinal.setInputType(InputType.TYPE_NULL);

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

	private void setDatePickerDialog() {

		CadastrarEditalDataPickerOnClickListener listener = new CadastrarEditalDataPickerOnClickListener(
				this);
		editTextInicioInscricoes.setOnClickListener(listener);
		editTextFimInscricoes.setOnClickListener(listener);
		editTextPrazoRelatorioParcial.setOnClickListener(listener);
		editTextPrazoRelatorioFinal.setOnClickListener(listener);

		// Data de inicio
		DatePickerDialogAdapter inicioInscricoesDatePicker = new DatePickerDialogAdapter(
				this, editTextInicioInscricoes);
		inicioInscricoesPickerDialog = inicioInscricoesDatePicker.builder();

		// Data de fim
		DatePickerDialogAdapter fimInscricoesDatePicker = new DatePickerDialogAdapter(
				this, editTextFimInscricoes);
		fimInscricoesPickerDialog = fimInscricoesDatePicker.builder();

		// Prazo relat�rio parcial
		DatePickerDialogAdapter prazoRelatorioParcialDatePicker = new DatePickerDialogAdapter(
				this, editTextPrazoRelatorioParcial);
		prazoRelatorioParcialPickerDialog = prazoRelatorioParcialDatePicker
				.builder();

		// Prazo relat�rio final
		DatePickerDialogAdapter prazoRelatorioFinalDatePicker = new DatePickerDialogAdapter(
				this, editTextPrazoRelatorioFinal);
		prazoRelatorioFinalPickerDialog = prazoRelatorioFinalDatePicker
				.builder();
	}

	public EditText getEditTextInicioInscricoes() {
		return editTextInicioInscricoes;
	}

	public EditText getEditTextFimInscricoes() {
		return editTextFimInscricoes;
	}

	public DatePickerDialog getInicioInscricoesPickerDialog() {
		return inicioInscricoesPickerDialog;
	}

	public DatePickerDialog getFimInscricoesPickerDialog() {
		return fimInscricoesPickerDialog;
	}

	public EditText getEditTextPrazoRelatorioParcial() {
		return editTextPrazoRelatorioParcial;
	}

	public EditText getEditTextPrazoRelatorioFinal() {
		return editTextPrazoRelatorioFinal;
	}

	public DatePickerDialog getPrazoRelatorioParcialPickerDialog() {
		return prazoRelatorioParcialPickerDialog;
	}

	public DatePickerDialog getPrazoRelatorioFinalPickerDialog() {
		return prazoRelatorioFinalPickerDialog;
	}
}
