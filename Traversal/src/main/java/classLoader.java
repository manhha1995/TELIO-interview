package main.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class classLoader extends ClassLoader{
    
    @Override
    public Class findClass(String name) throws ClassNotFoundException{
        byte[] b  = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String filename) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
            filename.replace('.', File.separatorChar + ".class")
        );
        byte[] buffer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try
        {
            while((nextValue = inputStream.read()) != -1) {
                byteArrayOutputStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteArrayOutputStream.toByteArray();
        return buffer;
    }
}
