package ssssaa.asdas.myren;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Utils {
    public static float d2r(float f) {
        return (f * 3.1415927f) / 180.0f;
    }

    static FloatBuffer toFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    static ShortBuffer toShortBuffer(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        return asShortBuffer;
    }

    public static Bitmap func (Context context, Bitmap bitmap, int empty){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap decodeEmpty = BitmapFactory.decodeResource(context.getResources(), empty, options);
        decodeEmpty = decodeEmpty.copy(Bitmap.Config.ARGB_8888, true);


        for(int x = 0; x <64 /*bitmap width*/; x++)
        {
            for(int y = 0; y <32 /*bitmap height*/; y++)
            {
                int color = bitmap.getPixel(x, y);
                decodeEmpty.setPixel(x,y,color);
            }
        }

        return decodeEmpty;
    }
    public static boolean isSteveSkin(Bitmap bitmap) {
        return bitmap.getPixel(54, 22) != 0;
    }

    public static boolean isOldSkin(Bitmap bitmap) {
        return bitmap.getHeight() < 50;
    }
}
