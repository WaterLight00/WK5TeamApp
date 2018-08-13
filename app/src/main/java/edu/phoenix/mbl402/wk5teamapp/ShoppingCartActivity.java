package edu.phoenix.mbl402.wk5teamapp;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ShoppingCartActivity extends Activity {

    private List<String> mCartList;
    private ProductListAdapter mProductListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);


        mCartList = DataProvider.getProductNames();


        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }


        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductListAdapter = new ProductListAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductListAdapter);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(),DetailActivity.class);
                productDetailsIntent.putExtra(String.valueOf(DataProvider.productList), position);
                startActivity(productDetailsIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


        if(mProductListAdapter != null) {
            mProductListAdapter.notifyDataSetChanged();
        }
    }

}



