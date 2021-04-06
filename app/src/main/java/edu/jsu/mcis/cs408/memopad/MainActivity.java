package edu.jsu.mcis.cs408.memopad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private EditText addMemoText, deleteMemoId;
    private RecyclerView output;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (RecyclerView) findViewById(R.id.output);
        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();
    }

    public void addMemo(View v) {
        EditText memoInput = (EditText) findViewById(R.id.MemoAddText);
        String memoText = memoInput.getText().toString();
        db.addMemo(new Memo(memoText));
        updateRecyclerView();
    }

    public void deleteMemo(View v) {
        EditText idInput = (EditText) findViewById(R.id.MemoDeleteText);
        int id = Integer.parseInt(idInput.getText().toString());
        db.deleteMemo(id);
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());
        output.setHasFixedSize(true);
        output.setLayoutManager(new LinearLayoutManager(this));
        output.setAdapter(adapter);
    }

}