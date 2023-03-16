package com.softworldtechnologies.applistacurso.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.softworldtechnologies.applistacurso.R;
import com.softworldtechnologies.applistacurso.controller.CursoController;
import com.softworldtechnologies.applistacurso.controller.PessoaController;
import com.softworldtechnologies.applistacurso.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;
    List<String> nomesDosCursos;

    EditText edit_primeiro_nome;
    EditText edit_sobrenome;
    EditText edit_nome_curso;
    EditText edit_telefone;

    Button button_limpar;
    Button button_salvar;
    Button button_finalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        controller = new PessoaController ( MainActivity.this );

        cursoController = new CursoController ( );
        nomesDosCursos = cursoController.dadosParaSpinner ( );

        pessoa = new Pessoa ( );
        controller.buscar ( pessoa );

        edit_primeiro_nome = findViewById ( R.id.edit_primeiro_nome );
        edit_sobrenome = findViewById ( R.id.edit_sobrenome );
        edit_nome_curso = findViewById ( R.id.edit_nome_curso );
        edit_telefone = findViewById ( R.id.edit_telefone );

        edit_primeiro_nome.setText ( pessoa.getPrimeiroNome ( ) );
        edit_sobrenome.setText ( pessoa.getSobreNome ( ) );
        edit_nome_curso.setText ( pessoa.getCursoDesejado ( ) );
        edit_telefone.setText ( pessoa.getTelefoneContato ( ) );

        button_limpar = findViewById ( R.id.button_limpar );
        button_salvar = findViewById ( R.id.button_salvar );
        button_finalizar = findViewById ( R.id.button_finalizar );

        spinner = findViewById ( R.id.spinner );

        ArrayAdapter<String> adapter = new ArrayAdapter<> ( this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner ( ) );
        adapter.setDropDownViewResource ( android.R.layout.simple_list_item_1 );
        spinner.setAdapter ( adapter );

        button_limpar.setOnClickListener ( v -> {
            edit_primeiro_nome.setText ( "" );
            edit_sobrenome.setText ( "" );
            edit_nome_curso.setText ( "" );
            edit_telefone.setText ( "" );

            controller.limpar ( );
        } );

        button_salvar.setOnClickListener ( v -> {
            pessoa.setPrimeiroNome ( edit_primeiro_nome.getText ( ).toString ( ) );
            pessoa.setSobreNome ( edit_sobrenome.getText ( ).toString ( ) );
            pessoa.setCursoDesejado ( edit_nome_curso.getText ( ).toString ( ) );
            pessoa.setTelefoneContato ( edit_telefone.getText ( ).toString ( ) );

            controller.salvar ( pessoa );
        } );

        button_finalizar.setOnClickListener ( v -> finishAffinity ( ) );

    }
}