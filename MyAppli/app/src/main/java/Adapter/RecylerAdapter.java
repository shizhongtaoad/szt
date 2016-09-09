package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.application.myappli.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import entity.News;
import utils.vollyutil;

/**
 * Created by Administrator on 2016/8/29.
 */
public class RecylerAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<News.Data> list;
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
    public static final int TYPE_STR = 0;
    public static final int TYPE_IMG = 1;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_IMG) {
            View view = View.inflate(parent.getContext(), R.layout.recyler, null);
            return new MyHolder(view);
        } else {
            View view = View.inflate(parent.getContext(), R.layout.layout_item_news2, null);
            return new MyHolder2(view);
        }


    }

    //把集合中对象的属性设置到控件
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyHolder) {
            MyHolder mHolder = (MyHolder) holder;
            mHolder.imageView.setImageUrl(list.get(position).getIcon(), vollyutil.getInstance(context).getLoader());
            mHolder.tv_summary.setText(list.get(position).getSummary());
            mHolder.tv_title.setText(list.get(position).getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (myOnITemClickListener != null) {
                        myOnITemClickListener.onItemClick(view, position);
                    }
                }
            });

            mHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    if (myOnItemLongClickListener != null) {
                        return myOnItemLongClickListener.onItemLongClick(view, position);
                    }
                    return false;
                }
            });
        } else {
            MyHolder2 h = (MyHolder2) holder;
            h.tvHold2.setText(list.get(position).getTitle());
            h.networkImageView2.setImageUrl(list.get(position).getIcon(), vollyutil.getInstance(context).getLoader());
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0) {
            return TYPE_IMG;
        } else {
            return TYPE_STR;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        //findviewByID，把item布局中的控件找到
        @BindView(R.id.imageview)
        NetworkImageView imageView;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_summary)
        TextView tv_summary;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class MyHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_hold2)
        TextView tvHold2;
        @BindView(R.id.netWorkImageView2)
        NetworkImageView networkImageView2;
        public MyHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setMyOnITemClickListener(MyOnITemClickListener myOnITemClickListener) {
        this.myOnITemClickListener = myOnITemClickListener;
    }

    public MyOnITemClickListener myOnITemClickListener;

    public interface MyOnITemClickListener {
        void onItemClick(View view, int position);
    }


    MyOnItemLongClickListener myOnItemLongClickListener;

    public void setMyOnItemLongClickListener(MyOnItemLongClickListener myOnItemLongClickListener) {
        this.myOnItemLongClickListener = myOnItemLongClickListener;
    }


    public interface MyOnItemLongClickListener {
        boolean onItemLongClick(View view, int position);
    }
//    @Override
//    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = View.inflate(parent.getContext(), R.layout.recyler, null);
//        return new Myholder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(Myholder holder, int position) {
//        holder.imageview.setImageUrl(list.get(position).getIcon(), vollyutil.getInstance(context).getLoader());
//        holder.tv_title.setText(list.get(position).getTitle());
//        holder.tv_summary.setText(list.get(position).getSummary());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list==null?0:list.size();
//    }
//
//
//
//
//    public class Myholder extends RecyclerView.ViewHolder{
//        @BindView(R.id.imageview)
//        NetworkImageView imageview;
//        @ BindView(R.id.tv_title)
//        TextView tv_title;
//        @ BindView(R.id.tv_summary)
//        TextView  tv_summary;
//        public Myholder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this,itemView);
//        }
//    }
}
