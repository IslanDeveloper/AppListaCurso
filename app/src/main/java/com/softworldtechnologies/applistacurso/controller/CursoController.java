package com.softworldtechnologies.applistacurso.controller;

import com.softworldtechnologies.applistacurso.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listCursos;

    public List getListaDeCurso() {
        listCursos = new ArrayList<Curso> ( );

        listCursos.add ( new Curso ( "Java" ) );
        listCursos.add ( new Curso ( "HTML" ) );
        listCursos.add ( new Curso ( "C#" ) );
        listCursos.add ( new Curso ( "Python" ) );
        listCursos.add ( new Curso ( "PHP" ) );
        listCursos.add ( new Curso ( "Kotlin" ) );
        listCursos.add ( new Curso ( "Flutter" ) );
        listCursos.add ( new Curso ( "Dart" ) );

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner() {
        ArrayList<String> dados = new ArrayList<> ( );

        for (int i = 0; i < getListaDeCurso ( ).size ( ); i++) {
            Curso objeto = (Curso) getListaDeCurso ( ).get ( i );
            dados.add ( objeto.getNomeDoCursoDesejado ( ) );
        }
        return dados;
    }
}
