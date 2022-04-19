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
public class LinkedListNode<T extends Comparable<T>> {

    T data;
    LinkedListNode<T> nextNode;

    LinkedListNode(T data) {
        this.data = data;
        this.nextNode = null;
    }

}
