package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.File;

public class MakeDirectories {
    private static void usage() {
        System.err.println(
                "Usage:MakeDirectories path1 ... \n" +
                        "Creates each path\n" +
                        "Usage:MakeDirectories -r path path2\n" +
                        "Deletes each path\n" +
                        "Usage: MakeDirectories -r path1 path2\n" +
                        "Renames from path1 to path2"
        );
        System.exit(1);
    }

    private static void fileData(File file) {
        System.out.println(
                file.getAbsolutePath() + "\n" +
                        file.canRead() + "\n" +
                        file.canWrite() + "\n" +
                        file.getParent() + "\n" +
                        file.getPath() + "\n" +
                        file.length() + "\n" +
                        file.lastModified()
        );

        if (file.isDirectory()) {
            System.out.println("It's a directory");
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
        }
        if (args[0].equals(".r")) {
            File old = new File(args[1]);
            File rename = new File(args[2]);
            old.renameTo(rename);
            fileData(old);
            fileData(rename);
        }
    }
}
