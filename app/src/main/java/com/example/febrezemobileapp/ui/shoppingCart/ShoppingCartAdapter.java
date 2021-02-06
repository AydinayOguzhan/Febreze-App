package com.example.febrezemobileapp.ui.shoppingCart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.febrezemobileapp.R;
import com.example.febrezemobileapp.ui.market.Product;
import com.example.febrezemobileapp.ui.market.ProductAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder> {

    private List<ShoppingCart> shoppingCartList = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public ShoppingCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_item, parent, false);

        return new ShoppingCartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ShoppingCartViewHolder holder, int position) {
        ShoppingCart currentScProduct = shoppingCartList.get(position);
        holder.tvScProductName.setText(currentScProduct.getProductName());
        holder.tvScProductDescription.setText(currentScProduct.getProductDescription());
        holder.tvScProductPrice.setText(String.valueOf(currentScProduct.getProductPrice()));
        Picasso.get().load(currentScProduct.getProductImage()).into(holder.imScProductImage);
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    public void setShoppingCartList(List<ShoppingCart> shoppingCart){
        this.shoppingCartList = shoppingCart;
        notifyDataSetChanged();
    }

    class ShoppingCartViewHolder extends RecyclerView.ViewHolder{
        private TextView tvScProductName;
        private TextView tvScProductDescription;
        private TextView tvScProductPrice;
        private ImageView imScProductImage;
        private Button btnScDiscard;


        public ShoppingCartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvScProductName = itemView.findViewById(R.id.tvScProductName);
            tvScProductDescription = itemView.findViewById(R.id.tvScProductDescription);
            tvScProductPrice = itemView.findViewById(R.id.tvScProductPrice);
            imScProductImage = itemView.findViewById(R.id.imScProductImage);
            btnScDiscard = itemView.findViewById(R.id.btnScDiscard);

            btnScDiscard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(shoppingCartList.get(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(ShoppingCart shoppingCart);
    }

    public void ClickListener(ShoppingCartAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public ShoppingCart GetShoppingCartItem(int position){
        return shoppingCartList.get(position);
    }
}
