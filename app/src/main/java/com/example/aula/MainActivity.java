package com.example.aula;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextData, editTextMotivo;
    private RadioGroup radioGroupTipo;
    private Button buttonAgendar;

    private void addDateMask(EditText editTextData){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referência ao campo de data
        editTextData = findViewById(R.id.editTextData);

        // Adicionar máscara de data
        addDateMask(editTextData);


        // Componentes da interface
        editTextNome = findViewById(R.id.editTextNome);
        editTextData = findViewById(R.id.editTextData);
        editTextMotivo = findViewById(R.id.editTextMotivo);
        radioGroupTipo = findViewById(R.id.radioGroupTipo);
        buttonAgendar = findViewById(R.id.buttonAgendar);

        // Configura do botão
        buttonAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agendarConsulta();
            }
        });
    }

    private void agendarConsulta() {
        String nome = editTextNome.getText().toString();
        String data = editTextData.getText().toString();
        String motivo = editTextMotivo.getText().toString();

        int selectedTipoId = radioGroupTipo.getCheckedRadioButtonId();
        RadioButton radioButtonTipo = findViewById(selectedTipoId);
        String tipoConsulta = radioButtonTipo.getText().toString();

        if (nome.isEmpty() || data.isEmpty() || motivo.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
        } else {
            String mensagem = "Consulta " + tipoConsulta + " agendada para " + nome + " em " + data + ". Motivo: " + motivo;
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        }
    }
}
