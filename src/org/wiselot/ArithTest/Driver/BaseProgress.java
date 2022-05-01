package org.wiselot.ArithTest.Driver;

import org.jetbrains.annotations.NotNull;

public class BaseProgress implements Progress{
    @Override
    public void make(@NotNull Driver driver) {
        driver.message("Test Progress::make");
    }

    @Override
    public void display(@NotNull Driver driver) {
        driver.message("Test Progress::display");
    }

    @Override
    public void check(Driver driver, String... inputs) throws Exception {
        for(String s : inputs){
            driver.message("User Input: "+s);
        }
    }
    @Override
    public void redisplay(@NotNull Driver driver) {
        driver.message("Test Progress::redisplay");
    }
}
