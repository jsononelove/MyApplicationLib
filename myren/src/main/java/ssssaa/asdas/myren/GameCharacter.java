package ssssaa.asdas.myren;

import android.graphics.Bitmap;

import javax.microedition.khronos.opengles.GL10;

//import ssssaa.asdas.a3dskin.utils.BodyPart;

public class GameCharacter {
    private boolean isAlexSkin;
    private boolean isRunning;
    private AlexLArm mAlexLArm;
    private AlexLArmOverlay mAlexLArmOverlay;
    private AlexRArm mAlexRArm;
    private AlexRArmOverlay mAlexRArmOverlay;
    private Body mBody;
    private BodyOverlay mBodyOverlay;
    private boolean mBodyOverlayVisible;
    private boolean mBodyVisible;
    private Hat mHat;
    private boolean mHatVisible;
    private Head mHead;
    private boolean mHeadVisible;
    private LArm mLArm;
    private LArmOverlay mLArmOverlay;
    private boolean mLArmOverlayVisible;
    private boolean mLArmVisible;
    private LLeg mLLeg;
    private LLegOverlay mLLegOverlay;
    private boolean mLLegOverlayVisible;
    private boolean mLLegVisible;
    private RArm mRArm;
    private RArmOverlay mRArmOverlay;
    private boolean mRArmOverlayVisible;
    private boolean mRArmVisible;
    private RLeg mRLeg;
    private RLegOverlay mRLegOverlay;
    private boolean mRLegOverlayVisible;
    private boolean mRLegVisible;
    private float[] mRotate;
    private float[] rotate_step;
    public Bitmap selected_resource;

    public GameCharacter(Bitmap bitmap) {
        this.isRunning = false;
        this.isAlexSkin = false;
        this.mHeadVisible = true;
        this.mHatVisible = true;
        this.mBodyVisible = true;
        this.mBodyOverlayVisible = true;
        this.mLArmVisible = true;
        this.mRArmVisible = true;
        this.mLArmOverlayVisible = true;
        this.mRArmOverlayVisible = true;
        this.mLLegVisible = true;
        this.mRLegVisible = true;
        this.mLLegOverlayVisible = true;
        this.mRLegOverlayVisible = true;
        this.mRotate = new float[]{0.0f, 0.0f, 0.0f};
        this.rotate_step = new float[]{5.0f, 5.0f, 5.0f};
        this.selected_resource = bitmap;
        this.mHead = new Head();
        this.mHat = new Hat();
        this.mBody = new Body();
        this.mBodyOverlay = new BodyOverlay();
        this.mLArm = new LArm();
        this.mRArm = new RArm();
        this.mLArmOverlay = new LArmOverlay();
        this.mRArmOverlay = new RArmOverlay();
        this.mLLeg = new LLeg();
        this.mRLeg = new RLeg();
        this.mLLegOverlay = new LLegOverlay();
        this.mRLegOverlay = new RLegOverlay();
    }

//    public void hideBodyPart(BodyPart bodyPart) {
//        if (bodyPart == BodyPart.BODY) {
//            this.mBodyVisible = false;
//        }
//        if (bodyPart == BodyPart.HAT) {
//            this.mHatVisible = false;
//        }
//        if (bodyPart == BodyPart.HEAD) {
//            this.mHeadVisible = false;
//        }
//        if (bodyPart == BodyPart.JACKET) {
//            this.mBodyOverlayVisible = false;
//        }
//        if (bodyPart == BodyPart.LEFT_ARM) {
//            this.mLArmVisible = false;
//        }
//        if (bodyPart == BodyPart.RIGHT_ARM) {
//            this.mRArmVisible = false;
//        }
//        if (bodyPart == BodyPart.LEFT_LEG) {
//            this.mLLegVisible = false;
//        }
//        if (bodyPart == BodyPart.RIGHT_LEG) {
//            this.mRLegVisible = false;
//        }
//        if (bodyPart == BodyPart.LEFT_SLEEVE) {
//            this.mLArmOverlayVisible = false;
//        }
//        if (bodyPart == BodyPart.RIGHT_SLEEVE) {
//            this.mRArmOverlayVisible = false;
//        }
//        if (bodyPart == BodyPart.LEFT_LEG_OVERLAY) {
//            this.mLLegOverlayVisible = false;
//        }
//        if (bodyPart == BodyPart.RIGHT_LEG_OVERLAY) {
//            this.mRLegOverlayVisible = false;
//        }
//    }

    public void showAllBodyParts() {
        this.mHeadVisible = true;
        this.mHatVisible = true;
        this.mBodyVisible = true;
        this.mBodyOverlayVisible = true;
        this.mLArmVisible = true;
        this.mRArmVisible = true;
        this.mLArmOverlayVisible = true;
        this.mRArmOverlayVisible = true;
        this.mLLegVisible = true;
        this.mRLegVisible = true;
        this.mLLegOverlayVisible = true;
        this.mRLegOverlayVisible = true;
    }

    public GameCharacter(boolean z, Bitmap bitmap, boolean old) {
        this.isRunning = false;
        this.isAlexSkin = false;
        this.mHeadVisible = true;
        this.mHatVisible = true;
        this.mBodyVisible = true;
        this.mBodyOverlayVisible = true;
        this.mLArmVisible = true;
        this.mRArmVisible = true;
        this.mLArmOverlayVisible = true;
        this.mRArmOverlayVisible = true;
        this.mLLegVisible = true;
        this.mRLegVisible = true;
        this.mLLegOverlayVisible = true;
        this.mRLegOverlayVisible = true;
        this.mRotate = new float[]{0.0f, 0.0f, 0.0f};
        this.rotate_step = new float[]{5.0f, 5.0f, 5.0f};
        this.selected_resource = bitmap;
        if (z) {
            if (old){
                this.mHead = new Head();
                this.mHat = new Hat();
                this.mBody = new Body();
                this.mBodyOverlay = new BodyOverlay();
                this.mAlexLArm = new AlexLArm(true);
                this.mAlexRArm = new AlexRArm();
                this.mAlexLArmOverlay = new AlexLArmOverlay();
                this.mAlexRArmOverlay = new AlexRArmOverlay();
                this.mLLeg = new LLeg(true);
                this.mRLeg = new RLeg();
                this.mLLegOverlay = new LLegOverlay();
                this.mRLegOverlay = new RLegOverlay();
                return;
            }
            this.mHead = new Head();
            this.mHat = new Hat();
            this.mBody = new Body();
            this.mBodyOverlay = new BodyOverlay();
            this.mAlexLArm = new AlexLArm();
            this.mAlexRArm = new AlexRArm();
            this.mAlexLArmOverlay = new AlexLArmOverlay();
            this.mAlexRArmOverlay = new AlexRArmOverlay();
            this.mLLeg = new LLeg();
            this.mRLeg = new RLeg();
            this.mLLegOverlay = new LLegOverlay();
            this.mRLegOverlay = new RLegOverlay();
            return;
        }
        if (old){
            this.mHead = new Head();
            this.mHat = new Hat();
            this.mBody = new Body();
            this.mBodyOverlay = new BodyOverlay();
            this.mLArm = new LArm(true);
            this.mRArm = new RArm();
            this.mLArmOverlay = new LArmOverlay();
            this.mRArmOverlay = new RArmOverlay();
            this.mLLeg = new LLeg(true);
            this.mRLeg = new RLeg();
            this.mLLegOverlay = new LLegOverlay();
            this.mRLegOverlay = new RLegOverlay();
            return;
        }
        this.mHead = new Head();
        this.mHat = new Hat();
        this.mBody = new Body();
        this.mBodyOverlay = new BodyOverlay();
        this.mLArm = new LArm();
        this.mRArm = new RArm();
        this.mLArmOverlay = new LArmOverlay();
        this.mRArmOverlay = new RArmOverlay();
        this.mLLeg = new LLeg();
        this.mRLeg = new RLeg();
        this.mLLegOverlay = new LLegOverlay();
        this.mRLegOverlay = new RLegOverlay();
    }

    public GameCharacter() {
        this.isRunning = false;
        this.isAlexSkin = false;
        this.mHeadVisible = true;
        this.mHatVisible = true;
        this.mBodyVisible = true;
        this.mBodyOverlayVisible = true;
        this.mLArmVisible = true;
        this.mRArmVisible = true;
        this.mLArmOverlayVisible = true;
        this.mRArmOverlayVisible = true;
        this.mLLegVisible = true;
        this.mRLegVisible = true;
        this.mLLegOverlayVisible = true;
        this.mRLegOverlayVisible = true;
        this.mRotate = new float[]{0.0f, 0.0f, 0.0f};
        this.rotate_step = new float[]{5.0f, 5.0f, 5.0f};
        this.mHead = new Head();
        this.mHat = new Hat();
        this.mBody = new Body();
        this.mBodyOverlay = new BodyOverlay();
        this.mLArm = new LArm();
        this.mRArm = new RArm();
        this.mLArmOverlay = new LArmOverlay();
        this.mRArmOverlay = new RArmOverlay();
        this.mLLeg = new LLeg();
        this.mRLeg = new RLeg();
        this.mLLegOverlay = new LLegOverlay();
        this.mRLegOverlay = new RLegOverlay();
    }

    public GameCharacter(boolean z) {
        this.isRunning = false;
        this.isAlexSkin = false;
        this.mHeadVisible = true;
        this.mHatVisible = true;
        this.mBodyVisible = true;
        this.mBodyOverlayVisible = true;
        this.mLArmVisible = true;
        this.mRArmVisible = true;
        this.mLArmOverlayVisible = true;
        this.mRArmOverlayVisible = true;
        this.mLLegVisible = true;
        this.mRLegVisible = true;
        this.mLLegOverlayVisible = true;
        this.mRLegOverlayVisible = true;
        this.mRotate = new float[]{0.0f, 0.0f, 0.0f};
        this.rotate_step = new float[]{5.0f, 5.0f, 5.0f};
        if (z) {
            this.mHead = new Head();
            this.mHat = new Hat();
            this.mBody = new Body();
            this.mBodyOverlay = new BodyOverlay();
            this.mAlexLArm = new AlexLArm();
            this.mAlexRArm = new AlexRArm();
            this.mAlexLArmOverlay = new AlexLArmOverlay();
            this.mAlexRArmOverlay = new AlexRArmOverlay();
            this.mLLeg = new LLeg();
            this.mRLeg = new RLeg();
            this.mLLegOverlay = new LLegOverlay();
            this.mRLegOverlay = new RLegOverlay();
            return;
        }
        this.mHead = new Head();
        this.mHat = new Hat();
        this.mBody = new Body();
        this.mBodyOverlay = new BodyOverlay();
        this.mLArm = new LArm();
        this.mRArm = new RArm();
        this.mLArmOverlay = new LArmOverlay();
        this.mRArmOverlay = new RArmOverlay();
        this.mLLeg = new LLeg();
        this.mRLeg = new RLeg();
        this.mLLegOverlay = new LLegOverlay();
        this.mRLegOverlay = new RLegOverlay();
    }

    public void draw(GL10 gl10) {
        gl10.glMatrixMode(5888);
        gl10.glRotatef(this.mRotate[0], 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.mRotate[1], 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.mRotate[2], 0.0f, 0.0f, 1.0f);
        if (this.mBodyVisible) {
            this.mBody.draw(gl10, this.isRunning);
        }
        if (this.mHeadVisible) {
            this.mHead.draw(gl10, this.isRunning);
        }
        if (this.mLLegVisible) {
            this.mLLeg.draw(gl10, this.isRunning);
        }
        if (this.mRLegVisible) {
            this.mRLeg.draw(gl10, this.isRunning);
        }
        if (this.mRArm != null) {
            if (this.mLArmVisible) {
                this.mLArm.draw(gl10, this.isRunning);
            }
            if (this.mRArmVisible) {
                this.mRArm.draw(gl10, this.isRunning);
            }
            if (this.mHatVisible) {
                this.mHat.draw(gl10, this.isRunning);
            }
            if (this.mLArmOverlayVisible) {
                this.mLArmOverlay.draw(gl10, this.isRunning);
            }
            if (this.mRArmOverlayVisible) {
                this.mRArmOverlay.draw(gl10, this.isRunning);
            }
        } else {
            if (this.mLArmVisible) {
                this.mAlexLArm.draw(gl10, this.isRunning);
            }
            if (this.mRArmVisible) {
                this.mAlexRArm.draw(gl10, this.isRunning);
            }
            if (this.mHatVisible) {
                this.mHat.draw(gl10, this.isRunning);
            }
            if (this.mLArmOverlayVisible) {
                this.mAlexLArmOverlay.draw(gl10, this.isRunning);
            }
            if (this.mRArmOverlayVisible) {
                this.mAlexRArmOverlay.draw(gl10, this.isRunning);
            }
        }
        if (this.mLLegOverlayVisible) {
            this.mLLegOverlay.draw(gl10, this.isRunning);
        }
        if (this.mRLegOverlayVisible) {
            this.mRLegOverlay.draw(gl10, this.isRunning);
        }
        if (this.mBodyOverlayVisible) {
            this.mBodyOverlay.draw(gl10, this.isRunning);
        }
    }

    public void SetRotate(float f, float f2, float f3) {
        this.mRotate[0] = f;
        this.mRotate[1] = f2;
        this.mRotate[2] = f3;
    }

    public float getXRotation() {
        return this.mRotate[0];
    }

    public float getYRotation() {
        return this.mRotate[1];
    }

    public float getZRotation() {
        return this.mRotate[2];
    }

    public void setXRotation(int i) {
        this.mRotate[0] = (float) i;
    }

    public void setYRotation(int i) {
        this.mRotate[1] = (float) i;
    }

    public void setZRotation(int i) {
        this.mRotate[2] = (float) i;
    }

    public void SetRotateStep(float f, float f2) {
        if (Math.abs(f) >= 1.0f) {
            float[] fArr = this.mRotate;
            fArr[1] = fArr[1] + ((this.rotate_step[1] * Math.signum(f)) * 2.0f);
        }
        if (Math.abs(f2) >= 1.0f) {
            float[] fArr2 = this.mRotate;
            fArr2[0] = fArr2[0] + ((this.rotate_step[0] * Math.signum(f2)) * 2.0f);
        }
    }

    public void SetRunning(boolean z) {
        this.isRunning = z;
    }
}
