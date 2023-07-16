package practice2023.strings;

/**
 *
 */
public class StringToTable {
    public static void main(String[] args) {
        String[] strings = new String[]{"isAudioBuffer", "getTimeStamp", "setTimeStamp", "getSampleRate", "getSampleSize", "getNumberOfChannels", "getNumberOfSamples", "getDataBuffer", "getChannel"};
        System.out.println("Formatted: \n" + populateTable(strings, 60));
    }

    public static String populateTable(String[] strings, int charPerLine) {
        StringBuilder output = new StringBuilder();
        int appendedSoFar = 0;
        for (String str : strings) {
            int remaining = charPerLine - appendedSoFar;
            if ((remaining - 2) >= str.length()) {
                // Beginning of the line.
                if(remaining != charPerLine) {
                    output.append(" ");
                }
                output.append(str);
                appendedSoFar += str.length() + 1;
            } else {
                output.append("|");
                output.append("\n");
                output.append(str);
                appendedSoFar = str.length() + 1;
            }
        }
        return output.toString();
    }
}
