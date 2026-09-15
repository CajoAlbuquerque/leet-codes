package com.cajoalbuquerque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void Test1() {
        Solution sut = new Solution();

        String[] positive_feedback = new String[] { "smart", "brilliant", "studious" };
        String[] negative_feedback = new String[] { "not" };
        String[] report = new String[] { "this student is studious", "the student is smart" };
        int[] student_id = new int[] { 1, 2 };
        int k = 2;
        List<Integer> expected = Arrays.asList(1, 2);

        List<Integer> result = sut.topStudents(positive_feedback, negative_feedback, report, student_id, k);

        assertEquals(expected, result);
    }

    @Test
    public void Test2() {
        Solution sut = new Solution();

        String[] positive_feedback = new String[] { "smart", "brilliant", "studious" };
        String[] negative_feedback = new String[] { "not" };
        String[] report = new String[] { "this student is not studious", "the student is smart" };
        int[] student_id = new int[] { 1, 2 };
        int k = 2;
        List<Integer> expected = Arrays.asList(2, 1);

        List<Integer> result = sut.topStudents(positive_feedback, negative_feedback, report, student_id, k);

        assertEquals(expected, result);
    }

    @Test
    public void Test3() {
        Solution sut = new Solution();

        String[] positive_feedback = new String[] { "smart", "brilliant", "studious" };
        String[] negative_feedback = new String[] { "not" };
        String[] report = new String[] { "this student is not", "the student is smart" };
        int[] student_id = new int[] { 1, 2 };
        int k = 1;
        List<Integer> expected = Arrays.asList(2);

        List<Integer> result = sut.topStudents(positive_feedback, negative_feedback, report, student_id, k);

        assertEquals(expected, result);
    }

    @Test
    public void Test4() {
        Solution sut = new Solution();

        String[] positive_feedback = new String[] { "pyuknvau", "nc", "hwcpe", "wn" };
        String[] negative_feedback = new String[] { "bjzzjcgxv", "dibldp", "pmlb" };
        String[] report = new String[] { "qws z pmlb xmcugvuos lpnygddx bjzzjcgxv hwcpe pmlb pmlb rocg",
                "hwcpe pyuknvau dibldp bjzzjcgxv bjzzjcgxv hwcpe wn pmlb pyuknvau wodnvd",
                "dibldp dibldp gna dibldp pmlb pyuknvau pyuknvau nc iygs rkhtnjreq",
                "pmlb aas wn hwcpe bjzzjcgxv otird pyuknvau fdl bjzzjcgxv dibldp" };
        int[] student_id = new int[] { 357574114, 899543310, 676388750, 793586311 };
        int k = 2;
        List<Integer> expected = Arrays.asList(899543310, 676388750);

        List<Integer> result = sut.topStudents(positive_feedback, negative_feedback, report, student_id, k);

        assertEquals(expected, result);
    }

    @Test
    public void Test5() {
        Solution sut = new Solution();

        String[] positive_feedback = new String[] { "xrezzxgdvg", "bcgx", "wcfzmfosr" };
        String[] negative_feedback = new String[] { "qyouhus", "ukou", "eirhfbt", "qciw", "for" };
        String[] report = new String[] { "bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw",
                "bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw",
                "xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr",
                "for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt",
                "loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg",
                "rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx",
                "bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg",
                "bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr",
                "qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx" };
        int[] student_id = new int[] { 686276715, 934288178, 625397331, 519945877, 864052244, 971253305, 512505036,
                865635090, 281613863 };
        int k = 9;
        List<Integer> expected = Arrays.asList(865635090, 934288178, 864052244, 625397331, 281613863, 686276715,
                519945877, 971253305, 512505036);

        List<Integer> result = sut.topStudents(positive_feedback, negative_feedback, report, student_id, k);

        assertEquals(expected, result);
    }
}
