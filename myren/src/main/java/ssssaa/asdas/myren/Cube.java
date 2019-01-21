package ssssaa.asdas.myren;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Cube {
    protected float[] angle_axis;
    protected float[] face_vertices;
    protected float mAngle;
    protected FloatBuffer mNormalVertexBuffer;
    protected float[] mOffset;
    protected float[] mScale;
    protected ArrayList<FloatBuffer> mTextureBuffers;
    protected FloatBuffer mVertexBuffer;
    protected float max_angle;
    protected float min_angle;
    protected float[] normal_vertices;
    protected float step_value;

    public Cube(float n, float n2, float n3, float n4, float n5, float n6) {
        this.mScale = new float[]{0.0f, 0.0f, 0.0f};
        this.mOffset = new float[]{0.0f, 0.0f, 0.0f};
        this.mAngle = 0.0f;
        this.step_value = -0.15f;
        this.max_angle = 3.0f;
        this.min_angle = -3.0f;
        this.angle_axis = new float[]{0.0f, 0.0f, 0.0f};
        this.face_vertices = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.normal_vertices = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, -1.0f};
        this.mTextureBuffers = new ArrayList();
        this.mScale[0] = n;
        this.mScale[1] = n2;
        this.mScale[2] = n3;
        this.mOffset[0] = n4;
        this.mOffset[1] = n5;
        this.mOffset[2] = n6;
        for (int i = 0; i < 24; i++) {
            this.face_vertices[i * 3] = (this.face_vertices[i * 3] * this.mScale[0]) / 2.0f;
            this.face_vertices[(i * 3) + 1] = (this.face_vertices[(i * 3) + 1] * this.mScale[1]) / 2.0f;
            this.face_vertices[(i * 3) + 2] = (this.face_vertices[(i * 3) + 2] * this.mScale[2]) / 2.0f;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.face_vertices.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mVertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.face_vertices);
        this.mVertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.normal_vertices.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.mNormalVertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.normal_vertices);
        this.mNormalVertexBuffer.position(0);
    }

    public Cube(float n, float n2, float n3, float n4, float n5, float n6, float step_value, float n7, float n8, float n9, float max_angle, float min_angle) {
        this(n, n2, n3, n4, n5, n6);
        this.step_value = step_value;
        this.max_angle = max_angle;
        this.min_angle = min_angle;
        this.angle_axis[0] = n7;
        this.angle_axis[1] = n8;
        this.angle_axis[2] = n9;
    }

    public FloatBuffer AddTextures(float[] array) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(array.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = allocateDirect.asFloatBuffer();
        floatBuffer.put(array);
        floatBuffer.position(0);
        this.mTextureBuffers.add(floatBuffer);
        return floatBuffer;
    }

    public void ClearAllTextures() {
        this.mTextureBuffers.clear();
    }

    public void draw(GL10 gl10, boolean b) {
        gl10.glEnable(3042);
        gl10.glBlendFunc(1, 771);
        gl10.glEnableClientState(32884);
        gl10.glEnableClientState(32885);
        gl10.glEnableClientState(32888);
        gl10.glVertexPointer(3, 5126, 0, this.mVertexBuffer);
        gl10.glNormalPointer(5126, 0, this.mNormalVertexBuffer);
        gl10.glPushMatrix();
        gl10.glTranslatef(this.mOffset[0], this.mOffset[1], this.mOffset[2]);
        if (b) {
            gl10.glRotatef(this.mAngle, this.angle_axis[0], this.angle_axis[1], this.angle_axis[2]);
            this.mAngle += this.step_value;
            if (this.mAngle >= this.max_angle) {
                this.step_value *= -1.0f;
                this.mAngle = this.max_angle;
            } else if (this.mAngle <= this.min_angle) {
                this.step_value *= -1.0f;
                this.mAngle = this.min_angle;
            }
        }
        for (int i = 0; i < this.mTextureBuffers.size(); i++) {
            gl10.glTexCoordPointer(2, 5126, 0, (Buffer) this.mTextureBuffers.get(i));
            for (int j = 0; j < 6; j++) {
                gl10.glDrawArrays(6, j * 4, 4);
            }
        }
        gl10.glPopMatrix();
        gl10.glDisable(3042);
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
    }

    public void setZeroRun() {
        this.mAngle = 0.0f;
        this.step_value = -0.15f;
        this.max_angle = 3.0f;
        this.min_angle = -3.0f;
    }
}
