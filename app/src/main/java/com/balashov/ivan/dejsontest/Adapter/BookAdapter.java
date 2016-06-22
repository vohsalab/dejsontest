package com.balashov.ivan.dejsontest.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.balashov.ivan.dejsontest.Model.Book;
import com.balashov.ivan.dejsontest.R;

public class BookAdapter extends RecyclerView.Adapter<BookHolder> {
    private Book[] mBooks;

    public BookAdapter(Book[] booksList) {
        mBooks = booksList;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.books_view_item, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Book currentBook = mBooks[position];
        holder.bindBook(currentBook);
    }

    @Override
    public int getItemCount() {
        return mBooks.length;
    }

    public void setBooks(Book[] mBooks) {
        this.mBooks = mBooks;
    }
}
