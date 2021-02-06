package com.example.febrezemobileapp.ui.apply;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.example.febrezemobileapp.MainActivity;
import com.example.febrezemobileapp.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;
import java.lang.Object;

public class ApplyFragment extends Fragment {

    Button _btnApplyApply;
    EditText _etFirstName, _etLastName, _etGmail, _etContact, _etIl, _etIlce, _etAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_apply, container, false);

        _etFirstName = (EditText) root.findViewById(R.id.etFirstName);
        _etLastName = (EditText) root.findViewById(R.id.etLastName);
        _etGmail = (EditText) root.findViewById(R.id.etGmail);
        _etContact = (EditText) root.findViewById(R.id.etContact);
        _etIl = (EditText) root.findViewById(R.id.etIl);
        _etIlce = (EditText) root.findViewById(R.id.etIlce);
        _etAddress = (EditText) root.findViewById(R.id.etAddress);

        _btnApplyApply = (Button) root.findViewById(R.id.btnApplyApply);
        _btnApplyApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = _etFirstName.getText().toString();
                String lastName = _etLastName.getText().toString();
                String gmail = _etGmail.getText().toString();
                String contact = _etContact.getText().toString();
                String il = _etIl.getText().toString();
                String ilce = _etIlce.getText().toString();
                String address = _etAddress.getText().toString();

                if (firstName.isEmpty() || firstName.startsWith(" ") || firstName.endsWith(" ") ||
                        lastName.isEmpty() || lastName.startsWith(" ") || lastName.endsWith(" ") ||
                        gmail.isEmpty() || gmail.startsWith(" ") || gmail.endsWith(" ") ||
                        contact.isEmpty() || contact.startsWith(" ") || contact.endsWith(" ") ||
                        il.isEmpty() || il.startsWith(" ") || il.endsWith(" ")||
                        ilce.isEmpty() || ilce.startsWith(" ") || ilce.endsWith(" ") ||
                        address.isEmpty() || address.startsWith(" ")|| address.endsWith(" ") ){

                    Toast.makeText(getContext(), "Geçersiz veri girdiniz lütfen tekrar deneyiniz.", Toast.LENGTH_SHORT).show();
                }else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Onay");
                    builder.setMessage("Başvurunuzu tamamlamak istediğinizden emin misiniz?");


                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            _etFirstName.getText().clear();
                            _etLastName.getText().clear();
                            _etGmail.getText().clear();
                            _etContact.getText().clear();
                            _etIl.getText().clear();
                            _etIlce.getText().clear();
                            _etAddress.getText().clear();
                            Toast.makeText(getContext(), "Başvurunuz tamamlanmıştır. Başvurunuz için teşekkürler.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(getContext(), "İptal edilmiştir.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        return root;
    }
}
