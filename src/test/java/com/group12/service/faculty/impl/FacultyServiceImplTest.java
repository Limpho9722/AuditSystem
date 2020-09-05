package com.group12.service.faculty.impl;

import com.group12.entity.Faculty;
import com.group12.factory.FacultyFactory;
import com.group12.service.faculty.FacultyService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 05-09-2020
 *   Description: Tests for the Faculty Service Implementation
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyServiceImplTest{

    private static FacultyService service = FacultyServiceImpl.getService();

    // Instances to test with
    private static Faculty engineering = null;
    private static Faculty engineering2 = null;

    private static Faculty accounting = null;
    private static Faculty arts = null;

    @Test
    public void a_testCreate() {
        System.out.println("CREATE");
        try {
            engineering = FacultyFactory.createFactory("Engineering");
            engineering2 = FacultyFactory.createFactory("Engineering");

            accounting = FacultyFactory.createFactory("Accounting");
            arts = FacultyFactory.createFactory("Arts and Culture");

            service.create(engineering);
            service.create(engineering2);

            service.create(arts);

            Assert.assertEquals(accounting, service.create(accounting) );
        }
        catch (Exception e) {
            Assert.fail();
        }
        System.out.println("");
    }

    @Test
    public void b_testGetAll() {
        System.out.println("GET ALL");
        Set<Faculty> allFaculties = service.getAll();

        for (Faculty fac : allFaculties){
            System.out.println(fac.toString());
        }
        System.out.println("");
    }

    @Test
    public void c_testGetFacultyByName() {
        System.out.println("GET FACULTY BY NAME");

        Faculty engFac = service.getFacultyByName("engineering");
        System.out.println(engFac.toString());
        System.out.println("");

        Assert.assertEquals(engineering, engFac);
    }

    @Test
    public void d_testGetAllFacultyStartingWith() {
        System.out.println("GET ALL FACULTY STARTING WITH");
        Set<Faculty> all = service.getAllFacultyStartingWith("Ac");

        for(Faculty fac : all){
            System.out.println(fac.toString());
        }
        System.out.println("");
    }


    @Test
    public void e_testRead() {
    }

    @Test
    public void f_testUpdate() {
    }

    @Test
    public void g_testDelete() {
    }

}