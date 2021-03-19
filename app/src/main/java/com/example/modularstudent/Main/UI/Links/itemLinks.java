package com.example.modularstudent.Main.UI.Links;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.modularstudent.Models.ClassLinksModel;
import com.example.modularstudent.R;
import com.xwray.groupie.GroupieViewHolder;

public class itemLinks extends com.xwray.groupie.Item {
    private ClassLinksModel mClassLinksModel;
    private Context mContext;

    public itemLinks(Context context, ClassLinksModel classLinksModel){
        mContext = context;
        mClassLinksModel = classLinksModel;
    }


    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        TextView name = viewHolder.itemView.findViewById(R.id.labelItemName);
        TextView uploadItem = viewHolder.itemView.findViewById(R.id.labelItemUploadTime);
        Button openButton = viewHolder.itemView.findViewById(R.id.buttonOpenItem);
        name.setText(mClassLinksModel.getLinkTitle());
        uploadItem.setText(mClassLinksModel.getLinkUploadTime());
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoutubeLink(mClassLinksModel.getLinkName());
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.class_item_layout;
    }
    private void openYoutubeLink(String linkName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(linkName));
        mContext.startActivity(intent);
    }
}
