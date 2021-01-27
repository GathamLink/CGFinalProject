package objects3D;

import org.lwjgl.opengl.GL11;

public class Aix {

    public void DrawAix() {

        GL11.glBegin(GL11.GL_LINES);

        GL11.glColor3f(1, 0, 0);
        GL11.glVertex3f(-1000,0,0);
        GL11.glVertex3f(1000,0,0);
        GL11.glColor3f(1, 0, 0);
        GL11.glVertex3f(-1000,0.001f,0);
        GL11.glVertex3f(1000,0.001f,0);
        GL11.glColor3f(1, 0, 0);
        GL11.glVertex3f(-1000,-0.001f,0);
        GL11.glVertex3f(1000,-0.001f,0);

        GL11.glColor3f(0,0,1);
        GL11.glVertex3f(0,-1000,0);
        GL11.glVertex3f(0,1000,0);
        GL11.glColor3f(0,0,1);
        GL11.glVertex3f(0.001f,-1000,0);
        GL11.glVertex3f(0.001f,1000,0);
        GL11.glColor3f(0,0,1);
        GL11.glVertex3f(-0.001f,-1000,0);
        GL11.glVertex3f(-0.001f,1000,0);

        GL11.glColor3f(0,1,0);
        GL11.glVertex3f(0,0,-1000);
        GL11.glVertex3f(0,0,1000);
        GL11.glColor3f(0,1,0);
        GL11.glVertex3f(0.001f,0,-1000);
        GL11.glVertex3f(0.001f,0,1000);
        GL11.glColor3f(0,1,0);
        GL11.glVertex3f(-0.001f,0,-1000);
        GL11.glVertex3f(-0.001f,0,1000);

        GL11.glEnd();

    }

}
