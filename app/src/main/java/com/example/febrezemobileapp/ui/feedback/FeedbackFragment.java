package com.example.febrezemobileapp.ui.feedback;

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
import com.example.febrezemobileapp.R;

public class FeedbackFragment extends Fragment {

    Button _btnSend;
    EditText _etFeedback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feedback,container,false);

        _etFeedback = (EditText) root.findViewById(R.id.etFeedback);

        _btnSend = (Button) root.findViewById(R.id.btnSend);
        _btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = _etFeedback.getText().toString();
                if (text.isEmpty() || text.startsWith(" ") || text.endsWith(" ") ){
                    Toast.makeText(getContext(), "Hatalı giriş yaptınız lütfen tekrar deneyiniz.", Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Onay");
                    builder.setMessage("Göndermek istediğinize emin misiniz?");


                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            _etFeedback.getText().clear();
                            Toast.makeText(getContext(), "Gönderme işlemi tamamlanmıştır.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(getContext(), "Gönderme işlemi iptal edilmiştir.", Toast.LENGTH_SHORT).show();
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
