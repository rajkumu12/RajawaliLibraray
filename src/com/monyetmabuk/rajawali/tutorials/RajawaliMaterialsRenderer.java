package com.monyetmabuk.rajawali.tutorials;

import java.io.ObjectInputStream;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import rajawali.BaseObject3D;
import rajawali.SerializedObject3D;
import rajawali.lights.DirectionalLight;
import rajawali.materials.CubeMapMaterial;
import rajawali.materials.DiffuseMaterial;
import rajawali.materials.GouraudMaterial;
import rajawali.materials.PhongMaterial;
import rajawali.renderer.RajawaliRenderer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class RajawaliMaterialsRenderer extends RajawaliRenderer {
	private DirectionalLight mLight;
	private BaseObject3D mMonkey1, mMonkey2, mMonkey3, mMonkey4;
	private boolean mSceneInitialized;
	
	public RajawaliMaterialsRenderer(Context context) {
		super(context);
		setFrameRate(60);
		mClearChildren = false;
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		((RajawaliExampleActivity)mContext).showLoader();
		
		if (!mSceneInitialized) {
			mLight = new DirectionalLight(0, 0, 1);
			mLight.setPosition(-2, -2, -5);
			mCamera.setPosition(0, 0, -7);
			
			try {
				ObjectInputStream ois = new ObjectInputStream(mContext.getResources().openRawResource(R.raw.monkey_ser));
				SerializedObject3D serializedMonkey = (SerializedObject3D)ois.readObject();
				ois.close();
				
				mMonkey1 = new BaseObject3D(serializedMonkey);
				mMonkey1.setLight(mLight);
				mMonkey1.setScale(.7f);
				mMonkey1.setPosition(-1, 1, 0);
				mMonkey1.setRotY(0);
				addChild(mMonkey1);
				
				mMonkey2 = mMonkey1.clone();
				mMonkey2.setLight(mLight);
				mMonkey2.setScale(.7f);
				mMonkey2.setPosition(1, 1, 0);
				mMonkey2.setRotY(45);
				addChild(mMonkey2);
				
				mMonkey3 = mMonkey1.clone();
				mMonkey3.setLight(mLight);
				mMonkey3.setScale(.7f);
				mMonkey3.setPosition(-1, -1, 0);
				mMonkey3.setRotY(90);
				addChild(mMonkey3);

				mMonkey4 = mMonkey1.clone();
				mMonkey4.setLight(mLight);
				mMonkey4.setScale(.7f);
				mMonkey4.setPosition(1, -1, 0);
				mMonkey4.setRotY(135);
				addChild(mMonkey4);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			startRendering();

			mSceneInitialized = true;
		}
		
		mMonkey1.setMaterial(new DiffuseMaterial());
		mMonkey1.getMaterial().setUseColor(true);
		mMonkey1.setColor(0xff00ff00);
		
		mMonkey2.setMaterial(new GouraudMaterial());
		mMonkey2.getMaterial().setUseColor(true);
		mMonkey2.setColor(0xff999900);
		
		mMonkey3.setMaterial(new PhongMaterial());
		mMonkey3.getMaterial().setUseColor(true);
		mMonkey3.setColor(0xff00ff00);
		
		Bitmap[] textures = new Bitmap[6];
		textures[0] = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.posx);
		textures[1] = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.negx);
		textures[2] = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.posy);
		textures[3] = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.negy);
		textures[4] = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.posz);
		textures[5] = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.negz);
		
		mMonkey4.setMaterial(new CubeMapMaterial());
		mMonkey4.addTexture(mTextureManager.addCubemapTextures(textures));
		
        ((RajawaliExampleActivity)mContext).hideLoader();
	}
	
	public void onDrawFrame(GL10 glUnused) {
		super.onDrawFrame(glUnused);
		mMonkey1.setRotY(mMonkey1.getRotY() - 1f);		
		mMonkey2.setRotY(mMonkey2.getRotY() + 1f);
		mMonkey3.setRotY(mMonkey3.getRotY() - 1f);		
		mMonkey4.setRotY(mMonkey4.getRotY() + 1f);
	}
}
