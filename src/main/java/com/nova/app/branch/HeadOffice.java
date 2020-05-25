package com.nova.app.branch;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * It represents the head office of the bank. It is responsible for
 * creating and keeping track of all the branches.
 */
@Getter
@Setter
public class HeadOffice {

    private List<Branch> branches;
    private Logger logger = LoggerFactory.getLogger(HeadOffice.class);

    public HeadOffice() {
        this.branches = new ArrayList<>();
    }

    /**
     * It creates a new Branch and then adds it to the list of branches.
     *
     * @return
     */
    public Branch createBranch() {
        logger.debug("createBranch method started execution");

        int size = branches.size();
        int id;
        if (size == 0) {
            id = 1;
        } else {
            id = Integer.parseInt(branches.get(size - 1).getBranchId()) + 1;
        }
        Branch branch = new Branch(id + "");
        branches.add(branch);
        logger.debug("createBranch method ended execution");
        return branch;
    }

    /**
     * It returns the branch with the given branchId.
     *
     * @param branchId
     *
     * @return
     */
    public Branch getBranchByBranchId(String branchId) {
        logger.debug("getBranchByBranchId method started execution");
        for (Branch branch : branches) {
            if (branch.getBranchId().equals(branchId)) {
                return branch;
            }
        }
        return null;
    }

    /**
     * It returns the list of all the branches.
     *
     * @return
     */
    public List<Branch> getAllBranches() {
        logger.debug("getAllBranches method started execution");
        return branches;
    }
}
