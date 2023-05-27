import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class TestDemoTest {

    private TestDemo testDemo;

    @BeforeEach
    public void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(2, 4, 6, false),
                arguments(0, 5, 0, true),
                arguments(-3, 7, 0, true),
                arguments(10, -5, 0, true),
                arguments(8, 12, 20, false)
        );
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo testDemo = new TestDemo();
        TestDemo mockDemo = spy(testDemo);

        doReturn(5).when(mockDemo).getRandomInt();

        int fiveSquared = mockDemo.randomNumberSquared();

        assertThat(fiveSquared).isEqualTo(25);
    }
}
