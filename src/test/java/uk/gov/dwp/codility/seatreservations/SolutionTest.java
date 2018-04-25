package uk.gov.dwp.codility.seatreservations;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SolutionTest {

    @Test
    public void functionIsPresent() {
        Solution solution = new Solution();
        solution.solution(1, "String");
    }

    @Test
    public void rowIsTenElements() {
        boolean[] row = Solution.makeRow();
        assertThat(row.length, is(10));
    }

    @Test
    public void fillFirstSeat() {
        boolean[] row = Solution.makeRow();
        Solution.fillSeat(row, 'A');
        assertThat(row[0], is(true));
    }

    @Test
    public void getRowFromSeatName() {
        assertThat(Solution.getRow("3A"), is(3));
    }

    @Test
    public void getRowAboveTenFromSeatName() {
        assertThat(Solution.getRow("32A"), is(32));
    }

    @Test
    public void getSeatFromSeatName() {
        assertThat(Solution.getSeat("3A"), is('A'));
    }
}
