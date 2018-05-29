package mvp.a658jjh.com.mvp_simple.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

@GlideModule
public class ImageLoader
        extends AppGlideModule {
    private static ImageLoader instance;

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public void loadChatPhoto(final Context paramContext, String paramString, final ImageView paramImageView) {
        if (TextUtils.isEmpty(paramString)) {
            loadImageNo(paramContext, paramImageView);
            return;
        }
        GlideApp.with(paramContext)
                .load(paramString)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                // TODO add Placeholder and error
//                .placeholder()
//                .error()
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        try {
                            Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                            int i = bitmap.getWidth();
                            int j = bitmap.getHeight();
                            float f3 = i * 1.0F / j;
//                    float f2 = paramContext.getResources().getDimensionPixelSize(2131624130);
//                    float f1 = paramContext.getResources().getDimensionPixelSize(2131624133);
                            float f1 = 0;
                            float f2 = 0;
                            if (f3 > 1.0F) {
                                f1 = f2 / f3;
                            }
                            ViewGroup.LayoutParams layoutParams = paramImageView.getLayoutParams();
                            layoutParams.width = ((int) f2);
                            layoutParams.height = ((int) f1);
                            paramImageView.setLayoutParams(layoutParams);
                            paramImageView.setImageBitmap(bitmap);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void loadImageNo(Context paramContext, ImageView imageView) {
    }
}
