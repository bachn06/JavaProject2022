/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWrite;

import DoiTuong.DocGia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell 7559
 */
public class DocGiaFile {
    private static final String DOCGIA_FILE_NAME = "docgia.txt";

    //Ghi file
    @SuppressWarnings("unchecked")
    public void write(List<DocGia> docGiaList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(DOCGIA_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            for (DocGia docGia : docGiaList) {
                oos.writeObject(docGia);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    
    //Doc file
    @SuppressWarnings("unchecked")
    public List<DocGia> read(){
        List<DocGia> docGiaList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(DOCGIA_FILE_NAME));
            ois = new ObjectInputStream(fis);
            while (fis.available() != 0) {
                DocGia docGia = (DocGia) ois.readObject();
                docGiaList.add(docGia);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally{
            closeStream(fis);
            closeStream(ois);
        }
        return docGiaList;
    }
    
    //Close InputStream
    private void closeStream(InputStream is){
        if(is != null){
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    //Close OutputStream
    private void closeStream(OutputStream os){
        if(os != null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
