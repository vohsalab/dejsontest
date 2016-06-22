package com.balashov.ivan.dejsontest.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.balashov.ivan.dejsontest.Model.Book;
import com.balashov.ivan.dejsontest.R;
import com.bumptech.glide.Glide;

public class BookHolder extends RecyclerView.ViewHolder {
    private ImageView posterImageView;
    private TextView titleTextView;
    private TextView authorTextView;

    public BookHolder(View itemView) {
        super(itemView);
        posterImageView = (ImageView) itemView.findViewById(R.id.image_poster);
        authorTextView = (TextView) itemView.findViewById(R.id.book_author);
        titleTextView = (TextView) itemView.findViewById(R.id.book_title);
    }

    public void bindBook(Book book) {
        if(book.getTitle() != null && !book.getTitle().isEmpty()) {
            titleTextView.setText(book.getTitle());
        }

        if (book.getAuthor() != null && !book.getAuthor().isEmpty()) {
            authorTextView.setText(authorTextView.getContext().getResources().getString(R.string.author) + ": " + book.getAuthor());
        }

        if (book.getImageURL() != null && !book.getImageURL().isEmpty()) {
            Glide.with(posterImageView.getContext())
                    .load(book.getImageURL())
                    .into(posterImageView);
        }
    }
}
