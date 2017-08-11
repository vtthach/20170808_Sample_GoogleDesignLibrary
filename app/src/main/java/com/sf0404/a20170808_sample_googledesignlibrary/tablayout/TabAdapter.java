package com.sf0404.a20170808_sample_googledesignlibrary.tablayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.sf0404.a20170808_sample_googledesignlibrary.R;
import com.sf0404.a20170808_sample_googledesignlibrary.common.adapter.BaseRecyclerViewAdapter;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;


public class TabAdapter<T> extends BaseRecyclerViewAdapter<T> {

    protected View emptyView;

    private RequestOptions requestOption = new RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fitCenter()
            .priority(Priority.HIGH);

    public ItemClickListener<T> itemClickListener;

    public TabAdapter(Context context,
                      List<T> itemList,
                      ItemClickListener<T> listener) {
        super(context, itemList);
        this.itemClickListener = listener;
    }

    @Override
    public GenericViewHolder onCreateFooterHolder(ViewGroup parent) {
        throw new UnsupportedOperationException("Adapter not support footer type");
    }

    @Override
    public GenericViewHolder onCreateHeaderHolder(ViewGroup parent) {
        throw new UnsupportedOperationException("Adapter not support header type");
    }

    @Override
    public GenericViewHolder onCreateContentHolder(ViewGroup parent) {
        View itemView = inflateView(parent, R.layout.tab_layout_item);
        return new MenuItemViewHolder<>(itemView, requestOption, itemClickListener);
    }

    @Override
    public int getItemCount() {
//        int size = super.getItemCount();
//        if (emptyView != null) {
//            if (size == 0) {
//                emptyView.setVisibility(View.VISIBLE);
//            } else {
//                emptyView.setVisibility(View.GONE);
//            }
//        }
//        return size;
        return 50;
    }


    public void setEmptyView(View view) {
        this.emptyView = view;
    }

    public void changeItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    static class MenuItemViewHolder<T> extends GenericViewHolder<T> {

        private final ItemClickListener<T> itemClickListener;
        private final RequestOptions requestOption;
        T curItem;
        Context context;
        @BindView(R.id.tvTest)
        TextView tvTest;

        private int curPosition;

        public MenuItemViewHolder(View itemView, RequestOptions requestOption, final ItemClickListener<T> itemClickListener) {
            super(itemView);
            context = itemView.getContext();
            this.requestOption = requestOption;
            this.itemClickListener = itemClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClicked(curItem, curPosition);
                    }
                }
            });
        }

        @Override
        public void bindItem(int position, T item) {
            tvTest.setText(String.format(Locale.getDefault(), "%d", position));
        }
    }

    public interface ItemClickListener<T> {
        void onItemClicked(T item, int position);
    }
}
