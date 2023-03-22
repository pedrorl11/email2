package soares.pedro.email2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //seleciono o botão da interface main
        Button btnEnviar =findViewById(R.id.btnEnviar);
        //crio o evento de clique
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            //o que acontece ao clicar no botao
            public void onClick(View v) {

                //seleciono a caixa de texto
                EditText etEmail = findViewById(R.id.etEmail);
                EditText etAssunto = findViewById(R.id.etAssunto);
                EditText etTexto = findViewById(R.id.etTexto);

                //armazeno o texto dentro da caixa de texto
                String email = etEmail.getText().toString();
                String assunto = etAssunto.getText().toString();
                String texto = etTexto.getText().toString();


                //passa pra próxima interface
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));

                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                try{
                    startActivity(Intent.createChooser(i, "Escolha o APP"));
                }
                catch(ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}