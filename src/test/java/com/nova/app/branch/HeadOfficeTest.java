package com.nova.app.branch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class HeadOfficeTest {

    @InjectMocks
    HeadOffice headOffice;

    @Test
    public void testNewCreateBranch() {
        Branch branch = headOffice.createBranch();
        Assert.assertEquals("1", branch.getBranchId());
    }

    @Test
    public void testExistingCreateBranch() {
        Branch branch = new Branch("1");
        List<Branch> branches = new ArrayList<>(Arrays.asList(branch));
        headOffice.setBranches(branches);
        Branch result = headOffice.createBranch();
        Assert.assertEquals("2", result.getBranchId());
    }

    @Test
    public void testBranchByBranchId() {
        Branch branch = new Branch("1");
        List<Branch> branches = new ArrayList<>(Arrays.asList(branch));
        headOffice.setBranches(branches);
        Assert.assertNotNull(headOffice.getBranchByBranchId("1"));
    }

    @Test
    public void testBranchByBranchInvalidId() {
        Branch branch = new Branch("2");
        List<Branch> branches = new ArrayList<>(Arrays.asList(branch));
        headOffice.setBranches(branches);
        Assert.assertNull(headOffice.getBranchByBranchId("3"));
    }
}
