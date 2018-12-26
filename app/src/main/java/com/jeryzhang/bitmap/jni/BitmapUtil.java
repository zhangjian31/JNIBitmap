package com.jeryzhang.bitmap.jni;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class BitmapUtil {
    static {
        System.loadLibrary("load_bitmap");
    }


    public static Bitmap loadBitmap(Context context, String picName) {
        Bitmap bmp = null;
        AssetManager am = context.getApplicationContext().getResources().getAssets();
        try {
            InputStream is = am.open(picName);
            BitmapFactory.Options options = new BitmapFactory.Options();
            bmp = BitmapFactory.decodeStream(is, null, options);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    public static Bitmap processBitmap(Bitmap bitmap) {
        Bitmap bmp = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        nativeProcessBitmap(bmp);
        return bmp;
    }

    private static native void nativeProcessBitmap(Bitmap bitmap);
}
