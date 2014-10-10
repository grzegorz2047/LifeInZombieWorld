/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.lifeinzombieworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Grzegorz
 */
public class Main {
        public static void main(String[] args){
            System.out.println("Powiedz, jak cie zwą?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name;
            try
            {
                name = br.readLine();
                System.out.println("");
            }
            catch (IOException ex)
            {
                System.out.println("Wystapil blad z czytaniem co wpisal uzytkownik!");
                name = "Ktos";
                System.out.println("Nadal nie wiem kim jestes wiec nazwe cie Ktos!");
            }
            User user = new User(name);
            System.out.println("Ok, witaj " + user.getName() + ".");

            SaveHandler sh = new SaveHandler("save.dat");
            sh.getAllValuesFromFiles();
            try
            {
                br.readLine();
            }
            catch (IOException ex) {}
        }
}
