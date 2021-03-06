package edu.phoenix.mbl402.wk5teamapp;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.List;

public class ProductListAdapter extends ArrayAdapter<Product>{

    private boolean products;

    public ProductListAdapter(List<String> context, LayoutInflater resource, boolean objects) {
        super(resource, context, objects);
        products = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.layout_list, parent, false);
        }

        Product product = products.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(product.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(product.getPrice());
        TextView priceText = convertView.findViewById(R.id.priceText);
        priceText.setText(price);

        ImageView iv = convertView.findViewById(R.id.imageView);
        Bitmap bitmap = getBitmapFromAsset(product.getProductId());
        iv.setImageBitmap(bitmap);


        return convertView;
    }

    private Bitmap getBitmapFromAsset(String productId){
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;

        try{stream = assetManager.open(productId + ".png");
            return BitmapFactory.decodeStream(stream);

        }
        catch (IOException e){
            e.printStackTrace();
            return  null;

        }


    }
}
