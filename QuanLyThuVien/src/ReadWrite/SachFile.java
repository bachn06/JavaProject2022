/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadWrite;

import DoiTuong.Sach;
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
public class SachFile {
    private static final String SACH_FILE_NAME = "sach.txt";

    //Ghi file
    @SuppressWarnings("unchecked")
    public void write(List<Sach> sachList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(SACH_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            for (Sach sach : sachList) {
                oos.writeObject(sach);
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
    public List<Sach> read(){
        List<Sach> sachList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(SACH_FILE_NAME));
            ois = new ObjectInputStream(fis);
            while (fis.available() != 0) {
                Sach sach = (Sach) ois.readObject();
                sachList.add(sach);
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
        return sachList;
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
