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
}
