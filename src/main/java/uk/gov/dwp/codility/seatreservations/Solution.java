package uk.gov.dwp.codility.seatreservations;

import com.google.common.annotations.VisibleForTesting;

public class Solution {

    @VisibleForTesting
    static boolean[] makeRow() {
        return new boolean[10];
    }


    @VisibleForTesting
    static int seatColumn(char seat) {
        if (seat < 'I') {
            return seat - 'A';
        }
        return seat - ('A' + 1);
    }


    static void fillSeat(boolean[][] plane, String seatName) {
        int rowIndex = getRow(seatName);
        boolean[] row = plane[rowIndex];
        char seatColumn = getSeat(seatName);
        fillSeat(row, seatColumn);
    }

    @VisibleForTesting
    static void fillSeat(boolean[] row, char seat) {
        row[seatColumn(seat)] = true;
    }

    @VisibleForTesting
    static void fillSeat(boolean[] row, int seatIndex) {
        row[seatIndex] = true;
    }

    @VisibleForTesting
    static int getRow(String seatName) {
        String rowPart = seatName.substring(0, seatName.length() - 1);
        return Integer.parseInt(rowPart) - 1;
    }

    @VisibleForTesting
    static char getSeat(String seatName) {
        char seatPart = seatName.charAt(seatName.length() - 1);
        return seatPart;
    }

    private static boolean familyGapCheck(boolean[] row, int startIndex) {
        return ! ( row[startIndex] || row[startIndex + 1] || row[startIndex + 2] );
    }

    @VisibleForTesting
    /**
     * If you can seat a family in this row, return true and fill seats
     * Else return false
     */
    static boolean seatFamily(boolean[] row) {
        // we only need to check blocks at indices 0, 3, 4 and 7

        final int[] blockStarts = { 0, 3, 4, 7 };

        for (int index : blockStarts) {
            if (familyGapCheck(row, index)) {
                for (int ii = index ; ii < (index + 3) ; ii++ ) {
                    fillSeat(row, ii);
                }
                return true;
            }
        }
        return false;
    }

    public int solution(int N, String S) {
        return 0;
    }
}
