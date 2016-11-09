package length;

import length.Length;
import length.Unit;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void should_equal_with_same_unit_and_same_quantity() {
        assertThat(new Length(1, Unit.M), is(new Length(1, Unit.M)));
    }

    @Test
    public void should_not_equal_with_same_unit_and_diff_quantity() {
        assertThat(new Length(1, Unit.M), is(not(new Length(2, Unit.M))));
    }

    @Test
    public void should_not_equal_with_diff_unit_and_same_quantity() {
        assertThat(new Length(1, Unit.M), is(not(new Length(1, Unit.CM))));
    }

    @Test
    public void should_equal_with_diff_unit_and_diff_quantity_and_convertEqual() {
        assertThat(new Length(1, Unit.M), is(new Length(100, Unit.CM)));
    }
}
