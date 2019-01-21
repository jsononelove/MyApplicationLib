package ssssaa.asdas.myren;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SkinGLSurfaceView extends GLSurfaceView {
    private boolean alreadyCalled = false;
    private float mDensity;
    private float mPreviousX;
    private float mPreviousY;
    private MineCraftSkinRenderer mRenderer;

    public SkinGLSurfaceView(Context context) {
        super(context);
        if (!this.alreadyCalled) {
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            getHolder().setFormat(-3);
            setRenderMode(0);
            setZOrderOnTop(true);
            setZOrderMediaOverlay(true);
        }
    }

    public SkinGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!this.alreadyCalled) {
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            getHolder().setFormat(-3);
            setZOrderOnTop(true);
            setZOrderMediaOverlay(true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() == 2 && this.mRenderer != null) {
            float f = this.mPreviousY;
            f = this.mDensity;
            this.mRenderer.mCharacter.SetRotateStep(((x - this.mPreviousX) / this.mDensity) / 2.0f, 0.0f);
        }
        this.mPreviousX = x;
        this.mPreviousY = y;
        return true;
    }

    public void setRenderer(MineCraftSkinRenderer mineCraftSkinRenderer, float f) {
        this.mRenderer = mineCraftSkinRenderer;
        this.mDensity = f;
        super.setRenderer(mineCraftSkinRenderer);
    }
}
