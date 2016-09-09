package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.recyler.recylerview.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import entity.News;
import utils.vollyutil;

/**
 * Created by Administrator on 2016/8/27.
 */
public class RecylerAdapter extends  RecyclerView.Adapter<RecylerAdapter.Myholder>{
  private List<News.Data>list;
private Context context;

    public RecylerAdapter(Context context, List<News.Data> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<News.Data> list) {
        this.list = list;
    }


    public RecylerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.recyler, null);
        return new Myholder(v);
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        holder.imageview.setImageUrl(list.get(position).getIcon(), vollyutil.getInstance(context).getLoader());
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_summary.setText(list.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageview)
        NetworkImageView imageview;
        @ BindView(R.id.tv_title)
        TextView tv_title;
        @ BindView(R.id.tv_title)
        TextView  tv_summary;
        public Myholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
