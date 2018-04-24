package com.example.jv_an.filmes;

import android.R.*;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.jv_an.filmes.R;

public class MainActivity extends Activity {

    Connection c = new Connection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buscar(View view) throws Exception {


        EditText text = (EditText)findViewById(R.id.Filme);
        String name = text.getText().toString();
        if(TextUtils.isEmpty(name.toString())) {
            text.setError("Digite um filme");
            return;
        }


        EditText text2 = (EditText)findViewById(R.id.Diretor);
        String diretor = text2.getText().toString();
        if(TextUtils.isEmpty(diretor.toString())) {
            text.setError("Digite um diretor");
            return;
        }


        final TextView resultArea = (TextView) findViewById(R.id.result);


        Filme filmes = c.sendGetFilme(name, diretor);



        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------"+"\n");
        sb.append("|    Nome: " + filmes.getName() +"\n");
        sb.append("|    Diretor: " + filmes.getDiretor() +"\n");
        sb.append("|    Lançamento: " + filmes.getLancamento() + "\n");
        sb.append("|    Gênero: " + filmes.getGenero() +"\n");
        sb.append("|    Distribuidora: " + filmes.getDistribuicao() +"\n");

        resultArea.setText(sb);
    }
}
