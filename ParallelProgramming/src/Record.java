/**
 * Created by wlsgra012 on 2016/08/01.
 */
import java.io.FileNotFoundException;
import java.util.Formatter;
public class Record {

    //region instantiate
    private int arraySize;
    private int optimalThread;
    private int bestTime;
    private float speedUp;
    private formatter x;
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

    public int getBestTime() {
        return bestTime;
    }

    public int getOptimalThread() {
        return optimalThread;
    }

    public float getSpeedUp() {
        return speedUp;
    }

    public formatter getX() {
        return x;
    }

    //endregion

    //region methods
    public void saveRun(int arraySize, int bestTime, int optimalThread, float speedUp){
        this.arraySize = arraySize;
        this.bestTime = bestTime;
        this.optimalThread = optimalThread;
        this.speedUp = speedUp;
    }

    public void addRecords(String outFile){
        openFile(outFile);
        //write to the file
        x.format("%s%s%s%s",arraySize+"",optimalThread+"",bestTime+"",speedUp+"");
        closeFile();
    }
    private void openFile(String fileName){
        try {
            x = new Formatter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    private void closeFile(){
        x.close();
    }
    //endregion

}
