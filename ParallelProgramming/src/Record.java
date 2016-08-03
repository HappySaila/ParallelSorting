/**
 * Created by wlsgra012 on 2016/08/01.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class Record {

    //region instantiate
    private int arraySize;
    private int optimalThread;
    private float bestTime;
    private float speedUp;
    //endregion

    //region constructors
    public Record(int arraySize, int bestTime, int optimalThread, float speedUp) {
        this.arraySize = arraySize;
        this.bestTime = bestTime;
        this.optimalThread = optimalThread;
        this.speedUp = speedUp;
    }
    public Record(){
    }
    //endregion

    //region get set

    public int getArraySize() {
        return arraySize;
    }

    public float getBestTime() {
        return bestTime;
    }

    public int getOptimalThread() {
        return optimalThread;
    }

    public float getSpeedUp() {
        return speedUp;
    }
    //endregion

    //region methods
    public void saveRun(int arraySize, float bestTime, int optimalThread, float speedUp){
        this.arraySize = arraySize;
        this.bestTime = bestTime;
        this.optimalThread = optimalThread;
        this.speedUp = speedUp;
    }
    public String getResults(){
        return "ArraySize: <"+arraySize+"> || "+"Best Time: <"+bestTime+"> || "+"OptimalThread: <"+optimalThread+"> || "+"SpeedUp: <"+speedUp+">";
    }

    //endregion
    public void write(String outFile, String output){
        try {

            String content = output;

            File file = new File(outFile);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
