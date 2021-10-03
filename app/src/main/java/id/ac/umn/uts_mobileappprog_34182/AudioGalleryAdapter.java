package id.ac.umn.uts_mobileappprog_34182;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class AudioGalleryAdapter extends RecyclerView.Adapter<AudioGalleryAdapter.ItemAudioViewHolder> {
    private LinkedList<AudioObject> mAudioGallery;
    private LayoutInflater mInflater;
    private Context mContext;

    public AudioGalleryAdapter(Context context, LinkedList<AudioObject> audioGallery){
        this.mContext = context;
        this.mAudioGallery = audioGallery;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AudioGalleryAdapter.ItemAudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.audio_item_layout, parent, false);
        return new ItemAudioViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioGalleryAdapter.ItemAudioViewHolder holder, int position) {
        AudioObject mAudioObject = mAudioGallery.get(position);

        holder.tvAudioTitle.setText(mAudioObject.getTitle());
        holder.tvAudioCategory.setText(mAudioObject.getCategory());
    }

    @Override
    public int getItemCount(){ return mAudioGallery.size();}

    class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvAudioTitle;
        private TextView tvAudioCategory;
        private ImageButton btnAudioDelete;
        private AudioGalleryAdapter mAdapter;
        private int mPosition;
        private AudioObject mAudioObject;

        private static final String AUDIO_DETAIL_KEY = "id.ac.umn.uts_mobileappprog_34182.audio";

        public ItemAudioViewHolder(View view, AudioGalleryAdapter audioGalleryAdapter) {
            super(view);
            mAdapter = audioGalleryAdapter;
            tvAudioTitle = view.findViewById(R.id.tv_audio_title);
            tvAudioCategory = view.findViewById(R.id.tv_audio_category);
            btnAudioDelete = view.findViewById(R.id.btn_audio_delete);
            view.setOnClickListener(this);

            btnAudioDelete.setOnClickListener((v)->{
                removeAt(getAdapterPosition());
            });

        }

        @Override
        public void onClick(View v){
            mPosition = getLayoutPosition();
            mAudioObject = mAudioGallery.get(mPosition);

            Intent audioPlayer = new Intent(mContext, AudioPlayer.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(AUDIO_DETAIL_KEY, mAudioObject);
            audioPlayer.putExtras(bundle);
            mContext.startActivity(audioPlayer);
        }
    }

    public void removeAt(int position){
        mAudioGallery.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mAudioGallery.size());
    }
}
