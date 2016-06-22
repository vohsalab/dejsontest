package com.balashov.ivan.dejsontest.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.balashov.ivan.dejsontest.API.CallbackInterface;
import com.balashov.ivan.dejsontest.API.NetworkFactory;
import com.balashov.ivan.dejsontest.Adapter.BookAdapter;
import com.balashov.ivan.dejsontest.Model.Book;
import com.balashov.ivan.dejsontest.R;

public class MainActivity extends AppCompatActivity implements CallbackInterface {

    private BookAdapter mBookAdapter;
    private TextView mEmptytextView;
    private RecyclerView mBooksRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmptytextView = (TextView) findViewById(R.id.empty_view);
        mBooksRecyclerView = (RecyclerView) findViewById(R.id.books_view);
        mBooksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        NetworkFactory.get().getBooks(this);
    }

    @Override
    public void processBooksResponse(Book[] books) {
        if (books.length == 0) {
            mEmptytextView.setVisibility(View.VISIBLE);
            mBooksRecyclerView.setVisibility(View.GONE);

        }
        else {
            mEmptytextView.setVisibility(View.GONE);
            mBooksRecyclerView.setVisibility(View.VISIBLE);
            if (mBookAdapter == null) {
                mBookAdapter = new BookAdapter(books);
                mBooksRecyclerView.setAdapter(mBookAdapter);
            } else {
                mBookAdapter.setBooks(books);
                mBookAdapter.notifyDataSetChanged();
            }
        }

    }
}
