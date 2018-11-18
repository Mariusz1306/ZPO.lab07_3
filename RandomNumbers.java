import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.Random;

public class RandomNumbers {
    private final int count;
    private final int mean;
    private final int standardDeviation;

    public RandomNumbers(int count, int mean, int standardDeviation) {
        assert (standardDeviation > 0);
        this.count = count;
        this.mean = mean;
        this.standardDeviation = standardDeviation;

        for (int i = 0; i < getCount(); i++){
            double randomNumber = generateRandomNumber();
            String randomNumberString = format(randomNumber);
            writeToBinaryFile(randomNumberString);
        }
    }

    public double generateRandomNumber(){
        Random r = new Random();
        Double result = r.nextGaussian()*getStandardDeviation()+getMean();
        return result;
    }

    public void writeToBinaryFile(String number){
        try {
            DataOutputStream os = new DataOutputStream(new FileOutputStream("binout.dat"));
            os.writeChars(number);
            os.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String format(double number){
        String result = NumberFormat.getInstance().format(number);
        return result;
    }

    public int getCount() {
        return count;
    }

    public int getMean() {
        return mean;
    }

    public int getStandardDeviation() {
        return standardDeviation;
    }
}
