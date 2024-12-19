public class Main {
    public static void main(String[] args) {
        int[] T = {4,2,45,52,3,5,4,200};
        System.out.println(solution(T));
    }
    public static String solution(int[] T){
        String[] seasons = {"Winter","Spring","Summer","Autumn"};
        int[] currentCalc;
        int currentCalcNumber = 0;
        int biggestAmplitude = 0;
        int biggestAmplitudeNumber = 0;
        for(int i = 0; i<4;i++) {
            currentCalc = new int[T.length / 4];
            for (int j = currentCalcNumber * T.length / 4; j < (currentCalcNumber + 1) * T.length / 4; j++) {
                currentCalc[j - (currentCalcNumber * T.length / 4)] = T[j];
            }
            if(calcAmplitude(currentCalc)>biggestAmplitude){
                biggestAmplitude = calcAmplitude(currentCalc);
                biggestAmplitudeNumber = currentCalcNumber;
            }
            currentCalcNumber++;
        }
        return seasons[biggestAmplitudeNumber];
    }
    public static int calcAmplitude(int[] currentCalc){
        int amplitude = 0;
        int lowestTemp = currentCalc[0];
        int highestTemp = currentCalc[0];
        for(int i = 0; i < currentCalc.length; i++){
            if(currentCalc[i]>highestTemp){
                highestTemp = currentCalc[i];
            }else if(currentCalc[i]<lowestTemp){
                lowestTemp = currentCalc[i];
            }
            amplitude = highestTemp - lowestTemp;
        }
        return amplitude;
    }
}