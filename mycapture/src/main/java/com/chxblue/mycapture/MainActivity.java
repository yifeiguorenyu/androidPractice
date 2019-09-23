package com.chxblue.mycapture;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity-1";
    private int reqCode = 1001;
    private ImageView imageView;
    private String mFilePath;
    Uri photoUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        mFilePath = Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"temp.png";
    }

    public void capture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // UpdateConfig.FILE_PROVIDER_AUTH 即是在清单文件中配置的authorities
            File newFile = new File(mFilePath);
            Log.d(TAG, "filePath=" +newFile.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 23) {
                int REQUEST_CODE_CONTACT = 101;
                String[] permissions = {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE};
                //验证是否许可权限
                for (String str : permissions) {
                    if (MainActivity.this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                        //申请权限
                        MainActivity.this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                        return;
                    } else {
                        //这里就是权限打开之后自己要操作的逻辑
                        if(!newFile.exists()){
                            try {
                                newFile.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                                Log.d(TAG, "--error--"+e.getMessage());
                            }
                        }
                        photoUri=  FileProvider.getUriForFile(MainActivity.this,"com.chxblue.mycapture.FileProvider",newFile);
                        // 给目标应用一个临时授权
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    }
                }
            }


        } else {
            photoUri = Uri.fromFile(new File(mFilePath));
        }

        intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
        startActivityForResult(intent,reqCode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "resultCode="+resultCode);
        if(resultCode==RESULT_OK){
            if(reqCode==requestCode){
//                Bundle bundle = data.getExtras();
//                Bitmap bitmap = (Bitmap) bundle.get("data");
//                imageView.setImageBitmap(bitmap);
                FileInputStream fis =null;
                try {
                    fis= new FileInputStream(mFilePath);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    if(fis!=null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }else {
            Log.d(TAG, "onActivityResult: --error--");
        }
    }

}
