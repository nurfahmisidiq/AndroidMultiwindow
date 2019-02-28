package id.sch.smktelkom_mlg.www.multiwindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit, btnHapus;
    EditText editNama, editTahun, editAlamat, editTelepon, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnHapus = findViewById(R.id.btnHapus);
        editNama = findViewById(R.id.editNama);
        editTahun = findViewById(R.id.editTahun);
        editAlamat = findViewById(R.id.editAlamat);
        editTelepon = findViewById(R.id.editTelepon);
        editEmail = findViewById(R.id.editEmail);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editNama.setText("");
                editTahun.setText("");
                editAlamat.setText("");
                editTelepon.setText("");
                editEmail.setText("");
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nama = editNama.getText().toString();
                Integer tahun = Integer.parseInt(editTahun.getText().toString());
                String alamat = editAlamat.getText().toString();
                Integer telepon = Integer.parseInt(editTelepon.getText().toString());
                String email = editEmail.getText().toString();
                if (TextUtils.isEmpty(nama)) {
                    editNama.setError("Nama diperlukan!");
                } else if (tahun.equals("")) {
                    editTahun.setError("Tahun diperlukan!");
                    return;
                } else if (TextUtils.isEmpty(alamat)) {
                    editAlamat.setError("Alamat diperlukan!");
                    return;
                } else if (telepon.equals("")) {
                    editTelepon.setError("Nomor telepon diperlukan!");
                    return;
                } else if (TextUtils.isEmpty(email)) {
                    editEmail.setError("Email diperlukan!");
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "Penyimpanan data berhasil",
                            Toast.LENGTH_SHORT).show();
                }
                Intent i = null;
                i = new Intent(MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();
                b.putString("parse_nama", nama);
                b.putInt("parse_tahun", tahun);
                b.putString("parse_alamat", alamat);
                b.putInt("parse_telepon", telepon);
                b.putString("parse_email", email);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
