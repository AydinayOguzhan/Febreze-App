package com.example.febrezemobileapp.ui.qrCodeReader;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.febrezemobileapp.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QrCodeReaderFragment extends Fragment {

    Button _btnQr;
    TextView _tvResult, _tvQrCodeResult,_tvQrKind,_tvQrKindResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_qr_code_reader,container, false);

        _btnQr = (Button) root.findViewById(R.id.btnQr);
        _tvResult = (TextView) root.findViewById(R.id.tvQrResult);
        _tvQrCodeResult = (TextView) root.findViewById(R.id.tvQrCodeResult);
        _tvQrKind = (TextView) root.findViewById(R.id.tvQrKind);
        _tvQrKindResult = (TextView) root.findViewById(R.id.tvQrKindResult);

        _btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(getActivity());

                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Tara");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });


        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Kütüphane okuduktan sonra bu metodla bize result döndürüyor.
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                _tvQrCodeResult.setText("Kod Sonucu:");
                _tvResult.setText("Qr Code Bulunamadı.");
                _tvQrKind.setText("Kod Türü:");
                _tvQrKindResult.setText("Bulunamadı.");
            } else {
                _tvQrCodeResult.setText("Kod Sonucu:");
                _tvResult.setText(result.getContents());
                _tvQrKind.setText("Kod Türü:");
                _tvQrKindResult.setText(result.getFormatName());
            }
        }
    }
}
