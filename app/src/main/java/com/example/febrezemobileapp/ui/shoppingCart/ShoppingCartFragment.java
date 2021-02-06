package com.example.febrezemobileapp.ui.shoppingCart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.febrezemobileapp.R;
import com.example.febrezemobileapp.ui.apply.ApplyFragment;
import com.example.febrezemobileapp.ui.market.MarketViewModel;
import com.example.febrezemobileapp.ui.market.Product;
import com.example.febrezemobileapp.ui.market.ProductAdapter;
import com.example.febrezemobileapp.ui.purchase_information.PurchaseInformationFragment;

import java.util.List;

public class ShoppingCartFragment extends Fragment {

    private ShoppingCartViewModel shoppingCartViewModel;
    Button _btnBuyAll;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        PurchaseInformationFragment fragment = new PurchaseInformationFragment();

        final RecyclerView _rvShoppingCart = (RecyclerView) root.findViewById(R.id.rvShoppingCart);
        _rvShoppingCart.setLayoutManager(new LinearLayoutManager(getContext()));
        _rvShoppingCart.setHasFixedSize(true);

        final ShoppingCartAdapter adapter = new ShoppingCartAdapter();
        _rvShoppingCart.setAdapter(adapter);

        adapter.ClickListener(new ShoppingCartAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ShoppingCart shoppingCart) {
                shoppingCartViewModel.delete(shoppingCart);
                Toast.makeText(getContext(), "Ürün sepetinizden kaldırılmıştır.", Toast.LENGTH_SHORT).show();
            }
        });

//        if (fragment.isPurchaseCompleted()){
//            Toast.makeText(getContext(), "Satın alım başarılı", Toast.LENGTH_SHORT).show();
//        }

        shoppingCartViewModel = ViewModelProviders.of(this).get(ShoppingCartViewModel.class);
        shoppingCartViewModel.getAllShoppingCart().observe(getViewLifecycleOwner(), new Observer<List<ShoppingCart>>() {
            @Override
            public void onChanged(List<ShoppingCart> shoppingCart) {
                adapter.setShoppingCartList(shoppingCart);
            }
        });


        _btnBuyAll = (Button)root.findViewById(R.id.btnBuyAll);
        _btnBuyAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adapter.getItemCount() <= 0) {
                    Toast.makeText(getContext(), "Sepetinizde hiç ürün bulunamadı.", Toast.LENGTH_SHORT).show();
                }else {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(((ViewGroup) getView().getParent()).getId(), PurchaseInformationFragment.class,
                            null).setReorderingAllowed(true).commit();
                }
            }
        });


        return root;
    }


}