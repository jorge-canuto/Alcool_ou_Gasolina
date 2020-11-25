package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textPrecoAlcool, textPrecoGasolina;
    private Button buttonCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPrecoAlcool = findViewById(R.id.textPrecoAlcool);
        textPrecoGasolina = findViewById(R.id.textPrecoGasolina);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcular(View view){

        // recuperar valores digitados
        String precoAlcool = textPrecoAlcool.getText().toString();
        String precoGasolina = textPrecoGasolina.getText().toString();

        // validar campos digitados
        boolean camposValidados = validaCampos(precoAlcool, precoGasolina);
        if(!camposValidados){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
        }else{
            // converter String para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            // cálculo utilizado para definir o melhor combustivel
            // se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            //     senão é melhor utilizar alcool

            if( (valorAlcool/valorGasolina) >= 0.7){
                textResultado.setText("Melhor utilizar gasolina");
            }else{
                textResultado.setText("Melhor utilizar álcool");
            }

        }

    }

    public boolean validaCampos(String precoAlcool, String precoGasolina){
        boolean validacao = true;
        if (precoAlcool.isEmpty() || precoGasolina.isEmpty()) {
            validacao = false;
        }
        return validacao;
    }




}
