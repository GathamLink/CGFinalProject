import java.io.IOException;
import java.nio.FloatBuffer;

import objects3D.*;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import objects3D.Aix;

//Main windows class controls and creates the 3D virtual world , please do not change this class but edit the other classes to complete the assignment. 
// Main window is built upon the standard Helloworld LWJGL class which I have heavily modified to use as your standard openGL environment. 
// 

// Do not touch this class, I will be making a version of it for your 3rd Assignment 
public class MainWindow {

    // basic colours
    static float[] black = {0.0f, 0.0f, 0.0f, 1.0f};
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
    static float[] pink = {1.0f, 0.6f, 0.6f, 1.0f, 1.0f};
    /**
     * position of pointer
     */
    float x = 0, y = 0;
    /**
     * angle of rotation
     */
    float rotation = 0;
    /**
     * time at last frame
     */
    long lastFrame;
    /**
     * frames per second
     */
    int fps;
    /**
     * last fps time
     */
    long lastFPS;
    long myDelta = 0; //to use for animation
    float Alpha = 0; //to use for animation
    long StartTime; // beginAnimiation
    Arcball MyArcball = new Arcball();
    boolean DRAWGRID = false;
    boolean waitForKeyrelease = true;
    /**
     * Mouse movement
     */
    int LastMouseX = -1;
    int LastMouseY = -1;
    float pullX = 0.0f; // arc ball  X cord.
    float pullY = 0.0f; // arc ball  Y cord.
    int OrthoNumber = 2000; // using this for screen size, making a window of 1200 x 800 so aspect ratio 3:2 // do not change this for assignment 3 but you can change everything for your project
    /**
     * these variables are used to record the texture picture
     */
    Texture texture;
    Texture texture1;
    Texture texture2;
    Texture texture3;

    // static GLfloat light_position[] = {0.0, 100.0, 100.0, 0.0};

    //support method to aid in converting a java float array into a Floatbuffer which is faster for the opengl layer to process
    Texture texture4;
    Texture texture5;
    Texture texture6;
    Texture texture7;
    Texture texture8;
    Texture texture9;
    Texture texture10;
    Texture sigma1;
    Texture sigma2;
    Texture sigma3;
    Texture sigma4;
    Texture sigma5;
    Texture sigma6;
    Texture sigma7;
    Texture sigma8;
    Texture sigma9;
    Texture sigma10;
    Texture sigma11;
    Texture sigma12;
    Texture sigma13;
    Texture sigma14;
    Texture sigma15;
    Texture sigma16;
    Texture sigma17;
    private boolean MouseOnepressed = true;
    private boolean dragMode = false;
    private boolean BadAnimation = false;
    private boolean Earth = false;
    private boolean bustime = false;
    private boolean trashtime = false;
    private boolean bartime = false;

    int move = 0;
    int direction  = 0;
    int jump = 0;
    int limit = 0;
    long bus = 0;
    long trash = 0;
    long btime;
    long ttime;

    public static void main(String[] argv) {
        MainWindow hello = new MainWindow();
        hello.start();
    }

    public void start() {

        StartTime = getTime();
        try {
            Display.setDisplayMode(new DisplayMode(1200, 800));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        initGL(); // init OpenGL
        getDelta(); // call once before loop to initialise lastFrame
        lastFPS = getTime(); // call before loop to initialise fps timer

        while (!Display.isCloseRequested()) {
            int delta = getDelta();
            update(delta);
            renderGL();
            Display.update();
            Display.sync(120); // cap fps to 120fps
        }

        Display.destroy();
    }

    public void update(int delta) {
        // rotate quad
        //rotation += 0.01f * delta;


        int MouseX = Mouse.getX();
        int MouseY = Mouse.getY();
        int WheelPostion = Mouse.getDWheel();


        boolean MouseButonPressed = Mouse.isButtonDown(0);


//		  if(MouseButonPressed && !MouseOnepressed )
//		  {
//			  MouseOnepressed =true;
////			  System.out.println("Mouse drag mode" + MouseX + " ," + MouseY);
//			  MyArcball.startBall( MouseX, MouseY, 1200, 800);
//			  dragMode=true;
//
//
//		  }else if( !MouseButonPressed)
//		  {
//				// System.out.println("Mouse drag mode end ");
//			  MouseOnepressed =false;
//			  dragMode=false;
//		  }
////
//		  if(dragMode)
//		  {
////			  System.out.println("Mouse drag mode" + MouseX + " ," + MouseY);
//			  MyArcball.updateBall( MouseX  , MouseY  , 1200, 800);
//		  }

//		  if(WheelPostion>0)
//		  {
//			  OrthoNumber += 10;
//			  System.out.println("Orth nubmer = " +  OrthoNumber);
//		  }
//
//		  if(WheelPostion<0)
//		  {
//			  OrthoNumber -= 10;
//			  if( OrthoNumber<610)
//			  {
//				  OrthoNumber=610;
//			  }
//
//			  System.out.println("Orth nubmer = " +  OrthoNumber);
//
//		  }

        /** rest key is R*/
        if (Keyboard.isKeyDown(Keyboard.KEY_R)){
            MyArcball.reset();
            initGL();
        }


        /* bad animation can be turn on or off using A key)*/

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
//			BadAnimation=!BadAnimation;
//			StartTime = getTime();
            x -= 0.35f * delta;
            direction = 0;
			move = 1;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            x += 0.35f * delta;
            direction = 1;
            move = 2;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_W)){
            y += 0.35f * delta;
            direction = 2;
            move = 3;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_S)){
            y -= 0.35f * delta;
            direction = 3;
            move = 4;
        } else {
		    move = 0;
        }

//        System.out.println("X " + x + " Y " + jump + " Z " + y);

		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            jump += 0.5f*delta;
            if (jump > 80) {
                limit = 1;
                jump = 80;
            }
            if (limit == 1) {
                jump -= 1f*delta;
            }
            if (jump <= 0) {
                jump = 0;
                limit = 0;
            }
        }

        if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            jump -= 0.5f*delta;
            if (jump <= 0) {
                jump = 0;
                limit = 0;
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
            if (move == 1) {
                x -= 10;
            }
            if (move == 2) {
                x += 10;
            }
            if (move == 3) {
                y += 10;
            }
            if (move == 4) {
                y -= 10;
            }
        }

		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
            rotation += 0.35f * delta;
        if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
            Earth = !Earth;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_B)) {
            if (x >= 1000 && x <= 1200) {
                if (y >= 440 && y <= 500) {
                    bustime = true;
                    bus = getTime();
                }
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_T)) {
            if (x>=-1080 && x<=-740) {
                if (y >= 30 && y <= 110) {
                    trashtime = true;
                    trash = getTime();
                    OrthoNumber = 1600;
                }
            }
        }
        if (!Keyboard.isKeyDown(Keyboard.KEY_T)) {
            if (x>=-1080 && x<=-740) {
                if (y >= 30 && y <= 110) {
                    trashtime = false;
                    OrthoNumber = 2000;
                }
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_U)) {
            if (x>=1670 && x<=1900) {
                if (y >= -85 && y <= 20) {
                    bartime = true;
                    OrthoNumber = 1600;
                }
            }

        }
        if (!Keyboard.isKeyDown(Keyboard.KEY_U)) {
            if (x>=1670 && x<=1900) {
                if (y >= -85 && y <= 20) {
                    bartime = false;
                    OrthoNumber = 2000;
                }
            }
        }

        if (waitForKeyrelease) // check done to see if key is released
        {
            if (Keyboard.isKeyDown(Keyboard.KEY_G)) {

                DRAWGRID = !DRAWGRID;
                Keyboard.next();
                if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
                    waitForKeyrelease = true;
                } else {
                    waitForKeyrelease = false;

                }
            }
        }

        /** to check if key is released */
        if (Keyboard.isKeyDown(Keyboard.KEY_G) == false) {
            waitForKeyrelease = true;
        } else {
            waitForKeyrelease = false;

        }


        // keep quad on the screen
        if (x < -1200)
            x = -1200;
        if (x > 2000)
            x = 2000;
        if (y < -1000)
            y = -1000;
        if (y > 500)
            y = 500;

        updateFPS(); // update FPS Counter

        LastMouseX = MouseX;
        LastMouseY = MouseY;
    }

    /**
     * Calculate how many milliseconds have passed since last frame.
     *
     * @return milliseconds passed since last frame
     */
    public int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;
    }

    /**
     * Get the accurate system time
     *
     * @return The system time in milliseconds
     */
    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    /**
     * Calculate the FPS and set it in the title bar
     */
    public void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

    public void initGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        changeOrth();

        MyArcball.startBall(600, 400, 1200, 800);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
        lightPos.put(600).put(300).put(1100).put(0).flip();

        FloatBuffer lightPos2 = BufferUtils.createFloatBuffer(4);
        lightPos2.put(600).put(0).put(2000).put(0).flip();

        FloatBuffer lightPos3 = BufferUtils.createFloatBuffer(4);
        lightPos3.put(-720f).put(400f).put(-260).put(1).flip();

        FloatBuffer lightPos4 = BufferUtils.createFloatBuffer(4);
        lightPos4.put(1000f).put(1000f).put(1000f).put(0).flip();

        FloatBuffer lightPos5 = BufferUtils.createFloatBuffer(4);
        lightPos5.put(1920).put(1000).put(1000).put(1).flip();
//
        FloatBuffer lightPos6 = BufferUtils.createFloatBuffer(4);
        lightPos6.put(-740).put(1000).put(1000).put(1).flip();

//
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, lightPos); // specify the
        // position
        // of the
        // light
        GL11.glEnable(GL11.GL_LIGHT1); // switch light #0 on
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, Utils.ConvertForGL(white));
//
        GL11.glLight(GL11.GL_LIGHT2, GL11.GL_POSITION, lightPos2); // specify
        // the
        // position
        // of the
        // light
        GL11.glEnable(GL11.GL_LIGHT2); // switch light #0 on
        GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, Utils.ConvertForGL(white));

        GL11.glLight(GL11.GL_LIGHT3, GL11.GL_POSITION, lightPos6); // specify
        // the
        // position
        // of the
        // light
        GL11.glEnable(GL11.GL_LIGHT3); // switch light #0 on
        GL11.glLight(GL11.GL_LIGHT3, GL11.GL_DIFFUSE, Utils.ConvertForGL(yellow));

        GL11.glLight(GL11.GL_LIGHT4, GL11.GL_POSITION, lightPos5);
        GL11.glEnable(GL11.GL_LIGHT4);
        GL11.glLight(GL11.GL_LIGHT4, GL11.GL_DIFFUSE, Utils.ConvertForGL(yellow));

        GL11.glLight(GL11.GL_LIGHT5, GL11.GL_POSITION, lightPos3);
        GL11.glEnable(GL11.GL_LIGHT5);
        GL11.glLight(GL11.GL_LIGHT5, GL11.GL_DIFFUSE, Utils.ConvertForGL(pink));

        GL11.glEnable(GL11.GL_LIGHTING); // switch lighting on
        GL11.glEnable(GL11.GL_DEPTH_TEST); // make sure depth buffer is switched
        // on
        GL11.glEnable(GL11.GL_NORMALIZE); // normalize normal vectors for safety
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        try {
            init();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //load in texture


    }

    public void changeOrth() {

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(1200 - OrthoNumber, OrthoNumber, (800 - (OrthoNumber * 0.66f)), (OrthoNumber * 0.66f), 100000, -100000);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        FloatBuffer CurrentMatrix = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, CurrentMatrix);



        MyArcball.getMatrix(CurrentMatrix);

        GL11.glLoadMatrix(CurrentMatrix);

    }

    /*
     * You can edit this method to add in your own objects /  remember to load in textures in the INIT method as they take time to load
     *
     */
    public void renderGL() {
        changeOrth();
        GLU.gluLookAt(0, -200, 1000, x, 200+jump, -500+y, 0, 1, 0);

        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor3f(0.5f, 0.5f, 1.0f);

        myDelta = getTime() - StartTime;
        float delta = ((float) myDelta) / 5000;

        btime = getTime() - bus;
        float actbus = ((float) btime) / 5000;

        ttime = getTime() - trash;
        float acttrash = ((float) ttime) / 5000;

        // code to aid in animation
        float theta = (float) (delta * 2 * Math.PI);
        float thetaDeg = delta * 360;
        float posn_x = (float) Math.cos(theta); // same as your circle code in your notes
        float posn_y = (float) Math.sin(theta);

        float alpha = (float) (acttrash * 2 * Math.PI);



        // human character is drawed here
        GL11.glPushMatrix();
        Human MyHuman = new Human();

        if (x>=-1080 && x<=-740) {
            if (y >= 30 && y <= 110) {
                if (trashtime) {
                    direction = 2;
                }
            }
        }

        if (x >= 1000 && x <= 1200) {
            if (y >= 440 && y <= 500) {
                if (bustime) {
                    direction = 2;
                }
            }
        }

        if (x>=1670 && x<=1900) {
            if (y >= -85 && y <= 20) {
                if (bartime) {
                    GL11.glTranslatef(1920, 380, -650);
                    direction = 1;
                }else {
                    GL11.glTranslatef(200 + x, 200+jump, -500 + 3 * y);
                }
            } else {
                GL11.glTranslatef(200+x, 200+jump, -500+3*y);
            }
        } else {
            GL11.glTranslatef(200+x, 200+jump, -500+3*y);
        }
//        System.out.println("X " + (200+x) + " Y " + (200+jump) + " Z " + (-500 + 3*y));

        GL11.glScalef(90f, 90f, 90f);
        GL11.glRotatef(90, 0, 1.0f, 0);
        if (direction == 0) {
            GL11.glRotatef(0, 0, 1.0f, 0);
        }
        if (direction == 1) {
            GL11.glRotatef(180, 0, 1.0f, 0);
        }
        if (direction == 2) {
            GL11.glRotatef(90f, 0, 1.0f, 0);
        }
        if (direction == 3) {
            GL11.glRotatef(-90, 0, 1.0f, 0);
        }
        Boolean movement = true;
        if (move == 0) {
            movement = false;
        }

        MyHuman.DrawHuman(delta * 10, actbus * 10, acttrash * 10, movement, bustime, trashtime, bartime,texture1, texture2); // give a delta for the Human object ot be animated

        GL11.glPopMatrix();


        GL11.glPushMatrix();
        {
            Bus bus = new Bus();
            GL11.glTranslatef(950, 400, 1600);
            GL11.glScalef(200, 200, 200);
            if (bustime) {
                if (actbus * 10 >= 10) {
                    GL11.glTranslatef(-(actbus - 1) * 28.8f, 0, 0);
                }
            }
            bus.DrawBus(actbus * 10, bustime, texture7);
            GL11.glPopMatrix();
        }


        GL11.glPushMatrix();{
            Cube dance = new Cube();
            Cylinder arm = new Cylinder();
            Sphere elbow = new Sphere();
            GL11.glColor3f(grey[0], grey[1], grey[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
            GL11.glTranslatef(-720, 200, 0);
            GL11.glScalef(200, 400, 50);
            dance.DrawCube();

            GL11.glPushMatrix();{
                GL11.glColor3f(grey[0], grey[1], grey[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
                GL11.glTranslatef(0,-0.3f,-1);
                GL11.glScalef(1, 0.4f, 1);
                dance.DrawCube();

                GL11.glPopMatrix();
            }
            GL11.glPushMatrix();{
                GL11.glColor3f(white[0], white[1], white[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                GL11.glTranslatef(0, 1f, -3);
                GL11.glScalef(1, 0.01f, 2);
                dance.DrawCube();

                GL11.glPopMatrix();
            }
            GL11.glPushMatrix();{
                TexCube screen = new TexCube();
                GL11.glColor3f(white[0], white[1], white[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                GL11.glColor3f(black[0], black[1], black[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
                GL11.glTexParameteri(
                        GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                        GL11.GL_CLAMP);

                Color.white.bind();
                    int animation = (int) (delta * 50);
                    if (animation % 17 == 0){
                        sigma1.bind();
                    } else if (animation % 17 == 1) {
                        sigma2.bind();
                    } else if (animation % 17 == 2) {
                        sigma3.bind();
                    } else if (animation % 17 == 3) {
                        sigma4.bind();
                    } else if (animation % 17 == 4) {
                        sigma5.bind();
                    } else if (animation % 17 == 5) {
                        sigma6.bind();
                    } else if (animation % 17 == 6) {
                        sigma7.bind();
                    } else if (animation % 17 == 7) {
                        sigma8.bind();
                    } else if (animation % 17 == 8) {
                        sigma9.bind();
                    } else if (animation % 17 == 9) {
                        sigma10.bind();
                    } else if (animation % 17 == 10) {
                        sigma11.bind();
                    } else if (animation % 17 == 11) {
                        sigma12.bind();
                    } else if (animation % 17 == 12) {
                        sigma13.bind();
                    } else if (animation % 17 == 13) {
                        sigma14.bind();
                    } else if (animation % 17 == 14) {
                        sigma15.bind();
                    } else if (animation % 17 == 15) {
                        sigma16.bind();
                    } else if (animation % 17 == 16) {
                        sigma17.bind();
                    }

                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glTranslatef(0,0.5f,-1.0f);
                GL11.glScalef(0.8f, 0.4f, 0.2f);
                GL11.glRotatef(180, 0, 0,1);
                screen.DrawTexCube();
                GL11.glDisable(GL11.GL_TEXTURE_2D);

                GL11.glPopMatrix();
            }
            GL11.glPushMatrix();{
                GL11.glColor3f(orange[0], orange[1], orange[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
                GL11.glTranslatef(1.0f,0.7f,0f);
                GL11.glScalef(0.2f, 0.1f, 0.8f);
                if (trashtime) {
                    GL11.glRotatef((float) (Math.sin(theta * 8) * 70), 0,0, 1.0f);
                    GL11.glRotatef((float) (Math.sin(theta * 4) * 50), 0,1.0f, 0f);
                    GL11.glRotatef((float) (Math.sin(theta * 3) * 35), 1.0f,0, 0f);
                }
                elbow.DrawSphere(1.0f, 32, 32);


                GL11.glPushMatrix();{
                    GL11.glColor3f(orange[0], orange[1], orange[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
                    GL11.glRotatef(90f, 0, 1.0f, 0);
                    GL11.glTranslatef(0f, 0f, 1.7f);
                    arm.DrawCylinder(0.6f, 5f, 32);

                    GL11.glPushMatrix();{
                        GL11.glColor3f(white[0], white[1], white[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                        GL11.glTranslatef(0,0f,2.5f);
                        elbow.DrawSphere(0.9f, 32, 32);

                        GL11.glPopMatrix();
                    }

                    GL11.glPopMatrix();
                }

                GL11.glPopMatrix();
            }

            GL11.glPushMatrix();{
                GL11.glColor3f(orange[0], orange[1], orange[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
                GL11.glTranslatef(-1.0f,0.7f,0f);
                GL11.glScalef(0.2f, 0.1f, 0.8f);
                if (trashtime) {
                    GL11.glRotatef(-(float) (Math.sin(theta * 8) * 70), 0,0, 1.0f);
                    GL11.glRotatef((float) (Math.sin(theta * 4) * 50), 0,1.0f, 0f);
                    GL11.glRotatef((float) (Math.sin(theta * 3) * 35), 1.0f,0, 0f);
                }
                elbow.DrawSphere(1.0f, 32, 32);

                GL11.glPushMatrix();{
                    GL11.glColor3f(orange[0], orange[1], orange[2]);
                    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(orange));
                    GL11.glRotatef(-90f, 0, 1.0f, 0);
                    GL11.glTranslatef(0f, 0f, 1.7f);
                    arm.DrawCylinder(0.6f, 5f, 32);

                    GL11.glPushMatrix();{
                        GL11.glColor3f(white[0], white[1], white[2]);
                        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(white));
                        GL11.glTranslatef(0,0f,2.5f);
                        elbow.DrawSphere(0.9f, 32, 32);

                        GL11.glPopMatrix();
                    }

                    GL11.glPopMatrix();
                }

                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();{
            TexCube dance2 = new TexCube();
            GL11.glColor3f(black[0], black[1], black[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(black));
            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                    GL11.GL_CLAMP);

            Color.white.bind();
            texture9.bind();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(-720, 0, -300);
            GL11.glScalef(200, 10, 200);
            dance2.DrawTexCube();
            GL11.glPopMatrix();
        }

        //the texture cube is drawed here
        GL11.glPushMatrix();
        {
            TexCube cube = new TexCube();
            GL11.glTranslatef(600, -20, 0);
            GL11.glScalef(2000f, 10f, 1200f);

            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                    GL11.GL_CLAMP);

            Color.white.bind();
            texture3.bind();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

            cube.DrawTexCube();
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            TexCube cube2 = new TexCube();
            GL11.glTranslatef(600, -20, -2400);
            GL11.glScalef(2000f, 10f, 1200f);

            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                    GL11.GL_CLAMP);

            Color.white.bind();
            texture6.bind();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

            cube2.DrawTexCube();
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            TexCube road = new TexCube();
            GL11.glTranslatef(600, -20, 1800);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0);
            GL11.glScalef(600f, 10f, 3600f);
            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                    GL11.GL_CLAMP);

            Color.white.bind();
            texture5.bind();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

            road.DrawTexCube();
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glPopMatrix();
        }

        //background1
        GL11.glPushMatrix();
        {
            TexCube back = new TexCube();
            GL11.glTranslatef(600, 1000, 2800);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0);
            GL11.glRotatef(180.0f, 1.0f, 0, 0.0f);
            GL11.glScalef(10f, 1000f, 3600f);
            GL11.glTexParameteri(
                    GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                    GL11.GL_CLAMP);

            Color.white.bind();
            texture2.bind();
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

            back.DrawTexCube();
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            Cube back = new Cube();

            GL11.glColor3f(grey[0], grey[1], grey[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
            GL11.glTranslatef(600, 0, 2400);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0);
            GL11.glRotatef(180.0f, 1.0f, 0, 0.0f);
            GL11.glScalef(100f, 100f, 3600f);

            back.DrawCube();
            GL11.glPopMatrix();
        }

        //Advertisement
        GL11.glPushMatrix();
        {
            TexCube advT = new TexCube();
            Cube adv = new Cube();

            GL11.glColor3f(grey[0], grey[1], grey[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
            GL11.glTranslatef(590, 0, 975);
            GL11.glScalef(200, 20, 40);
            adv.DrawCube();

            GL11.glPushMatrix();
            {
                GL11.glColor4f(grey[0], grey[1], grey[2], 0.5f);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
                GL11.glTranslatef(0, 10, 0);
                GL11.glScalef(0.8f, 10, 0.4f);
                adv.DrawCube();
                GL11.glPopMatrix();
            }


            //Texture
            GL11.glPushMatrix();
            {
                GL11.glColor3f(grey[0], grey[1], grey[2]);
                GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(grey));
                GL11.glTranslatef(0, 10, -0.5f);
                GL11.glRotatef(180, 0, 0, 1.0f);
                GL11.glScalef(0.8f, 9, 0.05f);
                GL11.glTexParameteri(
                        GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S,
                        GL11.GL_CLAMP);

                Color.white.bind();
                int advertise = (int) (delta * 3);
                if ( advertise % 4 == 1) {
                    texture10.bind();
                } else if ( advertise % 4 == 2) {
                    texture9.bind();
                } else if ( advertise % 4 ==3) {
                    texture2.bind();
                } else if ( advertise % 4 == 0) {
                    texture4.bind();
                }

                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

                advT.DrawTexCube();
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();{
            shadowHuman shadow = new shadowHuman();
            if (x>=-1080 && x<=-740) {
                if (y >= 30 && y <= 110) {
                    if (trashtime) {
                        GL11.glTranslatef(-720, 10, -460);
                        direction = 2;
//                    System.out.println("X " + (200+x) + " Y " + (200+jump) + " Z " + (-500 + 3*y));
                    } else {
                        GL11.glTranslatef(200+x, 10, -700+3*y-jump);
                    }
                } else {
                    GL11.glTranslatef(200+x, 10, -700+3*y-jump);
                }
            } else {
                GL11.glTranslatef(200+x, 10, -700+3*y-jump);
            }
            GL11.glScalef(90f, 5f, 90f);
            GL11.glRotatef(180, 0, 1.0f, 0);

            GL11.glRotatef(90, 1.0f, 0, 0);
            if (direction == 0) {
                GL11.glRotatef(-90, 0, 1.0f, 0);
            }
            if (direction == 1) {
                GL11.glRotatef(90, 0, 1.0f, 0);
            }
            if (direction == 2) {
                GL11.glRotatef(0f, 0, 1.0f, 0);
            }
            if (direction == 3) {
                GL11.glRotatef(180, 0, 1.0f, 0);
            }
            GL11.glColor3f(black[0], black[1], black[2]);
            shadow.DrawHuman(delta * 10, actbus * 10, acttrash * 10,movement, bustime, trashtime, bartime,texture1, texture2);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();{
            Cylinder bar1 = new Cylinder();
            GL11.glColor3f(blue[0], blue[1], blue[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
            GL11.glTranslatef(2050, 250, -400);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            GL11.glScalef(0.8f, 0.8f, 5.5f);
            bar1.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();{
            Cylinder bar2 = new Cylinder();
            GL11.glColor3f(blue[0], blue[1], blue[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(blue));
            GL11.glTranslatef(2050, 250, -900);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            GL11.glScalef(0.8f, 0.8f, 5.5f);
            bar2.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();{
            Cylinder bar3 = new Cylinder();
            GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
            GL11.glTranslatef(2050, 500, -650);
            GL11.glScalef(0.5f, 0.5f, 5.0f);
            bar3.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }


        GL11.glPushMatrix();
        {
            Cylinder light = new Cylinder();
            GL11.glColor3f(brown[0], brown[1], brown[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(brown));
            GL11.glTranslatef(-740, 280, 975);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            GL11.glScalef(0.5f, 0.5f, 6.0f);
            light.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            Cylinder light2 = new Cylinder();
            GL11.glColor3f(brown[0], brown[1], brown[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(brown));
            GL11.glTranslatef(1920, 280, 975);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            GL11.glScalef(0.5f, 0.5f, 6.0f);
            light2.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            Sphere light3 = new Sphere();
            GL11.glColor4f(yellow[0], yellow[1], yellow[2], (float) 0.8);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
            GL11.glTranslatef(1920, 610, 975);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            light3.DrawSphere(50, 32, 32);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            Sphere light4 = new Sphere();
            GL11.glColor4f(yellow[0], yellow[1], yellow[2], (float) 0.8);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(yellow));
            GL11.glTranslatef(-740, 610, 975);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            light4.DrawSphere(50, 32, 32);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            Cylinder bottom = new Cylinder();
            GL11.glColor3f(brown[0], brown[1], brown[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(brown));
            GL11.glTranslatef(1920, 0, 975);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            GL11.glScalef(3f, 3f, 0.3f);
            bottom.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }

        GL11.glPushMatrix();
        {
            Cylinder bottom2 = new Cylinder();
            GL11.glColor3f(brown[0], brown[1], brown[2]);
            GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, Utils.ConvertForGL(brown));
            GL11.glTranslatef(-740, 0, 975);
            GL11.glRotatef(90.0f, 1.0f, 0, 0);
            GL11.glScalef(3f, 3f, 0.3f);
            bottom2.DrawCylinder(30.0f, 100.0f, 32);
            GL11.glPopMatrix();
        }

        /*
         * This code puts the earth code in which is larger than the human so it appears to change the scene
         */

    }

    /**
     * Any additional textures for your assignment should be written in here.
     * Make a new texture variable for each one so they can be loaded in at the beginning
     */
    public void init() throws IOException {

        texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/earthspace.png"));
        texture1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/shirt.png"));
        texture2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/building.png"));
        texture3 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/street.png"));
        texture4 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/Care.png"));
        texture5 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/road.png"));
        texture6 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/rawstreet.png"));
        texture7 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/window.png"));
        texture8 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/shadow.png"));
        texture9 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/dance.png"));
        texture10 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/overwatch.png"));
        sigma1= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma001.png"));
        sigma2= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma003.png"));
        sigma3= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma005.png"));
        sigma4= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma007.png"));
        sigma5= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma009.png"));
        sigma6= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma011.png"));
        sigma7= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma013.png"));
        sigma8= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma015.png"));
        sigma9= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma017.png"));
        sigma10= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma019.png"));
        sigma11= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma021.png"));
        sigma12= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma023.png"));
        sigma13= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma025.png"));
        sigma14= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma027.png"));
        sigma15= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma029.png"));
        sigma16= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma031.png"));
        sigma17= TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/sigma033.png"));

        System.out.println("Texture loaded okay ");
    }
}
