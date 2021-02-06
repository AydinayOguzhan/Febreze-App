package com.example.febrezemobileapp.ui.purchase_information;

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
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.example.febrezemobileapp.R;
import com.example.febrezemobileapp.ui.shoppingCart.ShoppingCartFragment;
import com.example.febrezemobileapp.ui.shoppingCart.ShoppingCartViewModel;

public class PurchaseInformationFragment extends Fragment {


    private ShoppingCartViewModel shoppingCartViewModel;
    Button _btnpiApply;
    EditText _etpiFirstName, _etpiLastName, _etpiGmail, _etpiContact, _etpiIl, _etpiIlce, _etpiAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_purchase_information,container,false);

        _btnpiApply = (Button)root.findViewById(R.id.btnpiApply);
        _etpiFirstName = (EditText)root.findViewById(R.id.etpiFirstName);
        _etpiLastName = (EditText)root.findViewById(R.id.etpiLastName);
        _etpiGmail = (EditText)root.findViewById(R.id.etpiGmail);
        _etpiContact = (EditText)root.findViewById(R.id.etpiContact);
        _etpiIl = (EditText)root.findViewById(R.id.etpiIl);
        _etpiIlce = (EditText)root.findViewById(R.id.etpiIlce);
        _etpiAddress = (EditText)root.findViewById(R.id.etpiAddress);


        _btnpiApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = _etpiFirstName.getText().toString();
                String lastName = _etpiLastName.getText().toString();
                String gmail = _etpiGmail.getText().toString();
                String contact = _etpiContact.getText().toString();
                String il = _etpiIl.getText().toString();
                String ilce = _etpiIlce.getText().toString();
                String address = _etpiAddress.getText().toString();

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
                    builder.setMessage("Satın alma işlemini onaylamak istediğinize emin misiniz?");


                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            _etpiFirstName.getText().clear();
                            _etpiLastName.getText().clear();
                            _etpiGmail.getText().clear();
                            _etpiContact.getText().clear();
                            _etpiIl.getText().clear();
                            _etpiIlce.getText().clear();
                            _etpiAddress.getText().clear();
                            shoppingCartViewModel = ViewModelProviders.of(getActivity()).get(ShoppingCartViewModel.class);
                            shoppingCartViewModel.deleteAllShoppingCart();

                            FragmentManager manager = getFragmentManager();
                            manager.beginTransaction().replace(((ViewGroup)getView().getParent()).getId(),ShoppingCartFragment.class, null)
                                    .setReorderingAllowed(true).commit();

                            Toast.makeText(getContext(), "İşlem gerçekleşmiştir. Satın alımınız işin teşekkürler.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(getContext(), "İşlem iptal edilmiştir.", Toast.LENGTH_SHORT).show();
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
