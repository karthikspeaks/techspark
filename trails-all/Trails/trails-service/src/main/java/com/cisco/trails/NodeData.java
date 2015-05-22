package com.cisco.trails;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/22/14
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeData {

    public static void main(String[] args) {

        String[] cmd = {
                "/bin/sh",
                "-c",
                "rpm -qa | grep nds"
        };

        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
