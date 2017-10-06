package ru.job4j.condition;

public class PointTest {
    @Test
    public void whenPointOnLineThenTrue() {
        //create of new point.  
        Point a = new Point(1, 1);
        // execute method - is and get result;
        boolean rsl = a.is(0, 1);
        // assert result by excepted value.
        assertThat(rsl, is(true));
   }
}