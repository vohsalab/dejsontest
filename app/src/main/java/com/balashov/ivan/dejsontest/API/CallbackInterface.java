package com.balashov.ivan.dejsontest.API;

import com.balashov.ivan.dejsontest.Model.Book;

/**
 * Created by Ivan on 6/21/2016.
 */

public interface CallbackInterface {
    public void processBooksResponse(Book[] books);
}
