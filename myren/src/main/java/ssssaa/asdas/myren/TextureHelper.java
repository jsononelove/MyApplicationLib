package ssssaa.asdas.myren;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.GLES20;
import android.opengl.GLUtils;

import javax.microedition.khronos.opengles.GL10;

public class TextureHelper {
    public static boolean isLoadingError = false;

    public static int loadGLTextureFromBitmap(Bitmap bitmap, GL10 gl10) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        gl10.glBindTexture(3553, iArr[0]);
        gl10.glTexParameterf(3553, 10241, 9728.0f);
        gl10.glTexParameterf(3553, 10240, 9728.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    public static int loadTexture(Context context, Bitmap bitmap) {
        isLoadingError = false;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            new Options().inScaled = false;
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameterf(3553, 10240, 9728.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            bitmap.recycle();
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        throw new RuntimeException("Error loading texture.");
    }

    public static int loadTexture(Context context, int i) {
        isLoadingError = false;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            Options options = new Options();
            options.inScaled = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i, options);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameterf(3553, 10240, 9728.0f);
            GLUtils.texImage2D(3553, 0, decodeResource, 0);
            decodeResource.recycle();
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        throw new RuntimeException("Error loading texture.");
    }

    public static int loadTextureFromBitmap(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9728.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            bitmap.recycle();
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        throw new RuntimeException("Error loading texture.");
    }

    public static int loadTextureFromFile(String str, int i) {
        isLoadingError = false;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            Options options = new Options();
            options.inScaled = false;
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                GLES20.glBindTexture(3553, iArr[0]);
                GLES20.glTexParameterf(3553, 10241, 9728.0f);
                GLES20.glTexParameterf(3553, 10240, 9728.0f);
                GLUtils.texImage2D(3553, 0, decodeFile, 0);
                decodeFile.recycle();
            } catch (Exception unused) {
                isLoadingError = true;
                return i;
            }
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        isLoadingError = true;
        return i;
    }
}
