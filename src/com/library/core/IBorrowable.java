package com.library.core;

public interface IBorrowable {
    void updateStatus(boolean isAvailable);
    boolean isAvailable();
}