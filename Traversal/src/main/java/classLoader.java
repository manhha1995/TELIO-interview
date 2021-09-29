package main.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class classLoader extends ClassLoader {

    private static int key;

    /**
     * Consruct a crypto class
     * 
     * @param k the decryption key
     */

    public classLoader(int k) {
        key = k;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String filename) {
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(filename.replace(".", File.separatorChar + ".class"));
        byte[] buffer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ((nextValue = inputStream.read()) != -1) {
                byteArrayOutputStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteArrayOutputStream.toByteArray();
        return buffer;
    }

    /**
     * Load and decrypt the class byte code
     * 
     * @param name ths class name
     * @return an array with class file bytes
     * @throws IOException
     */
    private static byte[] loadClassbytes(String name) throws IOException {
        String className = name.replace(".", "/") + ".class";
        byte[] bytes = Files.readAllBytes(Paths.get(className));
        for (int i = 0; i < bytes.length; i++)
            bytes[i] = (byte) (bytes[i] - key);
        return bytes;
    }

    public static void main(String[] args) throws IOException{
        
        byte[] b = loadClassbytes("Duck.java");
        System.out.println(b);
    }
}
