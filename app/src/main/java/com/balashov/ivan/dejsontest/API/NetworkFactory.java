package com.balashov.ivan.dejsontest.API;

import com.balashov.ivan.dejsontest.Model.Book;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkFactory {
    private static NetworkFactory sNetworkFactory;
    private static final String AWS_BASE_URL = "http://de-coding-test.s3.amazonaws.com/";

    public static NetworkFactory get() {
        if (sNetworkFactory == null) {
            sNetworkFactory = new NetworkFactory();
            return sNetworkFactory;
        }
        else return sNetworkFactory;
    }

    public void getBooks(final CallbackInterface callback) {
        OkHttpClient okClient = new OkHttpClient
                .Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        }).build();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(AWS_BASE_URL)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookApiInterface service = client.create(BookApiInterface.class);
        Call<Book[]> call = service.getBooks();
        call.enqueue(new Callback<Book[]>() {
            @Override
            public void onResponse(Call<Book[]> call, retrofit2.Response<Book[]> response) {
                Book[] booksList = response.body();
                callback.processBooksResponse(booksList);
            }

            @Override
            public void onFailure(Call<Book[]> call, Throwable t) {
                Book[] booksList = new Book[0];
                callback.processBooksResponse(booksList);
            }
        });

    }
}
