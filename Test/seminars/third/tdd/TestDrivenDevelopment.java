package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {
    MoodAnalyser moodAnalyser;
    String str;

    @BeforeEach
    void init() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void testMoodAnalysisHappy() {
        str = "хорошее настроение!!";
        assertThat(moodAnalyser.analyseMood(str))
                .isEqualTo("happy");
    }

    @Test
    void testMoodAnalysisSad() {
        str = "плохое настроение";
        assertThat(moodAnalyser.analyseMood(str)).isEqualTo("sad");
    }

    @Test
    void testMoodAnalysisSoso() {
        str = "нормальное настроение";
        assertThat(moodAnalyser.analyseMood(str)).isEqualTo("so so");
    }
}