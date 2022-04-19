/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniSearchEngine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.AEADBadTagException;

/**
 *
 * @author numan.kilincoglu
 * @param <T>
 */
public class BNTree<T extends Comparable<T>> {

    private BTNode<T> root;

    private void insert(T data) {
        if (root == null) {
            root = new BTNode(data);
        } else {
            BTNode<T> temp = root;
            while (temp != null) {
                if (data.compareTo(temp.data) > 0) {
                    if (temp.right == null) {
                        temp.right = new BTNode(data);
                        return;
                    }
                    temp = temp.right;

                } else if (data.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = new BTNode(data);
                        return;
                    }
                    temp = temp.left;
                } else {
                    temp.count = temp.count + 1;
                    return;
                }
            }
        }
    }

    private void preorder() {
        System.out.println("Preorder:");
        preorder(root);
        System.out.println();
    }

    private void preorder(BTNode<T> temp) {
        if (temp != null) {
            System.out.println(temp.data + " " + temp.count);
            preorder(temp.left);
            preorder(temp.right);
        }

    }

    void preorderTree(String path) throws IOException {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(path, true))) {
            writeFilePreOrder(path, root, bf);
        }
    }

    private void writeFilePreOrder(String path, BTNode<T> tempNode, BufferedWriter bf) throws IOException {

        String word = "";
        if (tempNode != null) {
            word += tempNode.data + ", " + tempNode.count + "\n";
            bf.write((String) word);
            writeFilePreOrder(path, tempNode.left, bf);
            writeFilePreOrder(path, tempNode.right, bf);
        }
    }

    void createTree(LinkedList<T> ignoreList, File file) throws IOException {

        Scanner inputWord;
        try {
            inputWord = new Scanner(file);
            String word = "";

            while (inputWord.hasNext()) {
                word = inputWord.next();
                String tempWord = "";
                if (!word.startsWith("<") && !ignoreList.search((T) word.toLowerCase())) {
                    if (!".".equals(word) && !",".equals(word)) {
                        if (word.contains(".")) {
                            tempWord = word.replace(".", "");
                            this.insert((T) tempWord);
                        } else if (word.contains(",")) {
                            tempWord = word.replace(",", "");
                            this.insert((T) tempWord);
                        } else {
                            this.insert((T) word);
                        }

                    }

                }
            }
            inputWord.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BNTree.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void deleteFiles(String path) {
        File fileDeleted = new File(path);
        if (fileDeleted.exists()) {
            fileDeleted.delete();
        }
    }

}
