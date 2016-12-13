package com.example.paul.keepandsavemoney.api;

import com.example.paul.keepandsavemoney.interfaces.ISuccess;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by paul on 12.12.16.
 */

public class ApiConnection {

    private HttpURLConnection mConnection;
    private InputStream mIs = null;


    public void connect(final String url, final String method, final ISuccess<String> pHttpCalcabk) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mConnection = (HttpURLConnection) new URL(url).openConnection();
                    mConnection.setRequestMethod(method);

                    int statusCode = mConnection.getResponseCode();

                    if (statusCode >= 200 && statusCode < 400) {
                        mIs = mConnection.getInputStream();
                    } else {
                        mIs = mConnection.getErrorStream();
                    }

                    String response = readInputStream(mIs);
                    ;

                    if (pHttpCalcabk != null) {
                        pHttpCalcabk.onSuccess(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.print(e.getMessage());
                } finally {
                    if (mConnection != null) {
                        mConnection.disconnect();
                    }
                    if (mIs != null) {
                        try {
                            mIs.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }

    private String readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }
}
