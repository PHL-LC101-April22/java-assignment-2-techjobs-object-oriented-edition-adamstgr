package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job testJob = new Job();
        Job otherTestJob = new Job();
        assertNotEquals(testJob, otherTestJob);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertEquals(new Employer("ACME"), job.getEmployer());
        assertEquals(new Location("Desert"), job.getLocation());
        assertEquals(new PositionType("Quality control"), job.getPositionType());
        assertEquals(new CoreCompetency("Persistence"), job.getCoreCompetency());
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job.equals(job1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.toString().charAt(0), '\n');
        assertEquals(job.toString().charAt(job.toString().length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.toString().contains("Id: 1\n"));
        assertEquals("\nId: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job.toString());
        assertTrue(job.toString().contains("Name: Product tester\n"));
        assertTrue(job.toString().contains("Employer: ACME\n"));
        assertTrue(job.toString().contains("Location: Desert\n"));
        assertTrue(job.toString().contains("Position Type: Quality control\n"));
        assertTrue(job.toString().contains("Core Competency: Persistence\n"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Data not available", new Employer("Data not available"), new Location("Data not available"), new PositionType("Data not available"), new CoreCompetency("Data not available"));
        assertTrue(job.toString().contains("Name: Data not available\n"));
        assertEquals("\nId: 1\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", job.toString());
        assertTrue(job.toString().contains("Employer: Data not available\n"));
        assertTrue(job.toString().contains("Location: Data not available\n"));
        assertTrue(job.toString().contains("Position Type: Data not available\n"));
        assertTrue(job.toString().contains("Core Competency: Data not available\n"));
    }
}
