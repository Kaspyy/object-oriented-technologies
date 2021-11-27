package com.company;
public interface IShippableTask<E> {
    E execute() throws Exception;
}