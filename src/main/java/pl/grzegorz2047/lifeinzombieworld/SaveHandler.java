/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.lifeinzombieworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class SaveHandler
{
  File file;
  
  private SaveHandler() {}
  
  public SaveHandler(String filename)
  {
    this.file = new File("save.dat");
    if (!this.file.exists()) {
      try
      {
        this.file.createNewFile();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
  }
  
  public String getValueFromValueId(String valueid)
  {
    try
    {
      Scanner sc = new Scanner(this.file);
      while (sc.hasNextLine())
      {
        String line = sc.next();
        if (line.startsWith(valueid + ":"))
        {
          String id = line.split(":")[0];
          String value = line.split(":")[1].substring(1);
          System.out.println("ID " + id + " przetrzymuje w pliku wartosc " + value);
          return line;
        }
      }
      sc.close();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public HashMap getAllValuesFromFiles()
  {
    HashMap hashmap = new HashMap();
    try
    {
      Scanner sc = new Scanner(this.file);
      while (sc.hasNextLine())
      {
        String line = sc.nextLine();
        System.out.println("Linia w pliku to " + line);
        String splitted = line.split(":")[0];
        if ((line.startsWith(splitted + ":")) || (line.contains(":")))
        {
          String id = line.split(":")[0];
          String value = line.split(":")[1].substring(1);
          System.out.println("ID " + id + " przetrzymuje w pliku wartosc " + value);
          hashmap.put(id, value);
        }
      }
      sc.close();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    return hashmap;
  }
  
    public boolean saveValueToFile(String valueid, String value){
        FileOutputStream fop = null;
        try{
            fop = new FileOutputStream(this.file);
            byte[] stringinbyte = value.getBytes();
            fop.write(stringinbyte);
            fop.flush();
            fop.close();
            return true;
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally{
            try
            {
                fop.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return false;
    }
  
    public boolean readSave(){
        return false;
    }
}
