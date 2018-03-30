package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {
    static Button toreturn;
    int rez = 0;

    public class ReturnListen implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();

            intent.putExtra("result", rez);

            setResult(0, intent);

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        Intent intent = getIntent();

        String terms = intent.getStringExtra("terms");

        String[] elems = terms.split("\\+");

        for (int i = 0; i < elems.length; ++i) {
            rez += Integer.parseInt(elems[i]);
        }

        TextView termText = (TextView) findViewById(R.id.Computed);

        termText.setText(terms + "=" + rez);

        toreturn = (Button) findViewById(R.id.Return);

        toreturn.setOnClickListener(new ReturnListen());

    }
}
