/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author numan.kilincoglu
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> {

    LinkedListNode<T> head;

    public LinkedList() {
        head = null;
    }

    LinkedList(T data) {
        head = new LinkedListNode(data);
    }

    void addFirst(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }

    }

    void print() {
        LinkedListNode<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.nextNode;
        }
        System.out.println("Null");
    }

    int size() {
        LinkedListNode<T> temp = head;
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.nextNode;
        }
        return counter;
    }

    public void createIgnoreList() {
        //Ignore file path comes here
        File file = new File("C:\\Users\\numan.kilincoglu\\Documents\\NetBeansProjects\\NumanKilincolguProject2\\src\\main\\java\\com\\mycompany\\numankilincolguproject2\\files\\ignoreList.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String word = "";

            try {
                while ((word = br.readLine()) != null) {
                    this.addFirst((T) word.toLowerCase());
                }
                br.close();

            } catch (IOException ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean search(T key) {

        LinkedListNode<T> current = head;
        while (current != null) {
            if (current.data.compareTo(key) == 0) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

}
