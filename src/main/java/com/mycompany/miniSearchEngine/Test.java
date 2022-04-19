
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
        String sourceDirectory = "Source File Directory";
        File file = new File(sourceDirectory);
        doThings(file);
    }

    public static void doThings(File source) throws IOException {

        for (File listFile : source.listFiles()) {
            if (listFile.getName().endsWith(".html")) {
                BNTree<String> tree = new BNTree<>();
                tree.createTree(ignoreList, listFile);
                String fileName = listFile.getName().replace(".html", "result.txt");
                String path = "Output File Directory;
                tree.deleteFiles(path);
                tree.preorderTree(path);
            }
        }
    }
}
