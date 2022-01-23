package com.tni.phitchaya.eventfinder.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.tni.phitchaya.eventfinder.R;
import com.tni.phitchaya.eventfinder.model.Event;

public class EventAdapter extends FirestoreAdapter<EventAdapter.ViewHolder>{

    public Context context2;

    @Override
    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

    }

    public interface  OnEventSelectedListener {
            void onEventSelected(DocumentSnapshot event);
    }

    private OnEventSelectedListener mListener;

//    public Load_Event(String name,String provide , String location , String startTime, String endTime,
//                 String startdate,/*String enddate,*/
//                 String category , String img , String detail, int popularity){
//        this.name = name;
//        this.provide = provide;
//        this.location = location;
//        this.startTime = startTime;
//        this.endTime = endTime ;
//        this.startdate = startdate;
////        this.enddate = enddate;
//        this.category = category;
//        this.img = img;
//        this.detail = detail;
//        this.popularity = popularity;
//    }

    public EventAdapter(Query query, /*OnEventSelectedListener listener*/ Context context) {
        super(query);
        this.context2 = context;
//        mListener = listener;
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

        TextView nameView;
        TextView localView;
        TextView poView;

        private View binding;
        // view iteme in interface
        public ViewHolder(View itemView){
            super(itemView);
            nameView = itemView.findViewById(R.id.EventTitleItem);
            localView = itemView.findViewById(R.id.EventLocalItem);
            poView = itemView.findViewById(R.id.EventNumberItem);
            this.binding = itemView;
        }

        // set deteil
        public void bind(final DocumentSnapshot snapshot, final OnEventSelectedListener listener){

            Event event = snapshot.toObject(Event.class);
//            Resources resources = itemView.getResources();


            nameView.setText(event.getName());
            localView.setText(event.getLocation());

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
