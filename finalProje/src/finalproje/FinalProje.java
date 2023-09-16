/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class FinalProje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          menu();       
    }
    private static void menu()
    {
        int tekrar=1;
        while(tekrar==1||tekrar==2||tekrar==3)
        {
        System.out.println("           "+"MENU");
        System.out.println("---------------------------");
        System.out.println("Yeni kayıt için         1: ");
        System.out.println("Randevu Almak için      2: ");
        System.out.println("Randevu Listelemek için 3: ");
        System.out.println("Çıkış için              0: ");
        
        Scanner in=new Scanner(System.in);
        System.out.print("\nLütfen Seçiminizi Giriniz: ");
        tekrar=in.nextInt();
        
        if(tekrar==0)
        {
            System.out.println("Çıktınız.!");
        }
        if(tekrar==1)
        {
            yenikayit();
        }
        if(tekrar==2)
        {
            randevual();
        }
        if(tekrar==3)
        {
            randevulistele();
        }
        
     }
    }
    private static void yenikayit() 
    {
        Scanner in=new Scanner(System.in);  
        System.out.print("Adı ve Soyadı: ");
        String adsoyad= in.nextLine();
        System.out.print("Öğrenci no: ");
        int no=in.nextInt();     
        System.out.println("Kaydınız başarılı şekilde yapılmıştır.\n");
        try
        {           
            File dosyaAdi=new File("asiListesi.txt");            
            dosyaAdi.createNewFile();
            FileWriter yazici=new FileWriter(dosyaAdi,true);            
            yazici.write("\n"+no+","+" "+adsoyad+","+"\n");            
            yazici.close();
        }
        catch(IOException e)
        {
            System.out.println("Bir hata ile karşılaşıldı.");
            e.printStackTrace();
        }   
        
    }
    private static void randevual()
    {        
        
        Scanner in=new Scanner(System.in);  
        System.out.print("Öğrenci no: ");        
        String no=in.nextLine();
        String[] dizi=new String[1000];
        String[] dizi2=new String[1000];
        String[] dizi4=new String[1000];
        int kontrol=0;
        try
        {
            String okunan=null;
            String okunan2=null;
            File dosyaAdi=new File("asiListesi.txt");
            File dosyaAdi2=new File("yaz.txt");     
            Scanner okuyucu=new Scanner(dosyaAdi);            
            while(okuyucu.hasNext())
            {
                String isim=okuyucu.next();
                okunan=okuyucu.nextLine();               
                for (int i = 0; i < 1; i++) 
                {
                   dizi[i]=okunan;
                   dizi2[i]=isim;
                   if (dizi2[i].contains(no)==true)
                    {                        
                    System.out.println(dizi[i]);                    
                    kontrol=1;                      
                    }
                }               
            
            
                
                for (int i = 0; i < 1; i++) 
                {
                    dizi4[i]=isim+okunan;
                 try
                {                   
                dosyaAdi2.createNewFile();
                FileWriter yazici=new FileWriter(dosyaAdi2,true);
                yazici.write(dizi4[i]+"\n");
                yazici.close();
                }
            catch(IOException e)
            {
                System.out.println("Bir hata ile karşılaşıldı.");
                e.printStackTrace();
            }          
                }
                
            }
            
            
            if (kontrol==0) 
            {
                System.out.println("Öğrenci Bulunamadı");
                dosyaAdi2.delete();
            }
            if (kontrol==1) {
                okuyucu.close();
                dosyaAdi.delete();
            }
           
        }        
        
        catch(FileNotFoundException e)
        {
            System.out.println("Bir hata ile karşılaşıldı.");
            e.printStackTrace();
        }      
        if (kontrol==1) 
        {
        System.out.println(" "+"Aşı Tercihi");
        System.out.println("------------");
        System.out.println("Biontech : 1");
        System.out.println("Sinovac  : 2");
        System.out.println("Sputnik  : 3");        
        int asi=in.nextInt();
        System.out.print("Lütfen Aşı Tarihini Giriniz: ");
        String tarih=in.next();
        System.out.println("Randevunuz Oluşturulmuştur.");
        String [] dizi3=new String[1000];
          try
            {
            String okunan=null;              
            File dosyaAdi=new File("yaz.txt");
            Scanner okuyucu=new Scanner(dosyaAdi);            
            while(okuyucu.hasNextLine())
                {
                okunan=okuyucu.nextLine();
                for (int i = 0; i < 1; i++) 
                    {             
                        dizi3[i]=okunan; 
                         if (dizi3[i].contains(no)==true)
                        {                      
                           
                             if (asi==1) 
                            {          
                                dizi3[i]=dizi3[i]+"Biontech"+","+tarih;
                                
                            }
                        else if(asi==2)
                            {
                                 dizi3[i]=dizi3[i]+"Sinovac"+","+tarih;       
                            }
                        else if(asi==3)
                            {
                                 dizi3[i]=dizi3[i]+"Sputnik"+","+tarih;       
                            }
                        }
                         
                         
                         
                         try
                {
            File dosyaAdi3=new File("asiListesi.txt");     
            dosyaAdi3.createNewFile();
            FileWriter yazici=new FileWriter(dosyaAdi3,true);         
            //for (int i = 0; i < 1; i++) 
           // {
                yazici.write(dizi3[i]+"\n");
           // }
                    // dizi3[i]=dizi4[i];
            yazici.close();
            
                }
        catch(IOException e)
        {
            System.out.println("Bir hata ile karşılaşıldı.");
            e.printStackTrace();
        }          
                        
                                                
                    }
               
              
                 
                }
            
            
                okuyucu.close();
                dosyaAdi.delete();
            }
             
        
        catch(FileNotFoundException e)
        {
            System.out.println("Bir hata ile karşılaşıldı.");
            e.printStackTrace();
        }
            
        

            
        }
        
      
    }
    private static void randevulistele()
    {
        Scanner in=new Scanner(System.in);
        String a="Sinovac";
        String b="Biontech";
        String c="Sputnik";
        String[] dizi=new String[1000];
        System.out.println("Sıra No"+"|"+"Öğrenci No"+"|"+"Adı Soyadı"+"|"+"Aşı Firması"+"|"+"Tarih");
        System.out.println("------------------------------------------------");
        try
        {
            String okunan=null;
            File dosyaAdi=new File("asiListesi.txt");
            Scanner okuyucu=new Scanner(dosyaAdi);            
            int sayac=0;
            while(okuyucu.hasNextLine())
            {
                okunan=okuyucu.nextLine();               
                for (int i = 0; i < 1; i++) 
                {
                    dizi[i]=okunan;                
                   
                   if (dizi[i].contains(a)==true)
                    {
                    sayac++;
                    System.out.println(sayac+"       "+dizi[i]);                    
                    
                    }
                    else if (dizi[i].contains(b)==true)
                    {
                    sayac++;
                    System.out.println(sayac+"       "+dizi[i]);                    
                    
                    }
                     else  if (dizi[i].contains(c)==true)
                    {
                    sayac++;
                    System.out.println(sayac+"       "+dizi[i]); 
                    }
                }               
            }                
            
        }        
        
        catch(FileNotFoundException e)
        {
            System.out.println("Bir hata ile karşılaşıldı.");
            e.printStackTrace();
        }                          
        
    }
    
}