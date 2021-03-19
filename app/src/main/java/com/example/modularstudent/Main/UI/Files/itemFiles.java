package com.example.modularstudent.Main.UI.Files;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.modularstudent.Models.ClassFilesModel;
import com.example.modularstudent.R;
import com.xwray.groupie.GroupieViewHolder;

public class itemFiles extends com.xwray.groupie.Item {
    ClassFilesModel mClassFilesModel;
    Context mContext;

    public itemFiles(Context context, ClassFilesModel classFilesModel){
        mContext = context;
        mClassFilesModel = classFilesModel;
    }


    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        TextView name = viewHolder.itemView.findViewById(R.id.labelItemName);
        TextView uploadItem = viewHolder.itemView.findViewById(R.id.labelItemUploadTime);
        Button openButton = viewHolder.itemView.findViewById(R.id.buttonOpenItem);
        name.setText(mClassFilesModel.getFileTitle());
        uploadItem.setText(mClassFilesModel.getFileUploadTime());
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Check for file download in notifications", Toast.LENGTH_SHORT).show();
                DownloadBPdf(mClassFilesModel.getFileDownloadUrl(), mClassFilesModel.getFileTitle());
            }
        });

    }

    @Override
    public int getLayout() {
        return R.layout.class_item_layout;
    }

    public  void DownloadBPdf(String url,String title){
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
        String tempTitle=title.replace("","_");
        request.setTitle(tempTitle);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,tempTitle);
        DownloadManager downloadManager=(DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        request.allowScanningByMediaScanner();
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        downloadManager.enqueue(request);

    }
}
