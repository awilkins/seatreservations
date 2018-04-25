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

    @VisibleForTesting
    static int getRow(String seatName) {
        String rowPart = seatName.substring(0, seatName.length() - 1);
        return Integer.parseInt(rowPart);
    }

    @VisibleForTesting
    static char getSeat(String seatName) {
        char seatPart = seatName.charAt(seatName.length() - 1);
        return seatPart;
    }

    public int solution(int N, String S) {
        return 0;
    }
}
