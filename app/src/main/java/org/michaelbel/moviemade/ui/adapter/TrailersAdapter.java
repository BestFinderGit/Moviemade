package org.michaelbel.moviemade.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.michaelbel.moviemade.rest.model.v3.Trailer;
import org.michaelbel.moviemade.ui.view.trailer.TrailerCompatView;

import java.util.ArrayList;

public class TrailersAdapter extends RecyclerView.Adapter {

    private ArrayList<Trailer> trailers;

    public TrailersAdapter(ArrayList<Trailer> trailers) {
        this.trailers = trailers;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(new TrailerCompatView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Trailer trailer = trailers.get(position);

        TrailerCompatView view = (TrailerCompatView) holder.itemView;
        view.setTitle(trailer.name)
            .setQuality(trailer.size)
            .setSite(trailer.site)
            .setTrailerImage(trailer.key)
            .changeLayoutParams();
    }

    @Override
    public int getItemCount() {
        return trailers != null ? trailers.size() : 0;
    }
}