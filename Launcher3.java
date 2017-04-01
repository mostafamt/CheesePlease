import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
public class Launcher3
{
    public static void main (String[] args)
    {
        CheesePlease3 myProgram = new CheesePlease3();
        LwjglApplication launcher = new LwjglApplication( myProgram );
    }
}