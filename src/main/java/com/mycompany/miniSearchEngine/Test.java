/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.miniSearchEngine;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author numan.kilincoglu
 */
public class Test {

    public static LinkedList<String> ignoreList = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        ignoreList.createIgnoreList();
        String sourceDirectory = "C:\\Users\\numan.kilincoglu\\Desktop\\MiniSearchEngine\\src\\main\\java\\com\\mycompany\\srcFiles\\files";
        File file = new File(sourceDirectory);
        doThings(file);
    }

    public static void doThings(File source) throws IOException {

        for (File listFile : source.listFiles()) {
            if (listFile.getName().endsWith(".html")) {
                BNTree<String> tree = new BNTree<>();
                tree.createTree(ignoreList, listFile);
                String fileName = listFile.getName().replace(".html", "result.txt");
                String path = "C:\\Users\\numan.kilincoglu\\Desktop\\MiniSearchEngine\\src\\main\\java\\com\\mycompany\\srcFiles\\results\\" + fileName;
                tree.deleteFiles(path);
                tree.preorderTree(path);
            }
        }
    }
}
