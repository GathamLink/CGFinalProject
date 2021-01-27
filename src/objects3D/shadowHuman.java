package objects3D;

import GraphicsObjects.Utils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class shadowHuman {

    // basic colours
    static float black[] = {0.0f, 0.0f, 0.0f, 1.0f};
    static float white[] = {1.0f, 1.0f, 1.0f, 1.0f};

    static float grey[] = {0.5f, 0.5f, 0.5f, 1.0f};
    static float spot[] = {0.1f, 0.1f, 0.1f, 0.5f};

    // primary colours
    static float red[] = {1.0f, 0.0f, 0.0f, 1.0f};
    static float green[] = {0.0f, 1.0f, 0.0f, 1.0f};
    static float blue[] = {0.0f, 0.0f, 1.0f, 1.0f};

    // secondary colours
    static float yellow[] = {1.0f, 1.0f, 0.0f, 1.0f};
    static float magenta[] = {1.0f, 0.0f, 1.0f, 1.0f};
    static float cyan[] = {0.0f, 1.0f, 1.0f, 1.0f};

    // other colours
    static float orange[] = {1.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    static float brown[] = {0.5f, 0.25f, 0.0f, 1.0f, 1.0f};
    static float dkgreen[] = {0.0f, 0.5f, 0.0f, 1.0f, 1.0f};
    static float pink[] = {1.0f, 0.6f, 0.6f, 1.0f, 1.0f};


    public shadowHuman() {

    }

    // Implement using notes  in Animation lecture
    public void DrawHuman(float delta, float bustime, float trashtime, boolean movement, boolean bus, boolean trash, boolean bar, Texture text1, Texture text2) {
        float theta = (float) (delta * 2 * Math.PI);
        float LimbRotation;
        float limb;
        float limb2;
        float limb3;
        float limbA;
        float limbB;
        float limbD;
        if (movement) {
            LimbRotation = (float) Math.cos(theta) * 45;
            limbA = (float) (Math.sin(delta * 0.2 * Math.PI));
            limb2 = (float) (Math.sin(delta * 0.2 * Math.PI) * 45);
            limb3 = (float) (Math.sin(delta * 0.2 * Math.PI) * 120);
        } else {
            LimbRotation = 0;
            limb2 = 0;
            limb3 = 0;
            limbA = 0;
        }

        float beta = (float) (bustime * 2 * Math.PI);
        if (bus) {
            limb = (float) Math.sin(bustime * 0.8 * Math.PI);
        } else {
            limb = 0;
        }

        if (trash) {
            limbD = (float) Math.sin(delta * 2 * Math.PI);
        } else {
            limbD = 0;
        }

        if (bar) {
            limbB = (float) Math.sin(delta * 0.2 * Math.PI);
        } else {
            limbB = 0;
        }

        //There classes are used to implement 3D objects that are already realized
        Sphere sphere = new Sphere();
        Cylinder cylinder = new Cylinder();
        TexSphere texsphere = new TexSphere();
        TexCube texcube = new TexCube();

        //here is the pelvis of this human
        //the animation here is used to make human jump up and down when run
        GL11.glColor3f(black[0], black[1], black[2]);
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
        GL11.glPushMatrix();
        if (trash) {
            if (limbD > 0) {
                GL11.glTranslatef(0, limbD * 50 / 165, 0);
            } else {
                GL11.glTranslatef(0, -limbD * 50 / 165, 0);
            }
        }
        if (bar) {
            GL11.glTranslatef(0, -limbB , 0);
            if (limbB > 0) {
                GL11.glTranslatef( 0, 0, (float) (-limbB ));
            } else {
                GL11.glTranslatef( 0, 0, (float) (limbB ));
            }

        }
        {
            GL11.glTranslatef(0.0f, 0.0f, 0.0f);
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            sphere.DrawSphere(0.5f, 32, 32);
            //  chest
            GL11.glColor3f(black[0], black[1], black[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
            GL11.glPushMatrix();
            {
                GL11.glTranslatef(0.0f, 0.0f, -0.6f);
                GL11.glRotatef(-180.0f, 1.0f, 0.0f, 0.0f);
                sphere.DrawSphere(0.5f, 32, 32);


                // neck
                GL11.glColor3f(black[0], black[1], black[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                GL11.glPushMatrix();
                {
                    GL11.glTranslatef(0.0f, 0.0f, 0.28f);

                    GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
                    cylinder.DrawCylinder(0.15f, 1.0f, 32);


                    // head
                    GL11.glColor3f(black[0], black[1], black[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.0f, 0.0f, 0.68f);
                        if (bustime >= 2.5 && bustime <7.5) {
                            GL11.glRotatef(limb * 40, 0, 0,1.0f);
                        }
                        sphere.DrawSphere(0.45f, 32, 32);


                        //hat
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.0f, 0.3f, 0.0f);
                            sphere.DrawSphere(0.35f, 32, 32);
                            GL11.glPopMatrix();
                        }


                        //right eye
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.2f, 0.15f, -0.35f);
                            sphere.DrawSphere(0.12f, 32.0f, 32.0f);

                            //eyeball
                            GL11.glColor3f(black[0], black[1], black[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                            GL11.glPushMatrix();
                            {
                                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                GL11.glTranslatef(0.0f, -0.09f, 0.0f);
                                sphere.DrawSphere(0.05f, 32.0f, 32.0f);
                                GL11.glPopMatrix();
                            }

                            GL11.glPopMatrix();
                        }


                        //left eye
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(-0.2f, 0.15f, -0.35f);
                            sphere.DrawSphere(0.12f, 32.0f, 32.0f);

                            //eyeball
                            GL11.glColor3f(black[0], black[1], black[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                            GL11.glPushMatrix();
                            {
                                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                GL11.glTranslatef(0.0f, -0.09f, 0.0f);
                                sphere.DrawSphere(0.05f, 32.0f, 32.0f);
                                GL11.glPopMatrix();
                            }

                            GL11.glPopMatrix();
                        }

                        //nose
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.0f, 0.0f, -0.45f);
                            sphere.DrawSphere(0.1f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        //mouth 1
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.2f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.06f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        //mouth2
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.1f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.08f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        //mouth3
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(0.0f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.09f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        //mouth 4
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(-0.2f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.06f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }

                        //mouth5
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            GL11.glTranslatef(-0.1f, -0.22f, -0.35f);
                            sphere.DrawSphere(0.08f, 32.0f, 32.0f);
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();


                    // left shoulder
                    /*
                     * here I add an animation to let the left arm of human to wave when human is runnning
                     * the LimbRotation is the changeable variable to define the wave angle
                     */
                    GL11.glColor3f(black[0], black[1], black[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.65f, 0.0f, 0.33f);
                        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                        if (trash) {
                            GL11.glRotatef(limbD * 70.0f + 70.0f, 0.0f, 0.0f, 1.0f);
                        }
                        if (bar) {
                            GL11.glRotatef(limbB * 90 + 90, 1.0f, 0, 0);
                        }

                        GL11.glRotatef(LimbRotation, 1.0f, 0.0f, 0.0f);
                        sphere.DrawSphere(0.28f, 32, 32);


                        // left arm
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            cylinder.DrawCylinder(0.12f, 1.0f, 32);


                            // left elbow
                            GL11.glColor3f(black[0], black[1], black[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.35f);
                                if (bar) {
                                    if (limbB < 0) {
                                        GL11.glRotatef(-limbB * 120, 1.0f, 0, 0);
                                    }
                                }
                                sphere.DrawSphere(0.2f, 32, 32);

                                //left forearm
                                GL11.glColor3f(black[0], black[1], black[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                                    GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
//		                                GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
                                    cylinder.DrawCylinder(0.1f, 0.8f, 32);

                                    // left hand
                                    GL11.glColor3f(black[0], black[1], black[2]);
                                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                                    GL11.glPushMatrix();
                                    {
                                        GL11.glTranslatef(0.0f, 0.0f, 0.35f);
                                        sphere.DrawSphere(0.2f, 32, 32);

                                    }
                                    GL11.glPopMatrix();
                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                    // to chest

                    // right shoulder
                    /*
                     * like left arm, I also add a animation to right arm in the same way
                     */
                    GL11.glColor3f(black[0], black[1], black[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(-0.65f, 0.0f, 0.33f);
                        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                        if (trash) {
                            GL11.glRotatef(-limbD * 70.0f - 70.0f, 0.0f, 0.0f, 1.0f);
                        }
                        if (bar) {
                            GL11.glRotatef(limbB * 90 + 90, 1.0f, 0, 0);
                        }
                        GL11.glRotatef(-LimbRotation, 1.0f, 0.0f, 0.0f);
                        sphere.DrawSphere(0.28f, 32, 32);

                        // right arm
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, -0.5f, 0.0f);
                            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                            cylinder.DrawCylinder(0.12f, 1.0f, 32);

                            // right elbow
                            GL11.glColor3f(black[0], black[1], black[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.35f);
                                if (bar) {
                                    if (limbB < 0) {
                                        GL11.glRotatef(-limbB * 120, 1.0f, 0, 0);
                                    }
                                }
                                sphere.DrawSphere(0.2f, 32, 32);

                                //right forearm
                                GL11.glColor3f(black[0], black[1], black[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                                    GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
                                    //   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
                                    cylinder.DrawCylinder(0.1f, 0.8f, 32);

                                    // right hand
                                    GL11.glColor3f(black[0], black[1], black[2]);
                                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                                    GL11.glPushMatrix();
                                    {
                                        GL11.glTranslatef(0.0f, 0.0f, 0.35f);
                                        sphere.DrawSphere(0.2f, 32, 32);
                                    }
                                    GL11.glPopMatrix();
                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();

                    //chest


                }
                GL11.glPopMatrix();


                // right hip
                GL11.glColor3f(black[0], black[1], black[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                GL11.glPushMatrix();
                {
                    GL11.glTranslatef(-0.3f, 0.0f, 0.4f);
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
//                    if (delta < 10) {
                    if (LimbRotation > 0) {
                        GL11.glRotatef((LimbRotation) + 90, 1.0f, 0.0f, 0.0f);
                    } else {
                        GL11.glRotatef((LimbRotation / 2) + 90, 1.0f, 0.0f, 0.0f);
                    }
                    if (trash) {
                        GL11.glRotatef((limbD * 50), 1.0f, 0.0f, 0.0f);
                    }

                    cylinder.DrawCylinder(0.22f, 0.45f, 32);


                    // right high leg
                    GL11.glColor3f(black[0], black[1], black[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.0f, 0.0f, 0.4f);
                        GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
                        cylinder.DrawCylinder(0.15f, 1.0f, 32);


                        // right knee
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                            GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
//                            if (delta < 10) {
                            if (LimbRotation > 0) {
                                GL11.glRotatef(-LimbRotation, 1.0f, 0.0f, 0.0f);
                            } else {
                                GL11.glRotatef(LimbRotation / 2, 1.0f, 0.0f, 0.0f);
                            }
                            sphere.DrawSphere(0.25f, 32, 32);

                            //right low leg
                            GL11.glColor3f(black[0], black[1], black[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.45f);
                                GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);

                                cylinder.DrawCylinder(0.15f, 0.7f, 32);

                                // right foot
                                GL11.glColor3f(black[0], black[1], black[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, -0.05f, 0.4f);
                                    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                    cylinder.DrawCylinder(0.2f, 0.45f, 32);

                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                }
                GL11.glPopMatrix();


                // left hip
                GL11.glColor3f(black[0], black[1], black[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                GL11.glPushMatrix();
                {
                    GL11.glTranslatef(0.3f, 0.0f, 0.4f);
                    GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
//                    if (delta < 10) {
                    if (LimbRotation > 0) {
                        GL11.glRotatef((-LimbRotation / 2) + 90, 1.0f, 0.0f, 0.0f);
                    } else {
                        GL11.glRotatef((-LimbRotation) + 90, 1.0f, 0.0f, 0.0f);
                    }
                    if (trash) {
                        GL11.glRotatef(-(limbD * 50), 1.0f, 0.0f, 0.0f);
                    }
                    cylinder.DrawCylinder(0.22f, 0.45f, 32);
                    // left high leg
                    GL11.glColor3f(black[0], black[1], black[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                    GL11.glPushMatrix();
                    {
                        GL11.glTranslatef(0.0f, 0.0f, 0.4f);
                        GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
                        cylinder.DrawCylinder(0.15f, 1.0f, 32);


                        // left knee
                        GL11.glColor3f(black[0], black[1], black[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(0.0f, 0.0f, 0.5f);
                            GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f);
//                            if (delta < 10) {
                            if (LimbRotation > 0) {
                                GL11.glRotatef(-LimbRotation / 2, 1.0f, 0.0f, 0.0f);
                            } else {
                                GL11.glRotatef(LimbRotation, 1.0f, 0.0f, 0.0f);
                            }
                            sphere.DrawSphere(0.25f, 32, 32);

                            //left low leg
                            GL11.glColor3f(black[0], black[1], black[2]);
                            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(0.0f, 0.0f, 0.45f);
                                GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);

                                cylinder.DrawCylinder(0.15f, 0.7f, 32);

                                // left foot
                                GL11.glColor3f(black[0], black[1], black[2]);
                                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                                GL11.glPushMatrix();
                                {
                                    GL11.glTranslatef(0.0f, -0.05f, 0.4f);
                                    GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
                                    cylinder.DrawCylinder(0.2f, 0.45f, 32);

                                }
                                GL11.glPopMatrix();
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                }
                GL11.glPopMatrix();


            }
            GL11.glPopMatrix();

        }


    }


}


