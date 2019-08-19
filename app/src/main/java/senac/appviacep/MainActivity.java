package senac.appviacep;

import android.os.Bundle;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import senac.appviacep.models.Endereco;

public class MainActivity extends AppCompatActivity {

    TextView hello;
    EditText buscaCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hello = findViewById(R.id.txtCep);
        buscaCep = findViewById(R.id.txtBuscaCep);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                RequestQueue requestQueue;

                // Instantiate the cache
                Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

                // Set up the network to use HttpURLConnection as the HTTP client.
                Network network = new BasicNetwork(new HurlStack());

                // Instantiate the RequestQueue with the cache and network.
                requestQueue = new RequestQueue(cache, network);

                // Start the queue
                requestQueue.start();

                String cep = buscaCep.getText().toString();

                String url = "https://viacep.com.br/ws/" + cep +"/json/";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Endereco meuEndereco = new Endereco();

                        try {
                            meuEndereco.setBairro(response.getString("bairro"));
                            meuEndereco.setCep(response.getString("cep"));
                            meuEndereco.setComplemento(response.getString("complemento"));
                            meuEndereco.setUnidade(response.getString("unidade"));
                            meuEndereco.setGia(response.getString("gia"));
                            meuEndereco.setIbge(response.getString("ibge"));
                            meuEndereco.setLocalidade(response.getString("localidade"));
                            meuEndereco.setLogradouro(response.getString("logradouro"));
                            meuEndereco.setUf(response.getString("uf"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        hello.setText(meuEndereco.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("jsonObjectError", error.toString());
                        buscaCep.setError("Digite um CEP Válido!");
                    }
                });

                requestQueue.add(jsonObjectRequest);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
