package com.tni.phitchaya.eventfinder.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.tni.phitchaya.eventfinder.R;
import com.tni.phitchaya.eventfinder.model.Event1;

public class EventAdapter extends FirestoreAdapter<EventAdapter.ViewHolder>{

    @Override
    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

    }

    public interface  OnEventSelectedListener {
            void onEventSelected(DocumentSnapshot event);
    }

    private OnEventSelectedListener mListener;

    public EventAdapter(Query query, OnEventSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_recycler_view, parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        private View binding;
        // view iteme in interface
        public ViewHolder(View itemView){
            super(itemView);
            this.binding = itemView;
        }

        // set deteil
        public void bind(final DocumentSnapshot snapshot, final OnEventSelectedListener listener){

            Event1 event = snapshot.toObject(Event1.class);
            Resources resources = itemView.getResources();


//            binding.EventTitleItem.setName
//            binding.EventNumberItem.setpo

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        listener.onEventSelected(snapshot);
                    }
                }
            });

        }

    }
}
