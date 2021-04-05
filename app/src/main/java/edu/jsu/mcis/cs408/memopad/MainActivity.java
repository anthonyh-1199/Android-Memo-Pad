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

    public void addNewMemo(View v) {
        EditText memoInput = (EditText) findViewById(R.id.MemoAddText);
        String memoText = memoInput.getText().toString();
        db.addMemo(new Memo(memoText));
        updateRecyclerView();
    }

    private void updateRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());
        output.setHasFixedSize(true);
        output.setLayoutManager(new LinearLayoutManager(this));
        output.setAdapter(adapter);
    }

    /*
    //Add an entry to the database
    public void addMemo(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        addMemoText = (EditText) findViewById(R.id.addText);

        Memo memo = new Memo(addMemoText.getText().toString());

        db.addMemo(memo);

        getAllMemos(v);
    }

    //Delete an entry from the database
    public void deleteMemo(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        deleteMemoId = (EditText) findViewById(R.id.deleteText);

        int id = Integer.parseInt(deleteMemoId.getText().toString());

        db.deleteMemo(id);

        getAllMemos(v);
    }

    //Update the output text to show memos
    public void getAllMemos(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        String memos = db.getAllMemos();
        output.setText(memos);
    }

     */
}