package com.softworldtechnologies.applistacurso.controller;

import android.content.SharedPreferences;

import com.softworldtechnologies.applistacurso.model.Pessoa;
import com.softworldtechnologies.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences ( NOME_PREFERENCES, 0 );
        listaVip = preferences.edit ( );
    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString ( "primeiroNome", pessoa.getPrimeiroNome ( ) );
        listaVip.putString ( "sobreNome", pessoa.getSobreNome ( ) );
        listaVip.putString ( "nomeCurso", pessoa.getCursoDesejado ( ) );
        listaVip.putString ( "telefoneContato", pessoa.getTelefoneContato ( ) );
        listaVip.apply ( );
    }

    public void buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome ( preferences.getString ( "primeiroNome", "" ) );
        pessoa.setSobreNome ( preferences.getString ( "sobreNome", "" ) );
        pessoa.setCursoDesejado ( preferences.getString ( "nomeCurso", "" ) );
        pessoa.setTelefoneContato ( preferences.getString ( "telefoneContato", "" ) );
    }

    public void limpar() {
        listaVip.clear ( );
        listaVip.apply ( );
    }
}
