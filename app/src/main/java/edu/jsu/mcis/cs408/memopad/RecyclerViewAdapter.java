package edu.jsu.mcis.cs408.memopad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Memo> data;
    public RecyclerViewAdapter(List<Memo> data) {
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memo_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setMemo(data.get(position));
        holder.bindData();
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Memo memo;
        private TextView memoText;
        private TextView memoID;

        public ViewHolder(View itemView) {
            super(itemView);
        }
        public Memo getMemo() {
            return memo;
        }
        public void setMemo(Memo memo) {
            this.memo = memo;
        }
        public void bindData() {
            if (memoText == null) {
                memoText = (TextView) itemView.findViewById(R.id.memoText);
            }
            memoText.setText(memo.getText());

            if (memoID == null) {
                memoID = (TextView) itemView.findViewById(R.id.memoID);
            }
            memoID.setText(String.valueOf(memo.getID()) + ": ");
        }
    }

}