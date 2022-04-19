/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniSearchEngine;

/**
 *
 * @author numan.kilincoglu
 * @param <T>
 */
public class BTNode<T extends Comparable<T>> {

    T data;
    int count;
    BTNode<T> right, left;

    public BTNode(T data) {
        this.data = data;
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
