package com.example.febrezemobileapp.ui.market;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.febrezemobileapp.R;
import com.example.febrezemobileapp.ui.shoppingCart.ShoppingCart;
import com.example.febrezemobileapp.ui.shoppingCart.ShoppingCartAdapter;
import com.example.febrezemobileapp.ui.shoppingCart.ShoppingCartViewModel;

import java.util.List;
import java.util.Objects;

public class MarketFragment extends Fragment {

    private MarketViewModel marketViewModel;
    private ShoppingCartViewModel shoppingCartViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_market, container, false);


        RecyclerView _rvMarket = (RecyclerView) root.findViewById(R.id.rvMarket);
        _rvMarket.setLayoutManager(new LinearLayoutManager(getContext()));
        _rvMarket.setHasFixedSize(true);

        final ProductAdapter adapter = new ProductAdapter();
        _rvMarket.setAdapter(adapter);

        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                ShoppingCart tempShoppingCart = new ShoppingCart(product.getProductName(),
                        product.getProductDescription(), product.getProductPrice(), product.getProductImage());
                shoppingCartViewModel = ViewModelProviders.of(getActivity()).get(ShoppingCartViewModel.class);
                shoppingCartViewModel.insert(tempShoppingCart);

                Toast.makeText(getContext(), "Ürün sepenitize eklenmiştir.", Toast.LENGTH_SHORT).show();
            }
        });


        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
        marketViewModel.getAllProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setProduct(products);
            }
        });


        return root;
    }

}