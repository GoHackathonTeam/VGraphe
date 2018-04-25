package gohackathonteam.com.vgraphe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class InitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void proceed() {
        Intent i = new Intent(this, Object.class);//TODO
        startActivity(i);
        finish();
    }
}
