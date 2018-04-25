package uk.gov.dwp.codility.seatreservations;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SolutionTest {

    @Test
    public void functionIsPresent() {
        Solution solution = new Solution();
        solution.solution(1, "1A");
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
    public void fillAllSeats() {
        boolean[] row = Solution.makeRow();
        for(char seat = 'A' ; seat < 'L' ; seat++ ) {
            Solution.fillSeat(row, seat);
        }

        for(int ii = 0 ; ii < 10 ; ii++ ) {
            assertThat(row[ii], is(true));
        }
    }

    @Test
    public void seatColumnIndex() {
        assertThat(Solution.seatColumn('A'), is(0));
        assertThat(Solution.seatColumn('H'), is(7));
        assertThat(Solution.seatColumn('J'), is(8));
    }

    @Test
    public void fillSeatByIndex() {
        boolean[] row = Solution.makeRow();
        Solution.fillSeat(row, 2);
        assertThat(row[2], is(true));
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

    @Test
    public void canSeatFamilyInRow() {
        // should fill first three seats of empty row
        boolean[] row = Solution.makeRow();
        boolean canSeat = Solution.seatFamily(row);

        assertThat(canSeat, is(true));
        // first three seats full
        for (int ii = 0; ii < 3; ii++) {
            assertThat(row[ii], is(true));
        }
        // rest of seats empty
        for (int ii = 3; ii < 10; ii++) {
            assertThat(row[ii], is(false));
        }
    }

    @Test
    public void cantSeatFamilyInCrammedRow() {
        boolean[] row = Solution.makeRow();
        Solution.fillSeat(row, 'B');
        Solution.fillSeat(row, 'E');
        Solution.fillSeat(row, 'K');

        boolean canSeat = Solution.seatFamily(row);
        assertThat(canSeat, is(false));
    }
}
