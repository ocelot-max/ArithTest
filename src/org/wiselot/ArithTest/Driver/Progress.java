package org.wiselot.ArithTest.Driver;

public interface Progress {
    void make(Driver driver);
    void display(Driver driver);
    void check(Driver driver,String ... inputs) throws Exception;
    void redisplay(Driver driver);
}
