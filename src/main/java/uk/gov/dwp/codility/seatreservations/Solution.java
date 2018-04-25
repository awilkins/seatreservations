package uk.gov.dwp.codility.seatreservations;

import com.google.common.annotations.VisibleForTesting;

public class Solution {

    @VisibleForTesting
    static boolean[] makeRow() {
        return new boolean[10];
    }

    @VisibleForTesting
    static void fillSeat(boolean[] row, char seat) {
        int offset = seat - 'A';
        row[offset] = true;
    }

    public int solution(int N, String S) {
        return 0;
    }
}
