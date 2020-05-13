package multi.android.network.arduino;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import multi.android.network.R;

public class Serial_01 extends AppCompatActivity {
    Socket socket;
    InputStream is;
    OutputStream os;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_01);
    }

    public void onLED(View v) {
        AsyncTaskLED atLED = new AsyncTaskLED();
        atLED.execute("1");
    }

    public void offLED(View v) {
        AsyncTaskLED atLED = new AsyncTaskLED();
        atLED.execute("0");
    }

    class AsyncTaskLED extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(final String... strings) {
            try {

                String ip = "70.12.225.188";
                int port = 12345;
                socket = new Socket(ip, port);
                if (socket != null) {
                    ioWork();
                }
                Thread resivethread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            os.write(Integer.parseInt(strings[0]));
                        } catch (IOException e) {
                            try {
                                is.close();
                                os.close();
                                socket.close();
                            } catch (IOException e1) {
                            }
                        }
                    }
                });
                resivethread.start();

            } catch (UnknownHostException e) {
            } catch (IOException e) {
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("check","끝");
        }

        public void ioWork() {
            try {
                is = socket.getInputStream();
                os = socket.getOutputStream();
            } catch (IOException e) {
            }
        }
    }
}
