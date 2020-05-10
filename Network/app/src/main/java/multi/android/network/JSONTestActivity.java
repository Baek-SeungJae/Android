package multi.android.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JSONTestActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    ListView listView;
    ArrayList<ProductDTO> list;
    ProductAdapter itemAdapter;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_s_o_n_test);
        listView = findViewById(R.id.listView);
        //container = findViewById(R.id.container);
        list = new ArrayList<>();
       // progressDialog = new ProgressDialog(this);
        HttpTest task = new HttpTest();
        task.execute();

    }
    class HttpTest extends AsyncTask<Void,Void,String>{

       /* @Override
        protected void onPreExecute() {
            progressDialog.setTitle("HTTP Connect ..");
            progressDialog.setMessage("Please Wait..");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }*/
        @Override
        protected String doInBackground(Void... voids) {
            URL url = null;
            BufferedReader in=null;
            String data="";
            //progressDialog.dismiss();
            try {
                url = new URL("http://70.12.224.117:8088/DBServer/selectAll");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Content-Type","application/json");
                Log.d("dbtest","data"+httpURLConnection.getResponseCode());
                //android.os.NetworkOnMainThreadException이 발생한다.
                //메인쓰레드는 정지시킬 수 없다.
                if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                    in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8"));
                    data = in.readLine();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("dbtest",data);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
           // progressDialog.dismiss();
            JSONArray ja = null;

            //웹서버에서 가져온 데이터가 json형식이므로 파시애서 jsonObject를 productdto로 변환
            //변환한 productdto를 arraylist에 저장장
           try {
                ja = new JSONArray(s);
                for(int i=0;i<ja.length();i++){
                    JSONObject jo = ja.getJSONObject(i);
                    String name = jo.getString("mem_name");
                    String id = jo.getString("mem_age");
                    //String img = jo.getString("img_gen_file_nm");
                    String img="a";
                    ProductDTO item = new ProductDTO(id,name,img);
                    list.add(item);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            itemAdapter = new ProductAdapter(list);
            listView.setAdapter(itemAdapter);

        }
    }
    class ProductAdapter extends BaseAdapter {
        ArrayList<ProductDTO> alist;

        public ProductAdapter(ArrayList<ProductDTO> alist) {
            this.alist = alist;
        }

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public Object getItem(int position) {
            return alist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = null;
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.item, container, true);
            TextView prd_no = itemView.findViewById(R.id.textView);
            TextView prd_nm = itemView.findViewById(R.id.textView2);

            final ImageView imageView = itemView.findViewById(R.id.imageView);

            prd_no.setText(alist.get(position).getPrd_no());
            prd_nm.setText(alist.get(position).getPrd_nm());

            String img = alist.get(position).getImg_gen_file_nm();
            img = "http://70.12.224.117:8088/bigdataShop/resources/images/product/"+img;
            final String finalImg = img;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    URL url = null;
                    InputStream is = null;
                    try{
                        url = new URL(finalImg);
                        is = url.openStream();
                        final Bitmap bm = BitmapFactory.decodeStream(is);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(bm);
                            }
                        });
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            return itemView;


        }
    }
}
