package edu.jsu.mcis.cs408.memopad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.output);
    }

    //Add an entry to the database
    public void addMemo(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.getAllMemos();

        getAllMemos(v);
    }

    //Delete an entry from the database
    public void deleteMemo(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        String memos = db.getAllMemos();
        output.setText(memos);

        getAllMemos(v);
    }

    //Update the output text to show memos
    public void getAllMemos(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        String memos = db.getAllMemos();
        output.setText(memos);
    }
}