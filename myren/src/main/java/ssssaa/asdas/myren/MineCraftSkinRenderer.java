package ssssaa.asdas.myren;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MineCraftSkinRenderer implements Renderer {
    public static float[] light0Position = new float[]{0.0f, 0.0f, 100.0f, 0.0f};
    public boolean changeSkinImage = false;
    private int mBackTexData;
    public GameCharacter mCharacter;
    private int mCharacterTexData;
    private Context mContext;
    public String path;
    public float[] plane_texcords = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    protected float[] plane_vertices = new float[]{-200.0f, -100.0f, -100.0f, -200.0f, 100.0f, -100.0f, 200.0f, 100.0f, -100.0f, 200.0f, -100.0f, -100.0f};
    boolean updateBitmapSkin = false;

    public MineCraftSkinRenderer(Context context) {
        this.mContext = context;
        this.mCharacter = new GameCharacter();
    }

    public MineCraftSkinRenderer(Context context, boolean z) {
        this.mContext = context;
        this.mCharacter = new GameCharacter(z);
    }

    public MineCraftSkinRenderer(Context context, Bitmap bitmap) {
        this.mContext = context;
        this.mCharacter = new GameCharacter(bitmap);
    }

    public MineCraftSkinRenderer(Context context, Bitmap bitmap, boolean z, boolean old) {
        this.mContext = context;
        this.mCharacter = new GameCharacter(z, bitmap, old);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.mCharacterTexData = TextureHelper.loadTexture(this.mContext, this.mCharacter.selected_resource);
        gl10.glEnable(2884);
        gl10.glCullFace(1028);
        gl10.glShadeModel(7425);
        gl10.glEnable(3024);
        gl10.glEnable(2929);
        gl10.glDepthFunc(515);
        gl10.glHint(3152, 4354);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GL10 gl102 = gl10;
        int i3 = i;
        int i4 = i2;
        gl10.glViewport(0, 0, i, i4);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        float f = (float) i4;
        float f2 = f / 2.0f;
        float tan = f2 / ((float) Math.tan((double) Utils.d2r(22.5f)));
        float f3 = (float) i3;
        GLU.gluPerspective(gl10, 45.0f, f3 / f, 0.5f, Math.max(1500.0f, tan));
        gl10.glMatrixMode(5888);
        gl10.glLoadIdentity();
        float f4 = f3 / 2.0f;
        GLU.gluLookAt(gl10, f4, f2, tan, f4, f2, 0.0f, 0.0f, 1.0f, 0.0f);
        gl10.glEnable(2896);
        gl10.glEnable(16384);
        gl10.glLightfv(16384, 4608, new float[]{3.5f, 3.5f, 3.5f, 1.0f}, 0);
        light0Position = new float[]{0.0f, 0.0f, tan, 0.0f};
        gl10.glLightfv(16384, 4611, light0Position, 0);
    }

    public void onDrawFrame(GL10 gl10) {
        gl10.glClear(16640);
        gl10.glEnable(3553);
        gl10.glLoadIdentity();
        gl10.glColor4f(0.63671875f, 0.76953125f, 0.22265625f, 1.0f);
        gl10.glTranslatef(0.0f, 0.0f, -60.0f);
        gl10.glPushMatrix();
        gl10.glBindTexture(3553, this.mCharacterTexData);
        this.mCharacter.draw(gl10);
        gl10.glPopMatrix();
        gl10.glLoadIdentity();
    }

    public void UpdateTexture(String str) {
        this.mCharacterTexData = TextureHelper.loadTextureFromFile(str, this.mCharacterTexData);
    }

    public void updateTexture(int i) {
        this.mCharacterTexData = TextureHelper.loadTexture(this.mContext, i);
    }

    public void updateTexture(Bitmap bitmap) {
        this.updateBitmapSkin = true;
        this.mCharacter.selected_resource = bitmap;
    }
}
