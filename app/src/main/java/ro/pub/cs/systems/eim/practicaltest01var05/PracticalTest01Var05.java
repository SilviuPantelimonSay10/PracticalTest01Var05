package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var05 extends AppCompatActivity {

    static String terms;
    static Button add, compute;
    static EditText next;
    static TextView termText;

    public class AddListen implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            if (next.getText().toString().isEmpty())
                return;


            if (terms.isEmpty())
                terms = next.getText().toString();
            else
                terms = terms + '+' + next.getText().toString();

            termText.setText(terms);
        }
    }

    public class ComputeListen implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);

            intent.putExtra("terms", terms);

            startActivityForResult(intent, 0);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practical_test01_var05);

        terms = new String();

        add = (Button) findViewById(R.id.Add);

        add.setOnClickListener(new AddListen());

        next = (EditText) findViewById(R.id.Next_Term);

        termText = (TextView) findViewById(R.id.All_terms);

        compute = (Button) findViewById(R.id.Compute);
        compute.setOnClickListener(new ComputeListen());




    }


    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (intent != null)
            termText.setText("" + intent.getIntExtra("result", 0));
    }
}
