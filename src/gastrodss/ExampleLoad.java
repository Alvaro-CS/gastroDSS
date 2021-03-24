package gastrodss;

import net.sf.clipsrules.jni.*;

public class ExampleLoad {

    public static void main(String args[]) {
        Environment clips;
        clips = new Environment();
        try {
            clips.load("program.clp");
            clips.reset();
            clips.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
