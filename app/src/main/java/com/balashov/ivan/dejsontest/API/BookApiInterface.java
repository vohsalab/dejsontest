package com.balashov.ivan.dejsontest.API;

import com.balashov.ivan.dejsontest.Model.Book;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookApiInterface {

    @GET("books.json")
    Call<Book[]> getBooks();
}
