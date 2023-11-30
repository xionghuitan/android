package com.example.test2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{

    BufferedReader br;

    DataOutputStream dos;

    private boolean flag = true;
    public Send() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dos, client);
        }
    }

    private String getMessage() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            flag = false;
            // CloseUtil.closeAll(br);
        }
        return str;
    }

    public void sent(String str) {
        try {
            dos.writeUTF(str);
            dos.flush();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dos);
        }
    }


    @Override
    public void run() {
        while (flag) {
            this.sent(getMessage());
        }

    }
}
