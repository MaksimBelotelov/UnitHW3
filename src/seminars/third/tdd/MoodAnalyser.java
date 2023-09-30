package seminars.third.tdd;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.contains("хорошее"))
            return "happy";
        if (message.contains("плох"))
            return "sad";
        return "so so";
    }
}