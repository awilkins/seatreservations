package uk.gov.dwp.codility.seatreservations;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class is intended to replicate the Codility "input only" tests that
 * the web app presents - the user can populate a resource file to pass inputs and expected
 * outputs to the function
 *
 * Edit the inputs.txt resource file to add extra test/result sets
 *
 */
public class InputOnlyTest {

    private class Params {

        public Params(String line) {
            parse(line);
        }

        private void parse(String line) {
            String[] parts = line.split("\\|");
            N = Integer.parseInt(parts[0]);
            S = parts[1];
            returnValue = Integer.parseInt(parts[2]);
        }

        int N;
        String S;
        int returnValue;
    }

    @Test
    public void testInputs() throws IOException {
        InputStream inputStream = InputOnlyTest.class.getResourceAsStream("inputs.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        while(reader.ready()) {

            String line = reader.readLine();
            if(line.length() == 0) return;
            Params p = new Params(line);

            Solution s = new Solution();
            assertEquals(String.format("Failed for \"%s\"", line), p.returnValue, s.solution(p.N, p.S));
        }
    }
}
