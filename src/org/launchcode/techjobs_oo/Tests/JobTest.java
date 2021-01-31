package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;
    Job testJob5;

    @Before
    public void CreateJobObject() {
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job();
        testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId() {
        assertTrue(testJob1.getId() >0);
        assertFalse(testJob1 == testJob2);
        assertTrue(testJob2.getId()-testJob1.getId() == 1);
        assertTrue(testJob3.getId()-testJob2.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        //What about id? //
        //testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob4.getId() >0);
        assertTrue(testJob4.getName() instanceof String);
        assertEquals("Product tester", testJob4.getName());
        assertTrue(testJob4.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob4.getEmployer().getValue());
        assertTrue(testJob4.getLocation() instanceof Location);
        assertEquals("Desert", testJob4.getLocation().getValue());
        assertTrue(testJob4.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob4.getPositionType().getValue());
        assertTrue(testJob4.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob4.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJob4.equals(testJob5));
    }

    @Test
    public void testToStringForBlankLinesAtBeginningAndEnd(){
        assertEquals(testJob4.toString().substring(0,1), "\n");
        assertEquals(testJob4.toString().substring(testJob4.toString().length()-1, testJob4.toString().length()), "\n");
    }
}
