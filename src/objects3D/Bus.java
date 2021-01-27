package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Utils;

public class Bus {

	// basic colours
		static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

		static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
		static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

		// primary colours
		static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
		static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
		static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

		// secondary colours
		static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
		static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
		static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

		// other colours
		static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
		static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
		static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
		static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };
		
		public Bus() {
			
		}
		
		
		public void DrawBus(float delta,boolean GoodAnimation, Texture text1) { 
			
			float theta = (float) (delta * 2 * Math.PI);
			float LimbRotation;	  
			float limb ;
			float limb2;	
			float limb3;
			float limbA;
			float limbB;
				 
			if (GoodAnimation) {
				LimbRotation = (float) Math.cos(theta)*45;
				limbA = (float) (Math.cos(delta * 0.2 * Math.PI));
				limbB = (float) (Math.sin(delta * 0.4 * Math.PI));
				limb = (float) (Math.sin(delta * 0.2 * Math.PI)*25);
				limb2 = (float) (Math.sin(delta * 0.2 * Math.PI)*45);
				limb3 = (float) (Math.sin(delta * 0.2 * Math.PI)*120);
			}else {
				LimbRotation =0;
				limb = 0;
				limb2 = 0;
				limb3 = 0;
				limbA = 0;
				limbB = 0;
			} 
				 
			Sphere sphere= new Sphere();
			Cylinder cylinder= new Cylinder();
			TexSphere texsphere = new TexSphere();
			TexCube texcube = new TexCube();
			Cube cube = new Cube();
				  
			GL11.glColor3f(white[0], white[1], white[2]);
			GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
			GL11.glPushMatrix();{
				
		   		GL11.glScalef(1, 1.5f, 1.5f);
				cube.DrawCube();
				
				//Window1
				GL11.glColor4f(cyan[0], cyan[1], cyan[2], 0.5f);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(cyan));
				GL11.glPushMatrix();{
					
//					GL11.glTexParameteri(
//							GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_S,
//							GL11.GL_CLAMP);
//
//							Color.white.bind();
//							text1.bind();
//							GL11.glEnable(GL11.GL_TEXTURE_2D);
//							GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
//							GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.5f);
					
					GL11.glTranslatef(-0.5f, 0.15f, -0.98f);
//					GL11.glRotatef(90.0f, 1.0f, 0, 0);
					GL11.glScalef(0.5f, 0.5f, 0.05f);
					texcube.DrawTexCube();
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					
				GL11.glPopMatrix();}
				
				//Window2
				GL11.glColor4f(cyan[0], cyan[1], cyan[2], 0.5f);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(cyan));
				GL11.glPushMatrix();{
					
//					GL11.glTexParameteri(
//							GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_S,
//							GL11.GL_CLAMP);
//
//							Color.white.bind();
//							text1.bind();
//							GL11.glEnable(GL11.GL_TEXTURE_2D);
//							GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
//							GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.5f);
					
					GL11.glTranslatef(-1f, 0.15f, 0);
//					GL11.glRotatef(90.0f, 1.0f, 0, 0);
					GL11.glScalef(0.05f, 0.5f, 1f);
					texcube.DrawTexCube();
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					
				GL11.glPopMatrix();}
				
				//Window3
				GL11.glColor4f(cyan[0], cyan[1], cyan[2], 0.5f);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(cyan));
				GL11.glPushMatrix();{
					
//					GL11.glTexParameteri(
//							GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_S,
//							GL11.GL_CLAMP);
//
//							Color.white.bind();
//							text1.bind();
//							GL11.glEnable(GL11.GL_TEXTURE_2D);
//							GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
//							GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.5f);
					
					GL11.glTranslatef(5.25f, 0.15f, -0.98f);
//					GL11.glRotatef(90.0f, 1.0f, 0, 0);
					GL11.glScalef(2f, 0.5f, 0.05f);
					texcube.DrawTexCube();
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					
				GL11.glPopMatrix();}
				
				//Window4
				GL11.glColor4f(cyan[0], cyan[1], cyan[2], 0.5f);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(cyan));
				GL11.glPushMatrix();{
					
//					GL11.glTexParameteri(
//							GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_S,
//							GL11.GL_CLAMP);
//
//							Color.white.bind();
//							text1.bind();
//							GL11.glEnable(GL11.GL_TEXTURE_2D);
//							GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
//							GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.5f);
					
					GL11.glTranslatef(7.5f, 0.15f, 0);
//					GL11.glRotatef(90.0f, 1.0f, 0, 0);
					GL11.glScalef(0.05f, 0.5f, 1f);
					texcube.DrawTexCube();
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					
				GL11.glPopMatrix();}
				
				GL11.glColor3f(white[0], white[1], white[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
				GL11.glPushMatrix();{
					
					GL11.glTranslatef(2f, -0.95f,0);
					GL11.glScalef(1, 0.05f, 1);
					cube.DrawCube();
				
				GL11.glPopMatrix();}
				
				GL11.glColor3f(white[0], white[1], white[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
				GL11.glPushMatrix();{
					
					GL11.glTranslatef(2f, 0.95f,0);
					GL11.glScalef(1f, 0.05f, 1);
					cube.DrawCube();
				
				GL11.glPopMatrix();}
				
				GL11.glColor3f(white[0], white[1], white[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
				GL11.glPushMatrix();{
					
					GL11.glTranslatef(1.75f, 0,1);
					GL11.glScalef(0.8f, 1, 0.05f);
					cube.DrawCube();
				
				GL11.glPopMatrix();}
				
				//Bus Door 1
				GL11.glColor3f(orange[0], orange[1], orange[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
				GL11.glPushMatrix();{
					
					GL11.glTranslatef(1.1f, 0,-1);
					GL11.glRotatef(90.0f, 1.0f, 0, 0);
					GL11.glScalef(1, 2/3f, 1);
					if (delta >= 0 && delta < 2.5) {
						GL11.glRotatef(limbA*90.0f - 90.0f, 0, 0, 1.0f);
					}else if (delta >= 2.5 && delta < 5) {
						GL11.glRotatef(-90.0f, 0, 0, 1.0f);
					}else if (delta >= 5 && delta < 7.5) {
						GL11.glRotatef(limbA * 90.0f, 0, 0, 1.0f);
					}
					
					cylinder.DrawCylinder(0.1f, 1.8f, 32);

					GL11.glColor4f(cyan[0], cyan[1], cyan[2], 0.5f);
					GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(cyan));
					GL11.glPushMatrix();{
						
//						GL11.glTexParameteri(
//								GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_S,
//								GL11.GL_CLAMP);
//
//								Color.white.bind();
//								text1.bind();
//								GL11.glEnable(GL11.GL_TEXTURE_2D);
//								GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
//								GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
						
						GL11.glTranslatef(0.4f, 0,0);
						GL11.glRotatef(90.0f, 1.0f, 0, 0);
						GL11.glScalef(0.3f, 0.9f, 0.05f);
						texcube.DrawTexCube();
						GL11.glDisable(GL11.GL_TEXTURE_2D);
						
					GL11.glPopMatrix();}
				
				GL11.glPopMatrix();}
				
				//Bus Door 2
				GL11.glColor3f(orange[0], orange[1], orange[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
				GL11.glPushMatrix();{
					
					GL11.glTranslatef(2.5f, 0,-1);
					GL11.glRotatef(90.0f, 1.0f, 0, 0);
					GL11.glScalef(1, 2/3f, 1);
					if (delta >= 0 && delta < 2.5) {
						GL11.glRotatef(90.0f - limbA*90.0f , 0, 0, 1.0f);
					}else if (delta >= 2.5 && delta < 5) {
						GL11.glRotatef(90.0f, 0, 0, 1.0f);
					}else if (delta >= 5 && delta < 7.5) {
						GL11.glRotatef(-limbA * 90.0f, 0, 0, 1.0f);
					}
					
					cylinder.DrawCylinder(0.1f, 1.8f, 32);
					
					GL11.glColor4f(cyan[0], cyan[1], cyan[2], 0.5f);
					GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(cyan));
					GL11.glPushMatrix();{
						
//						GL11.glTexParameteri(
//								GL11.GL_TEXTURE_2D, 	GL11.GL_TEXTURE_WRAP_S,
//								GL11.GL_CLAMP);
//
//								Color.white.bind();
//								text1.bind();
//								GL11.glEnable(GL11.GL_TEXTURE_2D);
//								GL11.glTexParameteri( GL11.GL_TEXTURE_2D,  GL11.GL_TEXTURE_MAG_FILTER,  GL11.GL_NEAREST);
						
						GL11.glTranslatef(-0.4f, 0,0);
						GL11.glRotatef(90.0f, 1.0f, 0, 0);
						GL11.glScalef(0.3f, 0.9f, 0.05f);
						texcube.DrawTexCube();
						GL11.glDisable(GL11.GL_TEXTURE_2D);
					
					GL11.glPopMatrix();}
				
				GL11.glPopMatrix();}
				
				GL11.glColor3f(white[0], white[1], white[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(white));
				GL11.glPushMatrix();{
					
					GL11.glTranslatef(5f, 0,0);
					GL11.glScalef(2.5f, 1, 1);
					cube.DrawCube();
				
				GL11.glPopMatrix();}
				
				//wheels
				GL11.glColor3f(black[0], black[1], black[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
				GL11.glPushMatrix();{
					
					GL11.glScalef(1, 2/3f, 1);
					GL11.glTranslatef(0, -1.4f, -1);
					cylinder.DrawCylinder(0.7f, 0.3f, 32);
					
				GL11.glPopMatrix();}
				
				GL11.glColor3f(black[0], black[1], black[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
				GL11.glPushMatrix();{
					
					GL11.glScalef(1, 2/3f, 1);
					GL11.glTranslatef(0, -1.4f, 1);
					cylinder.DrawCylinder(0.7f, 0.3f, 32);
					
				GL11.glPopMatrix();}
				
				GL11.glColor3f(black[0], black[1], black[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
				GL11.glPushMatrix();{
					
					GL11.glScalef(1, 2/3f, 1);
					GL11.glTranslatef(6, -1.4f, -1);
					cylinder.DrawCylinder(0.7f, 0.3f, 32);
					
				GL11.glPopMatrix();}
				
				GL11.glColor3f(black[0], black[1], black[2]);
				GL11.glMaterial(  GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(black));
				GL11.glPushMatrix();{
					
					GL11.glScalef(1, 2/3f, 1);
					GL11.glTranslatef(6, -1.4f, 1);
					cylinder.DrawCylinder(0.7f, 0.3f, 32);
					
				GL11.glPopMatrix();}
		   			 
			GL11.glPopMatrix();}
				     
		}
	
}
