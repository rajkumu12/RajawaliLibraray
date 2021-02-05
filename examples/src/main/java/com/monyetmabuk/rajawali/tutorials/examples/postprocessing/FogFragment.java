 package com.monyetmabuk.rajawali.tutorials.examples.postprocessing;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.monyetmabuk.rajawali.tutorials.R;
import com.monyetmabuk.rajawali.tutorials.examples.AExampleFragment;

import org.rajawali3d.Object3D;
import org.rajawali3d.animation.Animation;
import org.rajawali3d.animation.TranslateAnimation3D;
import org.rajawali3d.cameras.ArcballCamera;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.plugins.FogMaterialPlugin;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;

public class FogFragment extends AExampleFragment {

	@Override
    public AExampleRenderer createRenderer() {
		return new FogRenderer(getActivity());
	}

	private final class FogRenderer extends AExampleRenderer {
		private DirectionalLight mLight;
		private Object3D mRoad, mroad1;

		public FogRenderer(Context context) {
			super(context);
		}

        @Override
		protected void initScene() {
			mLight = new DirectionalLight(0, -1, -1);
			mLight.setPower(.5f);

			getCurrentScene().addLight(mLight);

			int fogColor = 0x999999;
			getCurrentScene().setBackgroundColor(R.drawable.galaxy);
			/*getCurrentScene().setFog(new FogMaterialPlugin.FogParams(FogMaterialPlugin.FogType.LINEAR, fogColor, 1, 15));*/

		/*	LoaderOBJ objParser = new LoaderOBJ(mContext.getResources(),
					mTextureManager, R.raw.road);
			try {
				objParser.parse();
				mRoad = objParser.getParsedObject();
				mRoad.setZ(5);
				mRoad.setRotY(180);
				Log.d("hgfdkhfghkdgf","position"+mRoad.getPosition()+"hwp"+mRoad.getWorldPosition()+"Sce"+mRoad.getScenePosition());

				getCurrentScene().addChild(mRoad);

				for (int i=0;i<mRoad.getNumChildren();i++){
					Log.d("jhdjsahfdkjha","jkf"+mRoad.getChildAt(i).getName());
				}

				Material roadMaterial = new Material();
				roadMaterial.enableLighting(true);
				roadMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
				roadMaterial.addTexture(new Texture("roadTex", R.drawable.road));
				roadMaterial.setColorInfluence(0);
				mRoad.getChildByName("Road").setMaterial(roadMaterial);

				Material signMaterial = new Material();
				signMaterial.enableLighting(true);
				signMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
				signMaterial.addTexture(new Texture("rajawaliSign", R.drawable.sign));
				signMaterial.setColorInfluence(0);
				mRoad.getChildByName("WarningSign").setMaterial(signMaterial);

				Material warningMaterial = new Material();
				warningMaterial.enableLighting(true);
				warningMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
				warningMaterial.addTexture(new Texture("warning", R.drawable.warning));
				warningMaterial.setColorInfluence(0);
				mRoad.getChildByName("Warning").setMaterial(warningMaterial);
			} catch (Exception e) {
				e.printStackTrace();
			}*/

			LoaderOBJ objParser1 = new LoaderOBJ(mContext.getResources(),
					mTextureManager, R.raw.moooooo);
			try {
				objParser1.parse();
				mroad1 = objParser1.getParsedObject();

				mroad1.setZ(-30);

				mroad1.setRotY(180);

				Log.d("hgfdkhfghkdgf","position"+mroad1.getPosition()+"hwp"+mroad1.getWorldPosition()+"Sce"+mroad1.getScenePosition());
				getCurrentScene().addChild(mroad1);

				for (int i=0;i<mroad1.getNumChildren();i++){
					Log.d("jhdjsahfdkjha","jkf"+mroad1.getChildAt(i).getName());
				}

			/*	Material roadMaterial = new Material();
				roadMaterial.enableLighting(true);
				roadMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
				roadMaterial.addTexture(new Texture("roadTex", R.drawable.sun));
				roadMaterial.setColorInfluence(0);
				mroad1.getChildByName("default").setMaterial(roadMaterial);*/

				Material signMaterial = new Material();
				signMaterial.enableLighting(true);
				signMaterial.setDiffuseMethod(new DiffuseMethod.Lambert());
				signMaterial.addTexture(new Texture("rajawaliSign", R.drawable.earth_normal));
				signMaterial.setColorInfluence(0);
				mroad1.getChildByName("Sphere001").setMaterial(signMaterial);

			} catch (Exception e) {
				e.printStackTrace();
			}
			ArcballCamera arcball = new ArcballCamera(mContext, ((Activity)mContext).findViewById(R.id.drawer_layout));
			arcball.setPosition(5, 5, 5);
			getCurrentScene().replaceAndSwitchCamera(getCurrentCamera(), arcball);
			/*TranslateAnimation3D camAnim = new TranslateAnimation3D(
					new Vector3(0, 2, 0),
					new Vector3(0, 2, -23));
			camAnim.setDurationMilliseconds(8000);
			camAnim.setInterpolator(new AccelerateDecelerateInterpolator());
			camAnim.setRepeatMode(Animation.RepeatMode.REVERSE_INFINITE);
			camAnim.setTransformable3D(getCurrentCamera());

			Log.d("cmmmmmmmmmm",""+getCurrentCamera().getFieldOfView());
			getCurrentScene().registerAnimation(camAnim);
			camAnim.play();*/


		}
	}
}
